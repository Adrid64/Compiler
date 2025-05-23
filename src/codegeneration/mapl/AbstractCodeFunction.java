// Generated with VGen 2.0.0

/*

Esta es la clase base de todos los visitors correspondientes a las funciones de código. Contiene los
métodos que permiten invocar a las distintas funciones haciendo transparente el cambio entre
visitors.

Para su uso, sólo hay que copiarla a su ubicación deseada en el proyecto actualizando su 'package'.
NO ES NECESARIO añadir nada más para usarla.

NOTA: Si hay código que se use en varios visitor, esta clase puede ser un lugar candidato para
ubicarlo. Sin embargo, si se regenera esta clase, acordarse de no borrar dicho código.

*/


package codegeneration.mapl;


import java.util.stream.Stream;
import java.util.Optional;

import ast.AST;
import ast.type.Type;
import visitor.ExceptionThrowerVisitor;

/**
 * Common code for all Code Functions.
 */

public abstract class AbstractCodeFunction extends ExceptionThrowerVisitor {

    private MaplCodeSpecification specification;

    protected AbstractCodeFunction(MaplCodeSpecification specification) {
        this.specification = specification;
    }

    protected MaplCodeSpecification getSpecification() {
        return specification;
    }

    //# ------------------------------------------------------------------
    // Métodos auxiliares para la escritura de código

    protected void out(String line) {
        specification.getPrintWriter().println(line);
    }


   

    //# ------------------------------------------------------------------
    //# Método genérico para invocar cualquier función de código

    protected Object accept(MaplCodeSpecification.CodeFunction function, AST node, Object param) {
        return node.accept(specification.getVisitor(function), param);
    }

    //# ------------------------------------------------------------------
    //# Métodos específicos para cada función de código

    // Code Function: 'generateProgram'

