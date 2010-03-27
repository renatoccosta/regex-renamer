grammar Gramatica;

tokens {
	CLOSE_ELEMENT='/';
	SEPCAMPO=':';
	MARCADOR='$';
	ENTRA_GRUPO='{';
	SAI_GRUPO='}';
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
package br.com.renatoccosta.renamer.parser;

import br.com.renatoccosta.renamer.element.*;
import br.com.renatoccosta.renamer.element.base.*;
}

@members {
public StreamChangeElement root = new RootElement();
private StreamChangeElement last = root;
}

inicio :
	(
	literal {
		Element elem = new LiteralElement($literal.text);		
		last = last.add(elem);
	} 
	| 
	grupo {
		if ($grupo.elm != null) 
			last = last.add($grupo.elm);
	}
	)+ EOF;
	
grupo	returns [Element elm] :	
	MARCADOR 
	(
	NUMEROS {
		$elm = new CaptureGroupElement(Integer.parseInt($NUMEROS.text));
	} | 
	subgrupo {
		$elm = $subgrupo.elem;
	} );

subgrupo returns [Element elem] :	
	ENTRA_GRUPO conteudo SAI_GRUPO {
		$elem = $conteudo.elem;
	};

conteudo returns [Element elem] :
	( closeElement 
	| 
	otherElement {
		$elem = ElementFactory.compile($conteudo.text);
	} );
	
closeElement
	:
	CLOSE_ELEMENT LETRAS {
		last = last.close($LETRAS.text);
	};

otherElement
	:
	LETRAS (SEPCAMPO literal)*;	
	
literal	:
	(   ESCAPE ~( '\r' | '\n' )
        |   ~( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\r' | '\n' )
        )+
	;

LETRAS
	:	('a'..'z' | 'A'..'Z')+;
NUMEROS	:	 '1'..'9' '0'..'9'*;
ESPACOS	:	' '+;
QUALQUER:	~'\n';
