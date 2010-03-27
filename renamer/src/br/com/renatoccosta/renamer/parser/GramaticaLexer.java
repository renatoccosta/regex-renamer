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

public class GramaticaLexer extends Lexer {
    public static final int T__15=15;
    public static final int SEPCAMPO=5;
    public static final int ESCAPE=9;
    public static final int T__14=14;
    public static final int CLOSE_ELEMENT=4;
    public static final int ESPACOS=12;
    public static final int LETRAS=11;
    public static final int MARCADOR=6;
    public static final int EOF=-1;
    public static final int NUMEROS=10;
    public static final int ENTRA_GRUPO=7;
    public static final int SAI_GRUPO=8;
    public static final int QUALQUER=13;

    // delegates
    // delegators

    public GramaticaLexer() {;} 
    public GramaticaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GramaticaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g"; }

    // $ANTLR start "CLOSE_ELEMENT"
    public final void mCLOSE_ELEMENT() throws RecognitionException {
        try {
            int _type = CLOSE_ELEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:7:15: ( '/' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:7:17: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_ELEMENT"

    // $ANTLR start "SEPCAMPO"
    public final void mSEPCAMPO() throws RecognitionException {
        try {
            int _type = SEPCAMPO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:8:10: ( ':' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:8:12: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEPCAMPO"

    // $ANTLR start "MARCADOR"
    public final void mMARCADOR() throws RecognitionException {
        try {
            int _type = MARCADOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:9:10: ( '$' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:9:12: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MARCADOR"

    // $ANTLR start "ENTRA_GRUPO"
    public final void mENTRA_GRUPO() throws RecognitionException {
        try {
            int _type = ENTRA_GRUPO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:10:13: ( '{' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:10:15: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENTRA_GRUPO"

    // $ANTLR start "SAI_GRUPO"
    public final void mSAI_GRUPO() throws RecognitionException {
        try {
            int _type = SAI_GRUPO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:11:11: ( '}' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:11:13: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SAI_GRUPO"

    // $ANTLR start "ESCAPE"
    public final void mESCAPE() throws RecognitionException {
        try {
            int _type = ESCAPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:12:8: ( '\\\\' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:12:10: '\\\\'
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

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:13:7: ( '\\r' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:13:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:14:7: ( '\\n' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:14:9: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "LETRAS"
    public final void mLETRAS() throws RecognitionException {
        try {
            int _type = LETRAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:80:2: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:80:4: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:80:4: ( 'a' .. 'z' | 'A' .. 'Z' )+
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
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:
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
    // $ANTLR end "LETRAS"

    // $ANTLR start "NUMEROS"
    public final void mNUMEROS() throws RecognitionException {
        try {
            int _type = NUMEROS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:81:9: ( '1' .. '9' ( '0' .. '9' )* )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:81:12: '1' .. '9' ( '0' .. '9' )*
            {
            matchRange('1','9'); 
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:81:21: ( '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:81:21: '0' .. '9'
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
    // $ANTLR end "NUMEROS"

    // $ANTLR start "ESPACOS"
    public final void mESPACOS() throws RecognitionException {
        try {
            int _type = ESPACOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:82:9: ( ( ' ' )+ )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:82:11: ( ' ' )+
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:82:11: ( ' ' )+
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
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:82:11: ' '
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
    // $ANTLR end "ESPACOS"

    // $ANTLR start "QUALQUER"
    public final void mQUALQUER() throws RecognitionException {
        try {
            int _type = QUALQUER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:83:9: (~ '\\n' )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:83:11: ~ '\\n'
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
    // $ANTLR end "QUALQUER"

    public void mTokens() throws RecognitionException {
        // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:8: ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | T__14 | T__15 | LETRAS | NUMEROS | ESPACOS | QUALQUER )
        int alt4=12;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:10: CLOSE_ELEMENT
                {
                mCLOSE_ELEMENT(); 

                }
                break;
            case 2 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:24: SEPCAMPO
                {
                mSEPCAMPO(); 

                }
                break;
            case 3 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:33: MARCADOR
                {
                mMARCADOR(); 

                }
                break;
            case 4 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:42: ENTRA_GRUPO
                {
                mENTRA_GRUPO(); 

                }
                break;
            case 5 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:54: SAI_GRUPO
                {
                mSAI_GRUPO(); 

                }
                break;
            case 6 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:64: ESCAPE
                {
                mESCAPE(); 

                }
                break;
            case 7 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:71: T__14
                {
                mT__14(); 

                }
                break;
            case 8 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:77: T__15
                {
                mT__15(); 

                }
                break;
            case 9 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:83: LETRAS
                {
                mLETRAS(); 

                }
                break;
            case 10 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:90: NUMEROS
                {
                mNUMEROS(); 

                }
                break;
            case 11 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:98: ESPACOS
                {
                mESPACOS(); 

                }
                break;
            case 12 :
                // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:106: QUALQUER
                {
                mQUALQUER(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\27\uffff";
    static final String DFA4_eofS =
        "\27\uffff";
    static final String DFA4_minS =
        "\1\0\26\uffff";
    static final String DFA4_maxS =
        "\1\uffff\26\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\1\1\2\1\3\1\4\1\5\1\6\1\7\1\11\1\12\1\13";
    static final String DFA4_specialS =
        "\1\0\26\uffff}>";
    static final String[] DFA4_transitionS = {
            "\12\14\1\10\2\14\1\7\22\14\1\13\3\14\1\3\12\14\1\1\1\14\11"+
            "\12\1\2\6\14\32\11\1\14\1\6\4\14\32\11\1\4\1\14\1\5\uff82\14",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | T__14 | T__15 | LETRAS | NUMEROS | ESPACOS | QUALQUER );";
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

                        else if ( (LA4_0=='\r') ) {s = 7;}

                        else if ( (LA4_0=='\n') ) {s = 8;}

                        else if ( ((LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')) ) {s = 9;}

                        else if ( ((LA4_0>='1' && LA4_0<='9')) ) {s = 10;}

                        else if ( (LA4_0==' ') ) {s = 11;}

                        else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\u001F')||(LA4_0>='!' && LA4_0<='#')||(LA4_0>='%' && LA4_0<='.')||LA4_0=='0'||(LA4_0>=';' && LA4_0<='@')||LA4_0=='['||(LA4_0>=']' && LA4_0<='`')||LA4_0=='|'||(LA4_0>='~' && LA4_0<='\uFFFF')) ) {s = 12;}

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