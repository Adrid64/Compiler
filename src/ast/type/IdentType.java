// Generated with VGen 2.0.0

package ast.type;

import ast.*;
import ast.declaration.StructField;

import java.util.List;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	identType: type -> name:string
	type -> 
	
	PHASE Identification
	identType -> structDeclaration:structDeclaration
*/
public class IdentType extends AbstractType  {

    // ----------------------------------
    // Instance Variables

	// identType: type -> string
	private String name;

    // PHASE Identification
	private StructDeclaration structDeclaration;

    // ----------------------------------
    // Constructors

	public IdentType(String name) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		updatePositions(name);
	}

	public IdentType(Object name) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		updatePositions(name);
	}


    // ----------------------------------
    // identType: type -> string

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
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


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IdentType{" + " name=" + this.getName() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
    @Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return name;
	}
    
    @Override
	public int getSize() {
		// TODO Auto-generated method stub
    	int size=0;
    	List<StructField> list = structDeclaration.getStructFields();
    	for (StructField structField : list) {
			size+=structField.getType().getSize();
		}
		return size;
	}
    // %% --------------------------------------

	
}
