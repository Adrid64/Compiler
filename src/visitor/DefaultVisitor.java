// Generated with VGen 2.0.0

/**
* El objetivo de esta clase DefaultVisitor es ser la implementación base de la que
* deriven todos los demás visitor.
*
* Sus métodos visit recorren los hijos del nodo que se está visitando. Por tanto,
* todo visitor que derive de este ya tendrá implementado todo el código de
* recorrido del AST.
*
* Para crear nuevos visitor, en vez de modificar esta clase, se recomienda copiar
* 'SkeletonForNewVisitors.java' o, mejor aún, definir una nueva PHASE en la gramática
* y usar el visitor generado para la misma.
*/

package visitor;

import ast.*;
import ast.declaration.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;




public class DefaultVisitor implements Visitor {
	@Override
	public Object visit(Program program, Object param) {

		program.getClassDeclaration().accept(this, param);
		program.getRunStatement().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ClassDeclaration classDeclaration, Object param) {

		classDeclaration.getGlobalSection().ifPresent(globalSection -> globalSection.accept(this, param));
		classDeclaration.getCreateSection().accept(this, param);
		classDeclaration.getFeatureSections().forEach(featureSection -> featureSection.accept(this, param));
		return null;
	}

	@Override
	public Object visit(GlobalSection globalSection, Object param) {

		globalSection.getTypesSection().ifPresent(typesSection -> typesSection.accept(this, param));
		globalSection.getVarSection().ifPresent(varSection -> varSection.accept(this, param));
		return null;
	}

	@Override
	public Object visit(TypesSection typesSection, Object param) {

		typesSection.getStructDeclarations().forEach(structDeclaration -> structDeclaration.accept(this, param));
		return null;
	}

	@Override
	public Object visit(VarSection varSection, Object param) {

		varSection.getVariableDeclarations().forEach(variableDeclaration -> variableDeclaration.accept(this, param));
		return null;
	}

	@Override
	public Object visit(VariableDeclaration variableDeclaration, Object param) {

		variableDeclaration.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(StructDeclaration structDeclaration, Object param) {

		structDeclaration.getStructFields().forEach(structField -> structField.accept(this, param));
		return null;
	}

	@Override
	public Object visit(StructField structField, Object param) {

		structField.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(CreateSection createSection, Object param) {

		return null;
	}

	@Override
	public Object visit(FeatureSection featureSection, Object param) {

		featureSection.getArgs().ifPresent(args -> args.accept(this, param));
		featureSection.getType().ifPresent(type -> type.accept(this, param));
		featureSection.getLocalSection().ifPresent(localSection -> localSection.accept(this, param));
		featureSection.getStatements().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(LocalSection localSection, Object param) {

		localSection.getVariableDeclarations().forEach(variableDeclaration -> variableDeclaration.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Args args, Object param) {

		args.getArgs().forEach(arg -> arg.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Arg arg, Object param) {

		arg.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Assignment assignment, Object param) {

		assignment.getLeft().accept(this, param);
		assignment.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Print print, Object param) {

		print.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Println println, Object param) {

		println.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Read read, Object param) {

		read.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Bloqueif bloqueif, Object param) {

		bloqueif.getExpression().accept(this, param);
		bloqueif.getSt2().forEach(statement -> statement.accept(this, param));
		bloqueif.getSt3().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(LoopFrom loopFrom, Object param) {

		loopFrom.getSt1().forEach(statement -> statement.accept(this, param));
		loopFrom.getExpression().accept(this, param);
		loopFrom.getBody().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Return returnValue, Object param) {

		returnValue.getExpression().ifPresent(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

		functionCallStatement.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(RunStatement runStatement, Object param) {

		runStatement.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(RealConstant realConstant, Object param) {

		return null;
	}

	@Override
	public Object visit(CharConstant charConstant, Object param) {

		return null;
	}

	@Override
	public Object visit(FunctionCallExp functionCallExp, Object param) {

		functionCallExp.getExpresiones().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(ArrayAcces arrayAcces, Object param) {

		arrayAcces.getExp2().accept(this, param);
		arrayAcces.getExp3().accept(this, param);
		return null;
	}

	@Override
	public Object visit(VariableAcces variableAcces, Object param) {

		return null;
	}

	@Override
	public Object visit(RestaUnaria restaUnaria, Object param) {

		restaUnaria.getExp2().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Parentesis parentesis, Object param) {

		parentesis.getExp2().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Negacion negacion, Object param) {

		negacion.getExp2().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Cast cast, Object param) {

		cast.getTipoCast().accept(this, param);
		cast.getExp2().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

		arithmetic.getExp2().accept(this, param);
		arithmetic.getExp3().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Relacional relacional, Object param) {

		relacional.getExp2().accept(this, param);
		relacional.getExp3().accept(this, param);
		return null;
	}

	@Override
	public Object visit(BooleanExp booleanExp, Object param) {

		booleanExp.getExp2().accept(this, param);
		booleanExp.getExp3().accept(this, param);
		return null;
	}

	@Override
	public Object visit(StructFieldAcces structFieldAcces, Object param) {

		structFieldAcces.getExp2().accept(this, param);
		return null;
	}

	@Override
	public Object visit(IntType intType, Object param) {

		return null;
	}

	@Override
	public Object visit(DoubleType doubleType, Object param) {

		return null;
	}

	@Override
	public Object visit(CharacterType characterType, Object param) {

		return null;
	}

	@Override
	public Object visit(IdentType identType, Object param) {

		return null;
	}

	@Override
	public Object visit(Arraytype arraytype, Object param) {

		arraytype.getType2().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ErrorType errorType, Object param) {

		return null;
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

		return null;
	}


}
