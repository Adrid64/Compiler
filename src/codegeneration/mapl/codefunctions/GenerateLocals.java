package codegeneration.mapl.codefunctions;

import ast.*;
import ast.declaration.VariableDeclaration;

import codegeneration.mapl.*;

public class GenerateLocals extends AbstractCodeFunction {

    public GenerateLocals(MaplCodeSpecification specification) {
        super(specification);
    }

    // class LocalSection(List<VariableDeclaration> variableDeclarations)
    @Override
    public Object visit(LocalSection localSection, Object param) {
        for (VariableDeclaration varDecl : localSection.getVariableDeclarations()) {
            String identifierName = varDecl.getName();
            out("#LOCAL " + identifierName + " : " + varDecl.getType().getMaplName());
        }
        return null;
    }

}