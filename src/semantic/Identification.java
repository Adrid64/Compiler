package semantic;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.*;
import ast.declaration.Arg;
import ast.declaration.Declaration;
import ast.declaration.StructField;
import ast.declaration.VariableDeclaration;
import ast.expression.Arithmetic;
import ast.expression.ArrayAcces;
import ast.expression.BooleanExp;
import ast.expression.Cast;
import ast.expression.CharConstant;
import ast.expression.FunctionCallExp;
import ast.expression.IntLiteral;
import ast.expression.Negacion;
import ast.expression.Parentesis;
import ast.expression.RealConstant;
import ast.expression.RestaUnaria;
import ast.expression.StructFieldAcces;
import ast.expression.VariableAcces;
import ast.statement.Assignment;
import ast.statement.Bloqueif;
import ast.statement.FunctionCallStatement;
import ast.statement.LoopFrom;
import ast.statement.Print;
import ast.statement.Println;
import ast.statement.Read;
import ast.statement.Return;
import ast.statement.RunStatement;
import ast.type.Arraytype;
import ast.type.CharacterType;
import ast.type.DoubleType;
import ast.type.IdentType;
import ast.type.IntType;
import main.ErrorManager;
import visitor.DefaultVisitor;

// This class will be implemented in identification phase

public class Identification extends DefaultVisitor {

    private ErrorManager errorManager;
    private ContextMap<String,Declaration> variables= new ContextMap<String, Declaration>();
    private Map<String,StructDeclaration> structs= new HashMap<>();
    private Map<String,FeatureSection> features= new HashMap<>();
    private List<String> declaredFeatures = new ArrayList<String>();


    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // # ----------------------------------------------------------
    /*
     * Write "visits" here...
     */
    
 // class Program(ClassDeclaration classDeclaration, RunStatement runStatement)
 	@Override
 	public Object visit(Program program, Object param) {
 		variables.set();

 		// program.getClassDeclaration().accept(this, param);
 		// program.getRunStatement().accept(this, param);
 		super.visit(program, param);
 		variables.reset();
 		return null;
 	}
 	
 	
 // class LocalSection(List<VariableDeclaration> variableDeclarations)
 	@Override
 	public Object visit(LocalSection localSection, Object param) {
 		variables.set();
 		// localSection.getVariableDeclarations().forEach(variableDeclaration -> variableDeclaration.accept(this, param));
 		super.visit(localSection, param);
 		return null;
 	}
 	
 	
 	
    
 // class VariableDeclaration(List<String> identifiers, Type type)
 	@Override
 	public Object visit(VariableDeclaration variableDeclaration, Object param) {

 		// variableDeclaration.getType().accept(this, param);
 		super.visit(variableDeclaration, param);
 		List<String> identifiers= variableDeclaration.getIdentifiers();
 		for (String ident : identifiers) {
 			if(predicate(variables.getFromTop(ident)==null,"La variable: "+ident+" ya existe",variableDeclaration.end())) {
 	   	   		//Introducir la variable en el map
 	   			variables.put(ident, variableDeclaration);
 	   		}
		}
 		
 		return null;
 	}
 	
 // class VariableAcces(String name)
 	// phase Identification { VariableDeclaration variableDeclaration }
 	@Override
 	public Object visit(VariableAcces variableAcces, Object param) {

 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// variableAcces.setVariableDeclaration(?);
 		
 		if(predicate(variables.getFromAny(variableAcces.getName())!=null ,"La variable: "+variableAcces.getName()+" no existe",variableAcces.end())) {
   	   		//Poner varDefinition apuntando a la definición de la variable
 			
   			variableAcces.setDeclaration((variables.getFromAny(variableAcces.getName())));
   			variableAcces.setType(variableAcces.getDeclaration().getType());
   		}
 		
 		return null;
 	}
 	
 // class Args(List<Arg> args)
 	@Override
 	public Object visit(Args args, Object param) {
 		variables.set();
 		//args.getArgs().forEach(arg -> arg.accept(this, param));
 		super.visit(args, param);
 		return null;
 	}
 	
	// class Arg(String name, Type type)
	@Override
	public Object visit(Arg arg, Object param) {

		// arg.getType().accept(this, param);
		super.visit(arg, param);
		
		if(predicate(variables.getFromTop(arg.getName())==null,"El parámetro: "+arg.getName()+" ya existe",arg.end())) {
	   	   		//Introducir la variable en el map
	   			variables.put(arg.getName(), arg);
	   		}
		

		return null;
	}

