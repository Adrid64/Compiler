// Generated with VGen 2.0.0

package ast;

import ast.declaration.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	args -> args:arg*
*/
public class Args extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// args -> arg*
	private List<Arg> args;

    // ----------------------------------
    // Constructors

	public Args(List<Arg> args) {
		super();

		if (args == null)
			args = new ArrayList<>();
		this.args = args;

		updatePositions(args);
	}

	public Args(Object args) {
		super();

        this.args = castList(args, unwrapIfContext.andThen(Arg.class::cast));
		updatePositions(args);
	}


    // ----------------------------------
    // args -> arg*

	// Child 'arg*' 

	public void setArgs(List<Arg> args) {
		if (args == null)
			args = new ArrayList<>();
		this.args = args;

	}

    public List<Arg> getArgs() {
        return args;
    }

    public Stream<Arg> args() {
        return args.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Args{" + " args=" + this.getArgs() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
