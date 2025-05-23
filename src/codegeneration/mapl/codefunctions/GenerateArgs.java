// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class GenerateArgs extends AbstractCodeFunction {

    public GenerateArgs(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Args(List<Arg> args)
	@Override
	public Object visit(Args args, Object param) {

		// declare(args.args());

		out("<instruction>");

		return null;
	}

}
