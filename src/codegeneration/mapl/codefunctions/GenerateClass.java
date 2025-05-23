// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateClass extends AbstractCodeFunction {

    public GenerateClass(MaplCodeSpecification specification) {
        super(specification);
    }


	// class ClassDeclaration(String name, Optional<GlobalSection> globalSection, CreateSection createSection, List<FeatureSection> featureSections)
	@Override
	public Object visit(ClassDeclaration classDeclaration, Object param) {

		// generateGlobals(classDeclaration.getGlobalSection());

		// generateConstructors(classDeclaration.getCreateSection());

		// generateFunction(classDeclaration.featureSections());

		out("<instruction>");

		return null;
	}

}
