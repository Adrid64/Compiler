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
        address(arrayAcces.getExp2()); // base address
        value(arrayAcces.getExp3());   // index
        out("pushi " + arrayAcces.getType().getSize()); // element size
        out("muli");
        out("addi"); // final address = base + index * size
        return null;
    }

    // class VariableAcces(String name)
    @Override
    public Object visit(VariableAcces variableAcces, Object param) {
        Declaration decl = variableAcces.getDeclaration();

        if (decl instanceof VariableDeclaration varDecl) {
            int scope = varDecl.getScope();
            if (scope == 1) {
                out("pusha " + varDecl.getAddress()); // global
            } else if (scope == 2) {
                generateBpRelative(varDecl.getAddress()); // local
            } else {
                throw new IllegalStateException("Unexpected variable scope: " + scope);
            }

        } else if (decl instanceof Arg arg) {
            generateBpRelative(arg.getAddress()); // parameter
        } else {
            throw new IllegalStateException("Unexpected declaration type for VariableAcces");
        }

        return null;
    }

    // class Parentesis(Expression exp2)
    @Override
    public Object visit(Parentesis parentesis, Object param) {
        if (!parentesis.getExp2().isLvalue()) {
            throw new IllegalStateException("Cannot compute address of non-lvalue in Parentesis");
        }
        address(parentesis.getExp2());
        return null;
    }

    // class Cast(Type tipoCast, Expression exp2)
    @Override
    public Object visit(Cast cast, Object param) {
        if (!cast.getExp2().isLvalue()) {
            throw new IllegalStateException("Cannot compute address of non-lvalue in Cast");
        }
        address(cast.getExp2());
        return null;
    }

    // class StructFieldAcces(Expression exp2, String name)
    @Override
    public Object visit(StructFieldAcces structFieldAcces, Object param) {
        address(structFieldAcces.getExp2()); // base struct address
        StructDeclaration structDecl = structFieldAcces.getStructDeclaration();
        int offset = calculateFieldOffset(structDecl, structFieldAcces.getName());
        out("pushi " + offset);
        out("addi");
        return null;
    }

    // Emitir código para acceder a dirección relativa al BP
    private void generateBpRelative(int offset) {
        out("pusha bp");
        if (offset >= 0) {
            out("pushi " + offset);
            out("addi");
        } else {
            out("pushi " + (-offset));
            out("subi");
        }
    }



    // Cálculo de desplazamiento de un campo en una estructura
    private int calculateFieldOffset(StructDeclaration structDecl, String fieldName) {
        int offset = 0;
        for (StructField field : structDecl.getStructFields()) {
            if (field.getName().equals(fieldName)) {
                return offset;
            }
            offset += field.getType().getSize();
        }
        throw new IllegalStateException("Field '" + fieldName + "' not found in struct '" + structDecl.getName() + "'");
    }
}
