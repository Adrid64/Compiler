// Generated with VGen 2.0.0

package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	typesSection -> structDeclarations:structDeclaration*
*/
public class TypesSection extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// typesSection -> structDeclaration*
	private List<StructDeclaration> structDeclarations;

    // ----------------------------------
    // Constructors

	public TypesSection(List<StructDeclaration> structDeclarations) {
		super();

		if (structDeclarations == null)
			structDeclarations = new ArrayList<>();
		this.structDeclarations = structDeclarations;

		updatePositions(structDeclarations);
	}

	public TypesSection(Object structDeclarations) {
		super();

        this.structDeclarations = castList(structDeclarations, unwrapIfContext.andThen(StructDeclaration.class::cast));
		updatePositions(structDeclarations);
	}


    // ----------------------------------
    // typesSection -> structDeclaration*

	// Child 'structDeclaration*' 

	public void setStructDeclarations(List<StructDeclaration> structDeclarations) {
		if (structDeclarations == null)
			structDeclarations = new ArrayList<>();
		this.structDeclarations = structDeclarations;

	}

    public List<StructDeclaration> getStructDeclarations() {
        return structDeclarations;
    }

    public Stream<StructDeclaration> structDeclarations() {
        return structDeclarations.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "TypesSection{" + " structDeclarations=" + this.getStructDeclarations() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
