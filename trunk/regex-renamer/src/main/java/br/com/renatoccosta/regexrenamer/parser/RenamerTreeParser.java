// $ANTLR 3.3 Nov 30, 2010 12:45:30 F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g 2011-02-16 13:43:19

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
package br.com.renatoccosta.regexrenamer.parser;

import br.com.renatoccosta.regexrenamer.api.ElementException;
import br.com.renatoccosta.regexrenamer.api.element.CompositeElement;
import br.com.renatoccosta.regexrenamer.api.element.Element;
import br.com.renatoccosta.regexrenamer.element.LiteralElement;
import br.com.renatoccosta.regexrenamer.element.base.ElementFactory;
import br.com.renatoccosta.regexrenamer.element.base.RootElement;
import br.com.renatoccosta.regexrenamer.exception.RenamerSemanticException;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
public class RenamerTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TAG_START_OPEN", "TAG_END_OPEN", "TAG_CLOSE", "TAG_EMPTY_CLOSE", "ATTR_EQ", "ATTR_VALUE", "PCDATA", "LETTER", "NAMECHAR", "GENERIC_ID", "DIGIT", "WS", "ELEMENT", "ATTRIBUTE"
    };
    public static final int EOF=-1;
    public static final int TAG_START_OPEN=4;
    public static final int TAG_END_OPEN=5;
    public static final int TAG_CLOSE=6;
    public static final int TAG_EMPTY_CLOSE=7;
    public static final int ATTR_EQ=8;
    public static final int ATTR_VALUE=9;
    public static final int PCDATA=10;
    public static final int LETTER=11;
    public static final int NAMECHAR=12;
    public static final int GENERIC_ID=13;
    public static final int DIGIT=14;
    public static final int WS=15;
    public static final int ELEMENT=16;
    public static final int ATTRIBUTE=17;

    // delegates
    // delegators


        public RenamerTreeParser(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public RenamerTreeParser(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return RenamerTreeParser.tokenNames; }
    public String getGrammarFileName() { return "F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g"; }


    public CompositeElement root = new RootElement();



    // $ANTLR start "document"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:46:1: document : ( element | text= PCDATA )+ ;
    public final void document() throws RecognitionException {
        Tree text=null;
        Element element1 = null;


        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:47:2: ( ( element | text= PCDATA )+ )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:48:2: ( element | text= PCDATA )+
            {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:48:2: ( element | text= PCDATA )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ELEMENT) ) {
                    alt1=1;
                }
                else if ( (LA1_0==PCDATA) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:48:4: element
            	    {
            	    pushFollow(FOLLOW_element_in_document79);
            	    element1=element();

            	    state._fsp--;


            	    			root.add(element1);
            	    		

            	    }
            	    break;
            	case 2 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:52:4: text= PCDATA
            	    {
            	    text=(Tree)match(input,PCDATA,FOLLOW_PCDATA_in_document91); 
            	     
            	    			System.out.println((text!=null?text.getText():null)); 
            	    			root.add(new LiteralElement((text!=null?text.getText():null)));
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }

        catch (ElementException re) {
        	throw new RenamerSemanticException(input, re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "document"


    // $ANTLR start "element"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:59:1: element returns [Element elem] : ^( ELEMENT name= GENERIC_ID ( ^( ATTRIBUTE attrName= GENERIC_ID value= ATTR_VALUE ) )* (e1= element | text= PCDATA )* ) ;
    public final Element element() throws RecognitionException {
        Element elem = null;

        Tree name=null;
        Tree attrName=null;
        Tree value=null;
        Tree text=null;
        Element e1 = null;


        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:60:5: ( ^( ELEMENT name= GENERIC_ID ( ^( ATTRIBUTE attrName= GENERIC_ID value= ATTR_VALUE ) )* (e1= element | text= PCDATA )* ) )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:60:7: ^( ELEMENT name= GENERIC_ID ( ^( ATTRIBUTE attrName= GENERIC_ID value= ATTR_VALUE ) )* (e1= element | text= PCDATA )* )
            {
            match(input,ELEMENT,FOLLOW_ELEMENT_in_element120); 

            match(input, Token.DOWN, null); 
            name=(Tree)match(input,GENERIC_ID,FOLLOW_GENERIC_ID_in_element124); 
             
                        	//System.out.print("<"+(name!=null?name.getText():null)); 
                        	elem = ElementFactory.compile((name!=null?name.getText():null));
                        
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:65:13: ( ^( ATTRIBUTE attrName= GENERIC_ID value= ATTR_VALUE ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ATTRIBUTE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:65:15: ^( ATTRIBUTE attrName= GENERIC_ID value= ATTR_VALUE )
            	    {
            	    match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_element155); 

            	    match(input, Token.DOWN, null); 
            	    attrName=(Tree)match(input,GENERIC_ID,FOLLOW_GENERIC_ID_in_element159); 
            	    value=(Tree)match(input,ATTR_VALUE,FOLLOW_ATTR_VALUE_in_element163); 

            	    match(input, Token.UP, null); 
            	     
            	                    	//System.out.print(" "+(attrName!=null?attrName.getText():null)+"="+(value!=null?value.getText():null)); 
            	                    	String cleanValue = (value!=null?value.getText():null).substring(1, (value!=null?value.getText():null).length()-1);
            	                    	ElementFactory.setParameter(elem, (attrName!=null?attrName.getText():null), cleanValue);
            	                    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             
                        	//System.out.println(">"); 
                        
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:75:13: (e1= element | text= PCDATA )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ELEMENT) ) {
                    alt3=1;
                }
                else if ( (LA3_0==PCDATA) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:75:15: e1= element
            	    {
            	    pushFollow(FOLLOW_element_in_element229);
            	    e1=element();

            	    state._fsp--;


            	                		elem.add(e1);
            	                	

            	    }
            	    break;
            	case 2 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerTreeParser.g:79:15: text= PCDATA
            	    {
            	    text=(Tree)match(input,PCDATA,FOLLOW_PCDATA_in_element262); 
            	     
            	                    	//System.out.println((text!=null?text.getText():null)); 
            	                    	elem.add(new LiteralElement((text!=null?text.getText():null)));
            	                    

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             
                        	//System.out.println("</"+(name!=null?name.getText():null)+">"); 
                        

            match(input, Token.UP, null); 

            }

        }

        catch (ElementException re) {
        	throw new RenamerSemanticException(input, re);
        }
        finally {
        }
        return elem;
    }
    // $ANTLR end "element"

    // Delegated rules


 

    public static final BitSet FOLLOW_element_in_document79 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_PCDATA_in_document91 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_ELEMENT_in_element120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GENERIC_ID_in_element124 = new BitSet(new long[]{0x0000000000030408L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_element155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GENERIC_ID_in_element159 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ATTR_VALUE_in_element163 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_element_in_element229 = new BitSet(new long[]{0x0000000000010408L});
    public static final BitSet FOLLOW_PCDATA_in_element262 = new BitSet(new long[]{0x0000000000010408L});

}