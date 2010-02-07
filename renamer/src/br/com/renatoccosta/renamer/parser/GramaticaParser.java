// $ANTLR 3.2 Sep 23, 2009 12:02:23 G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g 2010-02-02 16:08:54

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

public class GramaticaParser extends Parser {
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


        public GramaticaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GramaticaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return GramaticaParser.tokenNames; }
    public String getGrammarFileName() { return "G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g"; }


    public StreamChangeElement root = new RootElement();
    private StreamChangeElement last = root;



    // $ANTLR start "expression"
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:59:1: expression : ( literal | variableExpression )+ EOF ;
    public final void expression() throws RecognitionException {
        GramaticaParser.literal_return literal1 = null;

        Element variableExpression2 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:59:12: ( ( literal | variableExpression )+ EOF )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:2: ( literal | variableExpression )+ EOF
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:2: ( literal | variableExpression )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=ESCAPE && LA1_0<=ANY)) ) {
                    alt1=1;
                }
                else if ( (LA1_0==DOLLAR) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:2: literal
            	    {
            	    pushFollow(FOLLOW_literal_in_expression76);
            	    literal1=literal();

            	    state._fsp--;


            	    		try {
            	    			Element elem = new LiteralElement((literal1!=null?input.toString(literal1.start,literal1.stop):null));		
            	    			last = last.add(elem);
            	    		} catch (InvalidElementException ex) {
            	    			throw new RenamerSemanticException(input, ex);
            	    		}
            	    	

            	    }
            	    break;
            	case 2 :
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:70:2: variableExpression
            	    {
            	    pushFollow(FOLLOW_variableExpression_in_expression86);
            	    variableExpression2=variableExpression();

            	    state._fsp--;


            	    		if (variableExpression2 != null) {
            	    			try {
            	    				last = last.add(variableExpression2);
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

            match(input,EOF,FOLLOW_EOF_in_expression94); 

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
    // $ANTLR end "expression"


    // $ANTLR start "variableExpression"
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:81:1: variableExpression returns [Element elm] : DOLLAR ( NUMBERS | group ) ;
    public final Element variableExpression() throws RecognitionException {
        Element elm = null;

        Token NUMBERS3=null;
        Element group4 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:81:42: ( DOLLAR ( NUMBERS | group ) )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:82:2: DOLLAR ( NUMBERS | group )
            {
            match(input,DOLLAR,FOLLOW_DOLLAR_in_variableExpression109); 
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:83:2: ( NUMBERS | group )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NUMBERS) ) {
                alt2=1;
            }
            else if ( (LA2_0==OPEN_BRACKET) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:84:2: NUMBERS
                    {
                    NUMBERS3=(Token)match(input,NUMBERS,FOLLOW_NUMBERS_in_variableExpression116); 

                    		elm = new CaptureGroupElement(Integer.parseInt((NUMBERS3!=null?NUMBERS3.getText():null)));
                    	

                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:87:2: group
                    {
                    pushFollow(FOLLOW_group_in_variableExpression124);
                    group4=group();

                    state._fsp--;


                    		elm = group4;
                    	

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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:91:1: group returns [Element elem] : OPEN_BRACKET content CLOSE_BRACKET ;
    public final Element group() throws RecognitionException {
        Element elem = null;

        GramaticaParser.content_return content5 = null;


        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:91:30: ( OPEN_BRACKET content CLOSE_BRACKET )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:92:2: OPEN_BRACKET content CLOSE_BRACKET
            {
            match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_group142); 
            pushFollow(FOLLOW_content_in_group144);
            content5=content();

            state._fsp--;

            match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_group146); 

            		elem = (content5!=null?content5.elem:null);
            	

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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:96:1: content returns [Element elem] : ( closeContent | expressionContent ) ;
    public final GramaticaParser.content_return content() throws RecognitionException {
        GramaticaParser.content_return retval = new GramaticaParser.content_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:96:32: ( ( closeContent | expressionContent ) )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:97:2: ( closeContent | expressionContent )
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:97:2: ( closeContent | expressionContent )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==SLASH) ) {
                alt3=1;
            }
            else if ( (LA3_0==LETTERS) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:97:4: closeContent
                    {
                    pushFollow(FOLLOW_closeContent_in_content163);
                    closeContent();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:99:2: expressionContent
                    {
                    pushFollow(FOLLOW_expressionContent_in_content171);
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:107:1: closeContent : SLASH LETTERS ;
    public final void closeContent() throws RecognitionException {
        Token LETTERS6=null;

        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:108:2: ( SLASH LETTERS )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:109:2: SLASH LETTERS
            {
            match(input,SLASH,FOLLOW_SLASH_in_closeContent186); 
            LETTERS6=(Token)match(input,LETTERS,FOLLOW_LETTERS_in_closeContent188); 

            		try {
            			last.close((LETTERS6!=null?LETTERS6.getText():null));
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
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:117:1: expressionContent : LETTERS ( COLON literal )* ;
    public final void expressionContent() throws RecognitionException {
        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:118:2: ( LETTERS ( COLON literal )* )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:119:2: LETTERS ( COLON literal )*
            {
            match(input,LETTERS,FOLLOW_LETTERS_in_expressionContent200); 
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:119:10: ( COLON literal )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==COLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:119:11: COLON literal
            	    {
            	    match(input,COLON,FOLLOW_COLON_in_expressionContent203); 
            	    pushFollow(FOLLOW_literal_in_expressionContent205);
            	    literal();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
        return ;
    }
    // $ANTLR end "expressionContent"

    public static class literal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "literal"
    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:121:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final GramaticaParser.literal_return literal() throws RecognitionException {
        GramaticaParser.literal_return retval = new GramaticaParser.literal_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:121:9: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ )
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:122:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            {
            // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:122:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ESCAPE) ) {
                    alt5=1;
                }
                else if ( ((LA5_0>=NUMBERS && LA5_0<=ANY)) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:122:6: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    match(input,ESCAPE,FOLLOW_ESCAPE_in_literal222); 
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
            	    // G:\\Documents\\Projetos\\rr-trunk\\regex-renamer\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:123:13: ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' )
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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


 

    public static final BitSet FOLLOW_literal_in_expression76 = new BitSet(new long[]{0x0000000000003E40L});
    public static final BitSet FOLLOW_variableExpression_in_expression86 = new BitSet(new long[]{0x0000000000003E40L});
    public static final BitSet FOLLOW_EOF_in_expression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_variableExpression109 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_NUMBERS_in_variableExpression116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_variableExpression124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_group142 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_content_in_group144 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_group146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_closeContent_in_content163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionContent_in_content171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_closeContent186 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LETTERS_in_closeContent188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTERS_in_expressionContent200 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_COLON_in_expressionContent203 = new BitSet(new long[]{0x0000000000003E00L});
    public static final BitSet FOLLOW_literal_in_expressionContent205 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ESCAPE_in_literal222 = new BitSet(new long[]{0x0000000000003FF0L});
    public static final BitSet FOLLOW_set_in_literal224 = new BitSet(new long[]{0x0000000000003E02L});
    public static final BitSet FOLLOW_set_in_literal247 = new BitSet(new long[]{0x0000000000003E02L});

}