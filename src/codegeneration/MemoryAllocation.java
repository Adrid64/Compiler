package codegeneration;

import visitor.DefaultVisitor;

import java.util.List;

import ast.*;
import ast.declaration.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;


// This class will be implemented in memory allocation phase

public class MemoryAllocation extends DefaultVisitor {
    public void process(AST ast) {
        ast.accept(this, null);
    }
    
    // Visit Methods --------------------------------------------------------------

   	// class Program(ClassDeclaration classDeclaration, RunStatement runStatement)
   	@Override
   	public Object visit(Program program, Object param) {

   		// program.getClassDeclaration().accept(this, param);
   		// program.getRunStatement().accept(this, param);
   		super.visit(program, param);

   		return null;
   	}

   	// class ClassDeclaration(String name, Optional<GlobalSection> globalSection, CreateSection createSection, List<FeatureSection> featureSections)
   	@Override
   	public Object visit(ClassDeclaration classDeclaration, Object param) {

   		// classDeclaration.getGlobalSection().ifPresent(globalSection -> globalSection.accept(this, param));
   		// classDeclaration.getCreateSection().accept(this, param);
   		// classDeclaration.getFeatureSections().forEach(featureSection -> featureSection.accept(this, param));
   		super.visit(classDeclaration, param);

   		return null;
   	}

   	// class GlobalSection(Optional<TypesSection> typesSection, Optional<VarSection> varSection)
   	@Override
   	public Object visit(GlobalSection globalSection, Object param) {

   		// globalSection.getTypesSection().ifPresent(typesSection -> typesSection.accept(this, param));
   		// globalSection.getVarSection().ifPresent(varSection -> varSection.accept(this, param));
   		super.visit(globalSection, param);

   		return null;
   	}

   	// class TypesSection(List<StructDeclaration> structDeclarations)
   	@Override
   	public Object visit(TypesSection typesSection, Object param) {

   		// typesSection.getStructDeclarations().forEach(structDeclaration -> structDeclaration.accept(this, param));
   		super.visit(typesSection, param);

   		return null;
   	}

   	// class VarSection(List<VariableDeclaration> variableDeclarations)
   	@Override
   	public Object visit(VarSection varSection, Object param) {
   		int address=0;
   		for (var variableDeclaration : varSection.getVariableDeclarations()) {
   			variableDeclaration.setAddress(address);
   			address+=variableDeclaration.getType().getSize();
   			// TODO: Remember to initialize INHERITED attributes <----
   			// variableDeclaration.setAddress(?);
   			
   		}

   		// varSection.getVariableDeclarations().forEach(variableDeclaration -> variableDeclaration.accept(this, param));
   		super.visit(varSection, param);

   		return null;
   	}

   	// class VariableDeclaration(List<String> identifiers, Type type)
   	// phase MemoryAllocation { int address }
   	@Override
   	public Object visit(VariableDeclaration variableDeclaration, Object param) {

   		// variableDeclaration.getType().accept(this, param);
   		super.visit(variableDeclaration, param);

   		return null;
   	}

   	// class StructDeclaration(String name, List<StructField> structFields)
   	@Override
   	public Object visit(StructDeclaration structDeclaration, Object param) {
   		int address=0;
   		for (var structField : structDeclaration.getStructFields()) {
   			// TODO: Remember to initialize INHERITED attributes <----
   			// structField.setAddress(?);
   			structField.setAddress(address);
   			address+=structField.getType().getSize();
   		}

   		// structDeclaration.getStructFields().forEach(structField -> structField.accept(this, param));
   		super.visit(structDeclaration, param);

   		return null;
   	}

   	// class StructField(String name, Type type)
   	// phase Identification { StructDeclaration structDeclaration }
   	// phase MemoryAllocation { int address }
   	@Override
   	public Object visit(StructField structField, Object param) {

   		// structField.getType().accept(this, param);
   		super.visit(structField, param);

   		return null;
   	}

   	// class CreateSection(List<String> strings)
   	@Override
   	public Object visit(CreateSection createSection, Object param) {

   		return null;
   	}

