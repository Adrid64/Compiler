// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arrayAcces: expression -> exp2:expression exp3:expression
	expression -> 
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class ArrayAcces extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// arrayAcces: expression -> exp2:expression exp3:expression
	private Expression exp2;
	private Expression exp3;

    // ----------------------------------
    // Constructors

	public ArrayAcces(Expression exp2, Expression exp3) {
		super();

		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

		if (exp3 == null)
			throw new IllegalArgumentException("Parameter 'exp3' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp3 = exp3;

		updatePositions(exp2, exp3);
	}

	public ArrayAcces(Object exp2, Object exp3) {
		super();

        if (exp2 == null)
            throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = (Expression) exp2;

        if (exp3 == null)
            throw new IllegalArgumentException("Parameter 'exp3' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp3 = (Expression) exp3;

		updatePositions(exp2, exp3);
	}


    // ----------------------------------
    // arrayAcces: expression -> exp2:expression exp3:expression

	// Child 'exp2:expression' 

	public void setExp2(Expression exp2) {
		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

	}

    public Expression getExp2() {
        return exp2;
    }


	// Child 'exp3:expression' 

	public void setExp3(Expression exp3) {
		if (exp3 == null)
			throw new IllegalArgumentException("Parameter 'exp3' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp3 = exp3;

	}

    public Expression getExp3() {
        return exp3;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayAcces{" + " exp2=" + this.getExp2() + " exp3=" + this.getExp3() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
