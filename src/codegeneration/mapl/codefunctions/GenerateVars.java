// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateVars extends AbstractCodeFunction {

    public GenerateVars(MaplCodeSpecification specification) {
        super(specification);
    }


	// class VarSection(List<VariableDeclaration> variableDeclarations)
	@Override
	public Object visit(VarSection varSection, Object param) {

		// declare(varSection.variableDeclarations());

		out("<instruction>");

		return null;
	}

}
