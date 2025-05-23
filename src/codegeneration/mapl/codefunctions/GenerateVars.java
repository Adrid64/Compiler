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

public class GenerateVars extends AbstractCodeFunction {

    public GenerateVars(MaplCodeSpecification specification) {
        super(specification);
    }

    // class VarSection(List<VariableDeclaration> variableDeclarations)
    @Override
    public Object visit(VarSection varSection, Object param) {
        for (VariableDeclaration varDecl : varSection.getVariableDeclarations()) {
            for (String identifier : varDecl.getIdentifiers()) {
                out("#GLOBAL " + identifier + " : " + varDecl.getType().getTypeName());
            }
        }
        return null;
    }

    
    }
