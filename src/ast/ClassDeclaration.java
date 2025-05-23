// Generated with VGen 2.0.0

package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Optional;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	classDeclaration -> name:string globalSection:globalSection? createSection:createSection featureSections:featureSection*
*/
public class ClassDeclaration extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// classDeclaration -> string globalSection? createSection featureSection*
	private String name;
	private Optional<GlobalSection> globalSection;
	private CreateSection createSection;
	private List<FeatureSection> featureSections;

    // ----------------------------------
    // Constructors

	public ClassDeclaration(String name, Optional<GlobalSection> globalSection, CreateSection createSection, List<FeatureSection> featureSections) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (globalSection == null)
			globalSection = Optional.empty();
		this.globalSection = globalSection;

		if (createSection == null)
			throw new IllegalArgumentException("Parameter 'createSection' can't be null. Pass a non-null value or use 'createSection?' in the abstract grammar");
		this.createSection = createSection;

		if (featureSections == null)
			featureSections = new ArrayList<>();
		this.featureSections = featureSections;

		updatePositions(name, globalSection, createSection, featureSections);
	}

	public ClassDeclaration(Object name, Object globalSection, Object createSection, Object featureSections) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.globalSection = castOptional(globalSection, GlobalSection.class);
        if (createSection == null)
            throw new IllegalArgumentException("Parameter 'createSection' can't be null. Pass a non-null value or use 'createSection?' in the abstract grammar");
		this.createSection = (CreateSection) createSection;

        this.featureSections = castList(featureSections, unwrapIfContext.andThen(FeatureSection.class::cast));
		updatePositions(name, globalSection, createSection, featureSections);
	}


    // ----------------------------------
    // classDeclaration -> string globalSection? createSection featureSection*

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'globalSection?' 

	public void setGlobalSection(Optional<GlobalSection> globalSection) {
		if (globalSection == null)
			globalSection = Optional.empty();
		this.globalSection = globalSection;

	}

    public Optional<GlobalSection> getGlobalSection() {
        return globalSection;
    }


	// Child 'createSection' 

	public void setCreateSection(CreateSection createSection) {
		if (createSection == null)
			throw new IllegalArgumentException("Parameter 'createSection' can't be null. Pass a non-null value or use 'createSection?' in the abstract grammar");
		this.createSection = createSection;

	}

    public CreateSection getCreateSection() {
        return createSection;
    }


	// Child 'featureSection*' 

	public void setFeatureSections(List<FeatureSection> featureSections) {
		if (featureSections == null)
			featureSections = new ArrayList<>();
		this.featureSections = featureSections;

	}

    public List<FeatureSection> getFeatureSections() {
        return featureSections;
    }

    public Stream<FeatureSection> featureSections() {
        return featureSections.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ClassDeclaration{" + " name=" + this.getName() + " globalSection=" + this.getGlobalSection() + " createSection=" + this.getCreateSection() + " featureSections=" + this.getFeatureSections() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
