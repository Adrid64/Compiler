package codegeneration.mapl.codefunctions;

import ast.expression.*;
import ast.StructDeclaration;
import ast.declaration.*;
import ast.type.*;
import codegeneration.mapl.*;

public class Address extends AbstractCodeFunction {

    public Address(MaplCodeSpecification specification) {
        super(specification);
    }

    // class ArrayAcces(Expression exp2, Expression exp3)
    @Override
    public Object visit(ArrayAcces arrayAcces, Object param) {
        // Dirección base del arreglo
        address(arrayAcces.getExp2());
        // Índice
        value(arrayAcces.getExp3());
        // Tamaño del elemento
        out("pushi " + arrayAcces.getType().getSize());
        // desplazamiento = índice * tamaño
        out("muli");
        // dirección final = base + desplazamiento
        out("addi");
        return null;
    }

    // class VariableAcces(String name)
    @Override
    public Object visit(VariableAcces variableAcces, Object param) {
        Declaration decl = variableAcces.getDeclaration();

        if (decl instanceof VariableDeclaration) {
            VariableDeclaration varDecl = (VariableDeclaration) decl;
            int scope = varDecl.getScope();
            if (scope == 1) {
                // global: pusha <absolute address>
                out("pusha " + varDecl.getAddress());
            } else if (scope == 2) {
                // local: BP-relative
                generateBpRelative(varDecl.getAddress());
            } else {
                throw new IllegalStateException(
                    "VariableDeclaration with unexpected scope: " + scope);
            }

        } else if (decl instanceof Arg) {
            Arg arg = (Arg) decl;
            // parámetros: BP-relative
            generateBpRelative(arg.getAddress());
        }

        return null;
    }

    // class Parentesis(Expression exp2)
    @Override
    public Object visit(Parentesis parentesis, Object param) {
        if (!parentesis.getExp2().isLvalue())
            throw new IllegalStateException(
                "Cannot compute address of Parentesis (inner expression is not an l-value)");
        address(parentesis.getExp2());
        return null;
    }

    // class Cast(Type tipoCast, Expression exp2)
    @Override
    public Object visit(Cast cast, Object param) {
        if (!cast.getExp2().isLvalue())
            throw new IllegalStateException(
                "Cannot compute address of Cast (inner expression is not an l-value)");
        address(cast.getExp2());
        return null;
    }

    // class StructFieldAcces(Expression exp2, String name)
    @Override
    public Object visit(StructFieldAcces structFieldAcces, Object param) {
        // Dirección base de la estructura
        address(structFieldAcces.getExp2());
        StructDeclaration structDecl = structFieldAcces.getStructDeclaration();
        int offset = calculateFieldOffset(structDecl, structFieldAcces.getName());
        out("pushi " + offset);
        out("addi");
        return null;
    }

    // --------------------------------------------------
    // Emite dirección BP-relative, manejando offsets positivos y negativos
    private void generateBpRelative(int offset) {
        // pusha bp
        out("pusha bp");
        if (offset >= 0) {
            out("pushi " + offset);
            out("addi");
        } else {
            out("pushi " + (-offset));
            out("subi");
        }
    }

    // Helper: calcular desplazamiento del campo en struct
    private int calculateFieldOffset(StructDeclaration structDecl, String fieldName) {
        int off = 0;
        for (StructField field : structDecl.getStructFields()) {
            if (field.getName().equals(fieldName)) {
                return off;
            }
            off += field.getType().getSize();
        }
        throw new IllegalStateException(
            "Field " + fieldName + " not found in struct " + structDecl.getName());
    }
}
