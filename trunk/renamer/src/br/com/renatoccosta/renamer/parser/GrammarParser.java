// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g 2010-02-22 00:41:39

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class GrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SLASH", "COLON", "DOLLAR", "OPEN_BRACKET", "CLOSE_BRACKET", "ESCAPE", "NUMBERS", "LETTERS", "WS", "ANY", "'\\r'", "'\\n'"
    };
    public static final int DOLLAR=6;
    public static final int COLON=5;
    public static final int OPEN_BRACKET=7;
    public static final int ANY=13;
    public static final int WS=12;
    public static final int SLASH=4;
    public static final int T__15=15;
    public static final int ESCAPE=9;
    public static final int T__14=14;
    public static final int LETTERS=11;
    public static final int EOF=-1;
    public static final int NUMBERS=10;
    public static final int CLOSE_BRACKET=8;

    // delegates
    // delegators


        public GrammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GrammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return GrammarParser.tokenNames; }
    public String getGrammarFileName() { return "/home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g"; }


    public StreamChangeElement root = new RootElement();
    public StreamChangeElement last = root;


    public static class begin_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "begin"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:63:1: begin : ( expression )+ EOF ;
    public final GrammarParser.begin_return begin() throws RecognitionException {
        GrammarParser.begin_return retval = new GrammarParser.begin_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF2=null;
        GrammarParser.expression_return expression1 = null;


        Object EOF2_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:63:7: ( ( expression )+ EOF )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:64:2: ( expression )+ EOF
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:64:2: ( expression )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DOLLAR||(LA1_0>=ESCAPE && LA1_0<=ANY)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:64:3: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_begin85);
            	    expression1=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression1.getTree());

            	    		if ((expression1!=null?expression1.elm:null) != null) {
            	    			try {
            	    				last = last.add((expression1!=null?expression1.elm:null));
            	    			} catch (InvalidElementException ex) {
            	    				throw new RenamerSemanticException(input, ex);
            	    			}
            	    		}
            	    	

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

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_begin92); 
            EOF2_tree = (Object)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


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
    // $ANTLR end "begin"

    public static class expression_return extends ParserRuleReturnScope {
        public Element elm;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:75:1: expression returns [Element elm] : ( literalExpression | variableExpression ) ;
    public final GrammarParser.expression_return expression() throws RecognitionException {
        GrammarParser.expression_return retval = new GrammarParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GrammarParser.literalExpression_return literalExpression3 = null;

        GrammarParser.variableExpression_return variableExpression4 = null;



        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:76:2: ( ( literalExpression | variableExpression ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:77:2: ( literalExpression | variableExpression )
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:77:2: ( literalExpression | variableExpression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=ESCAPE && LA2_0<=ANY)) ) {
                alt2=1;
            }
            else if ( (LA2_0==DOLLAR) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:78:2: literalExpression
                    {
                    pushFollow(FOLLOW_literalExpression_in_expression110);
                    literalExpression3=literalExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, literalExpression3.getTree());
                     retval.elm = (literalExpression3!=null?literalExpression3.elm:null); 

                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:80:2: variableExpression
                    {
                    pushFollow(FOLLOW_variableExpression_in_expression119);
                    variableExpression4=variableExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, variableExpression4.getTree());
                     retval.elm = (variableExpression4!=null?variableExpression4.elm:null); 

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
    // $ANTLR end "expression"

    public static class literalExpression_return extends ParserRuleReturnScope {
        public Element elm;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literalExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:83:1: literalExpression returns [Element elm] : literal ;
    public final GrammarParser.literalExpression_return literalExpression() throws RecognitionException {
        GrammarParser.literalExpression_return retval = new GrammarParser.literalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GrammarParser.literal_return literal5 = null;



        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:84:2: ( literal )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:85:2: literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_literal_in_literalExpression141);
            literal5=literal();

            state._fsp--;

            adaptor.addChild(root_0, literal5.getTree());

            		retval.elm = new LiteralElement((literal5!=null?input.toString(literal5.start,literal5.stop):null));
            	

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
    // $ANTLR end "literalExpression"

    public static class variableExpression_return extends ParserRuleReturnScope {
        public Element elm;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:89:1: variableExpression returns [Element elm] : DOLLAR ( NUMBERS | group ) ;
    public final GrammarParser.variableExpression_return variableExpression() throws RecognitionException {
        GrammarParser.variableExpression_return retval = new GrammarParser.variableExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOLLAR6=null;
        Token NUMBERS7=null;
        GrammarParser.group_return group8 = null;


        Object DOLLAR6_tree=null;
        Object NUMBERS7_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:90:2: ( DOLLAR ( NUMBERS | group ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:91:2: DOLLAR ( NUMBERS | group )
            {
            root_0 = (Object)adaptor.nil();

            DOLLAR6=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_variableExpression161); 
            DOLLAR6_tree = (Object)adaptor.create(DOLLAR6);
            adaptor.addChild(root_0, DOLLAR6_tree);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:92:2: ( NUMBERS | group )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NUMBERS) ) {
                alt3=1;
            }
            else if ( (LA3_0==OPEN_BRACKET) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:93:2: NUMBERS
                    {
                    NUMBERS7=(Token)match(input,NUMBERS,FOLLOW_NUMBERS_in_variableExpression168); 
                    NUMBERS7_tree = (Object)adaptor.create(NUMBERS7);
                    adaptor.addChild(root_0, NUMBERS7_tree);


                    		retval.elm = new CaptureGroupElement(Integer.parseInt((NUMBERS7!=null?NUMBERS7.getText():null)));
                    	

                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:96:2: group
                    {
                    pushFollow(FOLLOW_group_in_variableExpression176);
                    group8=group();

                    state._fsp--;

                    adaptor.addChild(root_0, group8.getTree());

                    		retval.elm = (group8!=null?group8.elem:null);
                    	

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
    // $ANTLR end "variableExpression"

    public static class group_return extends ParserRuleReturnScope {
        public Element elem;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "group"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:100:1: group returns [Element elem] : OPEN_BRACKET content CLOSE_BRACKET ;
    public final GrammarParser.group_return group() throws RecognitionException {
        GrammarParser.group_return retval = new GrammarParser.group_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OPEN_BRACKET9=null;
        Token CLOSE_BRACKET11=null;
        GrammarParser.content_return content10 = null;


        Object OPEN_BRACKET9_tree=null;
        Object CLOSE_BRACKET11_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:101:2: ( OPEN_BRACKET content CLOSE_BRACKET )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:102:2: OPEN_BRACKET content CLOSE_BRACKET
            {
            root_0 = (Object)adaptor.nil();

            OPEN_BRACKET9=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_group195); 
            OPEN_BRACKET9_tree = (Object)adaptor.create(OPEN_BRACKET9);
            adaptor.addChild(root_0, OPEN_BRACKET9_tree);

            pushFollow(FOLLOW_content_in_group197);
            content10=content();

            state._fsp--;

            adaptor.addChild(root_0, content10.getTree());
            CLOSE_BRACKET11=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_group199); 
            CLOSE_BRACKET11_tree = (Object)adaptor.create(CLOSE_BRACKET11);
            adaptor.addChild(root_0, CLOSE_BRACKET11_tree);


            		retval.elem = (content10!=null?content10.elem:null);
            	

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
    // $ANTLR end "group"

    public static class content_return extends ParserRuleReturnScope {
        public Element elem;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "content"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:106:1: content returns [Element elem] : ( closeContent | expressionContent ) ;
    public final GrammarParser.content_return content() throws RecognitionException {
        GrammarParser.content_return retval = new GrammarParser.content_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GrammarParser.closeContent_return closeContent12 = null;

        GrammarParser.expressionContent_return expressionContent13 = null;



        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:107:2: ( ( closeContent | expressionContent ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:108:2: ( closeContent | expressionContent )
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:108:2: ( closeContent | expressionContent )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==SLASH) ) {
                alt4=1;
            }
            else if ( (LA4_0==LETTERS) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:108:4: closeContent
                    {
                    pushFollow(FOLLOW_closeContent_in_content218);
                    closeContent12=closeContent();

                    state._fsp--;

                    adaptor.addChild(root_0, closeContent12.getTree());

                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:108:19: expressionContent
                    {
                    pushFollow(FOLLOW_expressionContent_in_content222);
                    expressionContent13=expressionContent();

                    state._fsp--;

                    adaptor.addChild(root_0, expressionContent13.getTree());

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
    // $ANTLR end "content"

    public static class closeContent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "closeContent"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:111:1: closeContent : SLASH function ;
    public final GrammarParser.closeContent_return closeContent() throws RecognitionException {
        GrammarParser.closeContent_return retval = new GrammarParser.closeContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH14=null;
        GrammarParser.function_return function15 = null;


        Object SLASH14_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:112:2: ( SLASH function )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:113:2: SLASH function
            {
            root_0 = (Object)adaptor.nil();

            SLASH14=(Token)match(input,SLASH,FOLLOW_SLASH_in_closeContent237); 
            SLASH14_tree = (Object)adaptor.create(SLASH14);
            adaptor.addChild(root_0, SLASH14_tree);

            pushFollow(FOLLOW_function_in_closeContent239);
            function15=function();

            state._fsp--;

            adaptor.addChild(root_0, function15.getTree());

            		try {
            			last.close((function15!=null?input.toString(function15.start,function15.stop):null));
            		} catch (ElementException ex) {
            			throw new RenamerSemanticException(input, ex);
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
    // $ANTLR end "closeContent"

    public static class expressionContent_return extends ParserRuleReturnScope {
        public Element elem;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionContent"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:121:1: expressionContent returns [Element elem] : function parameters ;
    public final GrammarParser.expressionContent_return expressionContent() throws RecognitionException {
        GrammarParser.expressionContent_return retval = new GrammarParser.expressionContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GrammarParser.function_return function16 = null;

        GrammarParser.parameters_return parameters17 = null;



        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:122:2: ( function parameters )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:123:2: function parameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_function_in_expressionContent255);
            function16=function();

            state._fsp--;

            adaptor.addChild(root_0, function16.getTree());

            		try {
            			retval.elem = ElementFactory.compile((function16!=null?input.toString(function16.start,function16.stop):null));
            		} catch (ElementNotFoundException ex) {
            			throw new RenamerSemanticException(input, ex);
            		}
            	
            pushFollow(FOLLOW_parameters_in_expressionContent260);
            parameters17=parameters();

            state._fsp--;

            adaptor.addChild(root_0, parameters17.getTree());

            		retval.elem.setParameters((parameters17!=null?parameters17.params:null));
            	

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
    // $ANTLR end "expressionContent"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:134:1: function : LETTERS ;
    public final GrammarParser.function_return function() throws RecognitionException {
        GrammarParser.function_return retval = new GrammarParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LETTERS18=null;

        Object LETTERS18_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:134:9: ( LETTERS )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:135:2: LETTERS
            {
            root_0 = (Object)adaptor.nil();

            LETTERS18=(Token)match(input,LETTERS,FOLLOW_LETTERS_in_function270); 
            LETTERS18_tree = (Object)adaptor.create(LETTERS18);
            adaptor.addChild(root_0, LETTERS18_tree);


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
    // $ANTLR end "function"

    public static class parameters_return extends ParserRuleReturnScope {
        public String[] params;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameters"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:138:1: parameters returns [String[] params] : ( COLON lstParam+= literal )* ;
    public final GrammarParser.parameters_return parameters() throws RecognitionException {
        GrammarParser.parameters_return retval = new GrammarParser.parameters_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON19=null;
        List list_lstParam=null;
        RuleReturnScope lstParam = null;
        Object COLON19_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:139:2: ( ( COLON lstParam+= literal )* )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:140:2: ( COLON lstParam+= literal )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:140:2: ( COLON lstParam+= literal )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COLON) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:140:4: COLON lstParam+= literal
            	    {
            	    COLON19=(Token)match(input,COLON,FOLLOW_COLON_in_parameters290); 
            	    COLON19_tree = (Object)adaptor.create(COLON19);
            	    adaptor.addChild(root_0, COLON19_tree);

            	    pushFollow(FOLLOW_literal_in_parameters294);
            	    lstParam=literal();

            	    state._fsp--;

            	    adaptor.addChild(root_0, lstParam.getTree());
            	    if (list_lstParam==null) list_lstParam=new ArrayList();
            	    list_lstParam.add(lstParam.getTree());


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             retval.params = (String[]) list_lstParam.toArray(new String[]{}); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException ex) {

            		reportError(ex);
            		recover(input,ex);
            	
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parameters"

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:148:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final GrammarParser.literal_return literal() throws RecognitionException {
        GrammarParser.literal_return retval = new GrammarParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ESCAPE20=null;
        Token set21=null;
        Token set22=null;

        Object ESCAPE20_tree=null;
        Object set21_tree=null;
        Object set22_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:148:9: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:149:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:149:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ESCAPE) ) {
                    alt6=1;
                }
                else if ( ((LA6_0>=NUMBERS && LA6_0<=ANY)) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:149:6: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    ESCAPE20=(Token)match(input,ESCAPE,FOLLOW_ESCAPE_in_literal323); 
            	    ESCAPE20_tree = (Object)adaptor.create(ESCAPE20);
            	    adaptor.addChild(root_0, ESCAPE20_tree);

            	    set21=(Token)input.LT(1);
            	    if ( (input.LA(1)>=SLASH && input.LA(1)<=ANY) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set21));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:150:13: ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' )
            	    {
            	    set22=(Token)input.LT(1);
            	    if ( (input.LA(1)>=NUMBERS && input.LA(1)<=ANY) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set22));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // $ANTLR end "literal"

    // Delegated rules


 

    public static final BitSet FOLLOW_expression_in_begin85 = new BitSet(new long[]{0x0000000000003E40L});
    public static final BitSet FOLLOW_EOF_in_begin92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExpression_in_expression110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExpression_in_expression119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_literalExpression141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_variableExpression161 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_NUMBERS_in_variableExpression168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_variableExpression176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_group195 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_content_in_group197 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_group199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_closeContent_in_content218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionContent_in_content222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_closeContent237 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_function_in_closeContent239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_expressionContent255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_expressionContent260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTERS_in_function270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_parameters290 = new BitSet(new long[]{0x0000000000003E00L});
    public static final BitSet FOLLOW_literal_in_parameters294 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ESCAPE_in_literal323 = new BitSet(new long[]{0x0000000000003FF0L});
    public static final BitSet FOLLOW_set_in_literal325 = new BitSet(new long[]{0x0000000000003E02L});
    public static final BitSet FOLLOW_set_in_literal348 = new BitSet(new long[]{0x0000000000003E02L});

}