// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import ast.declaration.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	variableAcces: expression -> name:string
	expression -> 
	
	PHASE Identification
	variableAcces -> declaration:declaration
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class VariableAcces extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// variableAcces: expression -> string
	private String name;

    // PHASE Identification
	private Declaration declaration;

    // ----------------------------------
    // Constructors

	public VariableAcces(String name) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		updatePositions(name);
	}

	public VariableAcces(Object name) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		updatePositions(name);
	}


    // ----------------------------------
    // variableAcces: expression -> string

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

	// Attribute 'declaration' 

	public void setDeclaration(Declaration declaration) {
		if (declaration == null)
			throw new IllegalArgumentException("Parameter 'declaration' can't be null. Pass a non-null value or use 'declaration?' in the abstract grammar");
		this.declaration = declaration;

	}

    public Declaration getDeclaration() {
        return declaration;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "VariableAcces{" + " name=" + this.getName() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
