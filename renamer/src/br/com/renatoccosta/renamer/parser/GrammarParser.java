// $ANTLR 3.2 Sep 23, 2009 12:02:23 G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g 2010-03-03 10:04:28

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
    public String getGrammarFileName() { return "G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g"; }


    public StreamChangeElement root = new RootElement();
    public StreamChangeElement last = root;



    // $ANTLR start "begin"
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:59:1: begin : ( expression )+ EOF ;
    public final void begin() throws RecognitionException {
        Element expression1 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:59:7: ( ( expression )+ EOF )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:60:2: ( expression )+ EOF
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:60:2: ( expression )+
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
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:60:3: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_begin74);
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

            match(input,EOF,FOLLOW_EOF_in_begin81); 

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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:71:1: expression returns [Element elm] : ( literalExpression | variableExpression ) ;
    public final Element expression() throws RecognitionException {
        Element elm = null;

        Element literalExpression2 = null;

        Element variableExpression3 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:72:2: ( ( literalExpression | variableExpression ) )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:73:2: ( literalExpression | variableExpression )
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:73:2: ( literalExpression | variableExpression )
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
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:74:2: literalExpression
                    {
                    pushFollow(FOLLOW_literalExpression_in_expression99);
                    literalExpression2=literalExpression();

                    state._fsp--;

                     elm = literalExpression2; 

                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:76:2: variableExpression
                    {
                    pushFollow(FOLLOW_variableExpression_in_expression108);
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:79:1: literalExpression returns [Element elm] : literal ;
    public final Element literalExpression() throws RecognitionException {
        Element elm = null;

        GrammarParser.literal_return literal4 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:80:2: ( literal )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:81:2: literal
            {
            pushFollow(FOLLOW_literal_in_literalExpression130);
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:85:1: variableExpression returns [Element elm] : DOLLAR ( NUMBERS | group ) ;
    public final Element variableExpression() throws RecognitionException {
        Element elm = null;

        Token NUMBERS5=null;
        Element group6 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:86:2: ( DOLLAR ( NUMBERS | group ) )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:87:2: DOLLAR ( NUMBERS | group )
            {
            match(input,DOLLAR,FOLLOW_DOLLAR_in_variableExpression150); 
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:88:2: ( NUMBERS | group )
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
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:89:2: NUMBERS
                    {
                    NUMBERS5=(Token)match(input,NUMBERS,FOLLOW_NUMBERS_in_variableExpression157); 

                    		elm = new CaptureGroupElement(Integer.parseInt((NUMBERS5!=null?NUMBERS5.getText():null)));
                    	

                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:92:2: group
                    {
                    pushFollow(FOLLOW_group_in_variableExpression165);
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:96:1: group returns [Element elem] : OPEN_BRACKET content CLOSE_BRACKET ;
    public final Element group() throws RecognitionException {
        Element elem = null;

        Element content7 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:97:2: ( OPEN_BRACKET content CLOSE_BRACKET )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:98:2: OPEN_BRACKET content CLOSE_BRACKET
            {
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_group184); 
            pushFollow(FOLLOW_content_in_group186);
            content7=content();

            state._fsp--;

            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_group188); 

            		elem = content7;
            	

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


    // $ANTLR start "content"
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:102:1: content returns [Element elem] : ( closeContent | expressionContent ) ;
    public final Element content() throws RecognitionException {
        Element elem = null;

        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:103:2: ( ( closeContent | expressionContent ) )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:104:2: ( closeContent | expressionContent )
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:104:2: ( closeContent | expressionContent )
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
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:104:4: closeContent
                    {
                    pushFollow(FOLLOW_closeContent_in_content207);
                    closeContent();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:104:19: expressionContent
                    {
                    pushFollow(FOLLOW_expressionContent_in_content211);
                    expressionContent();

                    state._fsp--;


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
        return elem;
    }
    // $ANTLR end "content"


    // $ANTLR start "closeContent"
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:107:1: closeContent : SLASH function ;
    public final void closeContent() throws RecognitionException {
        GrammarParser.function_return function8 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:108:2: ( SLASH function )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:109:2: SLASH function
            {
            match(input,SLASH,FOLLOW_SLASH_in_closeContent226); 
            pushFollow(FOLLOW_function_in_closeContent228);
            function8=function();

            state._fsp--;


            		try {
            			last.close((function8!=null?input.toString(function8.start,function8.stop):null));
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:117:1: expressionContent returns [Element elem] : function parameters ;
    public final Element expressionContent() throws RecognitionException {
        Element elem = null;

        GrammarParser.function_return function9 = null;

        String[] parameters10 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:118:2: ( function parameters )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:119:2: function parameters
            {
            pushFollow(FOLLOW_function_in_expressionContent244);
            function9=function();

            state._fsp--;


            		try {
            			elem = ElementFactory.compile((function9!=null?input.toString(function9.start,function9.stop):null));
            		} catch (ElementNotFoundException ex) {
            			throw new RenamerSemanticException(input, ex);
            		}
            	
            pushFollow(FOLLOW_parameters_in_expressionContent249);
            parameters10=parameters();

            state._fsp--;


            		if (parameters10 != null)
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:131:1: function : LETTERS ;
    public final GrammarParser.function_return function() throws RecognitionException {
        GrammarParser.function_return retval = new GrammarParser.function_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:131:9: ( LETTERS )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:132:2: LETTERS
            {
            match(input,LETTERS,FOLLOW_LETTERS_in_function259); 

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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:135:1: parameters returns [String[] params] : ( COLON literal )* ;
    public final String[] parameters() throws RecognitionException {
        String[] params = null;

        GrammarParser.literal_return literal11 = null;



        		List<String> lstParam = new ArrayList<String>();
        	
        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:142:2: ( ( COLON literal )* )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:143:2: ( COLON literal )*
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:143:2: ( COLON literal )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COLON) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:143:4: COLON literal
            	    {
            	    match(input,COLON,FOLLOW_COLON_in_parameters291); 
            	    pushFollow(FOLLOW_literal_in_parameters293);
            	    literal11=literal();

            	    state._fsp--;


            	    		String literal = (literal11!=null?input.toString(literal11.start,literal11.stop):null);
            	    		if (literal != null)
            	    			lstParam.add(literal);
            	    	

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            		params = lstParam.toArray(new String[]{}); 
            	
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:150:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final GrammarParser.literal_return literal() throws RecognitionException {
        GrammarParser.literal_return retval = new GrammarParser.literal_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:150:9: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:151:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:151:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
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
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:151:6: ESCAPE ~ ( '\\r' | '\\n' )
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
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Grammar.g:152:13: ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' )
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


 

    public static final BitSet FOLLOW_expression_in_begin74 = new BitSet(new long[]{0x0000000000003E40L});
    public static final BitSet FOLLOW_EOF_in_begin81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExpression_in_expression99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExpression_in_expression108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_literalExpression130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_variableExpression150 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_NUMBERS_in_variableExpression157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_variableExpression165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_group184 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_content_in_group186 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_group188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_closeContent_in_content207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionContent_in_content211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_closeContent226 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_function_in_closeContent228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_expressionContent244 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parameters_in_expressionContent249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTERS_in_function259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_parameters291 = new BitSet(new long[]{0x0000000000003E00L});
    public static final BitSet FOLLOW_literal_in_parameters293 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ESCAPE_in_literal314 = new BitSet(new long[]{0x0000000000003FF0L});
    public static final BitSet FOLLOW_set_in_literal316 = new BitSet(new long[]{0x0000000000003E02L});
    public static final BitSet FOLLOW_set_in_literal339 = new BitSet(new long[]{0x0000000000003E02L});

}