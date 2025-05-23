// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.declaration.*;
import codegeneration.mapl.*;


public class Declare extends AbstractCodeFunction {

    public Declare(MaplCodeSpecification specification) {
        super(specification);
    }


	// class VariableDeclaration(List<String> identifiers, Type type)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(VariableDeclaration variableDeclaration, Object param) {

		// declareType(variableDeclaration.getType());

		out("<instruction>");

		return null;
	}

	// class StructField(String name, Type type)
	// phase Identification { StructDeclaration structDeclaration }
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(StructField structField, Object param) {

		// declareType(structField.getType());

		out("<instruction>");

		return null;
	}

	// class Arg(String name, Type type)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(Arg arg, Object param) {

		// declareType(arg.getType());

		out("<instruction>");

		return null;
	}

}
