// $ANTLR 3.2 Sep 23, 2009 12:02:23 F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g 2009-10-01 16:47:56
 
package br.com.renatoccosta.renamer.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GramaticaLexer extends Lexer {
    public static final int SEPCAMPO=10;
    public static final int NUMERO=6;
    public static final int EOF=-1;
    public static final int CARACTERE=5;
    public static final int MARCADOR=7;
    public static final int ESPACO=4;
    public static final int ENTRA_GRUPO=8;
    public static final int SAI_GRUPO=9;

    // delegates
    // delegators

    public GramaticaLexer() {;} 
    public GramaticaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GramaticaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g"; }

    // $ANTLR start "CARACTERE"
    public final void mCARACTERE() throws RecognitionException {
        try {
            int _type = CARACTERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:11: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:13: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:13: ( 'a' .. 'z' | 'A' .. 'Z' )+
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
            	    // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:
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
    // $ANTLR end "CARACTERE"

    // $ANTLR start "ESPACO"
    public final void mESPACO() throws RecognitionException {
        try {
            int _type = ESPACO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:62:9: ( ( ' ' )+ )
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:62:11: ( ' ' )+
            {
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:62:11: ( ' ' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:62:11: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ESPACO"

    // $ANTLR start "NUMERO"
    public final void mNUMERO() throws RecognitionException {
        try {
            int _type = NUMERO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:63:9: ( '1' .. '9' ( '0' .. '9' )* )
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:63:11: '1' .. '9' ( '0' .. '9' )*
            {
            matchRange('1','9'); 
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:63:20: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:63:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMERO"

    // $ANTLR start "SEPCAMPO"
    public final void mSEPCAMPO() throws RecognitionException {
        try {
            int _type = SEPCAMPO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:64:10: ( ':' )
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:64:12: ':'
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
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:65:10: ( '$' )
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:65:12: '$'
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
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:66:13: ( '{' )
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:66:15: '{'
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
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:67:11: ( '}' )
            // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:67:13: '}'
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

    public void mTokens() throws RecognitionException {
        // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:8: ( CARACTERE | ESPACO | NUMERO | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO )
        int alt4=7;
        switch ( input.LA(1) ) {
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=1;
            }
            break;
        case ' ':
            {
            alt4=2;
            }
            break;
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt4=3;
            }
            break;
        case ':':
            {
            alt4=4;
            }
            break;
        case '$':
            {
            alt4=5;
            }
            break;
        case '{':
            {
            alt4=6;
            }
            break;
        case '}':
            {
            alt4=7;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;
        }

        switch (alt4) {
            case 1 :
                // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:10: CARACTERE
                {
                mCARACTERE(); 

                }
                break;
            case 2 :
                // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:20: ESPACO
                {
                mESPACO(); 

                }
                break;
            case 3 :
                // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:27: NUMERO
                {
                mNUMERO(); 

                }
                break;
            case 4 :
                // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:34: SEPCAMPO
                {
                mSEPCAMPO(); 

                }
                break;
            case 5 :
                // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:43: MARCADOR
                {
                mMARCADOR(); 

                }
                break;
            case 6 :
                // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:52: ENTRA_GRUPO
                {
                mENTRA_GRUPO(); 

                }
                break;
            case 7 :
                // F:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:1:64: SAI_GRUPO
                {
                mSAI_GRUPO(); 

                }
                break;

        }

    }


 

}