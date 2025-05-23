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
	createSection -> strings:string*
*/
public class CreateSection extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// createSection -> string*
	private List<String> strings;

    // ----------------------------------
    // Constructors

	public CreateSection(List<String> strings) {
		super();

		if (strings == null)
			strings = new ArrayList<>();
		this.strings = strings;

		updatePositions(strings);
	}

	public CreateSection(Object strings) {
		super();

        this.strings = castList(strings,
            unwrapIfContext
            .andThen(unwrapIfToken)
            .andThen(String.class::cast));

		updatePositions(strings);
	}


    // ----------------------------------
    // createSection -> string*

	// Child 'string*' 

	public void setStrings(List<String> strings) {
		if (strings == null)
			strings = new ArrayList<>();
		this.strings = strings;

	}

    public List<String> getStrings() {
        return strings;
    }

    public Stream<String> strings() {
        return strings.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "CreateSection{" + " strings=" + this.getStrings() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
