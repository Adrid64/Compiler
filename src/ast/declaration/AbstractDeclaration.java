// Generated with VGen 2.0.0

package ast.declaration;

import ast.*;
import ast.type.Type;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	declaration -> 
*/
public abstract class AbstractDeclaration extends AbstractAST implements Declaration {




    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
		
	protected Type type;
    protected String name;
    protected int scope;
    @Override
    public Type getType() {
        return type;
    }


    @Override
    public int getScope() {
        return scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }
    // %% --------------------------------------
}
