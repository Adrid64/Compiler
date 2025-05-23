// Generated from java-escape by ANTLR 4.11.1
package parser;


import ast.*;
import ast.type.*;
import ast.statement.*;
import ast.expression.*;
import ast.declaration.*;



import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, INT_LITERAL=51, LINE_COMMENT=52, 
		MULTILINE_COMMENT=53, WHITESPACE=54, REAL_CONSTANT=55, CHAR_CONSTANT=56, 
		IDENT=57;
	public static final int
		RULE_program = 0, RULE_classDeclaration = 1, RULE_globalSection = 2, RULE_typesSection = 3, 
		RULE_varSection = 4, RULE_variableDeclaration = 5, RULE_structDeclaration = 6, 
		RULE_structField = 7, RULE_createSection = 8, RULE_featureSection = 9, 
		RULE_args = 10, RULE_arg = 11, RULE_localSection = 12, RULE_statement = 13, 
		RULE_runStatement = 14, RULE_expression = 15, RULE_expressionList = 16, 
		RULE_type = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classDeclaration", "globalSection", "typesSection", "varSection", 
			"variableDeclaration", "structDeclaration", "structField", "createSection", 
			"featureSection", "args", "arg", "localSection", "statement", "runStatement", 
			"expression", "expressionList", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "';'", "'end'", "'global'", "'types'", "'vars'", "','", 
			"':'", "'deftuple'", "'as'", "'create'", "'feature'", "'('", "')'", "'is'", 
			"'do'", "'local'", "':='", "'print'", "'println'", "'read'", "'if'", 
			"'then'", "'else'", "'from'", "'until'", "'loop'", "'return'", "'run'", 
			"'['", "']'", "'.'", "'-'", "'not'", "'to'", "'<'", "'>'", "'*'", "'/'", 
			"'mod'", "'+'", "'<='", "'>='", "'='", "'<>'", "'and'", "'or'", "'INTEGER'", 
			"'DOUBLE'", "'CHARACTER'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT_LITERAL", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public ClassDeclarationContext classDeclaration;
		public RunStatementContext runStatement;
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public RunStatementContext runStatement() {
			return getRuleContext(RunStatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((ProgramContext)_localctx).classDeclaration = classDeclaration();
			setState(37);
			((ProgramContext)_localctx).runStatement = runStatement();
			setState(38);
			match(EOF);
			((ProgramContext)_localctx).ast =  new Program(((ProgramContext)_localctx).classDeclaration.ast, ((ProgramContext)_localctx).runStatement.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclaration ast;
		public List<FeatureSection> list = new ArrayList<FeatureSection>();
		public Token IDENT;
		public GlobalSectionContext globalSection;
		public CreateSectionContext createSection;
		public FeatureSectionContext featureSection;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public CreateSectionContext createSection() {
			return getRuleContext(CreateSectionContext.class,0);
		}
		public GlobalSectionContext globalSection() {
			return getRuleContext(GlobalSectionContext.class,0);
		}
		public List<FeatureSectionContext> featureSection() {
			return getRuleContexts(FeatureSectionContext.class);
		}
		public FeatureSectionContext featureSection(int i) {
			return getRuleContext(FeatureSectionContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			((ClassDeclarationContext)_localctx).IDENT = match(IDENT);
			setState(43);
			match(T__1);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(44);
				((ClassDeclarationContext)_localctx).globalSection = globalSection();
				}
			}

			setState(47);
			((ClassDeclarationContext)_localctx).createSection = createSection();
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				((ClassDeclarationContext)_localctx).featureSection = featureSection();
				 _localctx.list.add(((ClassDeclarationContext)_localctx).featureSection.ast); 
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__11 );
			setState(55);
			match(T__2);
			((ClassDeclarationContext)_localctx).ast =  new ClassDeclaration(((ClassDeclarationContext)_localctx).IDENT,
			     ((ClassDeclarationContext)_localctx).globalSection != null ? ((ClassDeclarationContext)_localctx).globalSection.ast : null, ((ClassDeclarationContext)_localctx).createSection.ast,
			     _localctx.list
			     );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalSectionContext extends ParserRuleContext {
		public GlobalSection ast;
		public TypesSectionContext typesSection;
		public VarSectionContext varSection;
		public TypesSectionContext typesSection() {
			return getRuleContext(TypesSectionContext.class,0);
		}
		public VarSectionContext varSection() {
			return getRuleContext(VarSectionContext.class,0);
		}
		public GlobalSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalSection; }
	}

	public final GlobalSectionContext globalSection() throws RecognitionException {
		GlobalSectionContext _localctx = new GlobalSectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__3);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(59);
				((GlobalSectionContext)_localctx).typesSection = typesSection();
				}
			}

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(62);
				((GlobalSectionContext)_localctx).varSection = varSection();
				}
			}

			((GlobalSectionContext)_localctx).ast =  new GlobalSection(((GlobalSectionContext)_localctx).typesSection != null ? ((GlobalSectionContext)_localctx).typesSection.ast : null,
				((GlobalSectionContext)_localctx).varSection != null ? ((GlobalSectionContext)_localctx).varSection.ast : null
				);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypesSectionContext extends ParserRuleContext {
		public TypesSection ast;
		public List<StructDeclaration> list = new ArrayList<StructDeclaration>();
		public StructDeclarationContext structDeclaration;
		public List<StructDeclarationContext> structDeclaration() {
			return getRuleContexts(StructDeclarationContext.class);
		}
		public StructDeclarationContext structDeclaration(int i) {
			return getRuleContext(StructDeclarationContext.class,i);
		}
		public TypesSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typesSection; }
	}

	public final TypesSectionContext typesSection() throws RecognitionException {
		TypesSectionContext _localctx = new TypesSectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typesSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__4);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(68);
				((TypesSectionContext)_localctx).structDeclaration = structDeclaration();
				 _localctx.list.add(((TypesSectionContext)_localctx).structDeclaration.ast); 
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((TypesSectionContext)_localctx).ast =  new TypesSection(_localctx.list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarSectionContext extends ParserRuleContext {
		public VarSection ast;
		public List<VariableDeclaration> list = new ArrayList<VariableDeclaration>();
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public VarSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varSection; }
	}

	public final VarSectionContext varSection() throws RecognitionException {
		VarSectionContext _localctx = new VarSectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__5);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(79);
				((VarSectionContext)_localctx).variableDeclaration = variableDeclaration();
				 _localctx.list.add(((VarSectionContext)_localctx).variableDeclaration.ast); 
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((VarSectionContext)_localctx).ast =  new VarSection(_localctx.list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableDeclaration ast;
		public List<Token> list = new ArrayList<Token>();
		public Token IDENT;
		public TypeContext type;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			((VariableDeclarationContext)_localctx).IDENT = match(IDENT);
			_localctx.list.add(((VariableDeclarationContext)_localctx).IDENT);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(91);
				match(T__6);
				setState(92);
				((VariableDeclarationContext)_localctx).IDENT = match(IDENT);
				_localctx.list.add(((VariableDeclarationContext)_localctx).IDENT);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(T__7);
			setState(100);
			((VariableDeclarationContext)_localctx).type = type();
			setState(101);
			match(T__1);
			 ((VariableDeclarationContext)_localctx).ast =  new VariableDeclaration(_localctx.list, ((VariableDeclarationContext)_localctx).type.ast);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclarationContext extends ParserRuleContext {
		public StructDeclaration ast;
		public List<StructField> list = new ArrayList<StructField>();
		public Token IDENT;
		public StructFieldContext structField;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__8);
			setState(105);
			((StructDeclarationContext)_localctx).IDENT = match(IDENT);
			setState(106);
			match(T__9);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(107);
				((StructDeclarationContext)_localctx).structField = structField();
				_localctx.list.add(((StructDeclarationContext)_localctx).structField.ast);
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			match(T__2);
			((StructDeclarationContext)_localctx).ast =  new StructDeclaration(((StructDeclarationContext)_localctx).IDENT,_localctx.list);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructFieldContext extends ParserRuleContext {
		public StructField ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			((StructFieldContext)_localctx).IDENT = match(IDENT);
			setState(119);
			match(T__7);
			setState(120);
			((StructFieldContext)_localctx).type = type();
			setState(121);
			match(T__1);
			((StructFieldContext)_localctx).ast =  new StructField(((StructFieldContext)_localctx).IDENT,((StructFieldContext)_localctx).type.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateSectionContext extends ParserRuleContext {
		public CreateSection ast;
		public List<Token> list = new ArrayList<Token>();
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public CreateSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createSection; }
	}

	public final CreateSectionContext createSection() throws RecognitionException {
		CreateSectionContext _localctx = new CreateSectionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_createSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__10);
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				((CreateSectionContext)_localctx).IDENT = match(IDENT);
				_localctx.list.add(((CreateSectionContext)_localctx).IDENT);
				setState(127);
				match(T__1);
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			((CreateSectionContext)_localctx).ast = new CreateSection(_localctx.list);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FeatureSectionContext extends ParserRuleContext {
		public FeatureSection ast;
		public List<Statement> list = new ArrayList<Statement>();
		public Token IDENT;
		public ArgsContext args;
		public TypeContext type;
		public LocalSectionContext localSection;
		public StatementContext statement;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalSectionContext localSection() {
			return getRuleContext(LocalSectionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FeatureSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureSection; }
	}

	public final FeatureSectionContext featureSection() throws RecognitionException {
		FeatureSectionContext _localctx = new FeatureSectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_featureSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__11);
			setState(135);
			((FeatureSectionContext)_localctx).IDENT = match(IDENT);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(136);
				match(T__12);
				setState(137);
				((FeatureSectionContext)_localctx).args = args();
				setState(138);
				match(T__13);
				}
			}

			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(142);
				match(T__7);
				setState(143);
				((FeatureSectionContext)_localctx).type = type();
				}
			}

			setState(146);
			match(T__14);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(147);
				((FeatureSectionContext)_localctx).localSection = localSection();
				}
			}

			setState(150);
			match(T__15);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439452946432L) != 0) {
				{
				{
				setState(151);
				((FeatureSectionContext)_localctx).statement = statement();
				 _localctx.list.add(((FeatureSectionContext)_localctx).statement.ast); 
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			match(T__2);
			((FeatureSectionContext)_localctx).ast =  new FeatureSection(((FeatureSectionContext)_localctx).IDENT,((FeatureSectionContext)_localctx).args != null ? ((FeatureSectionContext)_localctx).args.ast : null, 
				((FeatureSectionContext)_localctx).type != null ? ((FeatureSectionContext)_localctx).type.ast : null
				,((FeatureSectionContext)_localctx).localSection != null ? ((FeatureSectionContext)_localctx).localSection.ast : null, _localctx.list
				);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public Args ast;
		public List<Arg> lista = new ArrayList<Arg>();
		public ArgContext arg;
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			((ArgsContext)_localctx).arg = arg();
			_localctx.lista.add(((ArgsContext)_localctx).arg.ast);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(164);
				match(T__6);
				setState(165);
				((ArgsContext)_localctx).arg = arg();
				_localctx.lista.add(((ArgsContext)_localctx).arg.ast);
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((ArgsContext)_localctx).ast =  new Args(_localctx.lista);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgContext extends ParserRuleContext {
		public Arg ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			((ArgContext)_localctx).IDENT = match(IDENT);
			setState(176);
			match(T__7);
			setState(177);
			((ArgContext)_localctx).type = type();
			((ArgContext)_localctx).ast =  new Arg(((ArgContext)_localctx).IDENT, ((ArgContext)_localctx).type.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocalSectionContext extends ParserRuleContext {
		public LocalSection ast;
		public List<VariableDeclaration> list = new ArrayList<VariableDeclaration>();
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public LocalSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localSection; }
	}

	public final LocalSectionContext localSection() throws RecognitionException {
		LocalSectionContext _localctx = new LocalSectionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_localSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__16);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(181);
				((LocalSectionContext)_localctx).variableDeclaration = variableDeclaration();
				 _localctx.list.add(((LocalSectionContext)_localctx).variableDeclaration.ast); 
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((LocalSectionContext)_localctx).ast =  new LocalSection(_localctx.list);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ExpressionListContext expressionList;
		public ExpressionContext expression;
		public StatementContext statement;
		public List<StatementContext> st1 = new ArrayList<StatementContext>();
		public List<StatementContext> stms1 = new ArrayList<StatementContext>();
		public List<StatementContext> stms2 = new ArrayList<StatementContext>();
		public List<StatementContext> fromStmts = new ArrayList<StatementContext>();
		public List<StatementContext> bodyStmts = new ArrayList<StatementContext>();
		public Token IDENT;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				((StatementContext)_localctx).e1 = expression(0);
				setState(192);
				match(T__17);
				setState(193);
				((StatementContext)_localctx).e2 = expression(0);
				setState(194);
				match(T__1);
				 ((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(T__18);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439075983360L) != 0) {
					{
					setState(198);
					((StatementContext)_localctx).expressionList = expressionList();
					}
				}

				setState(201);
				match(T__1);
				((StatementContext)_localctx).ast = new Print(((StatementContext)_localctx).expressionList != null ? ((StatementContext)_localctx).expressionList.lista : null);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				match(T__19);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439075983360L) != 0) {
					{
					setState(204);
					((StatementContext)_localctx).expressionList = expressionList();
					}
				}

				setState(207);
				match(T__1);
				((StatementContext)_localctx).ast = new Println(((StatementContext)_localctx).expressionList != null ? ((StatementContext)_localctx).expressionList.lista : null);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				match(T__20);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439075983360L) != 0) {
					{
					setState(210);
					((StatementContext)_localctx).expressionList = expressionList();
					}
				}

				setState(213);
				match(T__1);
				((StatementContext)_localctx).ast = new Read(((StatementContext)_localctx).expressionList != null ? ((StatementContext)_localctx).expressionList.lista : null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(215);
				match(T__21);
				setState(216);
				((StatementContext)_localctx).expression = expression(0);
				setState(217);
				match(T__22);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439452946432L) != 0) {
					{
					{
					setState(218);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).st1.add(((StatementContext)_localctx).statement);
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Bloqueif(((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).st1, null);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				match(T__21);
				setState(228);
				((StatementContext)_localctx).expression = expression(0);
				setState(229);
				match(T__22);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439452946432L) != 0) {
					{
					{
					setState(230);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).stms1.add(((StatementContext)_localctx).statement);
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				match(T__23);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439452946432L) != 0) {
					{
					{
					setState(237);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).stms2.add(((StatementContext)_localctx).statement);
					}
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(243);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Bloqueif(((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).stms1, ((StatementContext)_localctx).stms2); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(246);
					match(T__24);
					setState(250);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(247);
							((StatementContext)_localctx).statement = statement();
							((StatementContext)_localctx).fromStmts.add(((StatementContext)_localctx).statement);
							}
							} 
						}
						setState(252);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					}
					}
				}

				setState(255);
				match(T__25);
				setState(256);
				((StatementContext)_localctx).expression = expression(0);
				setState(257);
				match(T__26);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439452946432L) != 0) {
					{
					{
					setState(258);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).bodyStmts.add(((StatementContext)_localctx).statement);
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(264);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new LoopFrom(((StatementContext)_localctx).fromStmts,((StatementContext)_localctx).expression.ast,((StatementContext)_localctx).bodyStmts); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(267);
				match(T__27);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439075983360L) != 0) {
					{
					setState(268);
					((StatementContext)_localctx).expression = expression(0);
					}
				}

				setState(271);
				match(T__1);
				 ((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).expression != null ? ((StatementContext)_localctx).expression.ast : null); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(273);
				((StatementContext)_localctx).IDENT = match(IDENT);
				setState(274);
				match(T__12);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439075983360L) != 0) {
					{
					setState(275);
					((StatementContext)_localctx).expressionList = expressionList();
					}
				}

				setState(278);
				match(T__13);
				setState(279);
				match(T__1);
				 ((StatementContext)_localctx).ast =  new FunctionCallStatement(((StatementContext)_localctx).IDENT, ((StatementContext)_localctx).expressionList != null ? ((StatementContext)_localctx).expressionList.lista : new ArrayList<Expression>()); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RunStatementContext extends ParserRuleContext {
		public RunStatement ast;
		public Token IDENT;
		public ExpressionListContext expressionList;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public RunStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runStatement; }
	}

	public final RunStatementContext runStatement() throws RecognitionException {
		RunStatementContext _localctx = new RunStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_runStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__28);
			setState(284);
			((RunStatementContext)_localctx).IDENT = match(IDENT);
			setState(285);
			match(T__12);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439075983360L) != 0) {
				{
				setState(286);
				((RunStatementContext)_localctx).expressionList = expressionList();
				}
			}

			setState(289);
			match(T__13);
			setState(290);
			match(T__1);
			 ((RunStatementContext)_localctx).ast =  new RunStatement(((RunStatementContext)_localctx).IDENT, ((RunStatementContext)_localctx).expressionList != null ? ((RunStatementContext)_localctx).expressionList.lista : new ArrayList<Expression>()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public Token INT_LITERAL;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token IDENT;
		public ExpressionListContext expressionList;
		public ExpressionContext expression;
		public TypeContext type;
		public Token op;
		public ExpressionContext e2;
		public TerminalNode INT_LITERAL() { return getToken(GrammarParser.INT_LITERAL, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(294);
				((ExpressionContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_LITERAL); 
				}
				break;
			case 2:
				{
				setState(296);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealConstant(((ExpressionContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 3:
				{
				setState(298);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharConstant(((ExpressionContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			case 4:
				{
				setState(300);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				 ((ExpressionContext)_localctx).ast =  new VariableAcces(((ExpressionContext)_localctx).IDENT); 
				}
				break;
			case 5:
				{
				setState(302);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				setState(303);
				match(T__12);
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 254453439075983360L) != 0) {
					{
					setState(304);
					((ExpressionContext)_localctx).expressionList = expressionList();
					}
				}

				setState(307);
				match(T__13);
				 ((ExpressionContext)_localctx).ast =  new FunctionCallExp(((ExpressionContext)_localctx).IDENT, ((ExpressionContext)_localctx).expressionList != null ? ((ExpressionContext)_localctx).expressionList.lista : new ArrayList<Expression>()); 
				}
				break;
			case 6:
				{
				setState(309);
				match(T__32);
				setState(310);
				((ExpressionContext)_localctx).expression = expression(10);
				 ((ExpressionContext)_localctx).ast =  new RestaUnaria(((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 7:
				{
				setState(313);
				match(T__33);
				setState(314);
				((ExpressionContext)_localctx).expression = expression(9);
				 ((ExpressionContext)_localctx).ast =  new Negacion(((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 8:
				{
				setState(317);
				match(T__34);
				setState(318);
				match(T__35);
				setState(319);
				((ExpressionContext)_localctx).type = type();
				setState(320);
				match(T__36);
				setState(321);
				match(T__12);
				setState(322);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(323);
				match(T__13);

				    ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).type.ast,((ExpressionContext)_localctx).expression.ast);
				    
				}
				break;
			case 9:
				{
				setState(326);
				match(T__12);
				setState(327);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(328);
				match(T__13);
				 ((ExpressionContext)_localctx).ast =  new Parentesis(((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(375);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(373);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(334);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1924145348608L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(335);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).op, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(338);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(339);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__40) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(340);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).op, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(343);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(344);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 13400297963520L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(345);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(5);
						 ((ExpressionContext)_localctx).ast =  new Relacional(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).op, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(348);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(349);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__43 || _la==T__44) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(350);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(4);
						 ((ExpressionContext)_localctx).ast =  new BooleanExp(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).op, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(353);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(354);
						match(T__45);
						setState(355);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(3);
						 ((ExpressionContext)_localctx).ast =  new BooleanExp(((ExpressionContext)_localctx).e1.ast, "and", ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(358);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(359);
						match(T__46);
						setState(360);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(2);
						 ((ExpressionContext)_localctx).ast =  new BooleanExp(((ExpressionContext)_localctx).e1.ast, "or", ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(363);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(364);
						match(T__29);
						setState(365);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(366);
						match(T__30);
						 ((ExpressionContext)_localctx).ast =  new ArrayAcces(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(369);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(370);
						match(T__31);
						setState(371);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						 ((ExpressionContext)_localctx).ast =  new StructFieldAcces(((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).IDENT); 
						}
						break;
					}
					} 
				}
				setState(377);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<Expression> lista = new ArrayList<Expression>();
		public ExpressionContext first;
		public ExpressionContext next;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			((ExpressionListContext)_localctx).first = expression(0);
			 _localctx.lista.add(((ExpressionListContext)_localctx).first.ast); 
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(380);
				match(T__6);
				setState(381);
				((ExpressionListContext)_localctx).next = expression(0);
				 _localctx.lista.add(((ExpressionListContext)_localctx).next.ast); 
				}
				}
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token ni;
		public Token nd;
		public Token nc;
		public Token name;
		public Token INT_LITERAL;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode INT_LITERAL() { return getToken(GrammarParser.INT_LITERAL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		try {
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__47:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				((TypeContext)_localctx).ni = match(T__47);
				((TypeContext)_localctx).ast = new IntType(((TypeContext)_localctx).ni);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				((TypeContext)_localctx).nd = match(T__48);
				((TypeContext)_localctx).ast = new DoubleType(((TypeContext)_localctx).nd);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				((TypeContext)_localctx).nc = match(T__49);
				((TypeContext)_localctx).ast = new CharacterType(((TypeContext)_localctx).nc);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(395);
				((TypeContext)_localctx).name = match(IDENT);
				((TypeContext)_localctx).ast = new IdentType(((TypeContext)_localctx).name);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 5);
				{
				setState(397);
				match(T__29);
				setState(398);
				((TypeContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				setState(399);
				match(T__30);
				setState(400);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast = new Arraytype(((TypeContext)_localctx).INT_LITERAL,((TypeContext)_localctx).type.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u0196\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001.\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0004\u00014\b\u0001\u000b\u0001\f\u00015\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001"+
		"\u0002\u0003\u0002@\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003H\b\u0003\n\u0003\f\u0003K\t"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004S\b\u0004\n\u0004\f\u0004V\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005_\b\u0005\n\u0005\f\u0005b\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006o\b\u0006\n\u0006\f\u0006r\t"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0004\b\u0081\b\b\u000b\b\f\b\u0082\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u008d\b\t\u0001\t\u0001\t\u0003"+
		"\t\u0091\b\t\u0001\t\u0001\t\u0003\t\u0095\b\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0005\t\u009b\b\t\n\t\f\t\u009e\t\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a9\b\n\n\n\f\n\u00ac"+
		"\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00b9\b\f\n\f\f\f\u00bc"+
		"\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00c8\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ce"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d4\b\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00dc\b\r\n\r\f\r\u00df\t\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e8\b\r\n"+
		"\r\f\r\u00eb\t\r\u0001\r\u0001\r\u0005\r\u00ef\b\r\n\r\f\r\u00f2\t\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00f9\b\r\n\r\f\r\u00fc\t\r"+
		"\u0003\r\u00fe\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0104\b\r\n"+
		"\r\f\r\u0107\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u010e"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0115\b\r\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u011a\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0120\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u0132\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u014c\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0176\b\u000f\n\u000f"+
		"\f\u000f\u0179\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u0181\b\u0010\n\u0010\f\u0010\u0184"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0194\b\u0011\u0001\u0011\u0000"+
		"\u0001\u001e\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"\u0000\u0004\u0001\u0000&(\u0002\u0000"+
		"!!))\u0002\u0000$%*+\u0001\u0000,-\u01bc\u0000$\u0001\u0000\u0000\u0000"+
		"\u0002)\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006C"+
		"\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000\nY\u0001\u0000\u0000"+
		"\u0000\fh\u0001\u0000\u0000\u0000\u000ev\u0001\u0000\u0000\u0000\u0010"+
		"|\u0001\u0000\u0000\u0000\u0012\u0086\u0001\u0000\u0000\u0000\u0014\u00a2"+
		"\u0001\u0000\u0000\u0000\u0016\u00af\u0001\u0000\u0000\u0000\u0018\u00b4"+
		"\u0001\u0000\u0000\u0000\u001a\u0119\u0001\u0000\u0000\u0000\u001c\u011b"+
		"\u0001\u0000\u0000\u0000\u001e\u014b\u0001\u0000\u0000\u0000 \u017a\u0001"+
		"\u0000\u0000\u0000\"\u0193\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001"+
		"\u0000%&\u0003\u001c\u000e\u0000&\'\u0005\u0000\u0000\u0001\'(\u0006\u0000"+
		"\uffff\uffff\u0000(\u0001\u0001\u0000\u0000\u0000)*\u0005\u0001\u0000"+
		"\u0000*+\u00059\u0000\u0000+-\u0005\u0002\u0000\u0000,.\u0003\u0004\u0002"+
		"\u0000-,\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/3\u0003\u0010\b\u000001\u0003\u0012\t\u000012\u0006\u0001"+
		"\uffff\uffff\u000024\u0001\u0000\u0000\u000030\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000078\u0005\u0003\u0000\u000089\u0006\u0001"+
		"\uffff\uffff\u00009\u0003\u0001\u0000\u0000\u0000:<\u0005\u0004\u0000"+
		"\u0000;=\u0003\u0006\u0003\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=?\u0001\u0000\u0000\u0000>@\u0003\b\u0004\u0000?>\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0006"+
		"\u0002\uffff\uffff\u0000B\u0005\u0001\u0000\u0000\u0000CI\u0005\u0005"+
		"\u0000\u0000DE\u0003\f\u0006\u0000EF\u0006\u0003\uffff\uffff\u0000FH\u0001"+
		"\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000LM\u0006\u0003\uffff\uffff\u0000M\u0007"+
		"\u0001\u0000\u0000\u0000NT\u0005\u0006\u0000\u0000OP\u0003\n\u0005\u0000"+
		"PQ\u0006\u0004\uffff\uffff\u0000QS\u0001\u0000\u0000\u0000RO\u0001\u0000"+
		"\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000"+
		"WX\u0006\u0004\uffff\uffff\u0000X\t\u0001\u0000\u0000\u0000YZ\u00059\u0000"+
		"\u0000Z`\u0006\u0005\uffff\uffff\u0000[\\\u0005\u0007\u0000\u0000\\]\u0005"+
		"9\u0000\u0000]_\u0006\u0005\uffff\uffff\u0000^[\u0001\u0000\u0000\u0000"+
		"_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000ac\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0005\b\u0000"+
		"\u0000de\u0003\"\u0011\u0000ef\u0005\u0002\u0000\u0000fg\u0006\u0005\uffff"+
		"\uffff\u0000g\u000b\u0001\u0000\u0000\u0000hi\u0005\t\u0000\u0000ij\u0005"+
		"9\u0000\u0000jp\u0005\n\u0000\u0000kl\u0003\u000e\u0007\u0000lm\u0006"+
		"\u0006\uffff\uffff\u0000mo\u0001\u0000\u0000\u0000nk\u0001\u0000\u0000"+
		"\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0005"+
		"\u0003\u0000\u0000tu\u0006\u0006\uffff\uffff\u0000u\r\u0001\u0000\u0000"+
		"\u0000vw\u00059\u0000\u0000wx\u0005\b\u0000\u0000xy\u0003\"\u0011\u0000"+
		"yz\u0005\u0002\u0000\u0000z{\u0006\u0007\uffff\uffff\u0000{\u000f\u0001"+
		"\u0000\u0000\u0000|\u0080\u0005\u000b\u0000\u0000}~\u00059\u0000\u0000"+
		"~\u007f\u0006\b\uffff\uffff\u0000\u007f\u0081\u0005\u0002\u0000\u0000"+
		"\u0080}\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0006\b\uffff\uffff\u0000\u0085"+
		"\u0011\u0001\u0000\u0000\u0000\u0086\u0087\u0005\f\u0000\u0000\u0087\u008c"+
		"\u00059\u0000\u0000\u0088\u0089\u0005\r\u0000\u0000\u0089\u008a\u0003"+
		"\u0014\n\u0000\u008a\u008b\u0005\u000e\u0000\u0000\u008b\u008d\u0001\u0000"+
		"\u0000\u0000\u008c\u0088\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008f\u0005\b\u0000"+
		"\u0000\u008f\u0091\u0003\"\u0011\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0094\u0005\u000f\u0000\u0000\u0093\u0095\u0003\u0018\f\u0000\u0094"+
		"\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u009c\u0005\u0010\u0000\u0000\u0097"+
		"\u0098\u0003\u001a\r\u0000\u0098\u0099\u0006\t\uffff\uffff\u0000\u0099"+
		"\u009b\u0001\u0000\u0000\u0000\u009a\u0097\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0003\u0000\u0000\u00a0"+
		"\u00a1\u0006\t\uffff\uffff\u0000\u00a1\u0013\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0003\u0016\u000b\u0000\u00a3\u00aa\u0006\n\uffff\uffff\u0000\u00a4"+
		"\u00a5\u0005\u0007\u0000\u0000\u00a5\u00a6\u0003\u0016\u000b\u0000\u00a6"+
		"\u00a7\u0006\n\uffff\uffff\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0006\n\uffff\uffff\u0000\u00ae\u0015\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u00059\u0000\u0000\u00b0\u00b1\u0005\b\u0000\u0000\u00b1\u00b2"+
		"\u0003\"\u0011\u0000\u00b2\u00b3\u0006\u000b\uffff\uffff\u0000\u00b3\u0017"+
		"\u0001\u0000\u0000\u0000\u00b4\u00ba\u0005\u0011\u0000\u0000\u00b5\u00b6"+
		"\u0003\n\u0005\u0000\u00b6\u00b7\u0006\f\uffff\uffff\u0000\u00b7\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000\u0000\u00b9\u00bc"+
		"\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0006\f\uffff\uffff\u0000\u00be\u0019"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003\u001e\u000f\u0000\u00c0\u00c1"+
		"\u0005\u0012\u0000\u0000\u00c1\u00c2\u0003\u001e\u000f\u0000\u00c2\u00c3"+
		"\u0005\u0002\u0000\u0000\u00c3\u00c4\u0006\r\uffff\uffff\u0000\u00c4\u011a"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c7\u0005\u0013\u0000\u0000\u00c6\u00c8"+
		"\u0003 \u0010\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005"+
		"\u0002\u0000\u0000\u00ca\u011a\u0006\r\uffff\uffff\u0000\u00cb\u00cd\u0005"+
		"\u0014\u0000\u0000\u00cc\u00ce\u0003 \u0010\u0000\u00cd\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0005\u0002\u0000\u0000\u00d0\u011a\u0006\r\uffff"+
		"\uffff\u0000\u00d1\u00d3\u0005\u0015\u0000\u0000\u00d2\u00d4\u0003 \u0010"+
		"\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u0002\u0000"+
		"\u0000\u00d6\u011a\u0006\r\uffff\uffff\u0000\u00d7\u00d8\u0005\u0016\u0000"+
		"\u0000\u00d8\u00d9\u0003\u001e\u000f\u0000\u00d9\u00dd\u0005\u0017\u0000"+
		"\u0000\u00da\u00dc\u0003\u001a\r\u0000\u00db\u00da\u0001\u0000\u0000\u0000"+
		"\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000"+
		"\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u0003\u0000\u0000"+
		"\u00e1\u00e2\u0006\r\uffff\uffff\u0000\u00e2\u011a\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0005\u0016\u0000\u0000\u00e4\u00e5\u0003\u001e\u000f\u0000"+
		"\u00e5\u00e9\u0005\u0017\u0000\u0000\u00e6\u00e8\u0003\u001a\r\u0000\u00e7"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ec\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec"+
		"\u00f0\u0005\u0018\u0000\u0000\u00ed\u00ef\u0003\u001a\r\u0000\u00ee\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0005\u0003\u0000\u0000\u00f4\u00f5\u0006\r\uffff\uffff\u0000\u00f5\u011a"+
		"\u0001\u0000\u0000\u0000\u00f6\u00fa\u0005\u0019\u0000\u0000\u00f7\u00f9"+
		"\u0003\u001a\r\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fd\u00f6\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0005"+
		"\u001a\u0000\u0000\u0100\u0101\u0003\u001e\u000f\u0000\u0101\u0105\u0005"+
		"\u001b\u0000\u0000\u0102\u0104\u0003\u001a\r\u0000\u0103\u0102\u0001\u0000"+
		"\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000"+
		"\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0108\u0001\u0000"+
		"\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u0003"+
		"\u0000\u0000\u0109\u010a\u0006\r\uffff\uffff\u0000\u010a\u011a\u0001\u0000"+
		"\u0000\u0000\u010b\u010d\u0005\u001c\u0000\u0000\u010c\u010e\u0003\u001e"+
		"\u000f\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u0002"+
		"\u0000\u0000\u0110\u011a\u0006\r\uffff\uffff\u0000\u0111\u0112\u00059"+
		"\u0000\u0000\u0112\u0114\u0005\r\u0000\u0000\u0113\u0115\u0003 \u0010"+
		"\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000"+
		"\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0005\u000e\u0000"+
		"\u0000\u0117\u0118\u0005\u0002\u0000\u0000\u0118\u011a\u0006\r\uffff\uffff"+
		"\u0000\u0119\u00bf\u0001\u0000\u0000\u0000\u0119\u00c5\u0001\u0000\u0000"+
		"\u0000\u0119\u00cb\u0001\u0000\u0000\u0000\u0119\u00d1\u0001\u0000\u0000"+
		"\u0000\u0119\u00d7\u0001\u0000\u0000\u0000\u0119\u00e3\u0001\u0000\u0000"+
		"\u0000\u0119\u00fd\u0001\u0000\u0000\u0000\u0119\u010b\u0001\u0000\u0000"+
		"\u0000\u0119\u0111\u0001\u0000\u0000\u0000\u011a\u001b\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0005\u001d\u0000\u0000\u011c\u011d\u00059\u0000\u0000"+
		"\u011d\u011f\u0005\r\u0000\u0000\u011e\u0120\u0003 \u0010\u0000\u011f"+
		"\u011e\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u000e\u0000\u0000\u0122"+
		"\u0123\u0005\u0002\u0000\u0000\u0123\u0124\u0006\u000e\uffff\uffff\u0000"+
		"\u0124\u001d\u0001\u0000\u0000\u0000\u0125\u0126\u0006\u000f\uffff\uffff"+
		"\u0000\u0126\u0127\u00053\u0000\u0000\u0127\u014c\u0006\u000f\uffff\uffff"+
		"\u0000\u0128\u0129\u00057\u0000\u0000\u0129\u014c\u0006\u000f\uffff\uffff"+
		"\u0000\u012a\u012b\u00058\u0000\u0000\u012b\u014c\u0006\u000f\uffff\uffff"+
		"\u0000\u012c\u012d\u00059\u0000\u0000\u012d\u014c\u0006\u000f\uffff\uffff"+
		"\u0000\u012e\u012f\u00059\u0000\u0000\u012f\u0131\u0005\r\u0000\u0000"+
		"\u0130\u0132\u0003 \u0010\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133"+
		"\u0134\u0005\u000e\u0000\u0000\u0134\u014c\u0006\u000f\uffff\uffff\u0000"+
		"\u0135\u0136\u0005!\u0000\u0000\u0136\u0137\u0003\u001e\u000f\n\u0137"+
		"\u0138\u0006\u000f\uffff\uffff\u0000\u0138\u014c\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0005\"\u0000\u0000\u013a\u013b\u0003\u001e\u000f\t\u013b"+
		"\u013c\u0006\u000f\uffff\uffff\u0000\u013c\u014c\u0001\u0000\u0000\u0000"+
		"\u013d\u013e\u0005#\u0000\u0000\u013e\u013f\u0005$\u0000\u0000\u013f\u0140"+
		"\u0003\"\u0011\u0000\u0140\u0141\u0005%\u0000\u0000\u0141\u0142\u0005"+
		"\r\u0000\u0000\u0142\u0143\u0003\u001e\u000f\u0000\u0143\u0144\u0005\u000e"+
		"\u0000\u0000\u0144\u0145\u0006\u000f\uffff\uffff\u0000\u0145\u014c\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0005\r\u0000\u0000\u0147\u0148\u0003\u001e"+
		"\u000f\u0000\u0148\u0149\u0005\u000e\u0000\u0000\u0149\u014a\u0006\u000f"+
		"\uffff\uffff\u0000\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0125\u0001"+
		"\u0000\u0000\u0000\u014b\u0128\u0001\u0000\u0000\u0000\u014b\u012a\u0001"+
		"\u0000\u0000\u0000\u014b\u012c\u0001\u0000\u0000\u0000\u014b\u012e\u0001"+
		"\u0000\u0000\u0000\u014b\u0135\u0001\u0000\u0000\u0000\u014b\u0139\u0001"+
		"\u0000\u0000\u0000\u014b\u013d\u0001\u0000\u0000\u0000\u014b\u0146\u0001"+
		"\u0000\u0000\u0000\u014c\u0177\u0001\u0000\u0000\u0000\u014d\u014e\n\u0006"+
		"\u0000\u0000\u014e\u014f\u0007\u0000\u0000\u0000\u014f\u0150\u0003\u001e"+
		"\u000f\u0007\u0150\u0151\u0006\u000f\uffff\uffff\u0000\u0151\u0176\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\n\u0005\u0000\u0000\u0153\u0154\u0007\u0001"+
		"\u0000\u0000\u0154\u0155\u0003\u001e\u000f\u0006\u0155\u0156\u0006\u000f"+
		"\uffff\uffff\u0000\u0156\u0176\u0001\u0000\u0000\u0000\u0157\u0158\n\u0004"+
		"\u0000\u0000\u0158\u0159\u0007\u0002\u0000\u0000\u0159\u015a\u0003\u001e"+
		"\u000f\u0005\u015a\u015b\u0006\u000f\uffff\uffff\u0000\u015b\u0176\u0001"+
		"\u0000\u0000\u0000\u015c\u015d\n\u0003\u0000\u0000\u015d\u015e\u0007\u0003"+
		"\u0000\u0000\u015e\u015f\u0003\u001e\u000f\u0004\u015f\u0160\u0006\u000f"+
		"\uffff\uffff\u0000\u0160\u0176\u0001\u0000\u0000\u0000\u0161\u0162\n\u0002"+
		"\u0000\u0000\u0162\u0163\u0005.\u0000\u0000\u0163\u0164\u0003\u001e\u000f"+
		"\u0003\u0164\u0165\u0006\u000f\uffff\uffff\u0000\u0165\u0176\u0001\u0000"+
		"\u0000\u0000\u0166\u0167\n\u0001\u0000\u0000\u0167\u0168\u0005/\u0000"+
		"\u0000\u0168\u0169\u0003\u001e\u000f\u0002\u0169\u016a\u0006\u000f\uffff"+
		"\uffff\u0000\u016a\u0176\u0001\u0000\u0000\u0000\u016b\u016c\n\f\u0000"+
		"\u0000\u016c\u016d\u0005\u001e\u0000\u0000\u016d\u016e\u0003\u001e\u000f"+
		"\u0000\u016e\u016f\u0005\u001f\u0000\u0000\u016f\u0170\u0006\u000f\uffff"+
		"\uffff\u0000\u0170\u0176\u0001\u0000\u0000\u0000\u0171\u0172\n\u000b\u0000"+
		"\u0000\u0172\u0173\u0005 \u0000\u0000\u0173\u0174\u00059\u0000\u0000\u0174"+
		"\u0176\u0006\u000f\uffff\uffff\u0000\u0175\u014d\u0001\u0000\u0000\u0000"+
		"\u0175\u0152\u0001\u0000\u0000\u0000\u0175\u0157\u0001\u0000\u0000\u0000"+
		"\u0175\u015c\u0001\u0000\u0000\u0000\u0175\u0161\u0001\u0000\u0000\u0000"+
		"\u0175\u0166\u0001\u0000\u0000\u0000\u0175\u016b\u0001\u0000\u0000\u0000"+
		"\u0175\u0171\u0001\u0000\u0000\u0000\u0176\u0179\u0001\u0000\u0000\u0000"+
		"\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000"+
		"\u0178\u001f\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000"+
		"\u017a\u017b\u0003\u001e\u000f\u0000\u017b\u0182\u0006\u0010\uffff\uffff"+
		"\u0000\u017c\u017d\u0005\u0007\u0000\u0000\u017d\u017e\u0003\u001e\u000f"+
		"\u0000\u017e\u017f\u0006\u0010\uffff\uffff\u0000\u017f\u0181\u0001\u0000"+
		"\u0000\u0000\u0180\u017c\u0001\u0000\u0000\u0000\u0181\u0184\u0001\u0000"+
		"\u0000\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000"+
		"\u0000\u0000\u0183!\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000"+
		"\u0000\u0185\u0186\u00050\u0000\u0000\u0186\u0194\u0006\u0011\uffff\uffff"+
		"\u0000\u0187\u0188\u00051\u0000\u0000\u0188\u0194\u0006\u0011\uffff\uffff"+
		"\u0000\u0189\u018a\u00052\u0000\u0000\u018a\u0194\u0006\u0011\uffff\uffff"+
		"\u0000\u018b\u018c\u00059\u0000\u0000\u018c\u0194\u0006\u0011\uffff\uffff"+
		"\u0000\u018d\u018e\u0005\u001e\u0000\u0000\u018e\u018f\u00053\u0000\u0000"+
		"\u018f\u0190\u0005\u001f\u0000\u0000\u0190\u0191\u0003\"\u0011\u0000\u0191"+
		"\u0192\u0006\u0011\uffff\uffff\u0000\u0192\u0194\u0001\u0000\u0000\u0000"+
		"\u0193\u0185\u0001\u0000\u0000\u0000\u0193\u0187\u0001\u0000\u0000\u0000"+
		"\u0193\u0189\u0001\u0000\u0000\u0000\u0193\u018b\u0001\u0000\u0000\u0000"+
		"\u0193\u018d\u0001\u0000\u0000\u0000\u0194#\u0001\u0000\u0000\u0000\""+
		"-5<?IT`p\u0082\u008c\u0090\u0094\u009c\u00aa\u00ba\u00c7\u00cd\u00d3\u00dd"+
		"\u00e9\u00f0\u00fa\u00fd\u0105\u010d\u0114\u0119\u011f\u0131\u014b\u0175"+
		"\u0177\u0182\u0193";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}