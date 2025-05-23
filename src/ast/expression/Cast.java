// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	cast: expression -> tipoCast:type exp2:expression
	expression -> 
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class Cast extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// cast: expression -> tipoCast:type exp2:expression
	private Type tipoCast;
	private Expression exp2;

    // ----------------------------------
    // Constructors

	public Cast(Type tipoCast, Expression exp2) {
		super();

		if (tipoCast == null)
			throw new IllegalArgumentException("Parameter 'tipoCast' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.tipoCast = tipoCast;

		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

		updatePositions(tipoCast, exp2);
	}

	public Cast(Object tipoCast, Object exp2) {
		super();

        if (tipoCast == null)
            throw new IllegalArgumentException("Parameter 'tipoCast' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.tipoCast = (Type) tipoCast;

        if (exp2 == null)
            throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = (Expression) exp2;

		updatePositions(tipoCast, exp2);
	}


    // ----------------------------------
    // cast: expression -> tipoCast:type exp2:expression

	// Child 'tipoCast:type' 

	public void setTipoCast(Type tipoCast) {
		if (tipoCast == null)
			throw new IllegalArgumentException("Parameter 'tipoCast' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.tipoCast = tipoCast;

	}

    public Type getTipoCast() {
        return tipoCast;
    }


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
        return "Cast{" + " tipoCast=" + this.getTipoCast() + " exp2=" + this.getExp2() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