   	// class FeatureSection(String name, Optional<Args> args, Optional<Type> type, Optional<LocalSection> localSection, List<Statement> statements)
   	// phase TypeChecking { boolean hasReturn }
   	@Override
   	public Object visit(FeatureSection featureSection, Object param) {

   		// featureSection.getArgs().ifPresent(args -> args.accept(this, param));
   		// featureSection.getType().ifPresent(type -> type.accept(this, param));
   		// featureSection.getLocalSection().ifPresent(localSection -> localSection.accept(this, param));
   		// featureSection.getStatements().forEach(statement -> statement.accept(this, param));
   		super.visit(featureSection, param);

   		return null;
   	}

   	// class LocalSection(List<VariableDeclaration> variableDeclarations)
   	@Override
   	public Object visit(LocalSection localSection, Object param) {
   		int address=0;
   		for (var variableDeclaration : localSection.getVariableDeclarations()) {
   			// TODO: Remember to initialize INHERITED attributes <----
   			// variableDeclaration.setAddress(?);
   			address-=variableDeclaration.getType().getSize();
   			variableDeclaration.setAddress(address);
   			
   		}

   		// localSection.getVariableDeclarations().forEach(variableDeclaration -> variableDeclaration.accept(this, param));
   		super.visit(localSection, param);

   		return null;
   	}

   	// class Args(List<Arg> args)
   	@Override
   	public Object visit(Args args, Object param) {
   		int address=4;
   		super.visit(args, param);
   		List<Arg> argsList=args.getArgs();
   		for (int i = (argsList.size() - 1); i >= 0; i--) {
			argsList.get(i).setAddress(address);
			address += argsList.get(i).getType().getSize();
		}
   		// args.getArgs().forEach(arg -> arg.accept(this, param));
   		

   		return null;
   	}

   	// class Arg(String name, Type type)
   	// phase MemoryAllocation { int address }
   	@Override
   	public Object visit(Arg arg, Object param) {

   		// arg.getType().accept(this, param);
   		super.visit(arg, param);

   		return null;
   	}

   	// class Assignment(Expression left, Expression right)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(Assignment assignment, Object param) {

   		// assignment.getLeft().accept(this, param);
   		// assignment.getRight().accept(this, param);
   		super.visit(assignment, param);

