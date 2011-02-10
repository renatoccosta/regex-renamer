// $ANTLR 3.3 Nov 30, 2010 12:45:30 F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g 2011-01-28 17:10:44

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class RenamerParser extends Parser {
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


        public RenamerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RenamerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return RenamerParser.tokenNames; }
    public String getGrammarFileName() { return "F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g"; }


    public static class document_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "document"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:32:1: document : ( element | PCDATA )+ ;
    public final RenamerParser.document_return document() throws RecognitionException {
        RenamerParser.document_return retval = new RenamerParser.document_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PCDATA2=null;
        RenamerParser.element_return element1 = null;


        Object PCDATA2_tree=null;

        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:32:10: ( ( element | PCDATA )+ )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:32:12: ( element | PCDATA )+
            {
            root_0 = (Object)adaptor.nil();

            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:32:12: ( element | PCDATA )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TAG_START_OPEN) ) {
                    alt1=1;
                }
                else if ( (LA1_0==PCDATA) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:32:14: element
            	    {
            	    pushFollow(FOLLOW_element_in_document62);
            	    element1=element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, element1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:32:24: PCDATA
            	    {
            	    PCDATA2=(Token)match(input,PCDATA,FOLLOW_PCDATA_in_document66); 
            	    PCDATA2_tree = (Object)adaptor.create(PCDATA2);
            	    adaptor.addChild(root_0, PCDATA2_tree);


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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "document"

    public static class element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "element"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:34:1: element : ( startTag ( element | PCDATA )* endTag | emptyElement ) ;
    public final RenamerParser.element_return element() throws RecognitionException {
        RenamerParser.element_return retval = new RenamerParser.element_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PCDATA5=null;
        RenamerParser.startTag_return startTag3 = null;

        RenamerParser.element_return element4 = null;

        RenamerParser.endTag_return endTag6 = null;

        RenamerParser.emptyElement_return emptyElement7 = null;


        Object PCDATA5_tree=null;

        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:35:5: ( ( startTag ( element | PCDATA )* endTag | emptyElement ) )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:35:7: ( startTag ( element | PCDATA )* endTag | emptyElement )
            {
            root_0 = (Object)adaptor.nil();

            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:35:7: ( startTag ( element | PCDATA )* endTag | emptyElement )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:35:9: startTag ( element | PCDATA )* endTag
                    {
                    pushFollow(FOLLOW_startTag_in_element84);
                    startTag3=startTag();

                    state._fsp--;

                    root_0 = (Object)adaptor.becomeRoot(startTag3.getTree(), root_0);
                    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:36:13: ( element | PCDATA )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==TAG_START_OPEN) ) {
                            alt2=1;
                        }
                        else if ( (LA2_0==PCDATA) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:36:15: element
                    	    {
                    	    pushFollow(FOLLOW_element_in_element101);
                    	    element4=element();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, element4.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:37:6: PCDATA
                    	    {
                    	    PCDATA5=(Token)match(input,PCDATA,FOLLOW_PCDATA_in_element108); 
                    	    PCDATA5_tree = (Object)adaptor.create(PCDATA5);
                    	    adaptor.addChild(root_0, PCDATA5_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    pushFollow(FOLLOW_endTag_in_element137);
                    endTag6=endTag();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:40:11: emptyElement
                    {
                    pushFollow(FOLLOW_emptyElement_in_element150);
                    emptyElement7=emptyElement();

                    state._fsp--;

                    adaptor.addChild(root_0, emptyElement7.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "element"

    public static class startTag_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "startTag"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:45:1: startTag : TAG_START_OPEN GENERIC_ID ( attribute )* TAG_CLOSE -> ^( ELEMENT GENERIC_ID ( attribute )* ) ;
    public final RenamerParser.startTag_return startTag() throws RecognitionException {
        RenamerParser.startTag_return retval = new RenamerParser.startTag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TAG_START_OPEN8=null;
        Token GENERIC_ID9=null;
        Token TAG_CLOSE11=null;
        RenamerParser.attribute_return attribute10 = null;


        Object TAG_START_OPEN8_tree=null;
        Object GENERIC_ID9_tree=null;
        Object TAG_CLOSE11_tree=null;
        RewriteRuleTokenStream stream_TAG_CLOSE=new RewriteRuleTokenStream(adaptor,"token TAG_CLOSE");
        RewriteRuleTokenStream stream_TAG_START_OPEN=new RewriteRuleTokenStream(adaptor,"token TAG_START_OPEN");
        RewriteRuleTokenStream stream_GENERIC_ID=new RewriteRuleTokenStream(adaptor,"token GENERIC_ID");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:46:2: ( TAG_START_OPEN GENERIC_ID ( attribute )* TAG_CLOSE -> ^( ELEMENT GENERIC_ID ( attribute )* ) )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:46:4: TAG_START_OPEN GENERIC_ID ( attribute )* TAG_CLOSE
            {
            TAG_START_OPEN8=(Token)match(input,TAG_START_OPEN,FOLLOW_TAG_START_OPEN_in_startTag184);  
            stream_TAG_START_OPEN.add(TAG_START_OPEN8);

            GENERIC_ID9=(Token)match(input,GENERIC_ID,FOLLOW_GENERIC_ID_in_startTag186);  
            stream_GENERIC_ID.add(GENERIC_ID9);

            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:46:30: ( attribute )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==GENERIC_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:46:30: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_startTag188);
            	    attribute10=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute10.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            TAG_CLOSE11=(Token)match(input,TAG_CLOSE,FOLLOW_TAG_CLOSE_in_startTag191);  
            stream_TAG_CLOSE.add(TAG_CLOSE11);



            // AST REWRITE
            // elements: GENERIC_ID, attribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 46:51: -> ^( ELEMENT GENERIC_ID ( attribute )* )
            {
                // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:46:54: ^( ELEMENT GENERIC_ID ( attribute )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                adaptor.addChild(root_1, stream_GENERIC_ID.nextNode());
                // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:46:75: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_1, stream_attribute.nextTree());

                }
                stream_attribute.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "startTag"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:49:1: attribute : GENERIC_ID ATTR_EQ ATTR_VALUE -> ^( ATTRIBUTE GENERIC_ID ATTR_VALUE ) ;
    public final RenamerParser.attribute_return attribute() throws RecognitionException {
        RenamerParser.attribute_return retval = new RenamerParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GENERIC_ID12=null;
        Token ATTR_EQ13=null;
        Token ATTR_VALUE14=null;

        Object GENERIC_ID12_tree=null;
        Object ATTR_EQ13_tree=null;
        Object ATTR_VALUE14_tree=null;
        RewriteRuleTokenStream stream_ATTR_EQ=new RewriteRuleTokenStream(adaptor,"token ATTR_EQ");
        RewriteRuleTokenStream stream_ATTR_VALUE=new RewriteRuleTokenStream(adaptor,"token ATTR_VALUE");
        RewriteRuleTokenStream stream_GENERIC_ID=new RewriteRuleTokenStream(adaptor,"token GENERIC_ID");

        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:50:2: ( GENERIC_ID ATTR_EQ ATTR_VALUE -> ^( ATTRIBUTE GENERIC_ID ATTR_VALUE ) )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:50:4: GENERIC_ID ATTR_EQ ATTR_VALUE
            {
            GENERIC_ID12=(Token)match(input,GENERIC_ID,FOLLOW_GENERIC_ID_in_attribute217);  
            stream_GENERIC_ID.add(GENERIC_ID12);

            ATTR_EQ13=(Token)match(input,ATTR_EQ,FOLLOW_ATTR_EQ_in_attribute219);  
            stream_ATTR_EQ.add(ATTR_EQ13);

            ATTR_VALUE14=(Token)match(input,ATTR_VALUE,FOLLOW_ATTR_VALUE_in_attribute221);  
            stream_ATTR_VALUE.add(ATTR_VALUE14);



            // AST REWRITE
            // elements: ATTR_VALUE, GENERIC_ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 50:34: -> ^( ATTRIBUTE GENERIC_ID ATTR_VALUE )
            {
                // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:50:37: ^( ATTRIBUTE GENERIC_ID ATTR_VALUE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTE, "ATTRIBUTE"), root_1);

                adaptor.addChild(root_1, stream_GENERIC_ID.nextNode());
                adaptor.addChild(root_1, stream_ATTR_VALUE.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attribute"

    public static class endTag_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "endTag"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:52:1: endTag : TAG_END_OPEN GENERIC_ID TAG_CLOSE ;
    public final RenamerParser.endTag_return endTag() throws RecognitionException {
        RenamerParser.endTag_return retval = new RenamerParser.endTag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TAG_END_OPEN15=null;
        Token GENERIC_ID16=null;
        Token TAG_CLOSE17=null;

        Object TAG_END_OPEN15_tree=null;
        Object GENERIC_ID16_tree=null;
        Object TAG_CLOSE17_tree=null;

        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:53:2: ( TAG_END_OPEN GENERIC_ID TAG_CLOSE )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:53:4: TAG_END_OPEN GENERIC_ID TAG_CLOSE
            {
            root_0 = (Object)adaptor.nil();

            TAG_END_OPEN15=(Token)match(input,TAG_END_OPEN,FOLLOW_TAG_END_OPEN_in_endTag243); 
            TAG_END_OPEN15_tree = (Object)adaptor.create(TAG_END_OPEN15);
            adaptor.addChild(root_0, TAG_END_OPEN15_tree);

            GENERIC_ID16=(Token)match(input,GENERIC_ID,FOLLOW_GENERIC_ID_in_endTag245); 
            GENERIC_ID16_tree = (Object)adaptor.create(GENERIC_ID16);
            adaptor.addChild(root_0, GENERIC_ID16_tree);

            TAG_CLOSE17=(Token)match(input,TAG_CLOSE,FOLLOW_TAG_CLOSE_in_endTag247); 
            TAG_CLOSE17_tree = (Object)adaptor.create(TAG_CLOSE17);
            adaptor.addChild(root_0, TAG_CLOSE17_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "endTag"

    public static class emptyElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "emptyElement"
    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:55:1: emptyElement : TAG_START_OPEN GENERIC_ID ( attribute )* TAG_EMPTY_CLOSE -> ^( ELEMENT GENERIC_ID ( attribute )* ) ;
    public final RenamerParser.emptyElement_return emptyElement() throws RecognitionException {
        RenamerParser.emptyElement_return retval = new RenamerParser.emptyElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TAG_START_OPEN18=null;
        Token GENERIC_ID19=null;
        Token TAG_EMPTY_CLOSE21=null;
        RenamerParser.attribute_return attribute20 = null;


        Object TAG_START_OPEN18_tree=null;
        Object GENERIC_ID19_tree=null;
        Object TAG_EMPTY_CLOSE21_tree=null;
        RewriteRuleTokenStream stream_TAG_EMPTY_CLOSE=new RewriteRuleTokenStream(adaptor,"token TAG_EMPTY_CLOSE");
        RewriteRuleTokenStream stream_TAG_START_OPEN=new RewriteRuleTokenStream(adaptor,"token TAG_START_OPEN");
        RewriteRuleTokenStream stream_GENERIC_ID=new RewriteRuleTokenStream(adaptor,"token GENERIC_ID");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:56:2: ( TAG_START_OPEN GENERIC_ID ( attribute )* TAG_EMPTY_CLOSE -> ^( ELEMENT GENERIC_ID ( attribute )* ) )
            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:56:4: TAG_START_OPEN GENERIC_ID ( attribute )* TAG_EMPTY_CLOSE
            {
            TAG_START_OPEN18=(Token)match(input,TAG_START_OPEN,FOLLOW_TAG_START_OPEN_in_emptyElement257);  
            stream_TAG_START_OPEN.add(TAG_START_OPEN18);

            GENERIC_ID19=(Token)match(input,GENERIC_ID,FOLLOW_GENERIC_ID_in_emptyElement259);  
            stream_GENERIC_ID.add(GENERIC_ID19);

            // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:56:30: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==GENERIC_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:56:30: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_emptyElement261);
            	    attribute20=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute20.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            TAG_EMPTY_CLOSE21=(Token)match(input,TAG_EMPTY_CLOSE,FOLLOW_TAG_EMPTY_CLOSE_in_emptyElement264);  
            stream_TAG_EMPTY_CLOSE.add(TAG_EMPTY_CLOSE21);



            // AST REWRITE
            // elements: GENERIC_ID, attribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 56:57: -> ^( ELEMENT GENERIC_ID ( attribute )* )
            {
                // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:56:60: ^( ELEMENT GENERIC_ID ( attribute )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                adaptor.addChild(root_1, stream_GENERIC_ID.nextNode());
                // F:\\Documents\\Projetos\\rr-trunk\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\RenamerParser.g:56:81: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_1, stream_attribute.nextTree());

                }
                stream_attribute.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "emptyElement"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\10\uffff";
    static final String DFA3_eofS =
        "\10\uffff";
    static final String DFA3_minS =
        "\1\4\1\15\1\6\1\10\2\uffff\1\11\1\6";
    static final String DFA3_maxS =
        "\1\4\2\15\1\10\2\uffff\1\11\1\15";
    static final String DFA3_acceptS =
        "\4\uffff\1\1\1\2\2\uffff";
    static final String DFA3_specialS =
        "\10\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1",
            "\1\2",
            "\1\4\1\5\5\uffff\1\3",
            "\1\6",
            "",
            "",
            "\1\7",
            "\1\4\1\5\5\uffff\1\3"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "35:7: ( startTag ( element | PCDATA )* endTag | emptyElement )";
        }
    }
 

    public static final BitSet FOLLOW_element_in_document62 = new BitSet(new long[]{0x0000000000000412L});
    public static final BitSet FOLLOW_PCDATA_in_document66 = new BitSet(new long[]{0x0000000000000412L});
    public static final BitSet FOLLOW_startTag_in_element84 = new BitSet(new long[]{0x0000000000000430L});
    public static final BitSet FOLLOW_element_in_element101 = new BitSet(new long[]{0x0000000000000430L});
    public static final BitSet FOLLOW_PCDATA_in_element108 = new BitSet(new long[]{0x0000000000000430L});
    public static final BitSet FOLLOW_endTag_in_element137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyElement_in_element150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_START_OPEN_in_startTag184 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_GENERIC_ID_in_startTag186 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_attribute_in_startTag188 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_TAG_CLOSE_in_startTag191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERIC_ID_in_attribute217 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ATTR_EQ_in_attribute219 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ATTR_VALUE_in_attribute221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_END_OPEN_in_endTag243 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_GENERIC_ID_in_endTag245 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TAG_CLOSE_in_endTag247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_START_OPEN_in_emptyElement257 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_GENERIC_ID_in_emptyElement259 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_attribute_in_emptyElement261 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_TAG_EMPTY_CLOSE_in_emptyElement264 = new BitSet(new long[]{0x0000000000000002L});

}