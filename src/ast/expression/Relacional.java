// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------


/*
	relacional: expression -> exp2:expression name:string exp3:expression
	expression -> 
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class Relacional extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// relacional: expression -> exp2:expression string exp3:expression
	private Expression exp2;
	private String name;
	private Expression exp3;

    // ----------------------------------
    // Constructors

	public Relacional(Expression exp2, String name, Expression exp3) {
		super();

		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (exp3 == null)
			throw new IllegalArgumentException("Parameter 'exp3' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp3 = exp3;

		updatePositions(exp2, name, exp3);
	}

	public Relacional(Object exp2, Object name, Object exp3) {
		super();

        if (exp2 == null)
            throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = (Expression) exp2;

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        if (exp3 == null)
            throw new IllegalArgumentException("Parameter 'exp3' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp3 = (Expression) exp3;

		updatePositions(exp2, name, exp3);
	}


    // ----------------------------------
    // relacional: expression -> exp2:expression string exp3:expression

	// Child 'exp2:expression' 

	public void setExp2(Expression exp2) {
		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

	}

    public Expression getExp2() {
        return exp2;
    }


	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
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
        return "Relacional{" + " exp2=" + this.getExp2() + " name=" + this.getName() + " exp3=" + this.getExp3() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------

}
