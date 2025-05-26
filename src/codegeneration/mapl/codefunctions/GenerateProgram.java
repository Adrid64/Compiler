// Generated with VGen 2.0.0
package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;

public class GenerateProgram extends AbstractCodeFunction {

    public GenerateProgram(MaplCodeSpecification specification) {
        super(specification);
    }

    // class Program(ClassDeclaration classDeclaration, RunStatement runStatement)
    @Override
    public Object visit(Program program, Object param) {
        out("\n#SOURCE\t" + "\"" + getSpecification().getSourceFile() + "\"\n");
        
        // Punto de entrada del programa
        out("' Programa principal");
        execute(program.getRunStatement());
        out("halt");
        
        // Generar la clase y sus funciones después
        generateClass(program.getClassDeclaration());
        
        return null;
    }
}