package codegeneration.mapl.codefunctions;

import ast.*;
import ast.declaration.Arg;
import ast.declaration.VariableDeclaration;
import ast.statement.Statement;
import ast.type.*;
import codegeneration.mapl.*;

public class GenerateFunction extends AbstractCodeFunction {

    public GenerateFunction(MaplCodeSpecification specification) {
        super(specification);
    }

    // class FeatureSection(String name, Optional<Args> args, Optional<Type> type, Optional<LocalSection> localSection, List<Statement> statements)
    // phase TypeChecking { boolean hasReturn }
    @Override
    public Object visit(FeatureSection featureSection, Object param) {
        // Emitir directiva #FUNC
        out("#FUNC " + featureSection.getName());

        // Procesar argumentos si están presentes
        if (featureSection.getArgs().isPresent()) {
            generateArgs(featureSection.getArgs().get());
        }

        // Procesar tipo de retorno
        if (featureSection.getType().isPresent()) {
            out("#RET " + featureSection.getType().get().getTypeName());
        } else {
            out("#RET VOID");
        }

        // Procesar variables locales si están presentes
        if (featureSection.getLocalSection().isPresent()) {
            generateLocals(featureSection.getLocalSection().get());
        }

        // Emitir etiqueta de la función
        out(featureSection.getName() + ":");

        // Emitir ENTER si hay variables locales
        int localsSize = featureSection.getLocalSection().isPresent()
                ? calculateLocalsSize(featureSection.getLocalSection().get())
                : 0;
        if (localsSize > 0) {
            out("ENTER " + localsSize);
        }

        // Procesar sentencias
        for (Statement statement : featureSection.getStatements()) {
            execute(statement, featureSection);
        }

        // Emitir instrucción RET solo si no hay return explícito
        if (!featureSection.isHasReturn()) {
            int returnSize = featureSection.getType().isPresent() ? featureSection.getType().get().getSize() : 0;
            int paramsSize = featureSection.getArgs().isPresent()
                    ? calculateParamsSize(featureSection.getArgs().get())
                    : 0;
            out("ret " + returnSize + ", " + localsSize + ", " + paramsSize);
        }

        return null;
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
}
