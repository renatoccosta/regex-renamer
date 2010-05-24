//START: Header
tree grammar TreeGrammar;

options {
	tokenVocab=Grammar;
	ASTLabelType=CommonTree;
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
//END: Header

//START: Rules
begin	
	:	expression+ {	
			last = last.add($expression.elem);
		} EOF
	;
	catch[RecognitionException e] {
		reportError(e);
		recover(input,e);
	}
	catch[ElementException e] {
		throw new RenamerSemanticException(input, e);
	}

expression returns [Element elem] 
	:
		(	e=literalExpression 
		| 	e=variableExpression
		)	{ $elem = $e.elem; }
	; 
	
literalExpression returns [Element elem]
	:	^(LITERAL literal)	{ 
			$elem = new LiteralElement($literal.text); 
		}
	;	
	
variableExpression returns [Element elem]
	:	^(CAPT_GROUP NUMBERS)	{
			$elem = new CaptureGroupElement(Integer.parseInt($NUMBERS.text));
		}
	|	^(FUNCTION content (expression* ^(CLOSE closeContent))?)	{
			$elem = $content.elem;
		}
	;

content returns [Element elem]
	@init {
		List<String> lstParam = new ArrayList<String>();
	}
	:	^(function parameter*	{			
			if ($parameter.text != null) {
				lstParam.add($parameter.text);
			}
		}
	)	{
			$elem = ElementFactory.compile($function.text);
			$elem.setParameters(lstParam.toArray(new String[]{})); 
		}
	;
	catch[RecognitionException e] {
		reportError(e);
		recover(input,e);
	}
	catch[ElementException e] {
		throw new RenamerSemanticException(input, e);
	}
	
closeContent
	:	function	{
			last.close($function.text);
		}
	;
	catch[RecognitionException e] {
		reportError(e);
		recover(input,e);
	}
	catch[ElementException e] {
		throw new RenamerSemanticException(input, e);
	}

function
	:	LETTERS	
	;
	
parameter 
	:	literal
	;
	
literal	
	:
		(	ESCAPE ~( '\r' | '\n' )
		|	~( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\r' | '\n' )
		)+
	;
//END: Rules
