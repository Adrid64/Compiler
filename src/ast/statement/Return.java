// Generated with VGen 2.0.0

package ast.statement;

import ast.expression.*;
import ast.*;
import java.util.Optional;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	return: statement -> expression:expression?
	statement -> 
	
	PHASE TypeChecking
	statement -> featureSection:featureSection
*/
public class Return extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// return: statement -> expression?
	private Optional<Expression> expression;

    // ----------------------------------
    // Constructors

	public Return(Optional<Expression> expression) {
		super();

		if (expression == null)
			expression = Optional.empty();
		this.expression = expression;

		updatePositions(expression);
	}

	public Return(Object expression) {
		super();

        this.expression = castOptional(expression, Expression.class);
		updatePositions(expression);
	}


    // ----------------------------------
    // return: statement -> expression?

	// Child 'expression?' 

	public void setExpression(Optional<Expression> expression) {
		if (expression == null)
			expression = Optional.empty();
		this.expression = expression;

	}

    public Optional<Expression> getExpression() {
        return expression;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Return{" + " expression=" + this.getExpression() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
