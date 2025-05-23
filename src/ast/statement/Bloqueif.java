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
	bloqueif: statement -> expression:expression st2:statement* st3:statement*
	statement -> 
	
	PHASE TypeChecking
	statement -> featureSection:featureSection
*/
public class Bloqueif extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// bloqueif: statement -> expression st2:statement* st3:statement*
	private Expression expression;
	private List<Statement> st2;
	private List<Statement> st3;

    // ----------------------------------
    // Constructors

	public Bloqueif(Expression expression, List<Statement> st2, List<Statement> st3) {
		super();

		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

		if (st2 == null)
			st2 = new ArrayList<>();
		this.st2 = st2;

		if (st3 == null)
			st3 = new ArrayList<>();
		this.st3 = st3;

		updatePositions(expression, st2, st3);
	}

	public Bloqueif(Object expression, Object st2, Object st3) {
		super();

        if (expression == null)
            throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = (Expression) expression;

        this.st2 = castList(st2, unwrapIfContext.andThen(Statement.class::cast));
        this.st3 = castList(st3, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(expression, st2, st3);
	}


    // ----------------------------------
    // bloqueif: statement -> expression st2:statement* st3:statement*

	// Child 'expression' 

	public void setExpression(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

	}

    public Expression getExpression() {
        return expression;
    }


	// Child 'st2:statement*' 

	public void setSt2(List<Statement> st2) {
		if (st2 == null)
			st2 = new ArrayList<>();
		this.st2 = st2;

	}

    public List<Statement> getSt2() {
        return st2;
    }

    public Stream<Statement> st2() {
        return st2.stream();
    }


	// Child 'st3:statement*' 

	public void setSt3(List<Statement> st3) {
		if (st3 == null)
			st3 = new ArrayList<>();
		this.st3 = st3;

	}

    public List<Statement> getSt3() {
        return st3;
    }

    public Stream<Statement> st3() {
        return st3.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Bloqueif{" + " expression=" + this.getExpression() + " st2=" + this.getSt2() + " st3=" + this.getSt3() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
