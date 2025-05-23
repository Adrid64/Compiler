package codegeneration.mapl.codefunctions;

import ast.expression.*;
import ast.declaration.*;
import ast.type.*;
import codegeneration.mapl.*;

public class Address extends AbstractCodeFunction {

    public Address(MaplCodeSpecification specification) {
        super(specification);
    }

    // class IntLiteral(String name)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        throw new IllegalStateException("Cannot compute address of IntLiteral (not an l-value)");
    }

    // class RealConstant(String name)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(RealConstant realConstant, Object param) {
        throw new IllegalStateException("Cannot compute address of RealConstant (not an l-value)");
    }

    // class CharConstant(String name)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(CharConstant charConstant, Object param) {
        throw new IllegalStateException("Cannot compute address of CharConstant (not an l-value)");
    }

    // class FunctionCallExp(String name, List<Expression> expresiones)
    // phase Identification { FeatureSection featureSection }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(FunctionCallExp functionCallExp, Object param) {
        throw new IllegalStateException("Cannot compute address of FunctionCallExp (not an l-value)");
    }

    // class ArrayAcces(Expression exp2, Expression exp3)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(ArrayAcces arrayAcces, Object param) {
        address(arrayAcces.getExp2()); // Dirección base del arreglo
        value(arrayAcces.getExp3());  // Índice
        out("pushi " + arrayAcces.getType().getSize()); // Tamaño del elemento
        out("muli"); // Calcular desplazamiento (índice * tamaño)
        out("addi"); // Sumar desplazamiento a la dirección base
        return null;
    }

    // class VariableAcces(String name)
    // phase Identification { Declaration declaration }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(VariableAcces variableAcces, Object param) {
        Declaration decl = variableAcces.getDeclaration();
        if (decl instanceof VariableDeclaration) {
            VariableDeclaration varDecl = (VariableDeclaration) decl;
            if (varDecl.getScope().equals("global")) {
                out("pusha " + varDecl.getAddress());
            } else {
                out("pushbp");
                out("pushi " + varDecl.getAddress());
                out("addi");
            }
        } else if (decl instanceof Arg) {
            Arg arg = (Arg) decl;
            out("pushbp");
            out("pushi " + arg.getAddress());
            out("addi");
        }
        return null;
    }

    // class RestaUnaria(Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(RestaUnaria restaUnaria, Object param) {
        throw new IllegalStateException("Cannot compute address of RestaUnaria (not an l-value)");
    }

    // class Parentesis(Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Parentesis parentesis, Object param) {
        if (parentesis.getExp2().getLvalue()) {
            address(parentesis.getExp2());
        } else {
            throw new IllegalStateException("Cannot compute address of Parentesis (inner expression is not an l-value)");
        }
        return null;
    }

    // class Negacion(Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Negacion negacion, Object param) {
        throw new IllegalStateException("Cannot compute address of Negacion (not an l-value)");
    }

    // class Cast(Type tipoCast, Expression exp2)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Cast cast, Object param) {
        if (cast.getExp2().getLvalue()) {
            address(cast.getExp2());
        } else {
            throw new IllegalStateException("Cannot compute address of Cast (inner expression is not an l-value)");
        }
        return null;
    }

    // class Arithmetic(Expression exp2, String name, Expression exp3)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        throw new IllegalStateException("Cannot compute address of Arithmetic (not an l-value)");
    }

    // class BooleanExp(Expression exp2, String name, Expression exp3)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(BooleanExp booleanExp, Object param) {
        throw new IllegalStateException("Cannot compute address of BooleanExp (not an l-value)");
    }

    // class StructFieldAcces(Expression exp2, String name)
    // phase Identification { StructDeclaration structDeclaration }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(StructFieldAcces structFieldAcces, Object param) {
        address(structFieldAcces.getExp2()); // Dirección base de la estructura
        StructDeclaration structDecl = structFieldAcces.getStructDeclaration();
        int offset = calculateFieldOffset(structDecl, structFieldAcces.getName());
        out("pushi " + offset);
        out("addi"); // Sumar desplazamiento a la dirección base
        return null;
    }

    // Método auxiliar para calcular el desplazamiento de un campo en una estructura
    private int calculateFieldOffset(StructDeclaration structDecl, String fieldName) {
        int offset = 0;
        for (StructField field : structDecl.getStructFields()) {
            if (field.getName().equals(fieldName)) {
                return offset;
            }
            offset += field.getType().getSize();
        }
        throw new IllegalStateException("Field " + fieldName + " not found in struct");
    }
}