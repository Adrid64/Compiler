// Generated with VGen 2.0.0

/**
* Este interfaz es el resultado de la aplicación del patrón Visitor a los nodos del AST.
*/

package visitor;

import ast.*;
import ast.declaration.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;




public interface Visitor {
	public Object visit(Program program, Object param);

	public Object visit(ClassDeclaration classDeclaration, Object param);

	public Object visit(GlobalSection globalSection, Object param);

	public Object visit(TypesSection typesSection, Object param);

	public Object visit(VarSection varSection, Object param);

	public Object visit(VariableDeclaration variableDeclaration, Object param);

	public Object visit(StructDeclaration structDeclaration, Object param);

	public Object visit(StructField structField, Object param);

	public Object visit(CreateSection createSection, Object param);

	public Object visit(FeatureSection featureSection, Object param);

	public Object visit(LocalSection localSection, Object param);

	public Object visit(Args args, Object param);

	public Object visit(Arg arg, Object param);

	public Object visit(Assignment assignment, Object param);

	public Object visit(Print print, Object param);

	public Object visit(Println println, Object param);

	public Object visit(Read read, Object param);

	public Object visit(Bloqueif bloqueif, Object param);

	public Object visit(LoopFrom loopFrom, Object param);

	public Object visit(Return returnValue, Object param);

	public Object visit(FunctionCallStatement functionCallStatement, Object param);

	public Object visit(RunStatement runStatement, Object param);

	public Object visit(IntLiteral intLiteral, Object param);

	public Object visit(RealConstant realConstant, Object param);

	public Object visit(CharConstant charConstant, Object param);

	public Object visit(FunctionCallExp functionCallExp, Object param);

	public Object visit(ArrayAcces arrayAcces, Object param);

	public Object visit(VariableAcces variableAcces, Object param);

	public Object visit(RestaUnaria restaUnaria, Object param);

	public Object visit(Parentesis parentesis, Object param);

	public Object visit(Negacion negacion, Object param);

	public Object visit(Cast cast, Object param);

	public Object visit(Arithmetic arithmetic, Object param);

	public Object visit(Relacional relacional, Object param);

	public Object visit(BooleanExp booleanExp, Object param);

	public Object visit(StructFieldAcces structFieldAcces, Object param);

	public Object visit(IntType intType, Object param);

	public Object visit(DoubleType doubleType, Object param);

	public Object visit(CharacterType characterType, Object param);

	public Object visit(IdentType identType, Object param);

	public Object visit(Arraytype arraytype, Object param);

	public Object visit(ErrorType errorType, Object param);

	public Object visit(VoidType voidType, Object param);


}
