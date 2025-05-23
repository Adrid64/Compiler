package codegeneration.mapl.codefunctions;

import ast.expression.*;
import ast.type.*;
import codegeneration.mapl.*;

public class Value extends AbstractCodeFunction {

    public Value(MaplCodeSpecification specification) {
        super(specification);
    }

    // class IntLiteral(String name)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        out("pushi " + intLiteral.getName());
        return null;
    }

    // class RealConstant(String name)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(RealConstant realConstant, Object param) {
        out("pushf " + realConstant.getName());
        return null;
    }

    // class CharConstant(String name)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(CharConstant charConstant, Object param) {
        out("pushb '" + charConstant.getName() + "'");
        return null;
    }

    // class FunctionCallExp(String name, List<Expression> expresiones)
    // phase Identification { FeatureSection featureSection }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(FunctionCallExp functionCallExp, Object param) {
        for (Expression expr : functionCallExp.getExpresiones()) {
            value(expr);
        }
        out("call " + functionCallExp.getName());
        // Si la función retorna un valor (no void), el valor ya está en la pila
        return null;
    }

    // class ArrayAcces(Expression exp2, Expression exp3)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(ArrayAcces arrayAcces, Object param) {
        address(arrayAcces);
        out("load", arrayAcces.getType());
        return null;
    }

    // class VariableAcces(String name)
    // phase Identification { Declaration declaration }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(VariableAcces variableAcces, Object param) {
        address(variableAcces);
        out("load", variableAcces.getType());
        return null;
    }

    // class RestaUnaria(Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(RestaUnaria restaUnaria, Object param) {
        value(restaUnaria.getExp2());
        out("neg", restaUnaria.getType());
        return null;
    }

    // class Parentesis(Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Parentesis parentesis, Object param) {
        value(parentesis.getExp2());
        return null;
    }

    // class Negacion(Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Negacion negacion, Object param) {
        value(negacion.getExp2());
        out("not");
        return null;
    }

    // class Cast(Type tipoCast, Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Cast cast, Object param) {
        value(cast.getExp2());
        String sourceType = cast.getExp2().getType().getTypeName();
        String targetType = cast.getTipoCast().getTypeName();
        if (!sourceType.equals(targetType)) {
            out("cast" + sourceType.charAt(0) + targetType.charAt(0));
        }
        return null;
    }

    // class Arithmetic(Expression exp2, String name, Expression exp3)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        value(arithmetic.getExp2());
        value(arithmetic.getExp3());
        String op = arithmetic.getName();
        String instruction;
        switch (op) {
            case "+": instruction = "add"; break;
            case "-": instruction = "sub"; break;
            case "*": instruction = "mul"; break;
            case "/": instruction = "div"; break;
            case "%": instruction = "mod"; break;
            default: throw new IllegalArgumentException("Unsupported arithmetic operator: " + op);
        }
        out(instruction, arithmetic.getType());
        return null;
    }

    // class BooleanExp(Expression exp2, String name, Expression exp3)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(BooleanExp booleanExp, Object param) {
        value(booleanExp.getExp2());
        value(booleanExp.getExp3());
        String op = booleanExp.getName();
        String instruction;
        switch (op) {
            case "&&": instruction = "and"; break;
            case "||": instruction = "or"; break;
            case "==": instruction = "eq"; break;
            case "!=": instruction = "ne"; break;
            case "<": instruction = "lt"; break;
            case ">": instruction = "gt"; break;
            case "<=": instruction = "le"; break;
            case ">=": instruction = "ge"; break;
            default: throw new IllegalArgumentException("Unsupported boolean operator: " + op);
        }
        out(instruction, booleanExp.getType());
        return null;
    }

    // class StructFieldAcces(Expression exp2, String name)
    // phase Identification { StructDeclaration structDeclaration }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(StructFieldAcces structFieldAcces, Object param) {
        address(structFieldAcces);
        out("load", structFieldAcces.getType());
        return null;
    }

    // Método auxiliar para emitir instrucción con sufijo según el tipo
    private void out(String instruction, Type type) {
        out(instruction + suffixFor(type));
    }

    // Método auxiliar para determinar el sufijo del tipo
    private String suffixFor(Type type) {
        if (type instanceof IntType) {
            return "i";
        } else if (type instanceof DoubleType) {
            return "f";
        } else if (type instanceof CharacterType) {
            return "b";
        } else {
            throw new IllegalArgumentException("Unsupported type for operation: " + type);
        }
    }
}