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
	loopFrom: statement -> st1:statement* expression:expression body:statement*
	statement -> 
	
	PHASE TypeChecking
	statement -> featureSection:featureSection
*/
public class LoopFrom extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// loopFrom: statement -> st1:statement* expression body:statement*
	private List<Statement> st1;
	private Expression expression;
	private List<Statement> body;

    // ----------------------------------
    // Constructors

	public LoopFrom(List<Statement> st1, Expression expression, List<Statement> body) {
		super();

		if (st1 == null)
			st1 = new ArrayList<>();
		this.st1 = st1;

		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

		if (body == null)
			body = new ArrayList<>();
		this.body = body;

		updatePositions(st1, expression, body);
	}

	public LoopFrom(Object st1, Object expression, Object body) {
		super();

        this.st1 = castList(st1, unwrapIfContext.andThen(Statement.class::cast));
        if (expression == null)
            throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = (Expression) expression;

        this.body = castList(body, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(st1, expression, body);
	}


    // ----------------------------------
    // loopFrom: statement -> st1:statement* expression body:statement*

	// Child 'st1:statement*' 

	public void setSt1(List<Statement> st1) {
		if (st1 == null)
			st1 = new ArrayList<>();
		this.st1 = st1;

	}

    public List<Statement> getSt1() {
        return st1;
    }

    public Stream<Statement> st1() {
        return st1.stream();
    }


	// Child 'expression' 

	public void setExpression(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

	}

    public Expression getExpression() {
        return expression;
    }


	// Child 'body:statement*' 

	public void setBody(List<Statement> body) {
		if (body == null)
			body = new ArrayList<>();
		this.body = body;

	}

    public List<Statement> getBody() {
        return body;
    }

    public Stream<Statement> body() {
        return body.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "LoopFrom{" + " st1=" + this.getSt1() + " expression=" + this.getExpression() + " body=" + this.getBody() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
