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
	localSection -> variableDeclarations:variableDeclaration*
*/
public class LocalSection extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// localSection -> variableDeclaration*
	private List<VariableDeclaration> variableDeclarations;

    // ----------------------------------
    // Constructors

	public LocalSection(List<VariableDeclaration> variableDeclarations) {
		super();

		if (variableDeclarations == null)
			variableDeclarations = new ArrayList<>();
		this.variableDeclarations = variableDeclarations;

		updatePositions(variableDeclarations);
	}

	public LocalSection(Object variableDeclarations) {
		super();

        this.variableDeclarations = castList(variableDeclarations, unwrapIfContext.andThen(VariableDeclaration.class::cast));
		updatePositions(variableDeclarations);
	}


    // ----------------------------------
    // localSection -> variableDeclaration*

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
        return "LocalSection{" + " variableDeclarations=" + this.getVariableDeclarations() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
