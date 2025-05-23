// Generated with VGen 2.0.0

package ast.statement;

import ast.*;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	statement -> 
	
	PHASE TypeChecking
	statement -> featureSection:featureSection
*/
public abstract class AbstractStatement extends AbstractAST implements Statement {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private FeatureSection featureSection;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'featureSection' 

	public void setFeatureSection(FeatureSection featureSection) {
		if (featureSection == null)
			throw new IllegalArgumentException("Parameter 'featureSection' can't be null. Pass a non-null value or use 'featureSection?' in the abstract grammar");
		this.featureSection = featureSection;

	}

    public FeatureSection getFeatureSection() {
        return featureSection;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
