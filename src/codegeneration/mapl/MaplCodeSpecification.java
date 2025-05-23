// Generated with VGen 2.0.0

/*

Esta clase es el punto de entrada a la especificación de código. Es la coordinadora de todos sus
visitors (funciones de código).

Para finalizar la implementación de esta clase:
- Copiar este fichero a su ubicación deseada en el proyecto.
- Actualizar su 'package' si es necesario.
No es necesario cambiar nada más.

Para usar esta clase:
- Invocar el método 'process(AST)' para generar el código.

Si posteriormente se necesita añadir o quitar funciones (visitors), aunque se puede hacer aquí a
mano, es más fácil indicar los cambios en el fichero de VGen y volver a generarla.

*/


package codegeneration.mapl;

import java.io.*;
import java.util.*;

import ast.AST;
import visitor.Visitor;

import codegeneration.mapl.codefunctions.*;

public class MaplCodeSpecification {

    enum CodeFunction {
        GENERATEPROGRAM, GENERATECLASS, GENERATEGLOBALS, GENERATETYPES, GENERATEVARS, GENERATESTRUCT, GENERATECONSTRUCTORS, GENERATEFUNCTION, GENERATELOCALS, GENERATEARGS, VALUE, ADDRESS, EXECUTE, DECLARETYPE, DECLARE
    }

    private String sourceFile;
    private PrintWriter printWriter;
    private Map<CodeFunction, Visitor> functions;

    public MaplCodeSpecification(String sourceFile, Writer writer) {

        this.sourceFile = sourceFile;
        this.printWriter = new PrintWriter(writer);

        this.functions = new EnumMap<>(CodeFunction.class);

		functions.put(CodeFunction.GENERATEPROGRAM, new GenerateProgram(this));
		functions.put(CodeFunction.GENERATECLASS, new GenerateClass(this));
		functions.put(CodeFunction.GENERATEGLOBALS, new GenerateGlobals(this));
		functions.put(CodeFunction.GENERATETYPES, new GenerateTypes(this));
		functions.put(CodeFunction.GENERATEVARS, new GenerateVars(this));
		functions.put(CodeFunction.GENERATESTRUCT, new GenerateStruct(this));
		functions.put(CodeFunction.GENERATECONSTRUCTORS, new GenerateConstructors(this));
		functions.put(CodeFunction.GENERATEFUNCTION, new GenerateFunction(this));
		functions.put(CodeFunction.GENERATELOCALS, new GenerateLocals(this));
		functions.put(CodeFunction.GENERATEARGS, new GenerateArgs(this));
		functions.put(CodeFunction.VALUE, new Value(this));
		functions.put(CodeFunction.ADDRESS, new Address(this));
		functions.put(CodeFunction.EXECUTE, new Execute(this));
		functions.put(CodeFunction.DECLARETYPE, new DeclareType(this));
		functions.put(CodeFunction.DECLARE, new Declare(this));

    }


    //$ Punto de entrada y lanzamiento de la primera función sobre el nodo raíz ---------

    public void process(AST ast) {
        ast.accept(functions.get(CodeFunction.GENERATEPROGRAM), null);
    }


    //$ Métodos auxiliares para los visitors de las funciones -----------------------------

    public Visitor getVisitor(CodeFunction function) {
        if (!functions.containsKey(function))
            throw new UnsupportedOperationException(
                    "Se te ha olvidado meter este visitor en la tabla hash: " + function);

        return functions.get(function);
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

}
