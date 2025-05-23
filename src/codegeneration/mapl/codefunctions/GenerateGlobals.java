// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateGlobals extends AbstractCodeFunction {

    public GenerateGlobals(MaplCodeSpecification specification) {
        super(specification);
    }


	// class GlobalSection(Optional<TypesSection> typesSection, Optional<VarSection> varSection)
	@Override
	public Object visit(GlobalSection globalSection, Object param) {

		if(globalSection.getTypesSection().isPresent()) {
			generateTypes(globalSection.getTypesSection().get());
		}
		if(globalSection.getVarSection().isPresent()) {
			generateVars(globalSection.getVarSection().get());
		}
		// generateTypes(globalSection.getTypesSection());

		// generateVars(globalSection.getVarSection());

		return null;
	}

}
