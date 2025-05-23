// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	parentesis: expression -> exp2:expression
	expression -> 
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class Parentesis extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// parentesis: expression -> exp2:expression
	private Expression exp2;

    // ----------------------------------
    // Constructors

	public Parentesis(Expression exp2) {
		super();

		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

		updatePositions(exp2);
	}

	public Parentesis(Object exp2) {
		super();

        if (exp2 == null)
            throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = (Expression) exp2;

		updatePositions(exp2);
	}


    // ----------------------------------
    // parentesis: expression -> exp2:expression

	// Child 'exp2:expression' 

	public void setExp2(Expression exp2) {
		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

	}

    public Expression getExp2() {
        return exp2;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Parentesis{" + " exp2=" + this.getExp2() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
