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

    private int labelCounter = 0;

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

        int currentLabel = labelCounter++;
        String elseLabel = "else_" + currentLabel;
        String endLabel = "end_if_" + currentLabel;

        value(bloqueif.getExpression()); // Evaluar condición

        if (!bloqueif.getSt3().isEmpty()) {
            out("jz " + elseLabel);
        } else {
            out("jz " + endLabel);
        }

        // Emitir bloque THEN
        for (Statement stmt : bloqueif.getSt2()) {
            stmt.accept(this, param);
        }

        if (!bloqueif.getSt3().isEmpty()) {
            // Saltar al final después del then
            out("jmp " + endLabel);
            // Bloque else
            out(elseLabel + ":");
            for (Statement stmt : bloqueif.getSt3()) {
                stmt.accept(this, param);
            }
        }

        // Emitir etiqueta de fin solo si ha sido usada
        out(endLabel + ":");

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
        out("jnz " + endLabel);             // Saltar al final si la condición es falsa
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

        if (returnValue.getExpression() != null) {
            value(returnValue.getExpression());
        }
        return null; 
    }

    // Sentencia FunctionCallStatement
    @Override
    public Object visit(FunctionCallStatement functionCallStatement, Object param) {
        line(functionCallStatement);
        for (Expression expr : functionCallStatement.getExpressions()) {
            value(expr); // Evaluar argumentos
        }
        out("call " + functionCallStatement.getName());

        // Si la función tiene tipo de retorno distinto de void, hacer pop
        FeatureSection feature = functionCallStatement.getFeatureSection();
        if (feature != null && feature.getType().isPresent() && !(feature.getType().get() instanceof VoidType)) {
            out("pop");
        }

        return null;
    }


    // Sentencia RunStatement
    @Override
    public Object visit(RunStatement runStatement, Object param) {
        line(runStatement);

        // Generar los valores de los argumentos
        for (Expression expr : runStatement.getExpressions()) {
            value(expr);
        }

        out("call " + runStatement.getName());

        // Si la función tiene valor de retorno y no se usa, eliminarlo con pop
        if (runStatement.getFeatureSection() != null &&
            runStatement.getFeatureSection().getType().isPresent() &&
            !(runStatement.getFeatureSection().getType().get() instanceof VoidType)) {
            out("pop");
        }

        return null;
    }


    // Método auxiliar para directivas de línea
    private void line(AST node) {
        if (node.end() != null) {
            out("\n#line " + node.end().getLine());
        }
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