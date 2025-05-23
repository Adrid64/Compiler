// Generated with VGen 2.0.0

package ast.expression;

import ast.*;
import ast.type.*;
import org.antlr.v4.runtime.Token;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	expression -> 
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public abstract class AbstractExpression extends AbstractAST implements Expression {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private boolean lvalue;
	private Type type;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'lvalue:boolean' 

	public void setLvalue(boolean lvalue) {
		this.lvalue = lvalue;

	}

    public boolean isLvalue() {
        return lvalue;
    }


	// Attribute 'type' 

	public void setType(Type type) {
		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = type;

	}

    public Type getType() {
        return type;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
