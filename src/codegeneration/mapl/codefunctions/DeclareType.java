// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.type.*;
import codegeneration.mapl.*;


public class DeclareType extends AbstractCodeFunction {

    public DeclareType(MaplCodeSpecification specification) {
        super(specification);
    }


	// class IntType(String name)
	@Override
	public Object visit(IntType intType, Object param) {

		out("<instruction>");

		return null;
	}

	// class DoubleType(String name)
	@Override
	public Object visit(DoubleType doubleType, Object param) {

		out("<instruction>");

		return null;
	}

	// class CharacterType(String name)
	@Override
	public Object visit(CharacterType characterType, Object param) {

		out("<instruction>");

		return null;
	}

	// class IdentType(String name)
	// phase Identification { StructDeclaration structDeclaration }
	@Override
	public Object visit(IdentType identType, Object param) {

		out("<instruction>");

		return null;
	}

	// class Arraytype(int intValue, Type type2)
	@Override
	public Object visit(Arraytype arraytype, Object param) {

		// declareType(arraytype.getType2());

		out("<instruction>");

		return null;
	}

	// class ErrorType(String name)
	@Override
	public Object visit(ErrorType errorType, Object param) {

		out("<instruction>");

		return null;
	}

	// class VoidType(String name)
	@Override
	public Object visit(VoidType voidType, Object param) {

		out("<instruction>");

		return null;
	}

}
