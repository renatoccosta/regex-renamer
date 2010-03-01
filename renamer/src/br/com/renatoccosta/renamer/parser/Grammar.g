grammar Grammar;

tokens {
	SLASH='/';
	COLON=':';
	DOLLAR='$';
	OPEN_BRACKET='{';
	CLOSE_BRACKET='}';
	ESCAPE='\\';
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

import br.com.renatoccosta.renamer.exception.*;
import br.com.renatoccosta.renamer.element.*;
import br.com.renatoccosta.renamer.element.base.*;
}

@members {
public StreamChangeElement root = new RootElement();
public StreamChangeElement last = root;
}

begin	:
	(expression {
		if ($expression.elm != null) {
			try {
				last = last.add($expression.elm);
			} catch (InvalidElementException ex) {
				throw new RenamerSemanticException(input, ex);
			}
		}
	})+
	EOF;

expression returns [Element elm] 
	:
	(
	literalExpression { $elm = $literalExpression.elm; }
	| 
	variableExpression { $elm = $variableExpression.elm; }
	); 
	
literalExpression returns [Element elm]
	:	
	literal {
		$elm = new LiteralElement($literal.text);
	} ;	
	
variableExpression returns [Element elm] 
	:
	DOLLAR 
	(
	NUMBERS {
		$elm = new CaptureGroupElement(Integer.parseInt($NUMBERS.text));
	} | 
	group {
		$elm = $group.elem;
	} );

group returns [Element elem] 
	:
	OPEN_BRACKET content CLOSE_BRACKET {
		$elem = $content.elem;
	};

content returns [Element elem] 
	:
	( closeContent | expressionContent )
	;
	
closeContent
	:
	SLASH function {
		try {
			last.close($function.text);
		} catch (ElementException ex) {
			throw new RenamerSemanticException(input, ex);
		}
	};

expressionContent returns [Element elem]
	:
	function {
		try {
			$elem = ElementFactory.compile($function.text);
		} catch (ElementNotFoundException ex) {
			throw new RenamerSemanticException(input, ex);
		}
	}
	parameters {
		if ($parameters.params != null)
			$elem.setParameters($parameters.params);
	};

function:
	LETTERS	
	;
	
parameters returns [String[\] params]
	@init {
		List<String> lstParam = new ArrayList<String>();
	}
	@after {
		$params = lstParam.toArray(new String[]{}); 
	}
	:
	( COLON literal {
		lstParam.add($literal.text);
	} )*
	;
	
literal	:
	(   ESCAPE ~( '\r' | '\n' )
        |   ~( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\r' | '\n' )
        )+;

LETTERS	:	('a'..'z' | 'A'..'Z')+;

NUMBERS	:	 '1'..'9' '0'..'9'*;

WS	:	' '+;

ANY	:	~'\n';