   		return null;
   	}

   	// class Print(List<Expression> expressions)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(Print print, Object param) {

   		// print.getExpressions().forEach(expression -> expression.accept(this, param));
   		super.visit(print, param);

   		return null;
   	}

   	// class Println(List<Expression> expressions)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(Println println, Object param) {

   		// println.getExpressions().forEach(expression -> expression.accept(this, param));
   		super.visit(println, param);

   		return null;
   	}

   	// class Read(List<Expression> expressions)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(Read read, Object param) {

   		// read.getExpressions().forEach(expression -> expression.accept(this, param));
   		super.visit(read, param);

   		return null;
   	}

   	// class Bloqueif(Expression expression, List<Statement> st2, List<Statement> st3)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(Bloqueif bloqueif, Object param) {

   		// bloqueif.getExpression().accept(this, param);
   		// bloqueif.getSt2().forEach(statement -> statement.accept(this, param));
   		// bloqueif.getSt3().forEach(statement -> statement.accept(this, param));
   		super.visit(bloqueif, param);

   		return null;
   	}

   	// class LoopFrom(List<Statement> st1, Expression expression, List<Statement> body)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(LoopFrom loopFrom, Object param) {

   		// loopFrom.getSt1().forEach(statement -> statement.accept(this, param));
   		// loopFrom.getExpression().accept(this, param);
   		// loopFrom.getBody().forEach(statement -> statement.accept(this, param));
   		super.visit(loopFrom, param);

   		return null;
   	}

   	// class Return(Optional<Expression> expression)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(Return returnValue, Object param) {

   		// returnValue.getExpression().ifPresent(expression -> expression.accept(this, param));
   		super.visit(returnValue, param);

   		return null;
   	}

   	// class FunctionCallStatement(String name, List<Expression> expressions)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

   		// functionCallStatement.getExpressions().forEach(expression -> expression.accept(this, param));
   		super.visit(functionCallStatement, param);

   		return null;
   	}

   	// class RunStatement(String name, List<Expression> expressions)
   	// phase TypeChecking { FeatureSection featureSection }
   	@Override
   	public Object visit(RunStatement runStatement, Object param) {

   		// runStatement.getExpressions().forEach(expression -> expression.accept(this, param));
   		super.visit(runStatement, param);

   		return null;
   	}

   	// class IntLiteral(String name)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(IntLiteral intLiteral, Object param) {

   		return null;
   	}

   	// class RealConstant(String name)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(RealConstant realConstant, Object param) {

   		return null;
   	}

   	// class CharConstant(String name)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(CharConstant charConstant, Object param) {

   		return null;
   	}

   	// class FunctionCallExp(String name, List<Expression> expresiones)
   	// phase Identification { FeatureSection featureSection }
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(FunctionCallExp functionCallExp, Object param) {

   		// functionCallExp.getExpresiones().forEach(expression -> expression.accept(this, param));
   		super.visit(functionCallExp, param);

   		return null;
   	}

   	// class ArrayAcces(Expression exp2, Expression exp3)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(ArrayAcces arrayAcces, Object param) {

   		// arrayAcces.getExp2().accept(this, param);
   		// arrayAcces.getExp3().accept(this, param);
   		super.visit(arrayAcces, param);

   		return null;
   	}

   	// class VariableAcces(String name)
   	// phase Identification { Declaration declaration }
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(VariableAcces variableAcces, Object param) {

   		return null;
   	}

   	// class RestaUnaria(Expression exp2)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(RestaUnaria restaUnaria, Object param) {

   		// restaUnaria.getExp2().accept(this, param);
   		super.visit(restaUnaria, param);

   		return null;
   	}

   	// class Parentesis(Expression exp2)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(Parentesis parentesis, Object param) {

   		// parentesis.getExp2().accept(this, param);
   		super.visit(parentesis, param);

   		return null;
   	}

   	// class Negacion(Expression exp2)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(Negacion negacion, Object param) {

   		// negacion.getExp2().accept(this, param);
   		super.visit(negacion, param);

   		return null;
   	}

   	// class Cast(Type tipoCast, Expression exp2)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(Cast cast, Object param) {

   		// cast.getTipoCast().accept(this, param);
   		// cast.getExp2().accept(this, param);
   		super.visit(cast, param);

   		return null;
   	}

   	// class Arithmetic(Expression exp2, String name, Expression exp3)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(Arithmetic arithmetic, Object param) {

   		// arithmetic.getExp2().accept(this, param);
   		// arithmetic.getExp3().accept(this, param);
   		super.visit(arithmetic, param);

   		return null;
   	}

   	// class BooleanExp(Expression exp2, String name, Expression exp3)
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(BooleanExp booleanExp, Object param) {

   		// booleanExp.getExp2().accept(this, param);
   		// booleanExp.getExp3().accept(this, param);
   		super.visit(booleanExp, param);

   		return null;
   	}

   	// class StructFieldAcces(Expression exp2, String name)
   	// phase Identification { StructDeclaration structDeclaration }
   	// phase TypeChecking { boolean lvalue, Type type }
   	@Override
   	public Object visit(StructFieldAcces structFieldAcces, Object param) {

   		// structFieldAcces.getExp2().accept(this, param);
   		super.visit(structFieldAcces, param);

   		return null;
   	}

   	// class IntType(String name)
   	@Override
   	public Object visit(IntType intType, Object param) {

   		return null;
   	}

   	// class DoubleType(String name)
   	@Override
   	public Object visit(DoubleType doubleType, Object param) {

   		return null;
   	}

   	// class CharacterType(String name)
   	@Override
   	public Object visit(CharacterType characterType, Object param) {

   		return null;
   	}

   	// class IdentType(String name)
   	// phase Identification { StructDeclaration structDeclaration }
   	@Override
   	public Object visit(IdentType identType, Object param) {

   		return null;
   	}

   	// class Arraytype(int intValue, Type type2)
   	@Override
   	public Object visit(Arraytype arraytype, Object param) {

   		// arraytype.getType2().accept(this, param);
   		super.visit(arraytype, param);

   		return null;
   	}

   	// class ErrorType(String name)
   	@Override
   	public Object visit(ErrorType errorType, Object param) {

   		return null;
   	}

   	// class VoidType(String name)
   	@Override
   	public Object visit(VoidType voidType, Object param) {

   		return null;
   	}

   

}
