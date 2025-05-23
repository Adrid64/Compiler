package codegeneration.mapl.codefunctions;

import ast.*;
import ast.declaration.StructField;
import ast.type.Arraytype;
import ast.type.CharacterType;
import ast.type.DoubleType;
import ast.type.IdentType;
import ast.type.IntType;
import ast.type.Type;
import ast.type.VoidType;
import codegeneration.mapl.*;

public class GenerateStruct extends AbstractCodeFunction {

    public GenerateStruct(MaplCodeSpecification specification) {
        super(specification);
    }

    // class StructDeclaration(String name, List<StructField> structFields)
    @Override
    public Object visit(StructDeclaration structDeclaration, Object param) {
        // Iniciar la directiva #TYPE con el nombre de la estructura
        StringBuilder typeDirective = new StringBuilder("#TYPE " + structDeclaration.getName() + " : (");
        
        // Iterar sobre los campos de la estructura
        for (int i = 0; i < structDeclaration.getStructFields().size(); i++) {
            StructField field = structDeclaration.getStructFields().get(i);
            typeDirective.append(field.getName()).append(" : ").append(field.getType().getTypeName());
            // Añadir coma si no es el último campo
            if (i < structDeclaration.getStructFields().size() - 1) {
                typeDirective.append(", ");
            }
        }
        
        typeDirective.append(")");
        out(typeDirective.toString());
        
        return null;
    }

}