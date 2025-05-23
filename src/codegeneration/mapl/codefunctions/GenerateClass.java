package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;

public class GenerateClass extends AbstractCodeFunction {

    public GenerateClass(MaplCodeSpecification specification) {
        super(specification);
    }

    // class ClassDeclaration(String name, Optional<GlobalSection> globalSection, CreateSection createSection, List<FeatureSection> featureSections)
    @Override
    public Object visit(ClassDeclaration classDeclaration, Object param) {
        // Procesar globalSection si está presente
        if (classDeclaration.getGlobalSection().isPresent()) {
            generateGlobals(classDeclaration.getGlobalSection().get());
        }

        // Procesar cada featureSection
        for (FeatureSection featureSection : classDeclaration.getFeatureSections()) {
            generateFunction(featureSection);
        }

        // Nota: createSection no genera código según la especificación
        return null;
    }
}