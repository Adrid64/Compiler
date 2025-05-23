// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.expression.*;
import codegeneration.mapl.*;


public class Address extends AbstractCodeFunction {

    public Address(MaplCodeSpecification specification) {
        super(specification);
    }


	// class IntLiteral(String name)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		out("<instruction>");

		return null;
	}

	// class RealConstant(String name)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(RealConstant realConstant, Object param) {

		out("<instruction>");

		return null;
	}

	// class CharConstant(String name)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(CharConstant charConstant, Object param) {

		out("<instruction>");

		return null;
	}

	// class FunctionCallExp(String name, List<Expression> expresiones)
	// phase Identification { FeatureSection featureSection }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(FunctionCallExp functionCallExp, Object param) {

		// value(functionCallExp.expresiones());
		// address(functionCallExp.expresiones());

		out("<instruction>");

		return null;
	}

	// class ArrayAcces(Expression exp2, Expression exp3)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(ArrayAcces arrayAcces, Object param) {

		// value(arrayAcces.getExp2());
		// address(arrayAcces.getExp2());

		// value(arrayAcces.getExp3());
		// address(arrayAcces.getExp3());

		out("<instruction>");

		return null;
	}

	// class VariableAcces(String name)
	// phase Identification { Declaration declaration }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(VariableAcces variableAcces, Object param) {

		out("<instruction>");

		return null;
	}

	// class RestaUnaria(Expression exp2)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(RestaUnaria restaUnaria, Object param) {

		// value(restaUnaria.getExp2());
		// address(restaUnaria.getExp2());

		out("<instruction>");

		return null;
	}

	// class Parentesis(Expression exp2)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Parentesis parentesis, Object param) {

		// value(parentesis.getExp2());
		// address(parentesis.getExp2());

		out("<instruction>");

		return null;
	}

	// class Negacion(Expression exp2)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Negacion negacion, Object param) {

		// value(negacion.getExp2());
		// address(negacion.getExp2());

		out("<instruction>");

		return null;
	}

	// class Cast(Type tipoCast, Expression exp2)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Cast cast, Object param) {

		// declareType(cast.getTipoCast());

		// value(cast.getExp2());
		// address(cast.getExp2());

		out("<instruction>");

		return null;
	}

	// class Arithmetic(Expression exp2, String name, Expression exp3)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

		// value(arithmetic.getExp2());
		// address(arithmetic.getExp2());

		// value(arithmetic.getExp3());
		// address(arithmetic.getExp3());

		out("<instruction>");

		return null;
	}

	// class BooleanExp(Expression exp2, String name, Expression exp3)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(BooleanExp booleanExp, Object param) {

		// value(booleanExp.getExp2());
		// address(booleanExp.getExp2());

		// value(booleanExp.getExp3());
		// address(booleanExp.getExp3());

		out("<instruction>");

		return null;
	}

	// class StructFieldAcces(Expression exp2, String name)
	// phase Identification { StructDeclaration structDeclaration }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(StructFieldAcces structFieldAcces, Object param) {

		// value(structFieldAcces.getExp2());
		// address(structFieldAcces.getExp2());

		out("<instruction>");

		return null;
	}

}
