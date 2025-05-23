// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateFunction extends AbstractCodeFunction {

    public GenerateFunction(MaplCodeSpecification specification) {
        super(specification);
    }


	// class FeatureSection(String name, Optional<Args> args, Optional<Type> type, Optional<LocalSection> localSection, List<Statement> statements)
	// phase TypeChecking { boolean hasReturn }
	@Override
	public Object visit(FeatureSection featureSection, Object param) {

		// generateArgs(featureSection.getArgs());

		// declareType(featureSection.getType());

		// generateLocals(featureSection.getLocalSection());

		// execute(featureSection.statements());

		out("<instruction>");

		return null;
	}

}
