grammar Grammar;
import Tokenizer;

@header{

import ast.*;
import ast.type.*;
import ast.statement.*;
import ast.expression.*;
import ast.declaration.*;


}
program returns[Program ast]
    : classDeclaration runStatement EOF {$ast= new Program($classDeclaration.ast, $runStatement.ast);}
    ;

classDeclaration returns[ClassDeclaration ast]
	locals[List<FeatureSection> list= new ArrayList<FeatureSection>()]
    : 'class' IDENT ';' globalSection?
     createSection (featureSection { $list.add($featureSection.ast); })+ 'end' {$ast= new ClassDeclaration($IDENT,
     $globalSection.ctx != null ? $globalSection.ast : null, $createSection.ast,
     $list
     );}
    ;
	
globalSection returns[GlobalSection ast]
	: 'global' typesSection? varSection?{$ast= new GlobalSection($typesSection.ctx != null ? $typesSection.ast : null,
	$varSection.ctx != null ? $varSection.ast : null
	);}
	;
	
typesSection returns[TypesSection ast]
	locals[List<StructDeclaration> list= new ArrayList<StructDeclaration>()]
	:'types' (structDeclaration { $list.add($structDeclaration.ast); })* { $ast= new TypesSection($list); }
	;

varSection returns[VarSection ast]
	locals[List<VariableDeclaration> allVarDecls = new ArrayList<VariableDeclaration>()] 

	:'vars' (variableDeclaration { $allVarDecls.addAll($variableDeclaration.ast); })* { $ast = new VarSection($allVarDecls); } 
;
	
variableDeclaration returns[List<VariableDeclaration> ast = new ArrayList<VariableDeclaration>()]
    locals[List<Token> idTokens = new ArrayList<Token>()]
    : IDENT { $idTokens.add($IDENT); } 
    (',' IDENT { $idTokens.add($IDENT); })*
    ':' type ';'
    {
        for (Token idToken : $idTokens) {
            $ast.add(new VariableDeclaration(idToken, $type.ast));
        }
    }
;
	
structDeclaration returns[StructDeclaration ast]
	locals[List<StructField> list= new ArrayList<StructField>()]
	
	 : 'deftuple' IDENT 'as' (structField{$list.add($structField.ast);})* 'end'
	 {$ast = new StructDeclaration($IDENT,$list);}
	;
	
structField returns [StructField ast]
	: IDENT ':' type ';'{$ast = new StructField($IDENT,$type.ast);}
	;
	
createSection returns [CreateSection ast]
	locals[List<Token> list= new ArrayList<Token>()]
	
	: 'create' (IDENT{$list.add($IDENT);} ';')+
	{$ast=new CreateSection($list);}
	;

featureSection returns[FeatureSection ast]
		locals[List<Statement> list= new ArrayList<Statement>()]
	
	: 'feature' IDENT ('(' args ')' )? (':' type)? 'is' localSection? 'do' (statement { $list.add($statement.ast); })* 'end'
	{$ast= new FeatureSection($IDENT,$args.ctx != null ? $args.ast : null, 
	$type.ctx != null ? $type.ast : null
	,$localSection.ctx != null ? $localSection.ast : null, $list
	);}
	;
	
args returns [Args ast]
		locals[List<Arg> lista= new ArrayList<Arg>()]
	
    : arg {$lista.add($arg.ast);} (',' arg {$lista.add($arg.ast);})*
    {$ast = new Args($lista);}
    ;

arg returns [Arg ast]
    : IDENT ':' type {$ast = new Arg($IDENT, $type.ast);}
    ;
	
localSection returns[LocalSection ast]
	locals[List<VariableDeclaration> allVarDecls = new ArrayList<VariableDeclaration>()] 

	: 'local' (variableDeclaration { $allVarDecls.addAll($variableDeclaration.ast); })*
	{$ast= new LocalSection($allVarDecls);
	}
