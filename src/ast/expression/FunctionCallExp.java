// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import ast.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	functionCallExp: expression -> name:string expresiones:expression*
	expression -> 
	
	PHASE Identification
	functionCallExp -> featureSection:featureSection
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class FunctionCallExp extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// functionCallExp: expression -> string expresiones:expression*
	private String name;
	private List<Expression> expresiones;

    // PHASE Identification
	private FeatureSection featureSection;

    // ----------------------------------
    // Constructors

	public FunctionCallExp(String name, List<Expression> expresiones) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (expresiones == null)
			expresiones = new ArrayList<>();
		this.expresiones = expresiones;

		updatePositions(name, expresiones);
	}

	public FunctionCallExp(Object name, Object expresiones) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.expresiones = castList(expresiones, unwrapIfContext.andThen(Expression.class::cast));
		updatePositions(name, expresiones);
	}


    // ----------------------------------
    // functionCallExp: expression -> string expresiones:expression*

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'expresiones:expression*' 

	public void setExpresiones(List<Expression> expresiones) {
		if (expresiones == null)
			expresiones = new ArrayList<>();
		this.expresiones = expresiones;

	}

    public List<Expression> getExpresiones() {
        return expresiones;
    }

    public Stream<Expression> expresiones() {
        return expresiones.stream();
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'featureSection' 

	public void setFeatureSection(FeatureSection featureSection) {
		if (featureSection == null)
			throw new IllegalArgumentException("Parameter 'featureSection' can't be null. Pass a non-null value or use 'featureSection?' in the abstract grammar");
		this.featureSection = featureSection;

	}

    public FeatureSection getFeatureSection() {
        return featureSection;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FunctionCallExp{" + " name=" + this.getName() + " expresiones=" + this.getExpresiones() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
