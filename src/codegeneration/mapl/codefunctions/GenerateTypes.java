// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateTypes extends AbstractCodeFunction {

    public GenerateTypes(MaplCodeSpecification specification) {
        super(specification);
    }


	// class TypesSection(List<StructDeclaration> structDeclarations)
	@Override
	public Object visit(TypesSection typesSection, Object param) {

		// generateStruct(typesSection.structDeclarations());

		out("<instruction>");

		return null;
	}

}
