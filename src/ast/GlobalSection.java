// Generated with VGen 2.0.0

package ast;

import java.util.Optional;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	globalSection -> typesSection:typesSection? varSection:varSection?
*/
public class GlobalSection extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// globalSection -> typesSection? varSection?
	private Optional<TypesSection> typesSection;
	private Optional<VarSection> varSection;

    // ----------------------------------
    // Constructors

	public GlobalSection(Optional<TypesSection> typesSection, Optional<VarSection> varSection) {
		super();

		if (typesSection == null)
			typesSection = Optional.empty();
		this.typesSection = typesSection;

		if (varSection == null)
			varSection = Optional.empty();
		this.varSection = varSection;

		updatePositions(typesSection, varSection);
	}

	public GlobalSection(Object typesSection, Object varSection) {
		super();

        this.typesSection = castOptional(typesSection, TypesSection.class);
        this.varSection = castOptional(varSection, VarSection.class);
		updatePositions(typesSection, varSection);
	}


    // ----------------------------------
    // globalSection -> typesSection? varSection?

	// Child 'typesSection?' 

	public void setTypesSection(Optional<TypesSection> typesSection) {
		if (typesSection == null)
			typesSection = Optional.empty();
		this.typesSection = typesSection;

	}

    public Optional<TypesSection> getTypesSection() {
        return typesSection;
    }


	// Child 'varSection?' 

	public void setVarSection(Optional<VarSection> varSection) {
		if (varSection == null)
			varSection = Optional.empty();
		this.varSection = varSection;

	}

    public Optional<VarSection> getVarSection() {
        return varSection;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "GlobalSection{" + " typesSection=" + this.getTypesSection() + " varSection=" + this.getVarSection() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
