// Generated with VGen 2.0.0

/**
 * AstPrinter. Utilidad que ayuda a validar un arbol AST:
 * - Muestra la estructura del árbol en HTML.
 * - Destaca los hijos/propiedades a null.
 * - Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna)
 *   ayudando a decidir cual de ellas usar en los errores y generación de código.
 *
 * Esta clase se genera con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */

package visitor;

import ast.*;
import ast.declaration.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class AstPrinter implements Visitor {

    // Css classes
    private static final String OMITTED_SOURCE_TEXT_CLASS = "omittedSourceText";
    private static final String POS_CLASS = "vgen-pos";
    private static final String DOTS_CLASS = "vgen-dots";
    private static final String VALUE_CLASS = "vgen-value";
    private static final String BODY_CLASS = "vgen-body";
    private static final String CHILD_NAME_CLASS = "vgen-child-name";
    private static final String TABS_CLASS = "vgen-tabs";
    private static final String TYPE_CLASS = "vgen-type";
    private static final String NON_NODE_SOURCE_TEXT_CLASS = "vgen-nonNodeSourceText";
    private static final String NODE_SOURCE_TEXT_CLASS = "vgen-nodeSourceText";
    private static final String SOURCE_TEXT_CLASS = "vgen-sourceText";
    private static final String NULL_CLASS = "vgen-null";

    /**
    * toHtml. Muestra la estructura del AST indicando qué hay en las posiciones
    * (línea y columna) de cada nodo.
    *
    * @param sourceFile El fichero del cual se ha obtenido el AST.
    * @param root       El AST creado a partir de sourceFile.
    * @param filename   Nombre del fichero HMTL a crear con la traza del AST.
    */

    public static void toHtml(String sourceFile, AST root, String filename) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(filename.endsWith(".html") ? filename : filename + ".html"))) {

            writer.println(HEADER);

            if (root != null) {
                AstPrinter printer = new AstPrinter(writer, loadLines(sourceFile));
                printer.printNodes(root);
            } else
                writer.println("root == null");

            writer.println(FOOTER);

            System.err.println(ls + "AstPrinter: Fichero '" + filename + ".html' generado.");

        } catch (IOException e) {
            System.err.println(ls + "AstPrinter: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private void printNodes(AST root) {
        writer.println("<div class=\"" + BODY_CLASS + "\">");

        writeDiv(span(CHILD_NAME_CLASS, root.getClass().getSimpleName()) + " = ");
        root.accept(this, Integer.valueOf(0));

        writer.println("</div>");

    }

    public static void toHtml(AST raiz, String filename) {
        toHtml(null, raiz, filename);
    }

    private AstPrinter(PrintWriter writer, List<String> sourceLines) {
        this(writer, sourceLines, 3);
    }

    private AstPrinter(PrintWriter writer, List<String> sourceLines, int tabSize) {
        this.writer = writer;
        this.sourceLines = sourceLines;
        this.tabSize = tabSize;

        tabulator = "&nbsp;".repeat(tabSize - 1);
    }

    //$ -------------------------------------------------------------------------------------
    // Aquí empiezan los 'visit' de los nodos


	@Override
	public Object visit(Program program, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "classDeclaration", "ClassDeclaration", program.getClassDeclaration());
        printNodeChild(indent + 1, "runStatement", "RunStatement", program.getRunStatement());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, program, "classDeclaration", "runStatement");
		return null;
	}

	@Override
	public Object visit(ClassDeclaration classDeclaration, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", classDeclaration.getName());
        printNodeChild(indent + 1, "globalSection", "Optional<GlobalSection>", classDeclaration.getGlobalSection().orElse(null));
        printNodeChild(indent + 1, "createSection", "CreateSection", classDeclaration.getCreateSection());
        printListOfNodesChild(indent + 1, "featureSections", "List<FeatureSection>", classDeclaration.getFeatureSections());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, classDeclaration, "name", "globalSection", "createSection", "featureSections");
		return null;
	}

	@Override
	public Object visit(GlobalSection globalSection, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "typesSection", "Optional<TypesSection>", globalSection.getTypesSection().orElse(null));
        printNodeChild(indent + 1, "varSection", "Optional<VarSection>", globalSection.getVarSection().orElse(null));

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, globalSection, "typesSection", "varSection");
		return null;
	}

	@Override
	public Object visit(TypesSection typesSection, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "structDeclarations", "List<StructDeclaration>", typesSection.getStructDeclarations());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, typesSection, "structDeclarations");
		return null;
	}

	@Override
	public Object visit(VarSection varSection, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "variableDeclarations", "List<VariableDeclaration>", varSection.getVariableDeclarations());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, varSection, "variableDeclarations");
		return null;
	}

	@Override
	public Object visit(VariableDeclaration variableDeclaration, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", variableDeclaration.getName());
        printNodeChild(indent + 1, "type", "Type", variableDeclaration.getType());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-2", "address", "int", variableDeclaration.getAddress());
		printUnknownFields(indent + 1, variableDeclaration, "name", "type", "address");
		return null;
	}

	@Override
	public Object visit(StructDeclaration structDeclaration, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", structDeclaration.getName());
        printListOfNodesChild(indent + 1, "structFields", "List<StructField>", structDeclaration.getStructFields());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, structDeclaration, "name", "structFields");
		return null;
	}

	@Override
	public Object visit(StructField structField, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", structField.getName());
        printNodeChild(indent + 1, "type", "Type", structField.getType());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-0", "structDeclaration", "StructDeclaration", structField.getStructDeclaration());
        printToString(indent + 1, "vgen-attribute-phase-2", "address", "int", structField.getAddress());
		printUnknownFields(indent + 1, structField, "name", "type", "structDeclaration", "address");
		return null;
	}

	@Override
	public Object visit(CreateSection createSection, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "strings", "List<String>", createSection.getStrings());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, createSection, "strings");
		return null;
	}

	@Override
	public Object visit(FeatureSection featureSection, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", featureSection.getName());
        printNodeChild(indent + 1, "args", "Optional<Args>", featureSection.getArgs().orElse(null));
        printNodeChild(indent + 1, "type", "Optional<Type>", featureSection.getType().orElse(null));
        printNodeChild(indent + 1, "localSection", "Optional<LocalSection>", featureSection.getLocalSection().orElse(null));
        printListOfNodesChild(indent + 1, "statements", "List<Statement>", featureSection.getStatements());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "hasReturn", "boolean", featureSection.isHasReturn());
		printUnknownFields(indent + 1, featureSection, "name", "args", "type", "localSection", "statements", "hasReturn");
		return null;
	}

	@Override
	public Object visit(LocalSection localSection, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "variableDeclarations", "List<VariableDeclaration>", localSection.getVariableDeclarations());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, localSection, "variableDeclarations");
		return null;
	}

	@Override
	public Object visit(Args args, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "args", "List<Arg>", args.getArgs());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, args, "args");
		return null;
	}

	@Override
	public Object visit(Arg arg, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", arg.getName());
        printNodeChild(indent + 1, "type", "Type", arg.getType());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-2", "address", "int", arg.getAddress());
		printUnknownFields(indent + 1, arg, "name", "type", "address");
		return null;
	}

	@Override
	public Object visit(Assignment assignment, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "left", "Expression", assignment.getLeft());
        printNodeChild(indent + 1, "right", "Expression", assignment.getRight());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", assignment.getFeatureSection());
		printUnknownFields(indent + 1, assignment, "left", "right", "featureSection");
		return null;
	}

	@Override
	public Object visit(Print print, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "expressions", "List<Expression>", print.getExpressions());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", print.getFeatureSection());
		printUnknownFields(indent + 1, print, "expressions", "featureSection");
		return null;
	}

	@Override
	public Object visit(Println println, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "expressions", "List<Expression>", println.getExpressions());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", println.getFeatureSection());
		printUnknownFields(indent + 1, println, "expressions", "featureSection");
		return null;
	}

	@Override
	public Object visit(Read read, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "expressions", "List<Expression>", read.getExpressions());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", read.getFeatureSection());
		printUnknownFields(indent + 1, read, "expressions", "featureSection");
		return null;
	}

	@Override
	public Object visit(Bloqueif bloqueif, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "expression", "Expression", bloqueif.getExpression());
        printListOfNodesChild(indent + 1, "st2", "List<Statement>", bloqueif.getSt2());
        printListOfNodesChild(indent + 1, "st3", "List<Statement>", bloqueif.getSt3());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", bloqueif.getFeatureSection());
		printUnknownFields(indent + 1, bloqueif, "expression", "st2", "st3", "featureSection");
		return null;
	}

	@Override
	public Object visit(LoopFrom loopFrom, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printListOfNodesChild(indent + 1, "st1", "List<Statement>", loopFrom.getSt1());
        printNodeChild(indent + 1, "expression", "Expression", loopFrom.getExpression());
        printListOfNodesChild(indent + 1, "body", "List<Statement>", loopFrom.getBody());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", loopFrom.getFeatureSection());
		printUnknownFields(indent + 1, loopFrom, "st1", "expression", "body", "featureSection");
		return null;
	}

	@Override
	public Object visit(Return returnValue, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "expression", "Optional<Expression>", returnValue.getExpression().orElse(null));

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", returnValue.getFeatureSection());
		printUnknownFields(indent + 1, returnValue, "expression", "featureSection");
		return null;
	}

	@Override
	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", functionCallStatement.getName());
        printListOfNodesChild(indent + 1, "expressions", "List<Expression>", functionCallStatement.getExpressions());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", functionCallStatement.getFeatureSection());
		printUnknownFields(indent + 1, functionCallStatement, "name", "expressions", "featureSection");
		return null;
	}

	@Override
	public Object visit(RunStatement runStatement, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", runStatement.getName());
        printListOfNodesChild(indent + 1, "expressions", "List<Expression>", runStatement.getExpressions());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "featureSection", "FeatureSection", runStatement.getFeatureSection());
		printUnknownFields(indent + 1, runStatement, "name", "expressions", "featureSection");
		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", intLiteral.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", intLiteral.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", intLiteral.getType());
		printUnknownFields(indent + 1, intLiteral, "name", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(RealConstant realConstant, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", realConstant.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", realConstant.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", realConstant.getType());
		printUnknownFields(indent + 1, realConstant, "name", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(CharConstant charConstant, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", charConstant.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", charConstant.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", charConstant.getType());
		printUnknownFields(indent + 1, charConstant, "name", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(FunctionCallExp functionCallExp, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", functionCallExp.getName());
        printListOfNodesChild(indent + 1, "expresiones", "List<Expression>", functionCallExp.getExpresiones());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-0", "featureSection", "FeatureSection", functionCallExp.getFeatureSection());
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", functionCallExp.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", functionCallExp.getType());
		printUnknownFields(indent + 1, functionCallExp, "name", "expresiones", "lvalue", "type", "featureSection");
		return null;
	}

	@Override
	public Object visit(ArrayAcces arrayAcces, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", arrayAcces.getExp2());
        printNodeChild(indent + 1, "exp3", "Expression", arrayAcces.getExp3());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", arrayAcces.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", arrayAcces.getType());
		printUnknownFields(indent + 1, arrayAcces, "exp2", "exp3", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(VariableAcces variableAcces, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", variableAcces.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-0", "declaration", "Declaration", variableAcces.getDeclaration());
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", variableAcces.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", variableAcces.getType());
		printUnknownFields(indent + 1, variableAcces, "name", "lvalue", "type", "declaration");
		return null;
	}

	@Override
	public Object visit(RestaUnaria restaUnaria, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", restaUnaria.getExp2());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", restaUnaria.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", restaUnaria.getType());
		printUnknownFields(indent + 1, restaUnaria, "exp2", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(Parentesis parentesis, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", parentesis.getExp2());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", parentesis.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", parentesis.getType());
		printUnknownFields(indent + 1, parentesis, "exp2", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(Negacion negacion, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", negacion.getExp2());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", negacion.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", negacion.getType());
		printUnknownFields(indent + 1, negacion, "exp2", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(Cast cast, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "tipoCast", "Type", cast.getTipoCast());
        printNodeChild(indent + 1, "exp2", "Expression", cast.getExp2());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", cast.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", cast.getType());
		printUnknownFields(indent + 1, cast, "tipoCast", "exp2", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", arithmetic.getExp2());
        printNonNodeChild(indent + 1, "name", "String", arithmetic.getName());
        printNodeChild(indent + 1, "exp3", "Expression", arithmetic.getExp3());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", arithmetic.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", arithmetic.getType());
		printUnknownFields(indent + 1, arithmetic, "exp2", "name", "exp3", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(Relacional relacional, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", relacional.getExp2());
        printNonNodeChild(indent + 1, "name", "String", relacional.getName());
        printNodeChild(indent + 1, "exp3", "Expression", relacional.getExp3());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", relacional.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", relacional.getType());
		printUnknownFields(indent + 1, relacional, "exp2", "name", "exp3", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(BooleanExp booleanExp, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", booleanExp.getExp2());
        printNonNodeChild(indent + 1, "name", "String", booleanExp.getName());
        printNodeChild(indent + 1, "exp3", "Expression", booleanExp.getExp3());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", booleanExp.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", booleanExp.getType());
		printUnknownFields(indent + 1, booleanExp, "exp2", "name", "exp3", "lvalue", "type");
		return null;
	}

	@Override
	public Object visit(StructFieldAcces structFieldAcces, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNodeChild(indent + 1, "exp2", "Expression", structFieldAcces.getExp2());
        printNonNodeChild(indent + 1, "name", "String", structFieldAcces.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-0", "structDeclaration", "StructDeclaration", structFieldAcces.getStructDeclaration());
        printToString(indent + 1, "vgen-attribute-phase-1", "lvalue", "boolean", structFieldAcces.isLvalue());
        printToString(indent + 1, "vgen-attribute-phase-1", "type", "Type", structFieldAcces.getType());
		printUnknownFields(indent + 1, structFieldAcces, "exp2", "name", "lvalue", "type", "structDeclaration");
		return null;
	}

	@Override
	public Object visit(IntType intType, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", intType.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, intType, "name");
		return null;
	}

	@Override
	public Object visit(DoubleType doubleType, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", doubleType.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, doubleType, "name");
		return null;
	}

	@Override
	public Object visit(CharacterType characterType, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", characterType.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, characterType, "name");
		return null;
	}

	@Override
	public Object visit(IdentType identType, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", identType.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
        printToString(indent + 1, "vgen-attribute-phase-0", "structDeclaration", "StructDeclaration", identType.getStructDeclaration());
		printUnknownFields(indent + 1, identType, "name", "structDeclaration");
		return null;
	}

	@Override
	public Object visit(Arraytype arraytype, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "intValue", "int", arraytype.getIntValue());
        printNodeChild(indent + 1, "type2", "Type", arraytype.getType2());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, arraytype, "intValue", "type2");
		return null;
	}

	@Override
	public Object visit(ErrorType errorType, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", errorType.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, errorType, "name");
		return null;
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

		int indent = ((Integer)param);

		// Imprimir los hijos (y recorrer si son nodos del AST)
        printNonNodeChild(indent + 1, "name", "String", voidType.getName());

		// Imprimir el 'toString()' de los atributos (pero no recorrer)
		printUnknownFields(indent + 1, voidType, "name");
		return null;
	}



    //$ -------------------------------------------------------------------------------------
    // Métodos invocados desde los métodos visit para imprimir los hijos

    /**
     * Método para imprimir aquel Child que sea un nodo del AST. Después de imprimirlo recorre sus hijos.
     */
    private void printNodeChild(int indent, String name, String type, AST node) {

        if (node == null) {
            writeDivWithTabs(indent,
                    span(CHILD_NAME_CLASS, name) + " = " + valueSpan(null) + "  " + span(TYPE_CLASS, type));
            return;
        }

        String text = name + " " + node.getClass().getSimpleName() + " ="; // Usado sólo para calcular tamaño sin tag 'span'
        String sourceText = getAlignedSourceText(indent, text.length(), node);

        writeDivWithTabs(indent, span(CHILD_NAME_CLASS, name) + " " + span(TYPE_CLASS, node.getClass().getSimpleName())
                + " =" + sourceText);

        node.accept(this, indent);
    }

    /**
     * Método para imprimir aquel Child que sea una lista de nodos del AST (pe, 'sentence*').
     * Imprime y recorre cada nodo de la lista.
     */
    private void printListOfNodesChild(int indent, String name, String type, List<? extends AST> nodes) {
        writeDivWithTabs(indent, span(CHILD_NAME_CLASS, name) + escapedSpan(TYPE_CLASS, " " + type) + " =");

        if (nodes != null)
            for (int i = 0; i < nodes.size(); i++) {
                AST node = nodes.get(i);

                String text = i + ": " + node.getClass().getSimpleName() + " ="; // Usado sólo para calcular tamaño sin tag 'span'
                String sourceText = getAlignedSourceText(indent + 1, text.length(), node);

                writeDivWithTabs(indent + 1, span(CHILD_NAME_CLASS, i + "") + ": "
                        + span(TYPE_CLASS, node.getClass().getSimpleName()) + " =" + sourceText);

                node.accept(this, indent + 1);
            }
        else
            writer.print(" " + valueSpan(null));
    }

    /**
     * Método para imprimir todo Child que no sea visitable, es decir, todo hijo que no sea un
     * nodo o lista de nodos.
     * Se limita a imprimir el 'toString()' de dicho hijo.
     */
    private void printNonNodeChild(int indent, String name, String type, Object value) {
        printToString(indent, CHILD_NAME_CLASS, name, type, value);
    }

    /**
     * Dado un nodo, busca e imprime todo aquel miembro que no se haya declarado en la Gramática Abstracta.
     * La razón por la que no se hace todo con Introspección es porque se quiere respetar el orden de
     * los hijos declarados en la Gramática Abstracta y, por ello, éstos se imprimen antes en el
     * 'visit'.
     * El parámetro knownFields son los miembros ya imprimidos del nodo y que no deben repetirse.
     */
    private void printUnknownFields(int indent, AST node, String... knownFields) {

        List<String> knownNames = new ArrayList<>(Arrays.asList(knownFields));
        knownNames.addAll(List.of("start", "end"));

        // Extraer todos las variables de instancia de la clase (propios o derivados)
        List<java.lang.reflect.Field> allFields = new ArrayList<>();
        Class<?> currentClass = node.getClass();
        while (currentClass != null && currentClass != Object.class) {
            java.util.Collections.addAll(allFields, currentClass.getDeclaredFields());
            currentClass = currentClass.getSuperclass();
        }

        // Imprimir el 'toString' de aquellas que no se hayan impreso ya y no sean static
        for (java.lang.reflect.Field field : allFields) {
            if ((!knownNames.contains(field.getName()))
                    && (!java.lang.reflect.Modifier.isStatic(field.getModifiers()))) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(node);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    value = "!!Error accesing value by introspection";
                }
                printToString(indent, "unknown-field", field.getName(), field.getType().getSimpleName(), value);
            }
        }
    }

    //$ -------------------------------------------------------------------------------------
    // Métodos auxiliares usados por los métodos anteriores

    // Imprime el 'toString()' del value que se le pase
    private void printToString(int indent, String cssClass, String name, String type, Object value) {

        if (type.equals("String"))
            type = "string"; // Queda mejor en minúsculas

        String typeText = escapedSpan(TYPE_CLASS, "  " + type);

        // No imprimir el tipo del miembro si es un AST y su valor es del mismo tipo (es decir, el
        // valor no es un tipo derivado y, por tanto, son iguales). Dicho tipo ya aparecerá en el
        // toString() del nodo.
        if (value instanceof AST && type.equals(value.getClass().getSimpleName()))
            typeText = "";

        writeDivWithTabs(indent, span(cssClass, name) + " = " + valueSpan(value) + typeText);
    }

    private void writeDiv(String text) {
        writer.println("<div>" + text + "</div>");
    }

    private void writeDivWithTabs(int indent, String text) {
        writeDiv(getTabuladores(indent) + text);
    }

    private String getTabuladores(int count) {
        var cadena = new StringBuilder();
        for (int i = 0; i < count; i++)
            cadena.append((i % 2 == 0 ? '|' : '.') + tabulator);
        return span(TABS_CLASS, cadena.toString());
    }

    private static String span(String cssClass, String text) {
        return "<span class=\"" + cssClass + "\">" + text + "</span>";
    }

    private static String escapedSpan(String cssClass, String text) {
        return span(cssClass, text.replace("<", "&lt;").replace(">", "&gt;"));
    }

    private static String valueSpan(Object value) {
        final int MAX_LENGTH = 46;

        if (value == null)
            return span(NULL_CLASS, "null");

        String text = value.toString();
        if (text.length() > MAX_LENGTH)
            text = text.substring(0, MAX_LENGTH) + "...";
        if (value instanceof String)
            text = '"' + text + '"';
        return escapedSpan(VALUE_CLASS, text);
    }

    // -----------------------------------------------------------------
    // Métodos para mostrar las Posiciones

    private String getAlignedSourceText(int indent, int textLength, AST node) {

        final int width = 75;

        int neededSpaces = width - (indent * tabSize) - textLength;
        var spaces = new StringBuilder();
        for (int i = 0; i < neededSpaces / 2; i++)
            spaces.append(" .");
        if (neededSpaces % 2 == 1)
            spaces.append(" ");

        return span(DOTS_CLASS, spaces.toString()) + getSourceText(node);
    }

    private String getSourceText(AST node) {

        String text = "[" + node.start() + " " + node.end() + "]";

        final int PADDING_LENGTH = 14;
        String paddedText = (text.length() < PADDING_LENGTH)
                ? text + "&nbsp;".repeat(PADDING_LENGTH - text.length())
                : text;

        text = span(POS_CLASS, paddedText);
        text = text.replace("null", "<span class=\"" + NULL_CLASS + "\">null</span>");
        String sourceText = findSourceText(node);
        if (sourceText != null)
            text = text + sourceText;
        return text;
    }


    private boolean isValidPosition(Position position) {
        return position != null && position.getLine() > 0 && position.getColumn() > 0;
    }

    private String findSourceText(AST node) {
        if (sourceLines.isEmpty())
            return null;

        Position start = node.start();
        Position end = node.end();

        var validPositions = isValidPosition(start) && isValidPosition(end) && start.lessThan(end);
        if (!validPositions)
            return null;

        // Single line source text
        if (start.getLine() == end.getLine()) {
            String line = sourceLines.get(start.getLine() - 1);

            var firstCharPosition = start.getColumn() - 1;
            var nextCharPosition = end.getColumn() - 1;

            var beforeText = line.substring(0, firstCharPosition);
            var text = line.substring(firstCharPosition, nextCharPosition);
            var afterText = line.substring(nextCharPosition);

            return span(SOURCE_TEXT_CLASS,
                    escapedSpan(NON_NODE_SOURCE_TEXT_CLASS, beforeText.stripLeading())
                            + escapedSpan(NODE_SOURCE_TEXT_CLASS, text)
                            + escapedSpan(NON_NODE_SOURCE_TEXT_CLASS, afterText.stripTrailing()));
        }

        // Multiline source text
        String firstLine = sourceLines.get(start.getLine() - 1);
        var firstCharPosition = start.getColumn() - 1;
        var beforeText = firstLine.substring(0, firstCharPosition);
        var firstLineText = firstLine.substring(firstCharPosition);

        String lastLine = sourceLines.get(end.getLine() - 1);
        var nextCharPosition = end.getColumn() - 1;
        var lastLineText = lastLine.substring(0, nextCharPosition);
        var afterText = lastLine.substring(nextCharPosition);

        return span(SOURCE_TEXT_CLASS,
                escapedSpan(NON_NODE_SOURCE_TEXT_CLASS, beforeText.stripLeading())
                        + escapedSpan(NODE_SOURCE_TEXT_CLASS, firstLineText.stripTrailing())
                        + span(OMITTED_SOURCE_TEXT_CLASS, " &bull;&bull;&bull; ")
                        + escapedSpan(NODE_SOURCE_TEXT_CLASS, lastLineText.stripLeading())
                        + escapedSpan(NON_NODE_SOURCE_TEXT_CLASS, afterText.stripTrailing()));
    }

    private static List<String> loadLines(String sourceFile) {
        if (sourceFile == null)
            return java.util.Collections.emptyList();

        var lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = br.readLine()) != null)
                lines.add(line);

        } catch (FileNotFoundException e) {
            System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile
                    + "'. No se mostrará información de posición.");
        } catch (IOException e) {
            System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile
                    + "'. No se mostrará información de posición.");
        }
        return lines;
    }

    //$ -------------------------------------------------------------------------------------
    // Texto literal

    private static final String HEADER = """
            <html>
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>AstPrinter</title>
                <style type="text/css">
                    .vgen-body {
                        font-family: monospace;
                        color: #404040;
                    }
                    .vgen-div {
                        white-space: pre;
                    }
                    .vgen-tabs {
                        color: #96c0d9;
                    }
                    .vgen-child-name {
                        color: #2A5873;
                    }
                    .vgen-attribute-phase-0 {
                        color: #04ab04ff;
                    }
                    .vgen-attribute-phase-1 {
                        color: #ab0479ff;
                    }
                    .vgen-attribute-phase-2 {
                        color: #abab04ff;
                    }
                    .vgen-unknown-field {
                        color: grey;
                    }
                    .vgen-type {
                        color: #A7CADF;
                    }
                    .vgen-value {
                        color: #D6630E;
                    }
                    .vgen-dots {
                        color: #7BB0CF;
                    }
                    .vgen-pos {
                        color: #7BB0CF;
                    }
                    .vgen-nonNodeSourceText {
                    }
                    .vgen-nodeSourceText {
                        background-color: #d7f9d6;
                        border-radius: 4px;
                        padding-left: 3px;
                        padding-right: 3px;
                    }
                    .vgen-omittedSourceText {
                        color: #a6f2a4ff;
                    }
                    .vgen-null {
                        color: white;
                        background-color: #c7655b;
                        border-radius: 7px;
                        padding-left: 4px;
                        padding-right: 4px;
                    }
                </style>
            </head>
            <body>
            """;

    private static final String FOOTER = """

            </body>
            </html>
            """;

    //$ -----------------------------------------------------------------
    // Variables de instancia

    private List<String> sourceLines;
    private static String ls = System.getProperty("line.separator");
    private PrintWriter writer;

    private String tabulator;
    private int tabSize;


}
