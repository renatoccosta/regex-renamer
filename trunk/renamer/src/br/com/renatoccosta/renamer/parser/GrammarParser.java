// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g 2010-02-16 15:48:37

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
        

    public String[] getTokenNames() { return GrammarParser.tokenNames; }
    public String getGrammarFileName() { return "/home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g"; }


    public StreamChangeElement root = new RootElement();
    private StreamChangeElement last = root;



    // $ANTLR start "begin"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:59:1: begin : ( expression )+ EOF ;
    public final void begin() throws RecognitionException {
        Element expression1 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:59:7: ( ( expression )+ EOF )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:60:2: ( expression )+ EOF
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:60:2: ( expression )+
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
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:60:3: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_begin75);
            	    expression1=expression();

            	    state._fsp--;


            	    		if (expression1 != null) {
            	    			try {
            	    				last = last.add(expression1);
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

            match(input,EOF,FOLLOW_EOF_in_begin82); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "begin"


    // $ANTLR start "expression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:71:1: expression returns [Element elm] : ( literalExpression | variableExpression ) ;
    public final Element expression() throws RecognitionException {
        Element elm = null;

        Element literalExpression2 = null;

        Element variableExpression3 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:72:2: ( ( literalExpression | variableExpression ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:73:2: ( literalExpression | variableExpression )
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:73:2: ( literalExpression | variableExpression )
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
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:74:2: literalExpression
                    {
                    pushFollow(FOLLOW_literalExpression_in_expression100);
                    literalExpression2=literalExpression();

                    state._fsp--;

                     elm = literalExpression2; 

                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:76:2: variableExpression
                    {
                    pushFollow(FOLLOW_variableExpression_in_expression109);
                    variableExpression3=variableExpression();

                    state._fsp--;

                     elm = variableExpression3; 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return elm;
    }
    // $ANTLR end "expression"


    // $ANTLR start "literalExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:79:1: literalExpression returns [Element elm] : literal ;
    public final Element literalExpression() throws RecognitionException {
        Element elm = null;

        GrammarParser.literal_return literal4 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:80:2: ( literal )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:81:2: literal
            {
            pushFollow(FOLLOW_literal_in_literalExpression131);
            literal4=literal();

            state._fsp--;


            		elm = new LiteralElement((literal4!=null?input.toString(literal4.start,literal4.stop):null));
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return elm;
    }
    // $ANTLR end "literalExpression"


    // $ANTLR start "variableExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:85:1: variableExpression returns [Element elm] : DOLLAR ( NUMBERS | group ) ;
    public final Element variableExpression() throws RecognitionException {
        Element elm = null;

        Token NUMBERS5=null;
        Element group6 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:86:2: ( DOLLAR ( NUMBERS | group ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:87:2: DOLLAR ( NUMBERS | group )
            {
            match(input,DOLLAR,FOLLOW_DOLLAR_in_variableExpression151); 
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:88:2: ( NUMBERS | group )
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
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:89:2: NUMBERS
                    {
                    NUMBERS5=(Token)match(input,NUMBERS,FOLLOW_NUMBERS_in_variableExpression158); 

                    		elm = new CaptureGroupElement(Integer.parseInt((NUMBERS5!=null?NUMBERS5.getText():null)));
                    	

                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:92:2: group
                    {
                    pushFollow(FOLLOW_group_in_variableExpression166);
                    group6=group();

                    state._fsp--;


                    		elm = group6;
                    	

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return elm;
    }
    // $ANTLR end "variableExpression"


    // $ANTLR start "group"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:96:1: group returns [Element elem] : OPEN_BRACKET content CLOSE_BRACKET ;
    public final Element group() throws RecognitionException {
        Element elem = null;

        GrammarParser.content_return content7 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:97:2: ( OPEN_BRACKET content CLOSE_BRACKET )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:98:2: OPEN_BRACKET content CLOSE_BRACKET
            {
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_group185); 
            pushFollow(FOLLOW_content_in_group187);
            content7=content();

            state._fsp--;

            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_group189); 

            		elem = (content7!=null?content7.elem:null);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return elem;
    }
    // $ANTLR end "group"

    public static class content_return extends ParserRuleReturnScope {
        public Element elem;
    };

    // $ANTLR start "content"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:102:1: content returns [Element elem] : ( closeContent | expressionContent ) ;
    public final GrammarParser.content_return content() throws RecognitionException {
        GrammarParser.content_return retval = new GrammarParser.content_return();
        retval.start = input.LT(1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:103:2: ( ( closeContent | expressionContent ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:104:2: ( closeContent | expressionContent )
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:104:2: ( closeContent | expressionContent )
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
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:104:4: closeContent
                    {
                    pushFollow(FOLLOW_closeContent_in_content208);
                    closeContent();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:106:2: expressionContent
                    {
                    pushFollow(FOLLOW_expressionContent_in_content216);
                    expressionContent();

                    state._fsp--;


                    		try {
                    			retval.elem = ElementFactory.compile(input.toString(retval.start,input.LT(-1)));
                    		} catch (ElementNotFoundException ex) {
                    			throw new RenamerSemanticException(input, ex);
                    		}
                    	

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "content"


    // $ANTLR start "closeContent"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:114:1: closeContent : SLASH LETTERS ;
    public final void closeContent() throws RecognitionException {
        Token LETTERS8=null;

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:115:2: ( SLASH LETTERS )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:116:2: SLASH LETTERS
            {
            match(input,SLASH,FOLLOW_SLASH_in_closeContent231); 
            LETTERS8=(Token)match(input,LETTERS,FOLLOW_LETTERS_in_closeContent233); 

            		try {
            			last.close((LETTERS8!=null?LETTERS8.getText():null));
            		} catch (ElementException ex) {
            			throw new RenamerSemanticException(input, ex);
            		}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "closeContent"


    // $ANTLR start "expressionContent"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:124:1: expressionContent returns [Element elem] : function parameters ;
    public final Element expressionContent() throws RecognitionException {
        Element elem = null;

        GrammarParser.function_return function9 = null;

        String[] parameters10 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:125:2: ( function parameters )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:126:2: function parameters
            {
            pushFollow(FOLLOW_function_in_expressionContent249);
            function9=function();

            state._fsp--;


            		try {
            			elem = ElementFactory.compile((function9!=null?input.toString(function9.start,function9.stop):null));
            		} catch (ElementNotFoundException ex) {
            			throw new RenamerSemanticException(input, ex);
            		}
            	
            pushFollow(FOLLOW_parameters_in_expressionContent254);
            parameters10=parameters();

            state._fsp--;


            		elem.setParameters(parameters10);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return elem;
    }
    // $ANTLR end "expressionContent"

    public static class function_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "function"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:137:1: function : LETTERS ;
    public final GrammarParser.function_return function() throws RecognitionException {
        GrammarParser.function_return retval = new GrammarParser.function_return();
        retval.start = input.LT(1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:137:9: ( LETTERS )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:138:2: LETTERS
            {
            match(input,LETTERS,FOLLOW_LETTERS_in_function264); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"


    // $ANTLR start "parameters"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:141:1: parameters returns [String[] params] : ( COLON literal )* ;
    public final String[] parameters() throws RecognitionException {
        String[] params = null;

        GrammarParser.literal_return literal11 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:142:2: ( ( COLON literal )* )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:143:2: ( COLON literal )*
            {

            		List lstParam = new ArrayList();
            	
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:146:2: ( COLON literal )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COLON) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:146:4: COLON literal
            	    {
            	    match(input,COLON,FOLLOW_COLON_in_parameters288); 
            	    pushFollow(FOLLOW_literal_in_parameters292);
            	    literal11=literal();

            	    state._fsp--;


            	    		lstParam.add((literal11!=null?input.toString(literal11.start,literal11.stop):null));
            	    	

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return params;
    }
    // $ANTLR end "parameters"

    public static class literal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "literal"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:153:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final GrammarParser.literal_return literal() throws RecognitionException {
        GrammarParser.literal_return retval = new GrammarParser.literal_return();
        retval.start = input.LT(1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:153:9: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:154:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:154:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
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
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:154:6: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    match(input,ESCAPE,FOLLOW_ESCAPE_in_literal314); 
            	    if ( (input.LA(1)>=SLASH && input.LA(1)<=ANY) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:155:13: ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>=NUMBERS && input.LA(1)<=ANY) ) {
            	        input.consume();
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    // Delegated rules


 

    public static final BitSet FOLLOW_expression_in_begin75 = new BitSet(new long[]{0x0000000000003E40L});
    public static final BitSet FOLLOW_EOF_in_begin82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExpression_in_expression100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExpression_in_expression109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_literalExpression131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_variableExpression151 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_NUMBERS_in_variableExpression158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_variableExpression166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_group185 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_content_in_group187 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_group189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_closeContent_in_content208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionContent_in_content216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_closeContent231 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LETTERS_in_closeContent233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_expressionContent249 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_expressionContent254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTERS_in_function264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_parameters288 = new BitSet(new long[]{0x0000000000003E00L});
    public static final BitSet FOLLOW_literal_in_parameters292 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ESCAPE_in_literal314 = new BitSet(new long[]{0x0000000000003FF0L});
    public static final BitSet FOLLOW_set_in_literal316 = new BitSet(new long[]{0x0000000000003E02L});
    public static final BitSet FOLLOW_set_in_literal339 = new BitSet(new long[]{0x0000000000003E02L});

}