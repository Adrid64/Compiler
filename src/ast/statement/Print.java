// Generated with VGen 2.0.0

package ast.statement;

import ast.expression.*;
import ast.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	print: statement -> expressions:expression*
	statement -> 
	
	PHASE TypeChecking
	statement -> featureSection:featureSection
*/
public class Print extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// print: statement -> expression*
	private List<Expression> expressions;

    // ----------------------------------
    // Constructors

	public Print(List<Expression> expressions) {
		super();

		if (expressions == null)
			expressions = new ArrayList<>();
		this.expressions = expressions;

		updatePositions(expressions);
	}

	public Print(Object expressions) {
		super();

        this.expressions = castList(expressions, unwrapIfContext.andThen(Expression.class::cast));
		updatePositions(expressions);
	}


    // ----------------------------------
    // print: statement -> expression*

	// Child 'expression*' 

	public void setExpressions(List<Expression> expressions) {
		if (expressions == null)
			expressions = new ArrayList<>();
		this.expressions = expressions;

	}

    public List<Expression> getExpressions() {
        return expressions;
    }

    public Stream<Expression> expressions() {
        return expressions.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Print{" + " expressions=" + this.getExpressions() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
