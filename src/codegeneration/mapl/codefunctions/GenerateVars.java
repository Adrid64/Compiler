package codegeneration.mapl.codefunctions;

import ast.*;
import ast.declaration.VariableDeclaration;
import codegeneration.mapl.*;

public class GenerateVars extends AbstractCodeFunction {

    public GenerateVars(MaplCodeSpecification specification) {
        super(specification);
    }

    @Override
    public Object visit(VarSection varSection, Object param) {
        for (VariableDeclaration varDecl : varSection.getVariableDeclarations()) {

            String identifierName = varDecl.getName();
            out("#GLOBAL " + identifierName + " : " + varDecl.getType().getMaplName());

    
        }
        return null;
    }
}