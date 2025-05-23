// Generated with VGen 2.0.0

package ast;

import ast.declaration.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	varSection -> variableDeclarations:variableDeclaration*
*/
public class VarSection extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// varSection -> variableDeclaration*
	private List<VariableDeclaration> variableDeclarations;

    // ----------------------------------
    // Constructors

	public VarSection(List<VariableDeclaration> variableDeclarations) {
		super();

		if (variableDeclarations == null)
			variableDeclarations = new ArrayList<>();
		this.variableDeclarations = variableDeclarations;

		updatePositions(variableDeclarations);
	}

	public VarSection(Object variableDeclarations) {
		super();

        this.variableDeclarations = castList(variableDeclarations, unwrapIfContext.andThen(VariableDeclaration.class::cast));
		updatePositions(variableDeclarations);
	}


    // ----------------------------------
    // varSection -> variableDeclaration*

	// Child 'variableDeclaration*' 

	public void setVariableDeclarations(List<VariableDeclaration> variableDeclarations) {
		if (variableDeclarations == null)
			variableDeclarations = new ArrayList<>();
		this.variableDeclarations = variableDeclarations;

	}

    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public Stream<VariableDeclaration> variableDeclarations() {
        return variableDeclarations.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "VarSection{" + " variableDeclarations=" + this.getVariableDeclarations() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
