// Generated with VGen 2.0.0

package ast.type;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arraytype: type -> intValue:int type2:type
	type -> 
*/
public class Arraytype extends AbstractType  {

    // ----------------------------------
    // Instance Variables

	// arraytype: type -> int type2:type
	private int intValue;
	private Type type2;

    // ----------------------------------
    // Constructors

	public Arraytype(int intValue, Type type2) {
		super();

		this.intValue = intValue;

		if (type2 == null)
			throw new IllegalArgumentException("Parameter 'type2' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type2 = type2;

		updatePositions(intValue, type2);
	}

	public Arraytype(Object intValue, Object type2) {
		super();

        if (intValue == null)
            throw new IllegalArgumentException("Parameter 'intValue' can't be null. Pass a non-null value or use 'int?' in the abstract grammar");
        var intValue_temp = intValue;
        if (intValue_temp instanceof Token)
            intValue_temp = ((Token) intValue_temp).getText();
        if (intValue_temp instanceof String)
            intValue_temp = Integer.valueOf((String) intValue_temp);
        this.intValue = (int) intValue_temp;

        if (type2 == null)
            throw new IllegalArgumentException("Parameter 'type2' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type2 = (Type) type2;

		updatePositions(intValue, type2);
	}


    // ----------------------------------
    // arraytype: type -> int type2:type

	// Child 'int' 

	public void setIntValue(int intValue) {
		this.intValue = intValue;

	}

    public int getIntValue() {
        return intValue;
    }


	// Child 'type2:type' 

	public void setType2(Type type2) {
		if (type2 == null)
			throw new IllegalArgumentException("Parameter 'type2' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type2 = type2;

	}

    public Type getType2() {
        return type2;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Arraytype{" + " intValue=" + this.getIntValue() + " type2=" + this.getType2() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
    @Override
    public String getTypeName() {
        return type2.getTypeName() + "[" + intValue + "]";
    }

    
    @Override
	public int getSize() {
		// TODO Auto-generated method stub
		return type2.getSize()* intValue;
	}
    // %% --------------------------------------



	
}
