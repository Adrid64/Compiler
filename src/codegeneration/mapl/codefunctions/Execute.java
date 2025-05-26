package codegeneration.mapl.codefunctions;

import ast.expression.*;
import ast.statement.*;
import ast.type.*;
import ast.*;
import ast.declaration.Arg;
import ast.declaration.VariableDeclaration;
import visitor.Visitor;
import codegeneration.mapl.*;

public class Execute extends AbstractCodeFunction {

    private int labelCounter = 0; // Contador para etiquetas únicas en estructuras de control

    public Execute(MaplCodeSpecification specification) {
        super(specification);
    }

    // Sentencia Assignment
    @Override
    public Object visit(Assignment assignment, Object param) {
        line(assignment);
        address(assignment.getLeft());   // Dirección del lado izquierdo
        value(assignment.getRight());    // Valor del lado derecho
        out("store", assignment.getLeft().getType()); // Almacenar según el tipo
        return null;
    }

    // Sentencia Print
    @Override
    public Object visit(Print print, Object param) {
        line(print);
        for (Expression expr : print.getExpressions()) {
            value(expr);                  // Evaluar cada expresión
            out("out", expr.getType());   // Imprimir según el tipo
        }
        return null;
    }

    // Sentencia Println
    @Override
    public Object visit(Println println, Object param) {
        line(println);
        for (Expression expr : println.getExpressions()) {
            value(expr);                  // Evaluar cada expresión
            out("out", expr.getType());   // Imprimir según el tipo
        }
        out("pushb 10");              // Colocar '\n' en la pila
        out("out", new CharacterType("")); // Imprimir salto de línea
        return null;
    }

    // Sentencia Read
    @Override
    public Object visit(Read read, Object param) {
        line(read);
        for (Expression expr : read.getExpressions()) {
            address(expr);                // Dirección donde almacenar la entrada
            out("in", expr.getType());    // Leer según el tipo
            out("store", expr.getType()); // Almacenar el valor leído
        }
        return null;
    }

    // Sentencia Bloqueif (if)
    @Override
    public Object visit(Bloqueif bloqueif, Object param) {
        line(bloqueif);
        String elseLabel = "else_" + labelCounter++; // Etiqueta para el bloque else
        String endLabel = "end_if_" + labelCounter++; // Etiqueta para el final
        value(bloqueif.getExpression()); // Evaluar la condición
        out("jz " + elseLabel);          // Saltar al else si la condición es falsa
        for (Statement stmt : bloqueif.getSt2()) { // Ejecutar bloque then
            stmt.accept(this, param);
        }
        if (!bloqueif.getSt3().isEmpty()) { // Si hay bloque else
            out("jmp " + endLabel);         // Saltar al final después del then
        }
        out(elseLabel + ":");              // Inicio del bloque else
        for (Statement stmt : bloqueif.getSt3()) { // Ejecutar bloque else
            stmt.accept(this, param);
        }
        out(endLabel + ":");               // Fin del if
        return null;
    }

    // Sentencia LoopFrom (bucle)
    @Override
    public Object visit(LoopFrom loopFrom, Object param) {
        line(loopFrom);
        String loopLabel = "loop_" + labelCounter++; // Etiqueta de inicio del bucle
        String endLabel = "end_loop_" + labelCounter++; // Etiqueta de fin
        for (Statement stmt : loopFrom.getSt1()) { // Ejecutar inicialización
            stmt.accept(this, param);
        }
        out(loopLabel + ":");              // Inicio del bucle
        value(loopFrom.getExpression());   // Evaluar la condición
        out("jz " + endLabel);             // Saltar al final si la condición es falsa
        for (Statement stmt : loopFrom.getBody()) { // Ejecutar cuerpo del bucle
            stmt.accept(this, param);
        }
        out("jmp " + loopLabel);           // Volver al inicio del bucle
        out(endLabel + ":");               // Fin del bucle
        return null;
    }

    // Sentencia Return
    @Override
    public Object visit(Return returnValue, Object param) {
        line(returnValue);
        FeatureSection feature = (FeatureSection) param; // Sección de la función actual
        if (returnValue.getExpression() != null) {
            value(returnValue.getExpression()); // Evaluar el valor de retorno
        }
        // Calcular tamaños para la instrucción ret, manejando parámetros opcionales
        int returnSize = feature.getType().isPresent() ? feature.getType().get().getSize() : 0;
        int localsSize = feature.getLocalSection().isPresent() ? calculateLocalsSize(feature.getLocalSection().get()) : 0;
        int paramsSize = feature.getArgs().isPresent() ? calculateParamsSize(feature.getArgs().get()) : 0;
        out("ret " + returnSize + ", " + localsSize + ", " + paramsSize); // Retornar
        return null;
    }

    // Sentencia FunctionCallStatement
    @Override
    public Object visit(FunctionCallStatement functionCallStatement, Object param) {
        line(functionCallStatement);
        for (Expression expr : functionCallStatement.getExpressions()) {
            value(expr);                  // Evaluar cada argumento
        }
        out("call " + functionCallStatement.getName()); // Llamar a la función
        return null;
    }

    // Sentencia RunStatement
    @Override
    public Object visit(RunStatement runStatement, Object param) {
        line(runStatement);
        for (Expression expr : runStatement.getExpressions()) {
            value(expr);                  // Evaluar cada argumento
        }
        out("call " + runStatement.getName()); // Llamar a la función
        return null;
    }

    // Método auxiliar para directivas de línea
    private void line(AST node) {
        if (node.end() != null) {
            out("\n#line " + node.end().getLine());
        }
    }

    // Método auxiliar para calcular el tamaño de las variables locales
    private int calculateLocalsSize(LocalSection localSection) {
        int size = 0;
        for (VariableDeclaration varDecl : localSection.getVariableDeclarations()) {
            size += varDecl.getType().getSize();
        }
        return size;
    }

    // Método auxiliar para calcular el tamaño de los parámetros
    private int calculateParamsSize(Args args) {
        int size = 0;
        for (Arg arg : args.getArgs()) {
            size += arg.getType().getSize();
        }
        return size;
    }

    // Método auxiliar para emitir instrucción con sufijo según el tipo
    private void out(String instruction, Type type) {
        out(instruction + suffixFor(type));
    }

    // Método auxiliar para emitir instrucción simple
    @Override
    protected void out(String instruction) {
        super.out(instruction);
    }

    // Método auxiliar para determinar el sufijo del tipo
    private String suffixFor(Type type) {
        if (type instanceof IntType)
            return "i";
        if (type instanceof DoubleType)
            return "f";
        if (type instanceof CharacterType)
            return "b";
        throw new IllegalArgumentException("Unknown Type: " + type);
    }
}