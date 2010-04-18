// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g 2010-04-17 17:52:25

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
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TreeGrammar extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SLASH", "COLON", "DOLLAR", "OPEN_BRACKET", "CLOSE_BRACKET", "ESCAPE", "LITERAL", "FUNCTION", "CAPT_GROUP", "CLOSE", "NUMBERS", "LETTERS", "WS", "ANY", "'\r'", "'\n'", "'\\r'", "'\\n'"
    };
    public static final int FUNCTION=11;
    public static final int DOLLAR=6;
    public static final int T__21=21;
    public static final int T__20=20;
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


        public TreeGrammar(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public TreeGrammar(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TreeGrammar.tokenNames; }
    public String getGrammarFileName() { return "/home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g"; }


    public StreamChangeElement root = new RootElement();
    public StreamChangeElement last = root;



    // $ANTLR start "begin"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:40:1: begin : ( expression )+ EOF ;
    public final void begin() throws RecognitionException {
        Element expression1 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:41:2: ( ( expression )+ EOF )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:41:4: ( expression )+ EOF
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:41:4: ( expression )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=LITERAL && LA1_0<=CAPT_GROUP)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:41:4: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_begin47);
            	    expression1=expression();

            	    state._fsp--;


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

            	
            			last = last.add(expression1);
            		
            match(input,EOF,FOLLOW_EOF_in_begin52); 

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
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:46:1: expression returns [Element elem] : (e= literalExpression | e= variableExpression ) ;
    public final Element expression() throws RecognitionException {
        Element elem = null;

        Element e = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:47:2: ( (e= literalExpression | e= variableExpression ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:48:3: (e= literalExpression | e= variableExpression )
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:48:3: (e= literalExpression | e= variableExpression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LITERAL) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=FUNCTION && LA2_0<=CAPT_GROUP)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:48:5: e= literalExpression
                    {
                    pushFollow(FOLLOW_literalExpression_in_expression74);
                    e=literalExpression();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:49:6: e= variableExpression
                    {
                    pushFollow(FOLLOW_variableExpression_in_expression84);
                    e=variableExpression();

                    state._fsp--;


                    }
                    break;

            }

             elem = e; 

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
    // $ANTLR end "expression"


    // $ANTLR start "literalExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:53:1: literalExpression returns [Element elem] : ^( LITERAL literal ) ;
    public final Element literalExpression() throws RecognitionException {
        Element elem = null;

        TreeGrammar.literal_return literal2 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:54:2: ( ^( LITERAL literal ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:54:4: ^( LITERAL literal )
            {
            match(input,LITERAL,FOLLOW_LITERAL_in_literalExpression108); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_literal_in_literalExpression110);
            literal2=literal();

            state._fsp--;


            match(input, Token.UP, null); 
             
            			elem = new LiteralElement((literal2!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(literal2.start),
              input.getTreeAdaptor().getTokenStopIndex(literal2.start))):null)); 
            		

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
    // $ANTLR end "literalExpression"


    // $ANTLR start "variableExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:59:1: variableExpression returns [Element elem] : ( ^( CAPT_GROUP NUMBERS ) | ^( FUNCTION content ( ( expression )* ^( CLOSE closeContent ) )? ) );
    public final Element variableExpression() throws RecognitionException {
        Element elem = null;

        CommonTree NUMBERS3=null;
        Element content4 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:60:2: ( ^( CAPT_GROUP NUMBERS ) | ^( FUNCTION content ( ( expression )* ^( CLOSE closeContent ) )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CAPT_GROUP) ) {
                alt5=1;
            }
            else if ( (LA5_0==FUNCTION) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:60:4: ^( CAPT_GROUP NUMBERS )
                    {
                    match(input,CAPT_GROUP,FOLLOW_CAPT_GROUP_in_variableExpression131); 

                    match(input, Token.DOWN, null); 
                    NUMBERS3=(CommonTree)match(input,NUMBERS,FOLLOW_NUMBERS_in_variableExpression133); 

                    match(input, Token.UP, null); 

                    			elem = new CaptureGroupElement(Integer.parseInt((NUMBERS3!=null?NUMBERS3.getText():null)));
                    		

                    }
                    break;
                case 2 :
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:63:4: ^( FUNCTION content ( ( expression )* ^( CLOSE closeContent ) )? )
                    {
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_variableExpression142); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_content_in_variableExpression144);
                    content4=content();

                    state._fsp--;

                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:63:23: ( ( expression )* ^( CLOSE closeContent ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=LITERAL && LA4_0<=CLOSE)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:63:24: ( expression )* ^( CLOSE closeContent )
                            {
                            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:63:24: ( expression )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( ((LA3_0>=LITERAL && LA3_0<=CAPT_GROUP)) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:63:24: expression
                            	    {
                            	    pushFollow(FOLLOW_expression_in_variableExpression147);
                            	    expression();

                            	    state._fsp--;


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);

                            match(input,CLOSE,FOLLOW_CLOSE_in_variableExpression151); 

                            match(input, Token.DOWN, null); 
                            pushFollow(FOLLOW_closeContent_in_variableExpression153);
                            closeContent();

                            state._fsp--;


                            match(input, Token.UP, null); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    			elem = content4;
                    		

                    }
                    break;

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
    // $ANTLR end "variableExpression"


    // $ANTLR start "content"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:68:1: content returns [Element elem] : ^( function ( parameter )* ) ;
    public final Element content() throws RecognitionException {
        Element elem = null;

        TreeGrammar.parameter_return parameter5 = null;

        TreeGrammar.function_return function6 = null;



        		List<String> lstParam = new ArrayList<String>();
        	
        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:72:2: ( ^( function ( parameter )* ) )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:72:4: ^( function ( parameter )* )
            {
            pushFollow(FOLLOW_function_in_content181);
            function6=function();

            state._fsp--;


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:72:15: ( parameter )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=ESCAPE && LA6_0<=19)) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:72:15: parameter
                	    {
                	    pushFollow(FOLLOW_parameter_in_content183);
                	    parameter5=parameter();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop6;
                    }
                } while (true);

                			
                			if ((parameter5!=null?(input.getTokenStream().toString(
                  input.getTreeAdaptor().getTokenStartIndex(parameter5.start),
                  input.getTreeAdaptor().getTokenStopIndex(parameter5.start))):null) != null) {
                				lstParam.add((parameter5!=null?(input.getTokenStream().toString(
                  input.getTreeAdaptor().getTokenStartIndex(parameter5.start),
                  input.getTreeAdaptor().getTokenStopIndex(parameter5.start))):null));
                			}
                		

                match(input, Token.UP, null); 
            }

            			elem = ElementFactory.compile((function6!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(function6.start),
              input.getTreeAdaptor().getTokenStopIndex(function6.start))):null));
            			elem.setParameters((parameter5!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(parameter5.start),
              input.getTreeAdaptor().getTokenStopIndex(parameter5.start))):null)); 
            		

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
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:83:1: closeContent : function ;
    public final void closeContent() throws RecognitionException {
        TreeGrammar.function_return function7 = null;


        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:84:2: ( function )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:84:4: function
            {
            pushFollow(FOLLOW_function_in_closeContent203);
            function7=function();

            state._fsp--;


            			last.close((function7!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(function7.start),
              input.getTreeAdaptor().getTokenStopIndex(function7.start))):null));
            		

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

    public static class function_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "function"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:89:1: function : LETTERS ;
    public final TreeGrammar.function_return function() throws RecognitionException {
        TreeGrammar.function_return retval = new TreeGrammar.function_return();
        retval.start = input.LT(1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:90:2: ( LETTERS )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:90:4: LETTERS
            {
            match(input,LETTERS,FOLLOW_LETTERS_in_function216); 

            }

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

    public static class parameter_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "parameter"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:93:1: parameter : literal ;
    public final TreeGrammar.parameter_return parameter() throws RecognitionException {
        TreeGrammar.parameter_return retval = new TreeGrammar.parameter_return();
        retval.start = input.LT(1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:94:2: ( literal )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:94:4: literal
            {
            pushFollow(FOLLOW_literal_in_parameter230);
            literal();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parameter"

    public static class literal_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "literal"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:97:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final TreeGrammar.literal_return literal() throws RecognitionException {
        TreeGrammar.literal_return retval = new TreeGrammar.literal_return();
        retval.start = input.LT(1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:98:2: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:99:3: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:99:3: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ESCAPE) ) {
                    alt7=1;
                }
                else if ( ((LA7_0>=LITERAL && LA7_0<=19)) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:99:5: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    match(input,ESCAPE,FOLLOW_ESCAPE_in_literal247); 
            	    if ( (input.LA(1)>=SLASH && input.LA(1)<=19) ) {
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
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:100:5: ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>=LITERAL && input.LA(1)<=19) ) {
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

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


 

    public static final BitSet FOLLOW_expression_in_begin47 = new BitSet(new long[]{0x0000000000001C00L});
    public static final BitSet FOLLOW_EOF_in_begin52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExpression_in_expression74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExpression_in_expression84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_literalExpression108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_literalExpression110 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAPT_GROUP_in_variableExpression131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBERS_in_variableExpression133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_variableExpression142 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_content_in_variableExpression144 = new BitSet(new long[]{0x0000000000003C08L});
    public static final BitSet FOLLOW_expression_in_variableExpression147 = new BitSet(new long[]{0x0000000000003C00L});
    public static final BitSet FOLLOW_CLOSE_in_variableExpression151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_closeContent_in_variableExpression153 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_in_content181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_parameter_in_content183 = new BitSet(new long[]{0x00000000000FFE08L});
    public static final BitSet FOLLOW_function_in_closeContent203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTERS_in_function216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_parameter230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCAPE_in_literal247 = new BitSet(new long[]{0x00000000000FFFF0L});
    public static final BitSet FOLLOW_set_in_literal249 = new BitSet(new long[]{0x00000000000FFE02L});
    public static final BitSet FOLLOW_set_in_literal264 = new BitSet(new long[]{0x00000000000FFE02L});

}