 // class StructDeclaration(String name, List<StructField> structFields)
 	@Override
 	public Object visit(StructDeclaration structDeclaration, Object param) {

 		// structDeclaration.getStructFields().forEach(structField -> structField.accept(this, param));
 		//-----------------Duda pasarle structDeclaration por ahi
 		variables.set();
 		super.visit(structDeclaration, structDeclaration);
 		variables.reset();

 		
 		if(predicate(!structs.containsKey(structDeclaration.getName()),
 			    "El nombre del struct: " + structDeclaration.getName() + " ya está definido", structDeclaration.end())) {
 			    // Introducir el struct en el mapa
 			    structs.put(structDeclaration.getName(), structDeclaration);
 			}

		
 		return null;
 	}
 	
	// class StructField(String name, Type type)
 	@Override
 	public Object visit(StructField structField, Object param) {
 		
 		if(predicate(variables.getFromTop(structField.getName())==null,
 			    "El nombre del campo del struct: " + structField.getName() + " ya está definido", structField.end())) {
 			    // Introducir el struct en el mapa
 			variables.put(structField.getName(), structField);
 			
 	 		structField.setStructDeclaration((StructDeclaration) param);

 			    }
 			
 		// structField.getType().accept(this, param);
 		super.visit(structField, param);

 		return null;
 	}

 	
 // class FeatureSection(String name, Optional<Args> args, Optional<Type> type, Optional<LocalSection> localSection, List<Statement> statements)
 	@Override
 	public Object visit(FeatureSection featureSection, Object param) {

 		// featureSection.getArgs().ifPresent(args -> args.accept(this, param));
 		// featureSection.getType().ifPresent(type -> type.accept(this, param));
 		// featureSection.getLocalSection().ifPresent(localSection -> localSection.accept(this, param));
 		// featureSection.getStatements().forEach(statement -> statement.accept(this, param));
 		super.visit(featureSection, param);
 		if(predicate(!features.containsKey(featureSection.getName()),"La feature: "+featureSection.getName()+" ya existe",featureSection.end())) {
	   	   		//Introducir la feature en el map
	   			features.put(featureSection.getName(), featureSection);
	   		}
 		if(featureSection.getArgs().isPresent()) {
 			variables.reset();
 		}
 		if(featureSection.getLocalSection().isPresent()) {
 			variables.reset();
 		}
	

 		return null;
 	}
 	
 // class FunctionCallStatement(String name, List<Expression> expressions)
 	@Override
 	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

