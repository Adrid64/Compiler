package codegeneration.mapl.codefunctions;

import ast.*;
import ast.declaration.VariableDeclaration;
import ast.type.Arraytype;
import ast.type.CharacterType;
import ast.type.DoubleType;
import ast.type.IdentType;
import ast.type.IntType;
import ast.type.Type;
import ast.type.VoidType;
import codegeneration.mapl.*;

public class GenerateLocals extends AbstractCodeFunction {

    public GenerateLocals(MaplCodeSpecification specification) {
        super(specification);
    }

    // class LocalSection(List<VariableDeclaration> variableDeclarations)
    @Override
    public Object visit(LocalSection localSection, Object param) {
        for (VariableDeclaration varDecl : localSection.getVariableDeclarations()) {
            for (String identifier : varDecl.getIdentifiers()) {
                out("#LOCAL " + identifier + " : " +varDecl.getType().getTypeName());
            }
        }
        return null;
    }

}