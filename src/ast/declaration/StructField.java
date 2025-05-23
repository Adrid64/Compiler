// Generated with VGen 2.0.0

package ast.declaration;

import ast.type.*;
import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	structField: declaration -> name:string type:type
	declaration -> 
	
	PHASE Identification
	structField -> structDeclaration:structDeclaration
	
	PHASE MemoryAllocation
	structField -> address:int
*/
public class StructField extends AbstractDeclaration  {

    // ----------------------------------
    // Instance Variables

	// structField: declaration -> string type
	private String name;
	private Type type;

    // PHASE Identification
	private StructDeclaration structDeclaration;

    // PHASE MemoryAllocation
	private int address;

    // ----------------------------------
    // Constructors

	public StructField(String name, Type type) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = type;

		updatePositions(name, type);
	}

	public StructField(Object name, Object type) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        if (type == null)
            throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = (Type) type;

		updatePositions(name, type);
	}


    // ----------------------------------
    // structField: declaration -> string type

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'type' 

	public void setType(Type type) {
		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = type;

	}

    public Type getType() {
        return type;
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'structDeclaration' 

	public void setStructDeclaration(StructDeclaration structDeclaration) {
		if (structDeclaration == null)
			throw new IllegalArgumentException("Parameter 'structDeclaration' can't be null. Pass a non-null value or use 'structDeclaration?' in the abstract grammar");
		this.structDeclaration = structDeclaration;

	}

    public StructDeclaration getStructDeclaration() {
        return structDeclaration;
    }



    // --------------------------------
    // PHASE MemoryAllocation

	// Attribute 'address:int' 

	public void setAddress(int address) {
		this.address = address;

	}

    public int getAddress() {
        return address;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StructField{" + " name=" + this.getName() + " type=" + this.getType() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
