// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateStruct extends AbstractCodeFunction {

    public GenerateStruct(MaplCodeSpecification specification) {
        super(specification);
    }


	// class StructDeclaration(String name, List<StructField> structFields)
	@Override
	public Object visit(StructDeclaration structDeclaration, Object param) {

		// declare(structDeclaration.structFields());

		out("<instruction>");

		return null;
	}

}
