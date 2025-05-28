/**
 * MLang. Programming Language Design Tutorial
 * @author Raúl Izquierdo (raul@uniovi.es)
 */

package semantic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ast.*;
import main.ErrorManager;
import visitor.DefaultVisitor;
import ast.declaration.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;

// This class will be implemented in type checking phase

public class TypeChecking extends DefaultVisitor {

    private ErrorManager errorManager;
    private List<String> constructors = new ArrayList<String>();

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // # ----------------------------------------------------------
    /*
    * Implement visit methods here.
    * COMPROBAR QUE NO DECLARO VARIABLES TIPO VOID
    * VER QUE ES UN LVALUE EL LADO IZQUIERDO DEL ARRAYACCES
    */
    
 // class Program(ClassDeclaration classDeclaration, RunStatement runStatement)
 	@Override
 	public Object visit(Program program, Object param) {

 		// program.getClassDeclaration().accept(this, param);
 		// program.getRunStatement().accept(this, param);
 		super.visit(program, param);

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

 	// class VariableDeclaration(List<String> identifiers, Type type)
 	@Override
 	public Object visit(VariableDeclaration variableDeclaration, Object param) {

 		// variableDeclaration.getType().accept(this, param);
 		super.visit(variableDeclaration, param);

 		return null;
 	}

 	// class StructDeclaration(String name, List<StructField> structFields)
 	@Override
 	public Object visit(StructDeclaration structDeclaration, Object param) {

 		// structDeclaration.getStructFields().forEach(structField -> structField.accept(this, param));
 		super.visit(structDeclaration, param);

 		return null;
 	}

 	// class StructField(String name, Type type)
 	// phase Identification { StructDeclaration structDeclaration }
 	@Override
 	public Object visit(StructField structField, Object param) {

 		// structField.getType().accept(this, param);
 		super.visit(structField, param);

 		return null;
 	}

 	// class CreateSection(List<String> strings)
 	@Override
 	public Object visit(CreateSection createSection, Object param) {
 		List<String> names= createSection.getStrings();
  		for (String featureName : names) {
  			if(!constructors.contains(featureName)) {
  				constructors.add(featureName);
  				}
  			}
		

 		return null;
 	}

 	// class FeatureSection(String name, Optional<Args> args, Optional<Type> type, Optional<LocalSection> localSection, List<Statement> statements)
 	@Override
 	public Object visit(FeatureSection featureSection, Object param) {
 		 featureSection.getArgs().ifPresent(args ->{
 			 List<Arg> listArgs=args.getArgs();
 			 for (Arg arg : listArgs) {
 	 			predicate(isSimpleType(arg.getType()),"El parámetro de la funcion no es de tipo simple",featureSection.start());
 	 			
			}
 		 });
 		// featureSection.getType().ifPresent(type -> type.accept(this, param));
 		// featureSection.getLocalSection().ifPresent(localSection -> localSection.accept(this, param));
 		// featureSection.getStatements().forEach(statement -> statement.accept(this, param));
 		
 		
 		List<Statement> statements=featureSection.getStatements();
 		for (Statement statement : statements) {
 			if(statement.getFeatureSection()==null) {
			statement.setFeatureSection(featureSection);
			}
			
		}
 		super.visit(featureSection, param);
 		if(featureSection.getType().isEmpty()) {
 			predicate(!featureSection.isHasReturn(),"La funcion es de tipo void y tiene return",featureSection.end());
 		}else {
 			predicate(featureSection.isHasReturn(),"La función debe tener alguna sentencia de retorno",featureSection.end());
 		}

 		return null;
 	}

 	// class LocalSection(List<VariableDeclaration> variableDeclarations)
 	@Override
 	public Object visit(LocalSection localSection, Object param) {

 		// localSection.getVariableDeclarations().forEach(variableDeclaration -> variableDeclaration.accept(this, param));
 		super.visit(localSection, param);

 		return null;
 	}

 	// class Args(List<Arg> args)
 	@Override
 	public Object visit(Args args, Object param) {

 		// args.getArgs().forEach(arg -> arg.accept(this, param));
 		super.visit(args, param);

 		return null;
 	}

 	// class Arg(String name, Type type)
 	@Override
 	public Object visit(Arg arg, Object param) {

 		// arg.getType().accept(this, param);
 		super.visit(arg, param);

 		return null;
 	}

 	@Override
 	public Object visit(Assignment assignment, Object param) {
 	    super.visit(assignment, param);
 	    // Se comprueba que ambos lados sean de tipos simples.
 	    predicate(isSimpleType(assignment.getLeft().getType()) && isSimpleType(assignment.getRight().getType()),
 	        "Solo se pueden asignar a tipos simples", assignment.end());
 	    
 	    
 	   // Comprobación de que el lado izquierdo sea un lvalue
 	    predicate(assignment.getLeft().isLvalue(),
 	        "La expresión de la izquierda no es un lvalue", assignment.getLeft().end());
 	    
 	    Type leftTypeToCompare;
 	    if(assignment.getLeft().getType() instanceof Arraytype) {
 	    	Arraytype a=((Arraytype)(assignment.getLeft().getType()));
 	    	
 	 		leftTypeToCompare=a.getType2();
 	    }
 	    else {
 	    	leftTypeToCompare=assignment.getLeft().getType();
 	    }
 	    
 	    
 	    
 	 
 	    // Comprobación de que los tipos sean iguales
 	    predicate(sameType(leftTypeToCompare, assignment.getRight().getType()),
 	        "No se pueden asignar expresiones tipo " + assignment.getLeft().getType().getTypeName() +
 	        " a expresiones tipo " + assignment.getRight().getType().getTypeName(), assignment.end());
 	    
 	   

 	    return null;
 	}



 	private boolean isSimpleType(Type type) {
 	    return !(type instanceof IdentType);
 	}

	// class Print(List<Expression> expressions)
 	@Override
 	public Object visit(Print print, Object param) {
 		super.visit(print, param);

 		print.getExpressions().forEach(expression -> predicate(isSimpleType(expression.getType()),"La expresion del print no es de tipo simple",expression.end()));

 		return null;
 	}

 	// class Println(List<Expression> expressions)
 	@Override
 	public Object visit(Println println, Object param) {
 		super.visit(println, param);

 		println.getExpressions().forEach(expression -> predicate(isSimpleType(expression.getType()),"La expresion del println no es de tipo simple",expression.end()));
 		

 		return null;
 	}

 	// class Read(List<Expression> expressions)
 	@Override
 	public Object visit(Read read, Object param) {
 		super.visit(read, param);
 		
 		read.getExpressions().forEach(expression -> {
 		predicate(isSimpleType(expression.getType()),"La operacion read solo acepta tipos simples",expression.end());
 		predicate(expression.isLvalue(),"La expresion del read no es lvalue",expression.end());
 		
 		});
 		

 		return null;
 	}

 	// class Bloqueif(Expression expression, List<Statement> st2, List<Statement> st3)
 	@Override
 	public Object visit(Bloqueif bloqueif, Object param) {

 		// bloqueif.getExpression().accept(this, param);
 		// bloqueif.getSt2().forEach(statement -> statement.accept(this, param));
 		// bloqueif.getSt3().forEach(statement -> statement.accept(this, param));
		 bloqueif.getSt2().forEach(s -> {if(s.getFeatureSection()==null) s.setFeatureSection(bloqueif.getFeatureSection());});
         bloqueif.getSt3().forEach(s -> {if(s.getFeatureSection()==null) s.setFeatureSection(bloqueif.getFeatureSection());});
 		super.visit(bloqueif, param);

   		predicate(sameType(bloqueif.getExpression().getType(), new IntType("Integer")) ,"La expresion no es un booleano",bloqueif.end());


 		return null;
 	}

 	// class LoopFrom(List<Statement> st1, Expression expression, List<Statement> body)
 	@Override
 	public Object visit(LoopFrom loopFrom, Object param) {

 		// loopFrom.getSt1().forEach(statement -> statement.accept(this, param));
 		// loopFrom.getExpression().accept(this, param);
 		loopFrom.getBody().forEach(s -> {if(s.getFeatureSection()==null) s.setFeatureSection(loopFrom.getFeatureSection());});
		 loopFrom.getSt1().forEach(s -> {if(s.getFeatureSection()==null) s.setFeatureSection(loopFrom.getFeatureSection());});
 		super.visit(loopFrom, param);

 		predicate(sameType(loopFrom.getExpression().getType(), new IntType("Integer")) ,"La expresion no es un booleano",loopFrom.end());
   		

 		return null;
 	}

 	// class Return(Optional<Expression> expression)
 	@Override
 	public Object visit(Return returnValue, Object param) {
 	    super.visit(returnValue, param);

 	    // Solo marcar como que tiene retorno si lleva expresión
 	    if (returnValue.getExpression().isPresent()) {
 	        returnValue.getFeatureSection().setHasReturn(true);

 	        if (returnValue.getFeatureSection().getType().isPresent()) {
 	            predicate(
 	                sameType(returnValue.getExpression().get().getType(),
 	                         returnValue.getFeatureSection().getType().get()),
 	                "El tipo de retorno no es el mismo que el de la funcion",
 	                returnValue.end()
 	            );
 	        }

 	        predicate(isSimpleType(returnValue.getExpression().get().getType()),
 	                  "El tipo de retorno no es simple",
 	                  returnValue.end());
 	    }

 	    return null;
 	}


 	// class FunctionCallStatement(String name, List<Expression> expressions)
 	// phase Identification { FeatureSection featureSection }
 	@Override
 	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

 		// functionCallStatement.getExpressions().forEach(expression -> expression.accept(this, param));
 		super.visit(functionCallStatement, param);

 		Optional<Args> args=functionCallStatement.getFeatureSection().getArgs();
 		if(args.isPresent()) {
 			List<Arg> argsList=args.get().getArgs();
 			List<Expression> parametros=functionCallStatement.getExpressions();
 			predicate(argsList.size()==parametros.size(),"Numero de parámetros incorrecto",functionCallStatement.end());
 			int indice=0;
 			for (Arg arg : argsList) {
 		   		predicate(sameType(arg.getType(), parametros.get(indice).getType()),"El Tipo del parametro esperado "+
 		   				arg.getName()+ " No coincide con el tipo proporcionado " + parametros.get(indice).getType().getTypeName()
 		   				,functionCallStatement.end());

				;
				indice++;
			}
 		}
 		else {

 			List<Expression> parametros=functionCallStatement.getExpressions();

 			predicate(parametros.size()==0,"Numero de parámetros incorrecto",functionCallStatement.end());
 		}
 		
 		

 		return null;
 	}

