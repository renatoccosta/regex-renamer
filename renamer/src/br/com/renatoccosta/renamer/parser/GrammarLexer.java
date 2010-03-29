// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g 2010-03-28 23:08:40

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

public class GrammarLexer extends Lexer {
    public static final int FUNCTION=11;
    public static final int DOLLAR=6;
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

    public GrammarLexer() {;} 
    public GrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g"; }

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:22:7: ( '/' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:22:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:23:7: ( ':' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:23:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:24:8: ( '$' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:24:10: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "OPEN_BRACKET"
    public final void mOPEN_BRACKET() throws RecognitionException {
        try {
            int _type = OPEN_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:25:14: ( '{' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:25:16: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_BRACKET"

    // $ANTLR start "CLOSE_BRACKET"
    public final void mCLOSE_BRACKET() throws RecognitionException {
        try {
            int _type = CLOSE_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:26:15: ( '}' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:26:17: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_BRACKET"

    // $ANTLR start "ESCAPE"
    public final void mESCAPE() throws RecognitionException {
        try {
            int _type = ESCAPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:27:8: ( '\\\\' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:27:10: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ESCAPE"

    // $ANTLR start "LITERAL"
    public final void mLITERAL() throws RecognitionException {
        try {
            int _type = LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:28:9: ( 'LITERAL' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:28:11: 'LITERAL'
            {
            match("LITERAL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITERAL"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:29:10: ( 'FUNCTION' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:29:12: 'FUNCTION'
            {
            match("FUNCTION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "CAPT_GROUP"
    public final void mCAPT_GROUP() throws RecognitionException {
        try {
            int _type = CAPT_GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:30:12: ( 'CAPT_GROUP' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:30:14: 'CAPT_GROUP'
            {
            match("CAPT_GROUP"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CAPT_GROUP"

    // $ANTLR start "CLOSE"
    public final void mCLOSE() throws RecognitionException {
        try {
            int _type = CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:31:7: ( 'CLOSE' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:31:9: 'CLOSE'
            {
            match("CLOSE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:32:7: ( '\\r' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:32:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:33:7: ( '\\n' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:33:9: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "LETTERS"
    public final void mLETTERS() throws RecognitionException {
        try {
            int _type = LETTERS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:114:9: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:114:11: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:114:11: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LETTERS"

    // $ANTLR start "NUMBERS"
    public final void mNUMBERS() throws RecognitionException {
        try {
            int _type = NUMBERS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:116:9: ( '1' .. '9' ( '0' .. '9' )* )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:116:12: '1' .. '9' ( '0' .. '9' )*
            {
            matchRange('1','9'); 
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:116:21: ( '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:116:21: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBERS"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:118:5: ( ( ' ' )+ )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:118:7: ( ' ' )+
            {
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:118:7: ( ' ' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:118:7: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "ANY"
    public final void mANY() throws RecognitionException {
        try {
            int _type = ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:120:6: (~ '\\n' )
            // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:120:8: ~ '\\n'
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANY"

    public void mTokens() throws RecognitionException {
        // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:8: ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | LITERAL | FUNCTION | CAPT_GROUP | CLOSE | T__18 | T__19 | LETTERS | NUMBERS | WS | ANY )
        int alt4=16;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:10: SLASH
                {
                mSLASH(); 

                }
                break;
            case 2 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:16: COLON
                {
                mCOLON(); 

                }
                break;
            case 3 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:22: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 4 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:29: OPEN_BRACKET
                {
                mOPEN_BRACKET(); 

                }
                break;
            case 5 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:42: CLOSE_BRACKET
                {
                mCLOSE_BRACKET(); 

                }
                break;
            case 6 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:56: ESCAPE
                {
                mESCAPE(); 

                }
                break;
            case 7 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:63: LITERAL
                {
                mLITERAL(); 

                }
                break;
            case 8 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:71: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 9 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:80: CAPT_GROUP
                {
                mCAPT_GROUP(); 

                }
                break;
            case 10 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:91: CLOSE
                {
                mCLOSE(); 

                }
                break;
            case 11 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:97: T__18
                {
                mT__18(); 

                }
                break;
            case 12 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:103: T__19
                {
                mT__19(); 

                }
                break;
            case 13 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:109: LETTERS
                {
                mLETTERS(); 

                }
                break;
            case 14 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:117: NUMBERS
                {
                mNUMBERS(); 

                }
                break;
            case 15 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:125: WS
                {
                mWS(); 

                }
                break;
            case 16 :
                // /home/renato/Desenvolvimento/projetos_ativos/rr-trunk/renamer/src/br/com/renatoccosta/renamer/parser/Grammar.g:1:128: ANY
                {
                mANY(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\7\uffff\3\27\14\uffff\1\27\1\uffff\3\27\3\uffff\12\27\1\uffff\1"+
        "\54\2\27\1\uffff\1\57\1\27\1\uffff\1\61\1\uffff";
    static final String DFA4_eofS =
        "\62\uffff";
    static final String DFA4_minS =
        "\1\0\6\uffff\1\111\1\125\1\101\14\uffff\1\124\1\uffff\1\116\1\120"+
        "\1\117\3\uffff\1\105\1\103\1\124\1\123\1\122\1\124\1\137\1\105\1"+
        "\101\1\111\1\uffff\1\101\1\114\1\117\1\uffff\1\101\1\116\1\uffff"+
        "\1\101\1\uffff";
    static final String DFA4_maxS =
        "\1\uffff\6\uffff\1\111\1\125\1\114\14\uffff\1\124\1\uffff\1\116"+
        "\1\120\1\117\3\uffff\1\105\1\103\1\124\1\123\1\122\1\124\1\137\1"+
        "\105\1\101\1\111\1\uffff\1\172\1\114\1\117\1\uffff\1\172\1\116\1"+
        "\uffff\1\172\1\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\3\uffff\1\13\1\14\1\15\1\16\1\17"+
        "\1\20\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\15\3\uffff\1\13\1\16\1\17"+
        "\12\uffff\1\11\3\uffff\1\12\2\uffff\1\7\1\uffff\1\10";
    static final String DFA4_specialS =
        "\1\0\61\uffff}>";
    static final String[] DFA4_transitionS = {
            "\12\17\1\13\2\17\1\12\22\17\1\16\3\17\1\3\12\17\1\1\1\17\11"+
            "\15\1\2\6\17\2\14\1\11\2\14\1\10\5\14\1\7\16\14\1\17\1\6\4\17"+
            "\32\14\1\4\1\17\1\5\uff82\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\26",
            "\1\30",
            "\1\31\12\uffff\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "\32\27\6\uffff\32\27",
            "\1\55",
            "\1\56",
            "",
            "\32\27\6\uffff\32\27",
            "\1\60",
            "",
            "\32\27\6\uffff\32\27",
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
            return "1:1: Tokens : ( SLASH | COLON | DOLLAR | OPEN_BRACKET | CLOSE_BRACKET | ESCAPE | LITERAL | FUNCTION | CAPT_GROUP | CLOSE | T__18 | T__19 | LETTERS | NUMBERS | WS | ANY );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                        s = -1;
                        if ( (LA4_0=='/') ) {s = 1;}

                        else if ( (LA4_0==':') ) {s = 2;}

                        else if ( (LA4_0=='$') ) {s = 3;}

                        else if ( (LA4_0=='{') ) {s = 4;}

                        else if ( (LA4_0=='}') ) {s = 5;}

                        else if ( (LA4_0=='\\') ) {s = 6;}

                        else if ( (LA4_0=='L') ) {s = 7;}

                        else if ( (LA4_0=='F') ) {s = 8;}

                        else if ( (LA4_0=='C') ) {s = 9;}

                        else if ( (LA4_0=='\r') ) {s = 10;}

                        else if ( (LA4_0=='\n') ) {s = 11;}

                        else if ( ((LA4_0>='A' && LA4_0<='B')||(LA4_0>='D' && LA4_0<='E')||(LA4_0>='G' && LA4_0<='K')||(LA4_0>='M' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')) ) {s = 12;}

                        else if ( ((LA4_0>='1' && LA4_0<='9')) ) {s = 13;}

                        else if ( (LA4_0==' ') ) {s = 14;}

                        else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\u001F')||(LA4_0>='!' && LA4_0<='#')||(LA4_0>='%' && LA4_0<='.')||LA4_0=='0'||(LA4_0>=';' && LA4_0<='@')||LA4_0=='['||(LA4_0>=']' && LA4_0<='`')||LA4_0=='|'||(LA4_0>='~' && LA4_0<='\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}