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


        int returnSize = 0;
        Type returnType = featureSection.getType().orElse(null);
        if (returnType != null && !(returnType instanceof VoidType)) {
            returnSize = returnType.getSize(); 
        }

        int paramsSize = featureSection.getArgs().isPresent()
                ? calculateParamsSize(featureSection.getArgs().get())
                : 0;

        out("ret " + returnSize + ", " + localsSize + ", " + paramsSize);

        return null;
    }

    private int calculateLocalsSize(LocalSection localSection) {
        int size = 0;
        for (VariableDeclaration varDecl : localSection.getVariableDeclarations()) {
            size += varDecl.getType().getSize();
        }
        return size;
    }

    private int calculateParamsSize(Args args) {
        int size = 0;
        for (Arg arg : args.getArgs()) {
            size += arg.getType().getSize();
        }
        return size;
    }

}