// Generated with VGen 2.0.0

package ast;

import ast.type.*;
import ast.statement.*;
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
	featureSection -> name:string args:args? type:type? localSection:localSection? statements:statement*
	
	PHASE TypeChecking
	featureSection -> hasReturn:boolean
*/
public class FeatureSection extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// featureSection -> string args? type? localSection? statement*
	private String name;
	private Optional<Args> args;
	private Optional<Type> type;
	private Optional<LocalSection> localSection;
	private List<Statement> statements;

    // PHASE TypeChecking
	private boolean hasReturn;

    // ----------------------------------
    // Constructors

	public FeatureSection(String name, Optional<Args> args, Optional<Type> type, Optional<LocalSection> localSection, List<Statement> statements) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (args == null)
			args = Optional.empty();
		this.args = args;

		if (type == null)
			type = Optional.empty();
		this.type = type;

		if (localSection == null)
			localSection = Optional.empty();
		this.localSection = localSection;

		if (statements == null)
			statements = new ArrayList<>();
		this.statements = statements;

		updatePositions(name, args, type, localSection, statements);
	}

	public FeatureSection(Object name, Object args, Object type, Object localSection, Object statements) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.args = castOptional(args, Args.class);
        this.type = castOptional(type, Type.class);
        this.localSection = castOptional(localSection, LocalSection.class);
        this.statements = castList(statements, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(name, args, type, localSection, statements);
	}


    // ----------------------------------
    // featureSection -> string args? type? localSection? statement*

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'args?' 

	public void setArgs(Optional<Args> args) {
		if (args == null)
			args = Optional.empty();
		this.args = args;

	}

    public Optional<Args> getArgs() {
        return args;
    }


	// Child 'type?' 

	public void setType(Optional<Type> type) {
		if (type == null)
			type = Optional.empty();
		this.type = type;

	}

    public Optional<Type> getType() {
        return type;
    }


	// Child 'localSection?' 

	public void setLocalSection(Optional<LocalSection> localSection) {
		if (localSection == null)
			localSection = Optional.empty();
		this.localSection = localSection;

	}

    public Optional<LocalSection> getLocalSection() {
        return localSection;
    }


	// Child 'statement*' 

	public void setStatements(List<Statement> statements) {
		if (statements == null)
			statements = new ArrayList<>();
		this.statements = statements;

	}

    public List<Statement> getStatements() {
        return statements;
    }

    public Stream<Statement> statements() {
        return statements.stream();
    }



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'hasReturn:boolean' 

	public void setHasReturn(boolean hasReturn) {
		this.hasReturn = hasReturn;

	}

    public boolean isHasReturn() {
        return hasReturn;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FeatureSection{" + " name=" + this.getName() + " args=" + this.getArgs() + " type=" + this.getType() + " localSection=" + this.getLocalSection() + " statements=" + this.getStatements() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
