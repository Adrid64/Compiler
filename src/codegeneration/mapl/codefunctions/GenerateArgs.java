// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import ast.declaration.Arg;
import codegeneration.mapl.*;


public class GenerateArgs extends AbstractCodeFunction {

    public GenerateArgs(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Args(List<Arg> args)
    @Override
    public Object visit(Args args, Object param) {
        for (Arg arg : args.getArgs()) {
            out("#PARAM " + arg.getName() + " : " + arg.getType().getTypeName());
        }
        return null;
    }

}
