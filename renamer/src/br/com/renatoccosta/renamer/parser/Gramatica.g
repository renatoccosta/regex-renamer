grammar Gramatica;

@lexer::header{ 
package br.com.renatoccosta.renamer.parser;
} 

@header {
package br.com.renatoccosta.renamer.parser;

import br.com.renatoccosta.renamer.element.*;
}

@members {
public Element root = new LiteralElement("");
private Element last = root;
}

inicio	:
	(
	ESPACO {
		Element elem = new LiteralElement($ESPACO.text);
		last.setNext(elem);
		last = elem;
	} | 
	CARACTERE {
		Element elem = new LiteralElement($CARACTERE.text);
		last.setNext(elem);
		last = elem;
	} | 
	NUMERO {
		Element elem = new LiteralElement($NUMERO.text);
		last.setNext(elem);
		last = elem;
	} | 
	grupo {
		Element elem = $grupo.elm;
		last.setNext(elem);
		last = elem;
	} )+ EOF;
	
grupo	returns [Element elm] :	
	MARCADOR 
	(
	NUMERO {
		$elm = new CaptureGroupElement($NUMERO.text);
	} | 
	subgrupo {
		$elm = $subgrupo.elem;
	} );

subgrupo returns [Element elem] :	
	ENTRA_GRUPO 
	conteudo 
	SAI_GRUPO {
		$elem = ExpressionElementFactory.compile($conteudo.text);
	};

conteudo:
	CARACTERE ( SEPCAMPO (CARACTERE | NUMERO)+ )*;
	
CARACTERE	: ('a'..'z' | 'A'..'Z')+;
ESPACO		: ' '+;
NUMERO		: '1'..'9' '0'..'9'*;
SEPCAMPO	: ':';
MARCADOR	: '$';
ENTRA_GRUPO	: '{';
SAI_GRUPO	: '}';