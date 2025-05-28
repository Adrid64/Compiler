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
        String literal = charConstant.getName();
        int asciiValue;

        // Check if the string is a valid character literal (starts and ends with quotes)
        if (literal.length() >= 2 && literal.startsWith("'") && literal.endsWith("'")) {
            // Extract the content between the quotes
            String content = literal.substring(1, literal.length() - 1);

            if (content.equals("\\n")) {
                asciiValue = 10; 
            } else if (content.length() == 1) {
                asciiValue = content.charAt(0); 
            } else {
                throw new IllegalStateException("Invalid character literal: " + literal);
            }
        } else {
            throw new IllegalStateException("Invalid character literal format: " + literal);
        }

        out("pushb " + asciiValue);
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
    
    @Override
    public Object visit(Relacional relacional, Object param) {
        // Evaluate left operand
        value(relacional.getExp2());
        // Evaluate right operand
        value(relacional.getExp3());
        // Emit comparison instruction based on operator and type
        String operator = relacional.getName();
        if (relacional.getExp2().getType() instanceof DoubleType) {
            switch (operator) {
                case "<":
                    out("ltf"); // Less than (float)
                    break;
                case ">":
                    out("gtf"); // Greater than (float)
                    break;
                case "<=":
                    out("lef"); // Less than or equal (float)
                    break;
                case ">=":
                    out("gef"); // Greater than or equal (float)
                    break;
                case "==":
                    out("eqf"); // Equal (float)
                    break;
                case "!=":
                    out("nef"); // Not equal (float)
                    break;
                default:
                    throw new IllegalStateException("Unknown relational operator: " + operator);
            }
        } else if (relacional.getExp2().getType() instanceof IntType) {
            switch (operator) {
                case "<":
                    out("lti"); // Less than (integer)
                    break;
                case ">":
                    out("gti"); // Greater than (integer)
                    break;
                case "<=":
                    out("lei"); // Less than or equal (integer)
                    break;
                case ">=":
                    out("gei"); // Greater than or equal (integer)
                    break;
                case "==":
                    out("eqi"); // Equal (integer)
                    break;
                case "!=":
                    out("nei"); // Not equal (integer)
                    break;
                default:
                    throw new IllegalStateException("Unknown relational operator: " + operator);
            }
        } else {
            throw new IllegalStateException("Unsupported type for relational operation: " + relacional.getExp2().getType());
        }
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
    //revisar
    @Override
    public Object visit(Cast cast, Object param) {
        value(cast.getExp2());

        String from = suffixFor(cast.getExp2().getType());
        String to = suffixFor(cast.getType());

        // Solo se aceptan las conversiones explícitas válidas
        String instr = switch (from + "2" + to) {
            case "i2f" -> "i2f";
            case "f2i" -> "f2i";
            case "b2i" -> "b2i";
            case "i2b" -> "i2b";
            default -> throw new IllegalArgumentException("Conversión no soportada de " + from + " a " + to);
        };

        out(instr);
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
        String sufijo = suffixFor(booleanExp.getExp2().getType()); // Sufijo según tipo (i, f, b)

        switch (op) {
            case "and":
                out("and");
                break;
            case "or":
                out("or");
                break;
            case "=":
                out("eq" + sufijo);
                break;
            case "!=":
                out("ne" + sufijo);
                break;
            case "<":
                out("lt" + sufijo);
                break;
            case "<=":
                out("le" + sufijo);
                break;
            case ">":
                out("gt" + sufijo);
                break;
            case ">=":
                out("ge" + sufijo);
                break;
            default:
                throw new IllegalArgumentException("Unsupported boolean operator in BooleanExp: " + op);
        }

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