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
public StreamChangeElement root = new RootElement();
private StreamChangeElement last = root;
}

inicio :
	(
	literal {
		Element elem = new LiteralElement($literal.text);		
		last = last.add(elem);;
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
		last.close($LETRAS.text);
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
