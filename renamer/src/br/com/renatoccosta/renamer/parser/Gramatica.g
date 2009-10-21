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
package br.com.renatoccosta.renamer.parser;
} 

@header {
package br.com.renatoccosta.renamer.parser;

import br.com.renatoccosta.renamer.element.*;
import br.com.renatoccosta.renamer.element.base.*;
}

@members {
public Element root = new LiteralElement("");
private Element last = root;
}

inicio :
	(
	literal {
		Element elem = new LiteralElement($literal.text);
		last.setNext(elem);
		last = elem;
	} 
	| 
	grupo {
		Element elem = $grupo.elm;
		last.setNext(elem);
		last = elem;
	}
	)+ EOF;
	
grupo	returns [Element elm] :	
	MARCADOR 
	(
	NUMEROS {
		$elm = new CaptureGroupElement(Integer.parseInt($NUMERO.text));
	} | 
	subgrupo {
		$elm = $subgrupo.elem;
	} );

subgrupo returns [Element elem] :	
	ENTRA_GRUPO 
	conteudo 
	SAI_GRUPO {
		$elem = ElementFactory.compile($conteudo.text);
	};

conteudo:
	(CLOSE_ELEMENT LETRAS | LETRAS (SEPCAMPO literal)* );
	
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