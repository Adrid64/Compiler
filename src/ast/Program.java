// Generated with VGen 2.0.0

package ast;

import ast.statement.*;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	program -> classDeclaration:classDeclaration runStatement:runStatement
*/
public class Program extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// program -> classDeclaration runStatement
	private ClassDeclaration classDeclaration;
	private RunStatement runStatement;

    // ----------------------------------
    // Constructors

	public Program(ClassDeclaration classDeclaration, RunStatement runStatement) {
		super();

		if (classDeclaration == null)
			throw new IllegalArgumentException("Parameter 'classDeclaration' can't be null. Pass a non-null value or use 'classDeclaration?' in the abstract grammar");
		this.classDeclaration = classDeclaration;

		if (runStatement == null)
			throw new IllegalArgumentException("Parameter 'runStatement' can't be null. Pass a non-null value or use 'runStatement?' in the abstract grammar");
		this.runStatement = runStatement;

		updatePositions(classDeclaration, runStatement);
	}

	public Program(Object classDeclaration, Object runStatement) {
		super();

        if (classDeclaration == null)
            throw new IllegalArgumentException("Parameter 'classDeclaration' can't be null. Pass a non-null value or use 'classDeclaration?' in the abstract grammar");
		this.classDeclaration = (ClassDeclaration) classDeclaration;

        if (runStatement == null)
            throw new IllegalArgumentException("Parameter 'runStatement' can't be null. Pass a non-null value or use 'runStatement?' in the abstract grammar");
		this.runStatement = (RunStatement) runStatement;

		updatePositions(classDeclaration, runStatement);
	}


    // ----------------------------------
    // program -> classDeclaration runStatement

	// Child 'classDeclaration' 

	public void setClassDeclaration(ClassDeclaration classDeclaration) {
		if (classDeclaration == null)
			throw new IllegalArgumentException("Parameter 'classDeclaration' can't be null. Pass a non-null value or use 'classDeclaration?' in the abstract grammar");
		this.classDeclaration = classDeclaration;

	}

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }


	// Child 'runStatement' 

	public void setRunStatement(RunStatement runStatement) {
		if (runStatement == null)
			throw new IllegalArgumentException("Parameter 'runStatement' can't be null. Pass a non-null value or use 'runStatement?' in the abstract grammar");
		this.runStatement = runStatement;

	}

    public RunStatement getRunStatement() {
        return runStatement;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Program{" + " classDeclaration=" + this.getClassDeclaration() + " runStatement=" + this.getRunStatement() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
