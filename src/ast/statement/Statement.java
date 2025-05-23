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
public interface Statement extends AST {




    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'featureSection' 

	public void setFeatureSection(FeatureSection featureSection);
	public FeatureSection getFeatureSection();


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