;
	

    	

    
statement returns [Statement ast]
    : e1=expression ':=' e2=expression ';' { $ast = new Assignment($e1.ast, $e2.ast);}
    | 'print' expressionList? ';'{$ast=new Print($expressionList.ctx != null ? $expressionList.lista : null);}
    | 'println' expressionList? ';'{$ast=new Println($expressionList.ctx != null ? $expressionList.lista : null);}
    | 'read' expressionList? ';'{$ast=new Read($expressionList.ctx != null ? $expressionList.lista : null);}
    | 'if' expression 'then' st1+=statement* 'end' { $ast = new Bloqueif($expression.ast, $st1, null);}
    | 'if' expression 'then' stms1+=statement* 'else' stms2+=statement* 'end' { $ast = new Bloqueif($expression.ast, $stms1, $stms2); }
	| ('from' fromStmts+=statement*)? 'until' expression 'loop' bodyStmts+=statement* 'end'   
	 { $ast = new LoopFrom($fromStmts,$expression.ast,$bodyStmts); }
    | 'return' expression? ';'
         { $ast = new Return($expression.ctx != null ? $expression.ast : null); }
    | IDENT '(' expressionList? ')' ';'
         { $ast = new FunctionCallStatement($IDENT, $expressionList.ctx != null ? $expressionList.lista : new ArrayList<Expression>()); }
    ;


runStatement returns[RunStatement ast]
    : 'run' IDENT '(' expressionList? ')' ';'
         { $ast = new RunStatement($IDENT, $expressionList.ctx != null ? $expressionList.lista : new ArrayList<Expression>()); }
    ;

expression returns [Expression ast]
    : INT_LITERAL
        { $ast = new IntLiteral($INT_LITERAL); }
    | REAL_CONSTANT
        { $ast = new RealConstant($REAL_CONSTANT); }
    | CHAR_CONSTANT
        { $ast = new CharConstant($CHAR_CONSTANT); }
    | IDENT
        { $ast = new VariableAcces($IDENT); }
    | IDENT '(' expressionList? ')'
        { $ast = new FunctionCallExp($IDENT, $expressionList.ctx != null ? $expressionList.lista : new ArrayList<Expression>()); }
    | e1=expression '[' e2=expression ']'
        { $ast = new ArrayAcces($e1.ast, $e2.ast); }
    | e1=expression '.' IDENT { $ast = new StructFieldAcces($e1.ast, $IDENT); }
    | '-' expression
        { $ast = new RestaUnaria($expression.ast); }
    | 'not' expression
        { $ast = new Negacion($expression.ast); }
    | 'to' '<' type '>' '(' expression ')'
    {
    $ast = new Cast($type.ast,$expression.ast);
    }
    | '(' expression ')'
        { $ast = new Parentesis($expression.ast); }
    | e1=expression op=('*' | '/' | 'mod') e2=expression
        { $ast = new Arithmetic($e1.ast, $op, $e2.ast); }
    | e1=expression op=('+' | '-') e2=expression
        { $ast = new Arithmetic($e1.ast, $op, $e2.ast); }
    | e1=expression op=('<' | '>' | '<=' | '>=') e2=expression
        { $ast = new Relacional($e1.ast, $op, $e2.ast); }
    | e1=expression op=('=' | '<>')  e2=expression
        { $ast = new BooleanExp($e1.ast, $op, $e2.ast); }
    | e1=expression 'and' e2=expression
        { $ast = new BooleanExp($e1.ast, "and", $e2.ast); }
    | e1=expression 'or' e2=expression
        { $ast = new BooleanExp($e1.ast, "or", $e2.ast); }
    ;

expressionList returns [List<Expression> lista = new ArrayList<Expression>()]
    : first=expression { $lista.add($first.ast); }
      (',' next=expression { $lista.add($next.ast); })*
    ;


type returns [Type ast]
    : ni='INTEGER' {$ast=new IntType($ni);}
    | nd='DOUBLE' {$ast=new DoubleType($nd);}
    | nc='CHARACTER' {$ast=new CharacterType($nc);}
    | name=IDENT {$ast=new IdentType($name);}
    | '['INT_LITERAL ']' type {$ast=new Arraytype($INT_LITERAL,$type.ast);}
    ;




	