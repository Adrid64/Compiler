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
 // dentro de GenerateStruct.java

    @Override
    public Object visit(StructDeclaration structDeclaration, Object param) {
        // Abrimos la directiva con llaves
        out("#TYPE " + structDeclaration.getName() + " : {");
        // Cada campo en su propia línea
        for (StructField field : structDeclaration.getStructFields()) {
			out(field.getName() + ":" + field.getType().getMaplName());
        }
        out("}");
        return null;
    }



}