    protected Object generateProgram(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATEPROGRAM), param);
    }

    protected Object generateProgram(AST node) {
        return generateProgram(node, null);
    }

    protected <T extends AST> void generateProgram(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateProgram(node, param));
    }

    protected <T extends AST> void generateProgram(Stream<T> nodes) {
        nodes.forEach(this::generateProgram);
    }

    protected <T extends AST> Object generateProgram(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateProgram(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateProgram(Optional<T> optionalNode) {
        return optionalNode.map(this::generateProgram).orElse(null);
    }


    // Code Function: 'generateClass'

    protected Object generateClass(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATECLASS), param);
    }

    protected Object generateClass(AST node) {
        return generateClass(node, null);
    }

    protected <T extends AST> void generateClass(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateClass(node, param));
    }

    protected <T extends AST> void generateClass(Stream<T> nodes) {
        nodes.forEach(this::generateClass);
    }

    protected <T extends AST> Object generateClass(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateClass(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateClass(Optional<T> optionalNode) {
        return optionalNode.map(this::generateClass).orElse(null);
    }


    // Code Function: 'generateGlobals'

    protected Object generateGlobals(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATEGLOBALS), param);
    }

    protected Object generateGlobals(AST node) {
        return generateGlobals(node, null);
    }

    protected <T extends AST> void generateGlobals(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateGlobals(node, param));
    }

    protected <T extends AST> void generateGlobals(Stream<T> nodes) {
        nodes.forEach(this::generateGlobals);
    }

    protected <T extends AST> Object generateGlobals(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateGlobals(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateGlobals(Optional<T> optionalNode) {
        return optionalNode.map(this::generateGlobals).orElse(null);
    }


    // Code Function: 'generateTypes'

    protected Object generateTypes(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATETYPES), param);
    }

    protected Object generateTypes(AST node) {
        return generateTypes(node, null);
    }

    protected <T extends AST> void generateTypes(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateTypes(node, param));
    }

    protected <T extends AST> void generateTypes(Stream<T> nodes) {
        nodes.forEach(this::generateTypes);
    }

    protected <T extends AST> Object generateTypes(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateTypes(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateTypes(Optional<T> optionalNode) {
        return optionalNode.map(this::generateTypes).orElse(null);
    }


    // Code Function: 'generateVars'

    protected Object generateVars(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATEVARS), param);
    }

    protected Object generateVars(AST node) {
        return generateVars(node, null);
    }

    protected <T extends AST> void generateVars(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateVars(node, param));
    }

    protected <T extends AST> void generateVars(Stream<T> nodes) {
        nodes.forEach(this::generateVars);
    }

    protected <T extends AST> Object generateVars(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateVars(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateVars(Optional<T> optionalNode) {
        return optionalNode.map(this::generateVars).orElse(null);
    }


    // Code Function: 'generateStruct'

    protected Object generateStruct(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATESTRUCT), param);
    }

    protected Object generateStruct(AST node) {
        return generateStruct(node, null);
    }

    protected <T extends AST> void generateStruct(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateStruct(node, param));
    }

    protected <T extends AST> void generateStruct(Stream<T> nodes) {
        nodes.forEach(this::generateStruct);
    }

    protected <T extends AST> Object generateStruct(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateStruct(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateStruct(Optional<T> optionalNode) {
        return optionalNode.map(this::generateStruct).orElse(null);
    }


    // Code Function: 'generateConstructors'

    protected Object generateConstructors(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATECONSTRUCTORS), param);
    }

    protected Object generateConstructors(AST node) {
        return generateConstructors(node, null);
    }

    protected <T extends AST> void generateConstructors(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateConstructors(node, param));
    }

    protected <T extends AST> void generateConstructors(Stream<T> nodes) {
        nodes.forEach(this::generateConstructors);
    }

    protected <T extends AST> Object generateConstructors(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateConstructors(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateConstructors(Optional<T> optionalNode) {
        return optionalNode.map(this::generateConstructors).orElse(null);
    }


    // Code Function: 'generateFunction'

    protected Object generateFunction(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATEFUNCTION), param);
    }

    protected Object generateFunction(AST node) {
        return generateFunction(node, null);
    }

    protected <T extends AST> void generateFunction(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateFunction(node, param));
    }

    protected <T extends AST> void generateFunction(Stream<T> nodes) {
        nodes.forEach(this::generateFunction);
    }

    protected <T extends AST> Object generateFunction(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateFunction(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateFunction(Optional<T> optionalNode) {
        return optionalNode.map(this::generateFunction).orElse(null);
    }


    // Code Function: 'generateLocals'

    protected Object generateLocals(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATELOCALS), param);
    }

    protected Object generateLocals(AST node) {
        return generateLocals(node, null);
    }

    protected <T extends AST> void generateLocals(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateLocals(node, param));
    }

    protected <T extends AST> void generateLocals(Stream<T> nodes) {
        nodes.forEach(this::generateLocals);
    }

    protected <T extends AST> Object generateLocals(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateLocals(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateLocals(Optional<T> optionalNode) {
        return optionalNode.map(this::generateLocals).orElse(null);
    }


    // Code Function: 'generateArgs'

    protected Object generateArgs(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.GENERATEARGS), param);
    }

    protected Object generateArgs(AST node) {
        return generateArgs(node, null);
    }

    protected <T extends AST> void generateArgs(Stream<T> nodes, Object param) {
        nodes.forEach(node -> generateArgs(node, param));
    }

    protected <T extends AST> void generateArgs(Stream<T> nodes) {
        nodes.forEach(this::generateArgs);
    }

    protected <T extends AST> Object generateArgs(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> generateArgs(node, param)).orElse(null);
    }

    protected <T extends AST> Object generateArgs(Optional<T> optionalNode) {
        return optionalNode.map(this::generateArgs).orElse(null);
    }


    // Code Function: 'value'

    protected Object value(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.VALUE), param);
    }

    protected Object value(AST node) {
        return value(node, null);
    }

    protected <T extends AST> void value(Stream<T> nodes, Object param) {
        nodes.forEach(node -> value(node, param));
    }

    protected <T extends AST> void value(Stream<T> nodes) {
        nodes.forEach(this::value);
    }

    protected <T extends AST> Object value(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> value(node, param)).orElse(null);
    }

    protected <T extends AST> Object value(Optional<T> optionalNode) {
        return optionalNode.map(this::value).orElse(null);
    }


    // Code Function: 'address'

    protected Object address(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.ADDRESS), param);
    }

    protected Object address(AST node) {
        return address(node, null);
    }

    protected <T extends AST> void address(Stream<T> nodes, Object param) {
        nodes.forEach(node -> address(node, param));
    }

    protected <T extends AST> void address(Stream<T> nodes) {
        nodes.forEach(this::address);
    }

    protected <T extends AST> Object address(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> address(node, param)).orElse(null);
    }

    protected <T extends AST> Object address(Optional<T> optionalNode) {
        return optionalNode.map(this::address).orElse(null);
    }


    // Code Function: 'execute'

    protected Object execute(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.EXECUTE), param);
    }

    protected Object execute(AST node) {
        return execute(node, null);
    }

    protected <T extends AST> void execute(Stream<T> nodes, Object param) {
        nodes.forEach(node -> execute(node, param));
    }

    protected <T extends AST> void execute(Stream<T> nodes) {
        nodes.forEach(this::execute);
    }

    protected <T extends AST> Object execute(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> execute(node, param)).orElse(null);
    }

    protected <T extends AST> Object execute(Optional<T> optionalNode) {
        return optionalNode.map(this::execute).orElse(null);
    }


    // Code Function: 'declareType'

    protected Object declareType(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.DECLARETYPE), param);
    }

    protected Object declareType(AST node) {
        return declareType(node, null);
    }

    protected <T extends AST> void declareType(Stream<T> nodes, Object param) {
        nodes.forEach(node -> declareType(node, param));
    }

    protected <T extends AST> void declareType(Stream<T> nodes) {
        nodes.forEach(this::declareType);
    }

    protected <T extends AST> Object declareType(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> declareType(node, param)).orElse(null);
    }

    protected <T extends AST> Object declareType(Optional<T> optionalNode) {
        return optionalNode.map(this::declareType).orElse(null);
    }


    // Code Function: 'declare'

    protected Object declare(AST node, Object param) {
        return node.accept(specification.getVisitor(MaplCodeSpecification.CodeFunction.DECLARE), param);
    }

    protected Object declare(AST node) {
        return declare(node, null);
    }

    protected <T extends AST> void declare(Stream<T> nodes, Object param) {
        nodes.forEach(node -> declare(node, param));
    }

    protected <T extends AST> void declare(Stream<T> nodes) {
        nodes.forEach(this::declare);
    }

    protected <T extends AST> Object declare(Optional<T> optionalNode, Object param) {
        return optionalNode.map(node -> declare(node, param)).orElse(null);
    }

    protected <T extends AST> Object declare(Optional<T> optionalNode) {
        return optionalNode.map(this::declare).orElse(null);
    }


}
