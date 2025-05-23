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

		// generateClass(program.getClassDeclaration());

		// execute(program.getRunStatement());

		out("<instruction>");

		return null;
	}

}
