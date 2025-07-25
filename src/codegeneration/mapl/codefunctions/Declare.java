package codegeneration.mapl.codefunctions;

import ast.declaration.*;
import ast.type.*;
import codegeneration.mapl.*;

public class Declare extends AbstractCodeFunction {

    public Declare(MaplCodeSpecification specification) {
        super(specification);
    }

    // class VariableDeclaration(List<String> identifiers, Type type)
    // phase MemoryAllocation { int address }
    @Override
    public Object visit(VariableDeclaration variableDeclaration, Object param) {
        int scope = variableDeclaration.getScope();
        String directive = (scope == 0) ? "#GLOBAL" : "#LOCAL";
        String identifierName = variableDeclaration.getName();

        out(directive + " " + identifierName + " : " + variableDeclaration.getType().getMaplName());

        return null;
    }

    // class StructField(String name, Type type)
    // phase Identification { StructDeclaration structDeclaration }
    // phase MemoryAllocation { int address }
    @Override
    public Object visit(StructField structField, Object param) {
        return null;
    }

    // class Arg(String name, Type type)
    // phase MemoryAllocation { int address }
    @Override
    public Object visit(Arg arg, Object param) {
        out("#PARAM " + arg.getName() + " : " + arg.getType().getMaplName()
        		);
        return null;
    }

}