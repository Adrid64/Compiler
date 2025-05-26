// Generated with VGen 2.0.0

package ast.type;

import ast.*;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	type -> 
*/
public abstract class AbstractType extends AbstractAST implements Type {




    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
	
	// En ast/type/AbstractType.java
	public Type dot(String fieldName) {
	    // Por defecto, no es un struct, luego no admite campos
	    return new ErrorType("El tipo " + getTypeName() + " no es un tipo compuesto");
	}

    // %% --------------------------------------
}
