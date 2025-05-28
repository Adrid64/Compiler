package codegeneration.mapl.codefunctions;

import ast.*;
import ast.declaration.Arg;
import ast.declaration.VariableDeclaration;
import ast.statement.Statement;
import ast.statement.Return;
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
        out("#FUNC " + featureSection.getName());

        if (featureSection.getArgs().isPresent()) {
            generateArgs(featureSection.getArgs().get());
        }

        if (featureSection.getType().isPresent()) {
            out("#RET " + featureSection.getType().get().getTypeName());
        } else {
            out("#RET VOID");
        }

        if (featureSection.getLocalSection().isPresent()) {
            generateLocals(featureSection.getLocalSection().get());
        }

        out(featureSection.getName() + ":");

        int localsSize = featureSection.getLocalSection().isPresent()
                ? calculateLocalsSize(featureSection.getLocalSection().get())
                : 0;

        if (localsSize > 0) {
            out("ENTER " + localsSize);
        }

        for (Statement statement : featureSection.getStatements()) {
            execute(statement, featureSection);
        }

        boolean isVoid = featureSection.getType().isEmpty() || featureSection.getType().get() instanceof VoidType;

        if (isVoid && !endsWithReturn(featureSection)) {
            int returnSize = 0;
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
            size += varDecl.getIdentifiers().size() * varDecl.getType().getSize();
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

    // Método auxiliar para comprobar si el último statement es un return explícito
    private boolean endsWithReturn(FeatureSection feature) {
        if (feature.getStatements().isEmpty()) return false;
        Statement last = feature.getStatements().get(feature.getStatements().size() - 1);
        return last instanceof Return;
    }
}
