grammar Gramatica;

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
private StreamChangeElement last = root;
}

expression :
	(
	literal {
		try {
			Element elem = new LiteralElement($literal.text);		
			last = last.add(elem);
		} catch (InvalidElementException ex) {
			throw new RenamerSemanticException(input, ex);
		}
	} 
	| 
	variableExpression {
		if ($variableExpression.elm != null) {
			try {
				last = last.add($variableExpression.elm);
			} catch (InvalidElementException ex) {
				throw new RenamerSemanticException(input, ex);
			}
		}
	}
	)+ EOF;
	
variableExpression returns [Element elm] :	
	DOLLAR 
	(
	NUMBERS {
		$elm = new CaptureGroupElement(Integer.parseInt($NUMBERS.text));
	} | 
	group {
		$elm = $group.elem;
	} );

group returns [Element elem] :	
	OPEN_BRACKET content CLOSE_BRACKET {
		$elem = $content.elem;
	};

content returns [Element elem] :
	( closeContent 
	| 
	expressionContent {
		try {
			$elem = ElementFactory.compile($content.text);
		} catch (ElementNotFoundException ex) {
			throw new RenamerSemanticException(input, ex);
		}
	} );
	
closeContent
	:
	SLASH LETTERS {
		try {
			last.close($LETTERS.text);
		} catch (RuntimeRenamerException ex) {
			throw new RenamerSemanticException(input, ex);
		}
	};

expressionContent
	:
	LETTERS (COLON literal)*;	
	
literal	:
	(   ESCAPE ~( '\r' | '\n' )
        |   ~( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\r' | '\n' )
        )+
	;

LETTERS
	:	('a'..'z' | 'A'..'Z')+;
NUMBERS	:	 '1'..'9' '0'..'9'*;
WS	:	' '+;
ANY:	~'\n';
