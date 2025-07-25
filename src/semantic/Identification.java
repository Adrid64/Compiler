package semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.*;
import ast.declaration.Arg;
import ast.declaration.Declaration;
import ast.declaration.StructField;
import ast.declaration.VariableDeclaration;
import ast.expression.ArrayAcces;
import ast.expression.FunctionCallExp;
import ast.expression.Relacional;
import ast.expression.StructFieldAcces;
import ast.expression.VariableAcces;
import ast.statement.Bloqueif;
import ast.statement.FunctionCallStatement;
import ast.statement.RunStatement;
import ast.statement.Statement;
import ast.type.Arraytype;
import ast.type.IdentType;
import ast.type.Type;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class Identification extends DefaultVisitor {

    private ErrorManager errorManager;
    private ContextMap<String, Declaration> variables = new ContextMap<String, Declaration>();
    private Map<String, StructDeclaration> structs = new HashMap<>();
    private Map<String, FeatureSection> features = new HashMap<>();
    private List<String> declaredFeatures = new ArrayList<String>();
    private int currentScope = 0; // Contador para el nivel de scope

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Métodos para manejar el scope
    private void enterScope() {
        variables.set();
        currentScope++;
    }

    private void exitScope() {
        variables.reset();
        currentScope--;
    }

    // class Program(ClassDeclaration classDeclaration, RunStatement runStatement)
    @Override
    public Object visit(Program program, Object param) {
        enterScope(); // Scope 0: nivel global
        super.visit(program, param);
        exitScope();
        return null;
    }

    @Override
    public Object visit(LocalSection localSection, Object param) {
        for (VariableDeclaration varDecl : localSection.getVariableDeclarations()) {
            varDecl.accept(this, param); 
        }
        return null;
    }

    // class VariableDeclaration(List<String> identifiers, Type type)
    @Override
    public Object visit(VariableDeclaration variableDeclaration, Object param) {
        super.visit(variableDeclaration, param);

        String ident = variableDeclaration.getName(); 

        if (predicate(variables.getFromTop(ident) == null, "La variable: " + ident + " ya existe", variableDeclaration.end())) {
            variableDeclaration.setScope(currentScope); // Asignar scope actual
            variables.put(ident, variableDeclaration);
        }
        return null;
    }

    // class VariableAcces(String name)
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
	
	@Override
	public Object visit(ArrayAcces arrayAcces, Object param) {
	    arrayAcces.getExp2().accept(this, param);
	    arrayAcces.getExp3().accept(this, param); // el índice

	    Type baseType = arrayAcces.getExp2().getType();
	    if (baseType instanceof Arraytype) {
	        arrayAcces.setType(((Arraytype) baseType).getType2()); // tipo del elemento
	    } else {
	        predicate(false,
	            "Acceso a array sobre un tipo no array: " + baseType,
	            arrayAcces.end());
	    }

	    return null;
	}


    // class Args(List<Arg> args)
	@Override
	public Object visit(Args args, Object param) {
	    for (Arg arg : args.getArgs()) {
	        arg.accept(this, param); 
	    }
	    return null;
	}

    // class Arg(String name, Type type)
	@Override
	public Object visit(Arg arg, Object param) {
	    return null;
	}
	
	@Override
	public Object visit(Relacional relacional, Object param) {

		// relacional.getExp2().accept(this, param);
		// relacional.getExp3().accept(this, param);
		super.visit(relacional, param);

		return null;
	}

    // class StructDeclaration(String name, List<StructField> structFields)
    @Override
    public Object visit(StructDeclaration structDeclaration, Object param) {
        enterScope(); // Scope para campos de la estructura
        super.visit(structDeclaration, structDeclaration);
        exitScope();
        if (predicate(!structs.containsKey(structDeclaration.getName()), "El nombre del struct: " + structDeclaration.getName() + " ya está definido", structDeclaration.end())) {
            structs.put(structDeclaration.getName(), structDeclaration);
        }
        return null;
    }

    // class StructField(String name, Type type)
    @Override
    public Object visit(StructField structField, Object param) {
        if (predicate(variables.getFromTop(structField.getName()) == null, "El nombre del campo del struct: " + structField.getName() + " ya está definido", structField.end())) {
            variables.put(structField.getName(), structField);
            structField.setStructDeclaration((StructDeclaration) param);
        }
        super.visit(structField, param);
        return null;
    }

    // class FeatureSection(String name, Optional<Args> args, Optional<Type> type, Optional<LocalSection> localSection, List<Statement> statements)
    @Override
    public Object visit(FeatureSection featureSection, Object param) {
        // Registrar la función en una tabla global, si aplica
        if (predicate(!features.containsKey(featureSection.getName()), 
                      "La feature: " + featureSection.getName() + " ya existe", 
                      featureSection.end())) {
            features.put(featureSection.getName(), featureSection);
        }
        
        // Abrir un único ámbito para la función
        enterScope();
        
        // Procesar parámetros (si existen) en el ámbito de la función
        if (featureSection.getArgs().isPresent()) {
            for (Arg arg : featureSection.getArgs().get().getArgs()) {
                if (predicate(variables.getFromTop(arg.getName()) == null, 
                              "El parámetro: " + arg.getName() + " ya existe", 
                              arg.end())) {
                    arg.setScope(currentScope); // Asignar el ámbito actual
                    variables.put(arg.getName(), arg); // Registrar el parámetro
                }
            }
        }
        
        // Procesar variables locales en el mismo ámbito de la función
        if (featureSection.getLocalSection().isPresent()) {
            for (VariableDeclaration varDecl : featureSection.getLocalSection().get().getVariableDeclarations()) {
                varDecl.accept(this, param); // Registrar las variables locales
            }
        }
        
        // Procesar el cuerpo de la función
        for (Statement stmt : featureSection.getStatements()) {
            stmt.accept(this, param);
        }
        
        // Cerrar el ámbito al final
        exitScope();
        return null;
    }

    // class FunctionCallStatement(String name, List<Expression> expressions)
    @Override
    public Object visit(FunctionCallStatement functionCallStatement, Object param) {
        super.visit(functionCallStatement, param);
        if (predicate(features.containsKey(functionCallStatement.getName()), "La función: " + functionCallStatement.getName() + " no existe", functionCallStatement.end())) {
            functionCallStatement.setFeatureSection(features.get(functionCallStatement.getName()));
            
        }


        return null;
    }

    // class FunctionCallExp(String name, List<Expression> expresiones)
    @Override
    public Object visit(FunctionCallExp functionCallExp, Object param) {
        super.visit(functionCallExp, param);
        if (predicate(features.containsKey(functionCallExp.getName()), "La función: " + functionCallExp.getName() + " no existe", functionCallExp.end())) {
            functionCallExp.setFeatureSection(features.get(functionCallExp.getName()));
        }
        return null;
    }

    // class IdentType(String name)
    @Override
    public Object visit(IdentType identType, Object param) {
        if (predicate(structs.containsKey(identType.getName()), "El struct: " + identType.getName() + " no existe", identType.end())) {
            identType.setStructDeclaration(structs.get(identType.getName()));
        }
        return null;
    }

    // class CreateSection(List<String> strings)
    @Override
    public Object visit(CreateSection createSection, Object param) {
        List<String> names = createSection.getStrings();
        for (String featureName : names) {
            if (predicate(!declaredFeatures.contains(featureName), "El nombre de funcion " + featureName + " ya existe", createSection.end())) {
                declaredFeatures.add(featureName);
            }
        }
        return null;
    }

    // class RunStatement(String name, List<Expression> expressions)
    @Override
    public Object visit(RunStatement runStatement, Object param) {
        super.visit(runStatement, param);
        if (predicate(features.containsKey(runStatement.getName()), "La feature: " + runStatement.getName() + " no existe", runStatement.end())) {
            runStatement.setFeatureSection(features.get(runStatement.getName()));
        }
        return null;
    }

    // class StructFieldAcces(Expression exp2, String name)
 // class StructFieldAcces(Expression exp2, String name)
 // class StructFieldAcces(Expression exp2, String name)
 // class StructFieldAcces(Expression exp2, String name)
    @Override
    public Object visit(StructFieldAcces structFieldAcces, Object param) {
        structFieldAcces.getExp2().accept(this, param);

        Type baseType = structFieldAcces.getExp2().getType();
        StructDeclaration sd = resolveStruct(baseType);

        if (predicate(sd != null,
                      "Acceso a campo de un tipo no estructurado: " + baseType,
                      structFieldAcces.end())) {
            structFieldAcces.setStructDeclaration(sd);

            // Asignar tipo al StructFieldAcces usando el campo accedido
            for (StructField field : sd.getStructFields()) {
                if (field.getName().equals(structFieldAcces.getName())) {
                    structFieldAcces.setType(field.getType());
                    break;
                }
            }
        }

        return null;
    }






    // class Bloqueif(Expression expression, List<Statement> st2, List<Statement> st3)
    @Override
    public Object visit(Bloqueif bloqueif, Object param) {
        super.visit(bloqueif, param);
        return null;
    }

    // Métodos auxiliares
    
    private StructDeclaration resolveStruct(Type type) {
        while (type instanceof Arraytype) {
            type = ((Arraytype) type).getType2(); // bajar un nivel
        }
        if (type instanceof IdentType) {
            return structs.get(((IdentType) type).getName());
        }
        return null;
    }


    private void notifyError(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private boolean predicate(boolean condition, String errorMessage, Position position) {
        if (!condition) {
            notifyError(errorMessage, position);
            return false;
        }
        return true;
    }
}