// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	structFieldAcces: expression -> exp2:expression name:string
	expression -> 
	
	PHASE Identification
	structFieldAcces -> structDeclaration:structDeclaration
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class StructFieldAcces extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// structFieldAcces: expression -> exp2:expression string
	private Expression exp2;
	private String name;

    // PHASE Identification
	private StructDeclaration structDeclaration;

    // ----------------------------------
    // Constructors

	public StructFieldAcces(Expression exp2, String name) {
		super();

		if (exp2 == null)
			throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = exp2;

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		updatePositions(exp2, name);
	}

	public StructFieldAcces(Object exp2, Object name) {
		super();

        if (exp2 == null)
            throw new IllegalArgumentException("Parameter 'exp2' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.exp2 = (Expression) exp2;

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		updatePositions(exp2, name);
	}


    // ----------------------------------
    // structFieldAcces: expression -> exp2:expression string

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



    // --------------------------------
    // PHASE Identification

	// Attribute 'structDeclaration' 

	public void setStructDeclaration(StructDeclaration structDeclaration) {
		if (structDeclaration == null)
			throw new IllegalArgumentException("Parameter 'structDeclaration' can't be null. Pass a non-null value or use 'structDeclaration?' in the abstract grammar");
		this.structDeclaration = structDeclaration;

	}

    public StructDeclaration getStructDeclaration() {
        return structDeclaration;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StructFieldAcces{" + " exp2=" + this.getExp2() + " name=" + this.getName() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
