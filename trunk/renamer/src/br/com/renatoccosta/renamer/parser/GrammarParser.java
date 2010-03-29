// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g 2010-03-28 23:08:39

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

public class GrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SLASH", "COLON", "DOLLAR", "OPEN_BRACKET", "CLOSE_BRACKET", "ESCAPE", "LITERAL", "FUNCTION", "CAPT_GROUP", "CLOSE", "NUMBERS", "LETTERS", "WS", "ANY", "'\\r'", "'\\n'"
    };
    public static final int DOLLAR=6;
    public static final int FUNCTION=11;
    public static final int CAPT_GROUP=12;
    public static final int LITERAL=10;
    public static final int LETTERS=15;
    public static final int EOF=-1;
    public static final int COLON=5;
    public static final int T__19=19;
    public static final int OPEN_BRACKET=7;
    public static final int SLASH=4;
    public static final int WS=16;
    public static final int ANY=17;
    public static final int T__18=18;
    public static final int ESCAPE=9;
    public static final int CLOSE=13;
    public static final int CLOSE_BRACKET=8;
    public static final int NUMBERS=14;

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


    public static class begin_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "begin"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:67:1: begin : ( expression )+ EOF ;
    public final GrammarParser.begin_return begin() throws RecognitionException {
        GrammarParser.begin_return retval = new GrammarParser.begin_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF2=null;
        GrammarParser.expression_return expression1 = null;


        Object EOF2_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:68:2: ( ( expression )+ EOF )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:68:4: ( expression )+ EOF
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:68:4: ( expression )+
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
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:68:4: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_begin114);
            	    expression1=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression1.getTree());

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

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_begin117); 
            EOF2_tree = (Object)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }



        finally {
        }
        return retval;
    }
    // $ANTLR end "begin"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:70:1: expression : ( literalExpression | variableExpression ) ;
    public final GrammarParser.expression_return expression() throws RecognitionException {
        GrammarParser.expression_return retval = new GrammarParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GrammarParser.literalExpression_return literalExpression3 = null;

        GrammarParser.variableExpression_return variableExpression4 = null;



        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:71:2: ( ( literalExpression | variableExpression ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:72:3: ( literalExpression | variableExpression )
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:72:3: ( literalExpression | variableExpression )
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
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:72:5: literalExpression
                    {
                    pushFollow(FOLLOW_literalExpression_in_expression130);
                    literalExpression3=literalExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, literalExpression3.getTree());

                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:73:6: variableExpression
                    {
                    pushFollow(FOLLOW_variableExpression_in_expression138);
                    variableExpression4=variableExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, variableExpression4.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }



        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class literalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literalExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:77:1: literalExpression : literal -> ^( LITERAL literal ) ;
    public final GrammarParser.literalExpression_return literalExpression() throws RecognitionException {
        GrammarParser.literalExpression_return retval = new GrammarParser.literalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GrammarParser.literal_return literal5 = null;


        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:78:2: ( literal -> ^( LITERAL literal ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:78:4: literal
            {
            pushFollow(FOLLOW_literal_in_literalExpression155);
            literal5=literal();

            state._fsp--;

            stream_literal.add(literal5.getTree());


            // AST REWRITE
            // elements: literal
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 78:12: -> ^( LITERAL literal )
            {
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:78:15: ^( LITERAL literal )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LITERAL, "LITERAL"), root_1);

                adaptor.addChild(root_1, stream_literal.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }



        finally {
        }
        return retval;
    }
    // $ANTLR end "literalExpression"

    public static class variableExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:80:1: variableExpression : DOLLAR ( NUMBERS -> ^( CAPT_GROUP NUMBERS ) | OPEN_BRACKET content CLOSE_BRACKET ( expression )* DOLLAR OPEN_BRACKET closeContent CLOSE_BRACKET -> ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | OPEN_BRACKET content SLASH CLOSE_BRACKET -> ^( FUNCTION content ) ) ;
    public final GrammarParser.variableExpression_return variableExpression() throws RecognitionException {
        GrammarParser.variableExpression_return retval = new GrammarParser.variableExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOLLAR6=null;
        Token NUMBERS7=null;
        Token OPEN_BRACKET8=null;
        Token CLOSE_BRACKET10=null;
        Token DOLLAR12=null;
        Token OPEN_BRACKET13=null;
        Token CLOSE_BRACKET15=null;
        Token OPEN_BRACKET16=null;
        Token SLASH18=null;
        Token CLOSE_BRACKET19=null;
        GrammarParser.content_return content9 = null;

        GrammarParser.expression_return expression11 = null;

        GrammarParser.closeContent_return closeContent14 = null;

        GrammarParser.content_return content17 = null;


        Object DOLLAR6_tree=null;
        Object NUMBERS7_tree=null;
        Object OPEN_BRACKET8_tree=null;
        Object CLOSE_BRACKET10_tree=null;
        Object DOLLAR12_tree=null;
        Object OPEN_BRACKET13_tree=null;
        Object CLOSE_BRACKET15_tree=null;
        Object OPEN_BRACKET16_tree=null;
        Object SLASH18_tree=null;
        Object CLOSE_BRACKET19_tree=null;
        RewriteRuleTokenStream stream_DOLLAR=new RewriteRuleTokenStream(adaptor,"token DOLLAR");
        RewriteRuleTokenStream stream_OPEN_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_BRACKET");
        RewriteRuleTokenStream stream_SLASH=new RewriteRuleTokenStream(adaptor,"token SLASH");
        RewriteRuleTokenStream stream_NUMBERS=new RewriteRuleTokenStream(adaptor,"token NUMBERS");
        RewriteRuleTokenStream stream_CLOSE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSE_BRACKET");
        RewriteRuleSubtreeStream stream_content=new RewriteRuleSubtreeStream(adaptor,"rule content");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_closeContent=new RewriteRuleSubtreeStream(adaptor,"rule closeContent");
        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:81:2: ( DOLLAR ( NUMBERS -> ^( CAPT_GROUP NUMBERS ) | OPEN_BRACKET content CLOSE_BRACKET ( expression )* DOLLAR OPEN_BRACKET closeContent CLOSE_BRACKET -> ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | OPEN_BRACKET content SLASH CLOSE_BRACKET -> ^( FUNCTION content ) ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:81:4: DOLLAR ( NUMBERS -> ^( CAPT_GROUP NUMBERS ) | OPEN_BRACKET content CLOSE_BRACKET ( expression )* DOLLAR OPEN_BRACKET closeContent CLOSE_BRACKET -> ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | OPEN_BRACKET content SLASH CLOSE_BRACKET -> ^( FUNCTION content ) )
            {
            DOLLAR6=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_variableExpression174);  
            stream_DOLLAR.add(DOLLAR6);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:82:3: ( NUMBERS -> ^( CAPT_GROUP NUMBERS ) | OPEN_BRACKET content CLOSE_BRACKET ( expression )* DOLLAR OPEN_BRACKET closeContent CLOSE_BRACKET -> ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | OPEN_BRACKET content SLASH CLOSE_BRACKET -> ^( FUNCTION content ) )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:82:5: NUMBERS
                    {
                    NUMBERS7=(Token)match(input,NUMBERS,FOLLOW_NUMBERS_in_variableExpression181);  
                    stream_NUMBERS.add(NUMBERS7);



                    // AST REWRITE
                    // elements: NUMBERS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 82:24: -> ^( CAPT_GROUP NUMBERS )
                    {
                        // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:82:27: ^( CAPT_GROUP NUMBERS )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CAPT_GROUP, "CAPT_GROUP"), root_1);

                        adaptor.addChild(root_1, stream_NUMBERS.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:83:5: OPEN_BRACKET content CLOSE_BRACKET ( expression )* DOLLAR OPEN_BRACKET closeContent CLOSE_BRACKET
                    {
                    OPEN_BRACKET8=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_variableExpression206);  
                    stream_OPEN_BRACKET.add(OPEN_BRACKET8);

                    pushFollow(FOLLOW_content_in_variableExpression208);
                    content9=content();

                    state._fsp--;

                    stream_content.add(content9.getTree());
                    CLOSE_BRACKET10=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_variableExpression210);  
                    stream_CLOSE_BRACKET.add(CLOSE_BRACKET10);

                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:83:40: ( expression )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==DOLLAR) ) {
                            int LA3_1 = input.LA(2);

                            if ( (LA3_1==OPEN_BRACKET) ) {
                                int LA3_3 = input.LA(3);

                                if ( (LA3_3==LETTERS) ) {
                                    alt3=1;
                                }


                            }
                            else if ( (LA3_1==NUMBERS) ) {
                                alt3=1;
                            }


                        }
                        else if ( ((LA3_0>=ESCAPE && LA3_0<=ANY)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:83:40: expression
                    	    {
                    	    pushFollow(FOLLOW_expression_in_variableExpression212);
                    	    expression11=expression();

                    	    state._fsp--;

                    	    stream_expression.add(expression11.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    DOLLAR12=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_variableExpression219);  
                    stream_DOLLAR.add(DOLLAR12);

                    OPEN_BRACKET13=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_variableExpression221);  
                    stream_OPEN_BRACKET.add(OPEN_BRACKET13);

                    pushFollow(FOLLOW_closeContent_in_variableExpression223);
                    closeContent14=closeContent();

                    state._fsp--;

                    stream_closeContent.add(closeContent14.getTree());
                    CLOSE_BRACKET15=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_variableExpression225);  
                    stream_CLOSE_BRACKET.add(CLOSE_BRACKET15);



                    // AST REWRITE
                    // elements: closeContent, expression, content
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:52: -> ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) )
                    {
                        // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:84:55: ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_content.nextTree());
                        // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:84:74: ( expression )*
                        while ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();
                        // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:84:86: ^( CLOSE closeContent )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CLOSE, "CLOSE"), root_2);

                        adaptor.addChild(root_2, stream_closeContent.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:85:5: OPEN_BRACKET content SLASH CLOSE_BRACKET
                    {
                    OPEN_BRACKET16=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_variableExpression248);  
                    stream_OPEN_BRACKET.add(OPEN_BRACKET16);

                    pushFollow(FOLLOW_content_in_variableExpression250);
                    content17=content();

                    state._fsp--;

                    stream_content.add(content17.getTree());
                    SLASH18=(Token)match(input,SLASH,FOLLOW_SLASH_in_variableExpression252);  
                    stream_SLASH.add(SLASH18);

                    CLOSE_BRACKET19=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_variableExpression254);  
                    stream_CLOSE_BRACKET.add(CLOSE_BRACKET19);



                    // AST REWRITE
                    // elements: content
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:49: -> ^( FUNCTION content )
                    {
                        // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:85:52: ^( FUNCTION content )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_content.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }



        finally {
        }
        return retval;
    }
    // $ANTLR end "variableExpression"

    public static class content_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "content"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:89:1: content : function ( parameter )* -> ^( function ( parameter )* ) ;
    public final GrammarParser.content_return content() throws RecognitionException {
        GrammarParser.content_return retval = new GrammarParser.content_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        GrammarParser.function_return function20 = null;

        GrammarParser.parameter_return parameter21 = null;


        RewriteRuleSubtreeStream stream_parameter=new RewriteRuleSubtreeStream(adaptor,"rule parameter");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:90:2: ( function ( parameter )* -> ^( function ( parameter )* ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:90:4: function ( parameter )*
            {
            pushFollow(FOLLOW_function_in_content280);
            function20=function();

            state._fsp--;

            stream_function.add(function20.getTree());
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:90:13: ( parameter )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COLON) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:90:13: parameter
            	    {
            	    pushFollow(FOLLOW_parameter_in_content282);
            	    parameter21=parameter();

            	    state._fsp--;

            	    stream_parameter.add(parameter21.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



            // AST REWRITE
            // elements: parameter, function
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 90:24: -> ^( function ( parameter )* )
            {
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:90:27: ^( function ( parameter )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_function.nextNode(), root_1);

                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:90:38: ( parameter )*
                while ( stream_parameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameter.nextTree());

                }
                stream_parameter.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:93:1: closeContent : SLASH function ;
    public final GrammarParser.closeContent_return closeContent() throws RecognitionException {
        GrammarParser.closeContent_return retval = new GrammarParser.closeContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH22=null;
        GrammarParser.function_return function23 = null;


        Object SLASH22_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:94:2: ( SLASH function )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:94:4: SLASH function
            {
            root_0 = (Object)adaptor.nil();

            SLASH22=(Token)match(input,SLASH,FOLLOW_SLASH_in_closeContent304); 
            pushFollow(FOLLOW_function_in_closeContent307);
            function23=function();

            state._fsp--;

            root_0 = (Object)adaptor.becomeRoot(function23.getTree(), root_0);

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }



        finally {
        }
        return retval;
    }
    // $ANTLR end "closeContent"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:97:1: function : LETTERS ;
    public final GrammarParser.function_return function() throws RecognitionException {
        GrammarParser.function_return retval = new GrammarParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LETTERS24=null;

        Object LETTERS24_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:98:2: ( LETTERS )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:98:4: LETTERS
            {
            root_0 = (Object)adaptor.nil();

            LETTERS24=(Token)match(input,LETTERS,FOLLOW_LETTERS_in_function319); 
            LETTERS24_tree = (Object)adaptor.create(LETTERS24);
            adaptor.addChild(root_0, LETTERS24_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }



        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class parameter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:101:1: parameter : COLON literal ;
    public final GrammarParser.parameter_return parameter() throws RecognitionException {
        GrammarParser.parameter_return retval = new GrammarParser.parameter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON25=null;
        GrammarParser.literal_return literal26 = null;


        Object COLON25_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:102:2: ( COLON literal )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:102:4: COLON literal
            {
            root_0 = (Object)adaptor.nil();

            COLON25=(Token)match(input,COLON,FOLLOW_COLON_in_parameter332); 
            pushFollow(FOLLOW_literal_in_parameter335);
            literal26=literal();

            state._fsp--;

            root_0 = (Object)adaptor.becomeRoot(literal26.getTree(), root_0);

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }



        finally {
        }
        return retval;
    }
    // $ANTLR end "parameter"

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:105:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final GrammarParser.literal_return literal() throws RecognitionException {
        GrammarParser.literal_return retval = new GrammarParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ESCAPE27=null;
        Token set28=null;
        Token set29=null;

        Object ESCAPE27_tree=null;
        Object set28_tree=null;
        Object set29_tree=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:106:2: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:107:3: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            {
            root_0 = (Object)adaptor.nil();

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:107:3: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ESCAPE) ) {
                    alt6=1;
                }
                else if ( ((LA6_0>=LITERAL && LA6_0<=ANY)) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:107:7: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    ESCAPE27=(Token)match(input,ESCAPE,FOLLOW_ESCAPE_in_literal355); 
            	    ESCAPE27_tree = (Object)adaptor.create(ESCAPE27);
            	    adaptor.addChild(root_0, ESCAPE27_tree);

            	    set28=(Token)input.LT(1);
            	    if ( (input.LA(1)>=SLASH && input.LA(1)<=ANY) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set28));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:108:13: ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' )
            	    {
            	    set29=(Token)input.LT(1);
            	    if ( (input.LA(1)>=LITERAL && input.LA(1)<=ANY) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set29));
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



        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\12\uffff";
    static final String DFA4_eofS =
        "\12\uffff";
    static final String DFA4_minS =
        "\1\7\1\uffff\1\17\1\4\1\11\2\uffff\3\4";
    static final String DFA4_maxS =
        "\1\16\1\uffff\1\17\1\10\1\21\2\uffff\3\21";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\3\uffff\1\3\1\2\3\uffff";
    static final String DFA4_specialS =
        "\12\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\6\uffff\1\1",
            "",
            "\1\3",
            "\1\5\1\4\2\uffff\1\6",
            "\1\7\10\10",
            "",
            "",
            "\16\11",
            "\1\5\1\4\2\uffff\1\6\1\7\10\10",
            "\1\5\1\4\2\uffff\1\6\1\7\10\10"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "82:3: ( NUMBERS -> ^( CAPT_GROUP NUMBERS ) | OPEN_BRACKET content CLOSE_BRACKET ( expression )* DOLLAR OPEN_BRACKET closeContent CLOSE_BRACKET -> ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | OPEN_BRACKET content SLASH CLOSE_BRACKET -> ^( FUNCTION content ) )";
        }
    }
 

    public static final BitSet FOLLOW_expression_in_begin114 = new BitSet(new long[]{0x000000000003FE40L});
    public static final BitSet FOLLOW_EOF_in_begin117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExpression_in_expression130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExpression_in_expression138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_literalExpression155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_variableExpression174 = new BitSet(new long[]{0x0000000000004080L});
    public static final BitSet FOLLOW_NUMBERS_in_variableExpression181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_variableExpression206 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_content_in_variableExpression208 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_variableExpression210 = new BitSet(new long[]{0x000000000003FE40L});
    public static final BitSet FOLLOW_expression_in_variableExpression212 = new BitSet(new long[]{0x000000000003FE40L});
    public static final BitSet FOLLOW_DOLLAR_in_variableExpression219 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_variableExpression221 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_closeContent_in_variableExpression223 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_variableExpression225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_variableExpression248 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_content_in_variableExpression250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SLASH_in_variableExpression252 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_variableExpression254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_content280 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_parameter_in_content282 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_SLASH_in_closeContent304 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_function_in_closeContent307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTERS_in_function319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_parameter332 = new BitSet(new long[]{0x000000000003FE00L});
    public static final BitSet FOLLOW_literal_in_parameter335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCAPE_in_literal355 = new BitSet(new long[]{0x000000000003FFF0L});
    public static final BitSet FOLLOW_set_in_literal357 = new BitSet(new long[]{0x000000000003FE02L});
    public static final BitSet FOLLOW_set_in_literal380 = new BitSet(new long[]{0x000000000003FE02L});

}