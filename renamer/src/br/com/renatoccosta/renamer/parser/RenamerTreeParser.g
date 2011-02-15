tree grammar RenamerTreeParser;

options {
    tokenVocab=RenamerLexer;
    ASTLabelType = Tree;
}

tokens {
    ELEMENT;
    ATTRIBUTE;
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
 * See the License for the specific langu
 age governing permissions and
 * limitations under the License.
 */
package br.com.renatoccosta.renamer.parser;

import br.com.renatoccosta.renamer.exception.*;
import br.com.renatoccosta.renamer.element.*;
import br.com.renatoccosta.renamer.element.base.*;
}

@members {
public CompositeElement root = new RootElement();
}

@rulecatch {
catch (ElementException re) {
	throw new RenamerSemanticException(input, re);
}
}

document
	: 
	( element 
		{
			root.add($element.elem);
		}
	| text=PCDATA 
		{ 
			System.out.println($text.text); 
			root.add(new LiteralElement($text.text));
		} 
	)+ ;

element returns [Element elem]
    : ^( ELEMENT name=GENERIC_ID
            { 
            	System.out.print("<"+$name.text); 
            	$elem = ElementFactory.compile($name.text);
            }
            ( ^(ATTRIBUTE attrName=GENERIC_ID value=ATTR_VALUE)
                { 
                	System.out.print(" "+$attrName.text+"="+$value.text); 
                	ElementFactory.setParameter($elem, $attrName.text, $value.text);
                }
            )*
            { 
            	System.out.println(">"); 
            }
            ( e1=element
            	{
            		$elem.add($e1.elem);
            	}
            | text=PCDATA
                { 
                	System.out.println($text.text); 
                	$elem.add(new LiteralElement($text.text));
                }
            )*
            { 
            	System.out.println("</"+$name.text+">"); 
            }
        )
    ;
