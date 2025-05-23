// Generated with VGen 2.0.0

package ast.declaration;

import ast.type.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	variableDeclaration: declaration -> identifiers:string* type:type
	declaration -> 
	
	PHASE MemoryAllocation
	variableDeclaration -> address:int
*/
public class VariableDeclaration extends AbstractDeclaration  {

    // ----------------------------------
    // Instance Variables

	// variableDeclaration: declaration -> identifiers:string* type
	private List<String> identifiers;
	private Type type;

    // PHASE MemoryAllocation
	private int address;

    // ----------------------------------
    // Constructors

	public VariableDeclaration(List<String> identifiers, Type type) {
		super();

		if (identifiers == null)
			identifiers = new ArrayList<>();
		this.identifiers = identifiers;

		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = type;

		updatePositions(identifiers, type);
	}

	public VariableDeclaration(Object identifiers, Object type) {
		super();

        this.identifiers = castList(identifiers,
            unwrapIfContext
            .andThen(unwrapIfToken)
            .andThen(String.class::cast));

        if (type == null)
            throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = (Type) type;

		updatePositions(identifiers, type);
	}


    // ----------------------------------
    // variableDeclaration: declaration -> identifiers:string* type

	// Child 'identifiers:string*' 

	public void setIdentifiers(List<String> identifiers) {
		if (identifiers == null)
			identifiers = new ArrayList<>();
		this.identifiers = identifiers;

	}

    public List<String> getIdentifiers() {
        return identifiers;
    }

    public Stream<String> identifiers() {
        return identifiers.stream();
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
        return "VariableDeclaration{" + " identifiers=" + this.getIdentifiers() + " type=" + this.getType() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
