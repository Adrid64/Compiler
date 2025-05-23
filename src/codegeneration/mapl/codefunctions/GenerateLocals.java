// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateLocals extends AbstractCodeFunction {

    public GenerateLocals(MaplCodeSpecification specification) {
        super(specification);
    }


	// class LocalSection(List<VariableDeclaration> variableDeclarations)
	@Override
	public Object visit(LocalSection localSection, Object param) {

		// declare(localSection.variableDeclarations());

		out("<instruction>");

		return null;
	}

}
