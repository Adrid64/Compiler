lexer grammar Tokenizer;


INT_LITERAL
	: [0-9]+
	;

LINE_COMMENT
	: '/*' .*? ('\n' | EOF) -> skip
	;

MULTILINE_COMMENT
	: '//*' .*? '*//' -> skip
	;
	

WHITESPACE
	: [ \t\r\n]+ -> skip
	;
REAL_CONSTANT
	: [0-9]+ '.' [0-9]+
	;
	
CHAR_CONSTANT
	: '\''~[\t\r\n]'\''
	| '\'\\n\''
	;

IDENT
	:[a-zA-Z][a-zA-Z0-9_]*
	;