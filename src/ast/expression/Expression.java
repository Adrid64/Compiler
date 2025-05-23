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
public interface Expression extends AST {




    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'lvalue:boolean' 

	public void setLvalue(boolean lvalue);
	public boolean isLvalue();

	// Attribute 'type' 

	public void setType(Type type);
	public Type getType();


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
