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
        
        out("' Programa principal");
        execute(program.getRunStatement());
        out("halt");
        
        generateClass(program.getClassDeclaration());
        
        return null;
    }
}