 	// class RunStatement(String name, List<Expression> expressions)
 	// phase Identification { FeatureSection featureSection }
 	@Override
 	public Object visit(RunStatement runStatement, Object param) {

 		// runStatement.getExpressions().forEach(expression -> expression.accept(this, param));
 		super.visit(runStatement, param);
 		predicate(constructors.contains(runStatement.getName()),"El Constructor " + runStatement.getName() +" no existe", runStatement.end());
 		Optional<Args> args=runStatement.getFeatureSection().getArgs();
 		if(args.isPresent()) {
 			List<Arg> argsList=args.get().getArgs();
 			List<Expression> parametros=runStatement.getExpressions();
 			if(predicate(argsList.size()==parametros.size(),"Numero de parámetros incorrecto",runStatement.end())) {
 			int indice=0;
 			for (Arg arg : argsList) {
 		   		predicate(sameType(arg.getType(), parametros.get(indice).getType()),"El Tipo del parametro esperado "+
 		   				arg.getName()+ " No coincide con el tipo proporcionado " + parametros.get(indice).getType().getTypeName()
 		   				,runStatement.end());

				;
				indice++;
			}}
 		}else {
 			List<Expression> parametros=runStatement.getExpressions();

 			predicate(parametros.size()==0,"Numero de parámetros incorrecto",runStatement.end());
 		}
 		

 		return null;
 	}

