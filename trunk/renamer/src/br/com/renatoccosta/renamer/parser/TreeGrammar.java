// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g 2010-03-28 22:36:21

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
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
public class TreeGrammar extends DebugTreeParser {
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

    public static final String[] ruleNames = new String[] {
        "invalidRule", "closeContent", "literalExpression", "parameter", 
        "function", "variableExpression", "begin", "content", "expression", 
        "literal"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public TreeGrammar(TreeNodeStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public TreeGrammar(TreeNodeStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this, port, input.getTreeAdaptor());
            setDebugListener(proxy);
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
        }
    public TreeGrammar(TreeNodeStream input, DebugEventListener dbg) {
        super(input, dbg, new RecognizerSharedState());

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }


    public String[] getTokenNames() { return TreeGrammar.tokenNames; }
    public String getGrammarFileName() { return "/home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g"; }



    // $ANTLR start "begin"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:30:1: begin : ( expression )+ EOF ;
    public final void begin() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "begin");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(30, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:31:2: ( ( expression )+ EOF )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:31:4: ( expression )+ EOF
            {
            dbg.location(31,4);
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:31:4: ( expression )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=LITERAL && LA1_0<=CAPT_GROUP)) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:31:4: expression
            	    {
            	    dbg.location(31,4);
            	    pushFollow(FOLLOW_expression_in_begin40);
            	    expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(31,16);
            match(input,EOF,FOLLOW_EOF_in_begin43); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(32, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "begin");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "begin"


    // $ANTLR start "expression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:34:1: expression : ( literalExpression | variableExpression ) ;
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(34, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:35:2: ( ( literalExpression | variableExpression ) )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:36:3: ( literalExpression | variableExpression )
            {
            dbg.location(36,3);
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:36:3: ( literalExpression | variableExpression )
            int alt2=2;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2);

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

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:36:5: literalExpression
                    {
                    dbg.location(36,5);
                    pushFollow(FOLLOW_literalExpression_in_expression58);
                    literalExpression();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:37:6: variableExpression
                    {
                    dbg.location(37,6);
                    pushFollow(FOLLOW_variableExpression_in_expression66);
                    variableExpression();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(39, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "literalExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:41:1: literalExpression : ^( LITERAL literal ) ;
    public final void literalExpression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "literalExpression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(41, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:42:2: ( ^( LITERAL literal ) )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:42:4: ^( LITERAL literal )
            {
            dbg.location(42,4);
            dbg.location(42,6);
            match(input,LITERAL,FOLLOW_LITERAL_in_literalExpression84); 

            match(input, Token.DOWN, null); 
            dbg.location(42,14);
            pushFollow(FOLLOW_literal_in_literalExpression86);
            literal();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(42, 22);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "literalExpression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "literalExpression"


    // $ANTLR start "variableExpression"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:44:1: variableExpression : ( ^( CAPT_GROUP NUMBERS ) | ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | ^( FUNCTION content ) );
    public final void variableExpression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "variableExpression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(44, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:45:2: ( ^( CAPT_GROUP NUMBERS ) | ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | ^( FUNCTION content ) )
            int alt4=3;
            try { dbg.enterDecision(4);

            try {
                isCyclicDecision = true;
                alt4 = dfa4.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:45:4: ^( CAPT_GROUP NUMBERS )
                    {
                    dbg.location(45,4);
                    dbg.location(45,6);
                    match(input,CAPT_GROUP,FOLLOW_CAPT_GROUP_in_variableExpression99); 

                    match(input, Token.DOWN, null); 
                    dbg.location(45,17);
                    match(input,NUMBERS,FOLLOW_NUMBERS_in_variableExpression101); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:46:4: ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) )
                    {
                    dbg.location(46,4);
                    dbg.location(46,6);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_variableExpression108); 

                    match(input, Token.DOWN, null); 
                    dbg.location(46,15);
                    pushFollow(FOLLOW_content_in_variableExpression110);
                    content();

                    state._fsp--;

                    dbg.location(46,23);
                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:46:23: ( expression )*
                    try { dbg.enterSubRule(3);

                    loop3:
                    do {
                        int alt3=2;
                        try { dbg.enterDecision(3);

                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=LITERAL && LA3_0<=CAPT_GROUP)) ) {
                            alt3=1;
                        }


                        } finally {dbg.exitDecision(3);}

                        switch (alt3) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:46:23: expression
                    	    {
                    	    dbg.location(46,23);
                    	    pushFollow(FOLLOW_expression_in_variableExpression112);
                    	    expression();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(3);}

                    dbg.location(46,35);
                    dbg.location(46,37);
                    match(input,CLOSE,FOLLOW_CLOSE_in_variableExpression116); 

                    match(input, Token.DOWN, null); 
                    dbg.location(46,43);
                    pushFollow(FOLLOW_closeContent_in_variableExpression118);
                    closeContent();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:47:4: ^( FUNCTION content )
                    {
                    dbg.location(47,4);
                    dbg.location(47,6);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_variableExpression126); 

                    match(input, Token.DOWN, null); 
                    dbg.location(47,15);
                    pushFollow(FOLLOW_content_in_variableExpression128);
                    content();

                    state._fsp--;


                    match(input, Token.UP, null); 

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
        dbg.location(48, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "variableExpression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "variableExpression"


    // $ANTLR start "content"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:50:1: content : ^( function ( parameter )* ) ;
    public final void content() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "content");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:51:2: ( ^( function ( parameter )* ) )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:51:4: ^( function ( parameter )* )
            {
            dbg.location(51,4);
            dbg.location(51,6);
            pushFollow(FOLLOW_function_in_content141);
            function();

            state._fsp--;


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                dbg.location(51,15);
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:51:15: ( parameter )*
                try { dbg.enterSubRule(5);

                loop5:
                do {
                    int alt5=2;
                    try { dbg.enterDecision(5);

                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=ESCAPE && LA5_0<=19)) ) {
                        alt5=1;
                    }


                    } finally {dbg.exitDecision(5);}

                    switch (alt5) {
                	case 1 :
                	    dbg.enterAlt(1);

                	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:51:15: parameter
                	    {
                	    dbg.location(51,15);
                	    pushFollow(FOLLOW_parameter_in_content143);
                	    parameter();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);
                } finally {dbg.exitSubRule(5);}


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(52, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "content");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "content"


    // $ANTLR start "closeContent"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:54:1: closeContent : function ;
    public final void closeContent() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "closeContent");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(54, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:55:2: ( function )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:55:4: function
            {
            dbg.location(55,4);
            pushFollow(FOLLOW_function_in_closeContent157);
            function();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(56, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "closeContent");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "closeContent"


    // $ANTLR start "function"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:58:1: function : LETTERS ;
    public final void function() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "function");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(58, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:59:2: ( LETTERS )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:59:4: LETTERS
            {
            dbg.location(59,4);
            match(input,LETTERS,FOLLOW_LETTERS_in_function168); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(60, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "parameter"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:62:1: parameter : literal ;
    public final void parameter() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "parameter");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(62, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:63:2: ( literal )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:63:4: literal
            {
            dbg.location(63,4);
            pushFollow(FOLLOW_literal_in_parameter181);
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
        dbg.location(64, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameter");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "parameter"


    // $ANTLR start "literal"
    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:66:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final void literal() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "literal");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 1);

        try {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:67:2: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+ )
            dbg.enterAlt(1);

            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:68:3: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            {
            dbg.location(68,3);
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:68:3: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' ) )+
            int cnt6=0;
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=3;
                try { dbg.enterDecision(6);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==ESCAPE) ) {
                    alt6=1;
                }
                else if ( ((LA6_0>=LITERAL && LA6_0<=19)) ) {
                    alt6=2;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:68:7: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    dbg.location(68,7);
            	    match(input,ESCAPE,FOLLOW_ESCAPE_in_literal200); 
            	    dbg.location(68,14);
            	    if ( (input.LA(1)>=SLASH && input.LA(1)<=19) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/TreeGrammar.g:69:13: ~ ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | '\\r' | '\\n' )
            	    {
            	    dbg.location(69,13);
            	    if ( (input.LA(1)>=LITERAL && input.LA(1)<=19) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt6++;
            } while (true);
            } finally {dbg.exitSubRule(6);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(71, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "literal");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "literal"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\14\uffff";
    static final String DFA4_eofS =
        "\14\uffff";
    static final String DFA4_minS =
        "\1\13\1\uffff\1\2\1\17\1\2\1\3\1\4\3\3\2\uffff";
    static final String DFA4_maxS =
        "\1\14\1\uffff\1\2\1\17\1\2\3\23\1\15\1\23\2\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\10\uffff\1\2\1\3";
    static final String DFA4_specialS =
        "\14\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\1\1",
            "",
            "\1\3",
            "\1\4",
            "\1\5",
            "\1\10\5\uffff\1\6\12\7",
            "\20\11",
            "\1\10\5\uffff\1\6\12\7",
            "\1\13\6\uffff\4\12",
            "\1\10\5\uffff\1\6\12\7",
            "",
            ""
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
            return "44:1: variableExpression : ( ^( CAPT_GROUP NUMBERS ) | ^( FUNCTION content ( expression )* ^( CLOSE closeContent ) ) | ^( FUNCTION content ) );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_expression_in_begin40 = new BitSet(new long[]{0x0000000000001C00L});
    public static final BitSet FOLLOW_EOF_in_begin43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExpression_in_expression58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExpression_in_expression66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_literalExpression84 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_literalExpression86 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAPT_GROUP_in_variableExpression99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBERS_in_variableExpression101 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_variableExpression108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_content_in_variableExpression110 = new BitSet(new long[]{0x0000000000003C00L});
    public static final BitSet FOLLOW_expression_in_variableExpression112 = new BitSet(new long[]{0x0000000000003C00L});
    public static final BitSet FOLLOW_CLOSE_in_variableExpression116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_closeContent_in_variableExpression118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_variableExpression126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_content_in_variableExpression128 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_in_content141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_parameter_in_content143 = new BitSet(new long[]{0x00000000000FFE08L});
    public static final BitSet FOLLOW_function_in_closeContent157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTERS_in_function168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_parameter181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCAPE_in_literal200 = new BitSet(new long[]{0x00000000000FFFF0L});
    public static final BitSet FOLLOW_set_in_literal202 = new BitSet(new long[]{0x00000000000FFE02L});
    public static final BitSet FOLLOW_set_in_literal225 = new BitSet(new long[]{0x00000000000FFE02L});

}