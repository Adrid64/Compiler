package codegeneration.mapl.codefunctions;

import ast.type.*;
import codegeneration.mapl.*;

public class DeclareType extends AbstractCodeFunction {

    public DeclareType(MaplCodeSpecification specification) {
        super(specification);
    }

    // class IntType(String name)
    @Override
    public Object visit(IntType intType, Object param) {
        // No se emite ninguna directiva; el tipo int se maneja en #GLOBAL, #LOCAL, #PARAM, #RET
        return null;
    }

    // class DoubleType(String name)
    @Override
    public Object visit(DoubleType doubleType, Object param) {
        // No se emite ninguna directiva; el tipo float se maneja en #GLOBAL, #LOCAL, #PARAM, #RET
        return null;
    }

    // class CharacterType(String name)
    @Override
    public Object visit(CharacterType characterType, Object param) {
        // No se emite ninguna directiva; el tipo char se maneja en #GLOBAL, #LOCAL, #PARAM, #RET
        return null;
    }

    // class IdentType(String name)
    // phase Identification { StructDeclaration structDeclaration }
    @Override
    public Object visit(IdentType identType, Object param) {
        // No se emite ninguna directiva; la estructura se declara en #TYPE en GenerateStruct
        return null;
    }

    // class Arraytype(int intValue, Type type2)
    @Override
    public Object visit(Arraytype arraytype, Object param) {
        // No se emite ninguna directiva; el tipo array se maneja en #GLOBAL, #LOCAL, #PARAM
        return null;
    }

    // class ErrorType(String name)
    @Override
    public Object visit(ErrorType errorType, Object param) {
        // No se emite ninguna directiva; ErrorType no debería llegar a la generación de código
        return null;
    }

    // class VoidType(String name)
    @Override
    public Object visit(VoidType voidType, Object param) {
        // No se emite ninguna directiva; el tipo void se maneja en #RET
        return null;
    }
}