 		// functionCallStatement.getExpressions().forEach(expression -> expression.accept(this, param));
 		super.visit(functionCallStatement, param);
 		if(predicate(features.containsKey(functionCallStatement.getName()) ,"La función: "+functionCallStatement.getName()+" no existe",functionCallStatement.end())) {
   			functionCallStatement.setFeatureSection(features.get(functionCallStatement.getName()));
   		}
 		return null;
 	}
 	
 // class FunctionCallExp(String name, List<Expression> expresiones)
 	@Override
 	public Object visit(FunctionCallExp functionCallExp, Object param) {

 		// functionCallExp.getExpresiones().forEach(expression -> expression.accept(this, param));
 		super.visit(functionCallExp, param);
 		if(predicate(features.containsKey(functionCallExp.getName()) ,"La función: "+functionCallExp.getName()+" no existe",functionCallExp.end())) {
   			functionCallExp.setFeatureSection(features.get(functionCallExp.getName()));
   		}
 		return null;
 	}
 	
 // class IdentType(String name)
 	// phase Identification { StructDeclaration structDeclaration }
 	@Override
 	public Object visit(IdentType identType, Object param) {

 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// identType.setStructDeclaration(?);
 		if(predicate(structs.containsKey(identType.getName()) ,"El struct: "+identType.getName()+" no existe",identType.end())) {
   			identType.setStructDeclaration(structs.get(identType.getName()));
   		}
 		return null;
 	}
 	
 // class CreateSection(List<String> strings)
  	@Override
  	public Object visit(CreateSection createSection, Object param) {
  		List<String> names= createSection.getStrings();
  		for (String featureName : names) {
  			if(predicate(!declaredFeatures.contains(featureName),"El nombre de funcion "+featureName+" ya existe",createSection.end())) {
  	   		declaredFeatures.add(featureName);
  			}
		}
  		
  		return null;
  	}
  	
 	// class RunStatement(String name, List<Expression> expressions)
 	@Override
 	public Object visit(RunStatement runStatement, Object param) {

 		// runStatement.getExpressions().forEach(expression -> expression.accept(this, param));
 		super.visit(runStatement, param);
 		if(predicate(features.containsKey(runStatement.getName()) ,"La feature: "+runStatement.getName()+" no existe",runStatement.end())) {
   			runStatement.setFeatureSection(features.get(runStatement.getName()));
   		}

 		return null;
 	}
 	
 // class StructFieldAcces(Expression exp2, String name)
 	@Override
 	public Object visit(StructFieldAcces structFieldAcces, Object param) {

 		super.visit(structFieldAcces, param);	
 		if(structFieldAcces.getExp2().getType() instanceof IdentType) {
 			IdentType id= (IdentType)structFieldAcces.getExp2().getType();
 			String name=id.getName();
 			StructDeclaration sd=structs.get(name);
 			if(predicate(sd!=null, "No existe el struct", structFieldAcces.end())) {
 				structFieldAcces.setStructDeclaration(sd);
 			}
 			
 		}

 		return null;
 	}
 	
 	
 	


 	// class ClassDeclaration(String name, Optional<GlobalSection> globalSection, CreateSection createSection, List<FeatureSection> featureSections)
 	@Override
 	public Object visit(ClassDeclaration classDeclaration, Object param) {

 		// classDeclaration.getGlobalSection().ifPresent(globalSection -> globalSection.accept(this, param));
 		// classDeclaration.getCreateSection().accept(this, param);
 		// classDeclaration.getFeatureSections().forEach(featureSection -> featureSection.accept(this, param));
 		super.visit(classDeclaration, param);

 		return null;
 	}

 	// class GlobalSection(Optional<TypesSection> typesSection, Optional<VarSection> varSection)
 	@Override
 	public Object visit(GlobalSection globalSection, Object param) {

 		// globalSection.getTypesSection().ifPresent(typesSection -> typesSection.accept(this, param));
 		// globalSection.getVarSection().ifPresent(varSection -> varSection.accept(this, param));
 		super.visit(globalSection, param);

 		return null;
 	}

 	// class TypesSection(List<StructDeclaration> structDeclarations)
 	@Override
 	public Object visit(TypesSection typesSection, Object param) {

 		// typesSection.getStructDeclarations().forEach(structDeclaration -> structDeclaration.accept(this, param));
 		super.visit(typesSection, param);

 		return null;
 	}

 	// class VarSection(List<VariableDeclaration> variableDeclarations)
 	@Override
 	public Object visit(VarSection varSection, Object param) {

 		// varSection.getVariableDeclarations().forEach(variableDeclaration -> variableDeclaration.accept(this, param));
 		super.visit(varSection, param);

 		return null;
 	}



 
 	
 

 

 	// class Assignment(Expression left, Expression right)
 	@Override
 	public Object visit(Assignment assignment, Object param) {

 		// assignment.getLeft().accept(this, param);
 		// assignment.getRight().accept(this, param);
 		super.visit(assignment, param);

 		return null;
 	}

 	// class Print(List<Expression> expressions)
 	@Override
 	public Object visit(Print print, Object param) {

 		// print.getExpressions().forEach(expression -> expression.accept(this, param));
 		super.visit(print, param);

 		return null;
 	}

 	// class Println(List<Expression> expressions)
 	@Override
 	public Object visit(Println println, Object param) {

 		// println.getExpressions().forEach(expression -> expression.accept(this, param));
 		super.visit(println, param);

 		return null;
 	}

 	// class Read(List<Expression> expressions)
 	@Override
 	public Object visit(Read read, Object param) {

 		// read.getExpressions().forEach(expression -> expression.accept(this, param));
 		super.visit(read, param);

 		return null;
 	}

 	// class Bloqueif(Expression expression, List<Statement> st2, List<Statement> st3)
 	@Override
 	public Object visit(Bloqueif bloqueif, Object param) {

 		// bloqueif.getExpression().accept(this, param);
 		// bloqueif.getSt2().forEach(statement -> statement.accept(this, param));
 		// bloqueif.getSt3().forEach(statement -> statement.accept(this, param));
 		super.visit(bloqueif, param);

 		return null;
 	}

 	// class LoopFrom(List<Statement> st1, Expression expression, List<Statement> body)
 	@Override
 	public Object visit(LoopFrom loopFrom, Object param) {

 		// loopFrom.getSt1().forEach(statement -> statement.accept(this, param));
 		// loopFrom.getExpression().accept(this, param);
 		// loopFrom.getBody().forEach(statement -> statement.accept(this, param));
 		super.visit(loopFrom, param);

 		return null;
 	}

 	// class Return(Optional<Expression> expression)
 	@Override
 	public Object visit(Return returnValue, Object param) {

 		// returnValue.getExpression().ifPresent(expression -> expression.accept(this, param));
 		super.visit(returnValue, param);

 		return null;
 	}

 	


 	// class IntLiteral(String name)
 	@Override
 	public Object visit(IntLiteral intLiteral, Object param) {

 		return null;
 	}

 	// class RealConstant(String name)
 	@Override
 	public Object visit(RealConstant realConstant, Object param) {

 		return null;
 	}

 	// class CharConstant(String name)
 	@Override
 	public Object visit(CharConstant charConstant, Object param) {

 		return null;
 	}

 	

 	// class ArrayAcces(Expression exp2, Expression exp3)
 	@Override
 	public Object visit(ArrayAcces arrayAcces, Object param) {

 		// arrayAcces.getExp2().accept(this, param);
 		// arrayAcces.getExp3().accept(this, param);
 		
 		super.visit(arrayAcces, param);

 		return null;
 	}


 	// class RestaUnaria(Expression exp2)
 	@Override
 	public Object visit(RestaUnaria restaUnaria, Object param) {

 		// restaUnaria.getExp2().accept(this, param);
 		super.visit(restaUnaria, param);

 		return null;
 	}

 	// class Parentesis(Expression exp2)
 	@Override
 	public Object visit(Parentesis parentesis, Object param) {

 		// parentesis.getExp2().accept(this, param);
 		super.visit(parentesis, param);

 		return null;
 	}

 	// class Negacion(Expression exp2)
 	@Override
 	public Object visit(Negacion negacion, Object param) {

 		// negacion.getExp2().accept(this, param);
 		super.visit(negacion, param);

 		return null;
 	}

 	// class Cast(Type type, Expression exp2)
 	@Override
 	public Object visit(Cast cast, Object param) {

 		// cast.getType().accept(this, param);
 		// cast.getExp2().accept(this, param);
 		super.visit(cast, param);

 		return null;
 	}

 	// class Arithmetic(Expression exp2, String name, Expression exp3)
 	@Override
 	public Object visit(Arithmetic arithmetic, Object param) {

 		// arithmetic.getExp2().accept(this, param);
 		// arithmetic.getExp3().accept(this, param);
 		super.visit(arithmetic, param);

 		return null;
 	}

 	// class BooleanExp(Expression exp2, String name, Expression exp3)
 	@Override
 	public Object visit(BooleanExp booleanExp, Object param) {

 		// booleanExp.getExp2().accept(this, param);
 		// booleanExp.getExp3().accept(this, param);
 		super.visit(booleanExp, param);

 		return null;
 	}



 	// class IntType(String name)
 	@Override
 	public Object visit(IntType intType, Object param) {

 		return null;
 	}

 	// class DoubleType(String name)
 	@Override
 	public Object visit(DoubleType doubleType, Object param) {

 		return null;
 	}

 	// class CharacterType(String name)
 	@Override
 	public Object visit(CharacterType characterType, Object param) {

 		return null;
 	}

 

 	// class Arraytype(int intValue, Type type2)
 	@Override
 	public Object visit(Arraytype arraytype, Object param) {

 		// arraytype.getType2().accept(this, param);
 		super.visit(arraytype, param);

 		return null;
 	}
 	

    // public Object visit(Program prog, Object param) {
    //      ...
    // }

    // ...
    // ...
    // ...

    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void notifyError(String msg) {
        errorManager.notify("Identification", msg);
    }

    private void notifyError(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private void notifyError(String msg, AST node) {
        notifyError(msg, node.start());
    }
    
    private boolean predicate(boolean condition, String errorMessage, Position position) {
        if (!condition) {
            notifyError(errorMessage, position);
            return false;
        }

        return true;
    }

    private boolean predicate(boolean condition, String errorMessage, AST node) {
        return predicate(condition, errorMessage, node.start());
    }


}
