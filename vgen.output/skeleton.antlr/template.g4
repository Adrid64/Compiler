// Generated with VGen 2.0.0

grammar Grammar;

@header {
	    import ast.expression.*;
	    import ast.statement.*;
	    import ast.type.*;
	    import ast.declaration.*;
	    import ast.*;
}

program returns[Program ast]
    : classDeclaration runStatement       { $ast = new Program($classDeclaration.ast, $runStatement.ast); }
	;

classDeclaration returns[ClassDeclaration ast]
    : name=IDENT globalSection? createSection featureSections+=featureSection* { $ast = new ClassDeclaration($name, ($globalSection.ctx == null) ? null : $globalSection.ast, $createSection.ast, $featureSections); }
	;

globalSection returns[GlobalSection ast]
    : typesSection? varSection?           { $ast = new GlobalSection(($typesSection.ctx == null) ? null : $typesSection.ast, ($varSection.ctx == null) ? null : $varSection.ast); }
	;

typesSection returns[TypesSection ast]
    : structDeclarations+=structDeclaration* { $ast = new TypesSection($structDeclarations); }      
	;

structDeclaration returns[StructDeclaration ast]
    : name=IDENT structFields+=structField* { $ast = new StructDeclaration($name, $structFields); }
	;

structField returns[StructField ast]
    : name=IDENT type                     { $ast = new StructField($name, $type.ast); }          
	;

type returns[Type ast]
    : name=IDENT                          { $ast = new IntType($name); }                         
    | name=IDENT                          { $ast = new DoubleType($name); }                      
    | name=IDENT                          { $ast = new CharacterType($name); }                   
    | name=IDENT                          { $ast = new IdentType($name); }                       
    | INT_LITERAL type                    { $ast = new Arraytype($INT_LITERAL, $type.ast); }     
    | name=IDENT                          { $ast = new ErrorType($name); }                       
    | name=IDENT                          { $ast = new VoidType($name); }                        
	;

varSection returns[VarSection ast]
    : variableDeclarations+=variableDeclaration* { $ast = new VarSection($variableDeclarations); }      
	;

variableDeclaration returns[VariableDeclaration ast]
    : identifiers+=IDENT* type            { $ast = new VariableDeclaration($identifiers, $type.ast); }
	;

createSection returns[CreateSection ast]
    : strings+=IDENT*                     { $ast = new CreateSection($strings); }                
	;

featureSection returns[FeatureSection ast]
    : name=IDENT args? type? localSection? statements+=statement* { $ast = new FeatureSection($name, ($args.ctx == null) ? null : $args.ast, ($type.ctx == null) ? null : $type.ast, ($localSection.ctx == null) ? null : $localSection.ast, $statements); }
	;

args returns[Args ast]
    : args+=arg*                          { $ast = new Args($args); }                            
	;

arg returns[Arg ast]
    : name=IDENT type                     { $ast = new Arg($name, $type.ast); }                  
	;

localSection returns[LocalSection ast]
    : variableDeclarations+=variableDeclaration* { $ast = new LocalSection($variableDeclarations); }    
	;

statement returns[Statement ast]
    : left=expression right=expression    { $ast = new Assignment($left.ast, $right.ast); }      
    | expressions+=expression*            { $ast = new Print($expressions); }                    
    | expressions+=expression*            { $ast = new Println($expressions); }                  
    | expressions+=expression*            { $ast = new Read($expressions); }                     
    | expression st2+=statement* st3+=statement* { $ast = new Bloqueif($expression.ast, $st2, $st3); }  
    | st1+=statement* expression body+=statement* { $ast = new LoopFrom($st1, $expression.ast, $body); } 
    | expression?                         { $ast = new Return(($expression.ctx == null) ? null : $expression.ast); }
    | name=IDENT expressions+=expression* { $ast = new FunctionCallStatement($name, $expressions); }
    | name=IDENT expressions+=expression* { $ast = new RunStatement($name, $expressions); }      
	;

expression returns[Expression ast]
    : name=IDENT                          { $ast = new IntLiteral($name); }                      
    | name=IDENT                          { $ast = new RealConstant($name); }                    
    | name=IDENT                          { $ast = new CharConstant($name); }                    
    | name=IDENT expresiones+=expression* { $ast = new FunctionCallExp($name, $expresiones); }   
    | exp2=expression exp3=expression     { $ast = new ArrayAcces($exp2.ast, $exp3.ast); }       
    | name=IDENT                          { $ast = new VariableAcces($name); }                   
    | expression                          { $ast = new RestaUnaria($expression.ast); }           
    | expression                          { $ast = new Parentesis($expression.ast); }            
    | expression                          { $ast = new Negacion($expression.ast); }              
    | type expression                     { $ast = new Cast($type.ast, $expression.ast); }       
    | exp2=expression name=IDENT exp3=expression { $ast = new Arithmetic($exp2.ast, $name, $exp3.ast); }
    | exp2=expression name=IDENT exp3=expression { $ast = new Relacional($exp2.ast, $name, $exp3.ast); }
    | exp2=expression name=IDENT exp3=expression { $ast = new BooleanExp($exp2.ast, $name, $exp3.ast); }
    | expression name=IDENT               { $ast = new StructFieldAcces($expression.ast, $name); }
	;

runStatement returns[RunStatement ast]
    : name=IDENT expressions+=expression* { $ast = new RunStatement($name, $expressions); }      
	;


// ---------------------------------------------------------------
// Tokens

IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
INT_LITERAL: [0-9]+;
