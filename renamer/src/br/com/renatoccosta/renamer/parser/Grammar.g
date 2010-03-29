//START: Header
grammar Grammar;

options {
	output=AST;
}

tokens {
	SLASH='/';
	COLON=':';
	DOLLAR='$';
	OPEN_BRACKET='{';
	CLOSE_BRACKET='}';
	ESCAPE='\\';
	//fake tokens to add imaginary nodes to ast
	LITERAL='LITERAL';
	FUNCTION='FUNCTION';
	CAPT_GROUP='CAPT_GROUP';
	CLOSE='CLOSE';
}

@lexer::header{
/**
 * Copyright 2009 Renato Couto da Costa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.renatoccosta.renamer.parser;
} 

@header {
/**
 * Copyright 2009 Renato Couto da Costa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.renatoccosta.renamer.parser;
}

@rulecatch {


}
//END: Header

//START: Rules
begin	
	:	expression+ EOF;

expression
	:
		(	literalExpression 
		| 	variableExpression
		)
	; 
	
literalExpression
	:	literal	->	^(LITERAL literal);	
	
variableExpression
	:	DOLLAR 
		(	NUMBERS 											->	^(CAPT_GROUP NUMBERS)
		|	OPEN_BRACKET content CLOSE_BRACKET expression*
				DOLLAR OPEN_BRACKET closeContent CLOSE_BRACKET	->	^(FUNCTION content expression* ^(CLOSE closeContent))
		|	OPEN_BRACKET content SLASH CLOSE_BRACKET 			->	^(FUNCTION content)
		)
	;

content
	:	function parameter*	->	^(function parameter*)
	;
	
closeContent
	:	SLASH! function^
	;

function
	:	LETTERS	
	;
	
parameter
	:	COLON! literal^
	;
	
literal	
	:
		(   ESCAPE ~( '\r' | '\n' )
        |   ~( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\r' | '\n' )
        )+
	;
//END: Rules

//START: Tokens
LETTERS	:	('a'..'z' | 'A'..'Z')+;

NUMBERS	:	 '1'..'9' '0'..'9'*;

WS		:	' '+;

ANY		:	~'\n';
//END: Tokens