 	// class IntLiteral(String name)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(IntLiteral intLiteral, Object param) {
   		//intLiteral.type=intType
 		intLiteral.setType(new IntType("Integer"));
 		//intLiteral.lvalue=false
 		intLiteral.setLvalue(false);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// intLiteral.setLvalue(?);
 		// intLiteral.setType(?);
 		return null;
 	}

 	// class RealConstant(String name)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(RealConstant realConstant, Object param) {
 		realConstant.setType(new DoubleType("Double"));
 		realConstant.setLvalue(false);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// realConstant.setLvalue(?);
 		// realConstant.setType(?);
 		return null;
 	}

 	// class CharConstant(String name)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(CharConstant charConstant, Object param) {
 		charConstant.setType(new CharacterType("CHARACTER"));
 		charConstant.setLvalue(false);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// charConstant.setLvalue(?);
 		// charConstant.setType(?);
 		return null;
 	}

 	// class FunctionCallExp(String name, List<Expression> expresiones)
 	// phase Identification { FeatureSection featureSection }
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(FunctionCallExp functionCallExp, Object param) {

 		// functionCallExp.getExpresiones().forEach(expression -> expression.accept(this, param));
 		super.visit(functionCallExp, param);
 		
 		predicate(functionCallExp.getFeatureSection().getType().isPresent(),"El tipo de retorno no puede ser void",functionCallExp.end());
 		if(functionCallExp.getFeatureSection().getType().isPresent()) {
 	 		functionCallExp.setType(functionCallExp.getFeatureSection().getType().get());
 		}
 		else {
 			functionCallExp.setType(new VoidType("Void"));
 		}
 		Optional<Args> args=functionCallExp.getFeatureSection().getArgs();
 		if(args.isPresent()) {
 			List<Arg> argsList=args.get().getArgs();
 			List<Expression> parametros=functionCallExp.getExpresiones();
 			if(predicate(argsList.size()==parametros.size(),"Numero de parámetros incorrecto",functionCallExp.end())) {
 				int indice=0;
 	 			for (Arg arg : argsList) {
 	 		   		predicate(sameType(arg.getType(), parametros.get(indice).getType()),"El Tipo del parametro esperado "+
 	 		   				arg.getName()+ " No coincide con el tipo proporcionado " + parametros.get(indice).getType().getTypeName()
 	 		   				,functionCallExp.end());

 					;
 					indice++;
 				}
 			}
 			
 		}else
 		{
 			List<Expression> parametros=functionCallExp.getExpresiones();

 			predicate(parametros.size()==0, "Numero de parámetros incorrecto", functionCallExp.end());
 		}
 		functionCallExp.setLvalue(false);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// functionCallExp.setLvalue(?);
 		// functionCallExp.setType(?);
 		return null;
 	}

 	// class ArrayAcces(Expression exp2, Expression exp3)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(ArrayAcces arrayAcces, Object param) {

 		// arrayAcces.getExp2().accept(this, param);
 		// arrayAcces.getExp3().accept(this, param);
 		super.visit(arrayAcces, param);
 		
 		if(predicate(arrayAcces.getExp2().isLvalue(), "La expresión de la izquierda de un acceso a array debe ser un lvalue", arrayAcces.start())) {
 			
 		if(!predicate((arrayAcces.getExp2().getType() instanceof Arraytype) , "No es un array", arrayAcces.end())) {
 			arrayAcces.setLvalue(false);
 	 		arrayAcces.setType(new ErrorType("No es un array"));
 		}
 		else if(!predicate(isIntegerType(arrayAcces.getExp3().getType()), "El indice dentro de un array debe ser Integer", arrayAcces.end())) {
 			arrayAcces.setLvalue(false);
 	 		arrayAcces.setType(new ErrorType("Indice Incorrecto"));
 		}
 		
 		else {
 		arrayAcces.setLvalue(true);
	 	arrayAcces.setType(((Arraytype)arrayAcces.getExp2().getType()).getType2());
	 	}
 		
 		}
 		else {
 		
 		arrayAcces.setType(new ErrorType("Tipo incorrecto"));}
 		
 		

 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// arrayAcces.setLvalue(?);
 		// arrayAcces.setType(?);
 		return null;
 	}

 	// class VariableAcces(String name)
 	// phase Identification { Declaration declaration }
 	// phase TypeChecking { boolean lvalue, Type type }
 	
 	@Override
 	public Object visit(VariableAcces variableAcces, Object param) {
 		//variable.type=variable.varDefinition.type
   		variableAcces.setType(variableAcces.getDeclaration().getType());
   		
   		//variable.lvalue=true
   		variableAcces.setLvalue(true);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// variableAcces.setLvalue(?);
 		// variableAcces.setType(?);
 		return null;
 	}

 	// class RestaUnaria(Expression exp2)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(RestaUnaria restaUnaria, Object param) {

 		// restaUnaria.getExp2().accept(this, param);
 		super.visit(restaUnaria, param);
 		
 		predicate(isIntegerType(restaUnaria.getExp2().getType()) || isDoubleType(restaUnaria.getExp2().getType()),
 				"la expresión de un menos unario debe ser de tipo INTEGER o DOUBLE.", restaUnaria.end());
 		restaUnaria.setType(restaUnaria.getExp2().getType());
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// restaUnaria.setLvalue(?);
 		// restaUnaria.setType(?);
 		return null;
 	}

 	// class Parentesis(Expression exp2)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(Parentesis parentesis, Object param) {

 		// parentesis.getExp2().accept(this, param);
 		super.visit(parentesis, param);
 		parentesis.setType(parentesis.getExp2().getType());
 		parentesis.setLvalue(parentesis.getExp2().isLvalue());

 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// parentesis.setLvalue(?);
 		// parentesis.setType(?);
 		return null;
 	}

 	// class Negacion(Expression exp2)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(Negacion negacion, Object param) {

 		// negacion.getExp2().accept(this, param);
 		super.visit(negacion, param);
 		predicate(isIntegerType(negacion.getExp2().getType()), "la expresión de un operador not debe ser de tipo INTEGER no de tipo "+ negacion.getExp2().getType().getTypeName(), negacion.end());
 		negacion.setType(negacion.getExp2().getType());
 		negacion.setLvalue(negacion.getExp2().isLvalue());
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// negacion.setLvalue(?);
 		// negacion.setType(?);
 		return null;
 	}

 	// class Cast(Type tipoCast, Expression exp2)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(Cast cast, Object param) {

 		// cast.getTipoCast().accept(this, param);
 		// cast.getExp2().accept(this, param);
 		
 		super.visit(cast, param);
 		comprobarReglasCast(cast);

 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// cast.setLvalue(?);
 		// cast.setType(?);
 		return null;
 	}

 	private void comprobarReglasCast(Cast cast) {
 	    Type fromType = cast.getExp2().getType();  // Tipo de la expresión que se castea
 	    Type toType   = cast.getTipoCast();        // Tipo de destino

 	    boolean isFromInteger = sameType(fromType, new IntType("Integer"));
 	    boolean isFromDouble  = sameType(fromType, new DoubleType("Double"));
 	    boolean isFromChar    = sameType(fromType, new CharacterType("CHARACTER"));

 	    boolean isToInteger   = sameType(toType, new IntType("Integer"));
 	    boolean isToDouble    = sameType(toType, new DoubleType("Double"));
 	    boolean isToChar      = sameType(toType, new CharacterType("CHARACTER"));

 	    boolean permitido = false;

 	    // Tabla de conversiones
 	    // INTEGER -> (INTEGER, DOUBLE, CHARACTER)
 	    if (isFromInteger) {
 	        if (isToInteger || isToDouble || isToChar) {
 	            permitido = true;
 	        }
 	    }
 	    // DOUBLE -> (INTEGER, DOUBLE)
 	    else if (isFromDouble) {
 	        if (isToInteger || isToDouble) {
 	            permitido = true;
 	        }
 	    }
 	    // CHARACTER -> (INTEGER, CHARACTER)
 	    else if (isFromChar) {
 	        if (isToInteger || isToChar) {
 	            permitido = true;
 	        }
 	    }

 	    if(!predicate(permitido,
 	        String.format("Cast de %s a %s no permitido",
 	            fromType.getTypeName(), toType.getTypeName()),
 	        cast)) {
 	    	cast.setType(new ErrorType("Cast incorrecto"));
 	    	cast.setLvalue(false);
 	    }

 	    if (permitido) {
 	        cast.setType(toType);
 	        cast.setLvalue(false);
 	    }
 	}


	// class Arithmetic(Expression exp2, String name, Expression exp3)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(Arithmetic arithmetic, Object param) {

 		// arithmetic.getExp2().accept(this, param);
 		// arithmetic.getExp3().accept(this, param);
 		
 		super.visit(arithmetic, param);
 		//sameType(left.type,right.type)==true
   		predicate(sameType(arithmetic.getExp2().getType(), arithmetic.getExp3().getType()),"No se pueden sumar expresiones tipo "+ 
   				arithmetic.getExp2().getType().getTypeName() +" a expressiones tipo " + arithmetic.getExp3().getType().getTypeName(),arithmetic.end());
   		
   		if(arithmetic.getName().equals("mod")) {
   			predicate(sameType(arithmetic.getExp2().getType(),
   					new IntType("Integer")) && sameType(arithmetic.getExp3().getType(), new IntType("Integer") ),
   					"En una operacion mod ambas expresiones deben ser integer", arithmetic.end());
   		}
   		//expression.type= left.type
   		arithmetic.setType(arithmetic.getExp2().getType());
   		//arithmetic.lvalue=false
   		arithmetic.setLvalue(false);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// arithmetic.setLvalue(?);
 		// arithmetic.setType(?);
 		return null;
 	}
 	
 // class Relacional(Expression exp2, String name, Expression exp3)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(Relacional relacional, Object param) {

 		// relacional.getExp2().accept(this, param);
 		// relacional.getExp3().accept(this, param);
 		super.visit(relacional, param);
 		predicate(sameType(relacional.getExp2().getType(), relacional.getExp3().getType()),"No se pueden comparar expresiones tipo "+ 
   				relacional.getExp2().getType().getTypeName() +" a expressiones tipo " + relacional.getExp3().getType().getTypeName(),relacional.end());
 		
 		predicate(isIntegerType(relacional.getExp2().getType()) || isDoubleType(relacional.getExp2().getType()), "No se pueden comparar expresiones tipo "
 		+ relacional.getExp2().getType().getTypeName(),relacional.end());
 		relacional.setType(new IntType("Integer"));
 		relacional.setLvalue(false);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// relacional.setLvalue(?);
 		// relacional.setType(?);
 		return null;
 	}

 	// class BooleanExp(Expression exp2, String name, Expression exp3)
 	// phase TypeChecking { boolean lvalue, Type type }
 	@Override
 	public Object visit(BooleanExp booleanExp, Object param) {

 		// booleanExp.getExp2().accept(this, param);
 		// booleanExp.getExp3().accept(this, param);
 		super.visit(booleanExp, param);
 		//DUDA EXPRESIONES RELACIONALES CREAR UNA NUEVA CLASE
 		predicate(isIntegerType(booleanExp.getExp2().getType()) && isIntegerType(booleanExp.getExp3().getType())
 				, "Las expresiones de una expresion lógica deben ser INTEGER no de tipo: "+ 
 		booleanExp.getExp2().getType().getTypeName() +" y " +booleanExp.getExp3().getType().getTypeName(), booleanExp.end());
 		booleanExp.setType(new IntType("Boolean"));
 		booleanExp.setLvalue(false);
 		// TODO: Remember to initialize SYNTHESIZED attributes <-----
 		// booleanExp.setLvalue(?);
 		// booleanExp.setType(?);
 		return null;
 	}

 	
	// class StructFieldAcces(Expression exp2, String name)
 	// phase TypeChecking { boolean lvalue, Type type }
 // En codegeneration/mapl/codefunctions/TypeChecking.java (o donde esté tu visitor)
 	@Override
 	public Object visit(StructFieldAcces structFieldAcces, Object param) {
 	    // 1) Procesamos primero el subárbol
 	    super.visit(structFieldAcces, param);

 	    Type exp2Type = structFieldAcces.getExp2().getType();
 	    // 3) Llamamos a dot() en ese tipo
 	    structFieldAcces.setType(exp2Type.dot(structFieldAcces.getName()));
	        structFieldAcces.setLvalue(true);


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

 	// class IdentType(String name)
 	// phase Identification { StructDeclaration structDeclaration }
 	@Override
 	public Object visit(IdentType identType, Object param) {

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

    //# ----------------------------------------------------------
    //# Auxiliary methods (optional)

    private void notifyError(String errorMessage, Position position) {
        errorManager.notify("Type Checking", errorMessage, position);
    }


    /**
     * predicate. Auxiliary method to implement predicates. Delete if not needed.
     *
     * Usage examples:
     *
     *    predicate(expr.type != null), "Type cannot be null", expr.start());
     *
     *    predicate(expr.type != null), "Type cannot be null", expr);       // expr.start() is assumed
     *
     * The start() method (example 1) indicates the position in the file where the node was. If VGen is used, this method
     * will have been generated in all AST nodes.
     *
     * @param condition     Must be met to avoid an error
     * @param errorMessage  Printed if the condition is not met
     * @param errorPosition Row and column in the file where the error occurred.
     * @return true if the condition is met
     */

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
    
    private boolean isIntegerType(Type type) {
		// TODO Auto-generated method stub
		return type instanceof IntType;
	}
    
    private boolean isDoubleType(Type type) {
		// TODO Auto-generated method stub
		return type instanceof DoubleType;
	}

    
   
    
    private boolean sameType(Type type1, Type type2) {
    	
    	return type1.getClass()==type2.getClass();
    	
    }

}
