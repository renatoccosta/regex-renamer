// $ANTLR 3.2 Sep 23, 2009 12:02:23 G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g 2009-10-20 15:26:48

package br.com.renatoccosta.renamer.parser;

import br.com.renatoccosta.renamer.element.*;
import br.com.renatoccosta.renamer.element.base.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GramaticaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLOSE_ELEMENT", "SEPCAMPO", "MARCADOR", "ENTRA_GRUPO", "SAI_GRUPO", "ESCAPE", "NUMEROS", "LETRAS", "ESPACOS", "QUALQUER", "'\\r'", "'\\n'"
    };
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
    public static final int SAI_GRUPO=8;
    public static final int ENTRA_GRUPO=7;
    public static final int QUALQUER=13;

    // delegates
    // delegators


        public GramaticaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GramaticaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return GramaticaParser.tokenNames; }
    public String getGrammarFileName() { return "G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g"; }


    public Element root = new LiteralElement("");
    private Element last = root;



    // $ANTLR start "inicio"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:28:1: inicio : ( literal | grupo )+ EOF ;
    public final void inicio() throws RecognitionException {
        GramaticaParser.literal_return literal1 = null;

        Element grupo2 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:28:8: ( ( literal | grupo )+ EOF )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:29:2: ( literal | grupo )+ EOF
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:29:2: ( literal | grupo )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=ESCAPE && LA1_0<=QUALQUER)) ) {
                    alt1=1;
                }
                else if ( (LA1_0==MARCADOR) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:30:2: literal
            	    {
            	    pushFollow(FOLLOW_literal_in_inicio76);
            	    literal1=literal();

            	    state._fsp--;


            	    		Element elem = new LiteralElement((literal1!=null?input.toString(literal1.start,literal1.stop):null));
            	    		last.setNext(elem);
            	    		last = elem;
            	    	

            	    }
            	    break;
            	case 2 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:36:2: grupo
            	    {
            	    pushFollow(FOLLOW_grupo_in_inicio86);
            	    grupo2=grupo();

            	    state._fsp--;


            	    		Element elem = grupo2;
            	    		last.setNext(elem);
            	    		last = elem;
            	    	

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

            match(input,EOF,FOLLOW_EOF_in_inicio94); 

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
    // $ANTLR end "inicio"


    // $ANTLR start "grupo"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:43:1: grupo returns [Element elm] : MARCADOR ( NUMEROS | subgrupo ) ;
    public final Element grupo() throws RecognitionException {
        Element elm = null;

        Element subgrupo3 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:43:29: ( MARCADOR ( NUMEROS | subgrupo ) )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:44:2: MARCADOR ( NUMEROS | subgrupo )
            {
            match(input,MARCADOR,FOLLOW_MARCADOR_in_grupo109); 
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:45:2: ( NUMEROS | subgrupo )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NUMEROS) ) {
                alt2=1;
            }
            else if ( (LA2_0==ENTRA_GRUPO) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:46:2: NUMEROS
                    {
                    match(input,NUMEROS,FOLLOW_NUMEROS_in_grupo116); 

                    		elm = new CaptureGroupElement(Integer.parseInt($NUMERO.text));
                    	

                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:49:2: subgrupo
                    {
                    pushFollow(FOLLOW_subgrupo_in_grupo124);
                    subgrupo3=subgrupo();

                    state._fsp--;


                    		elm = subgrupo3;
                    	

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
    // $ANTLR end "grupo"


    // $ANTLR start "subgrupo"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:53:1: subgrupo returns [Element elem] : ENTRA_GRUPO conteudo SAI_GRUPO ;
    public final Element subgrupo() throws RecognitionException {
        Element elem = null;

        GramaticaParser.conteudo_return conteudo4 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:53:33: ( ENTRA_GRUPO conteudo SAI_GRUPO )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:54:2: ENTRA_GRUPO conteudo SAI_GRUPO
            {
            match(input,ENTRA_GRUPO,FOLLOW_ENTRA_GRUPO_in_subgrupo142); 
            pushFollow(FOLLOW_conteudo_in_subgrupo146);
            conteudo4=conteudo();

            state._fsp--;

            match(input,SAI_GRUPO,FOLLOW_SAI_GRUPO_in_subgrupo150); 

            		elem = ElementFactory.compile((conteudo4!=null?input.toString(conteudo4.start,conteudo4.stop):null));
            	

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
    // $ANTLR end "subgrupo"

    public static class conteudo_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "conteudo"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:1: conteudo : ( CLOSE_ELEMENT LETRAS | LETRAS ( SEPCAMPO literal )* ) ;
    public final GramaticaParser.conteudo_return conteudo() throws RecognitionException {
        GramaticaParser.conteudo_return retval = new GramaticaParser.conteudo_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:9: ( ( CLOSE_ELEMENT LETRAS | LETRAS ( SEPCAMPO literal )* ) )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:2: ( CLOSE_ELEMENT LETRAS | LETRAS ( SEPCAMPO literal )* )
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:2: ( CLOSE_ELEMENT LETRAS | LETRAS ( SEPCAMPO literal )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==CLOSE_ELEMENT) ) {
                alt4=1;
            }
            else if ( (LA4_0==LETRAS) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:3: CLOSE_ELEMENT LETRAS
                    {
                    match(input,CLOSE_ELEMENT,FOLLOW_CLOSE_ELEMENT_in_conteudo161); 
                    match(input,LETRAS,FOLLOW_LETRAS_in_conteudo163); 

                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:26: LETRAS ( SEPCAMPO literal )*
                    {
                    match(input,LETRAS,FOLLOW_LETRAS_in_conteudo167); 
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:33: ( SEPCAMPO literal )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==SEPCAMPO) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:61:34: SEPCAMPO literal
                    	    {
                    	    match(input,SEPCAMPO,FOLLOW_SEPCAMPO_in_conteudo170); 
                    	    pushFollow(FOLLOW_literal_in_conteudo172);
                    	    literal();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


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
    // $ANTLR end "conteudo"

    public static class literal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "literal"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:63:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final GramaticaParser.literal_return literal() throws RecognitionException {
        GramaticaParser.literal_return retval = new GramaticaParser.literal_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:63:9: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+ )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:64:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:64:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ESCAPE) ) {
                    alt5=1;
                }
                else if ( ((LA5_0>=NUMEROS && LA5_0<=QUALQUER)) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:64:6: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    match(input,ESCAPE,FOLLOW_ESCAPE_in_literal190); 
            	    if ( (input.LA(1)>=CLOSE_ELEMENT && input.LA(1)<=QUALQUER) ) {
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
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:65:13: ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>=NUMEROS && input.LA(1)<=QUALQUER) ) {
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


 

    public static final BitSet FOLLOW_literal_in_inicio76 = new BitSet(new long[]{0x0000000000003E40L});
    public static final BitSet FOLLOW_grupo_in_inicio86 = new BitSet(new long[]{0x0000000000003E40L});
    public static final BitSet FOLLOW_EOF_in_inicio94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARCADOR_in_grupo109 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_NUMEROS_in_grupo116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subgrupo_in_grupo124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTRA_GRUPO_in_subgrupo142 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_conteudo_in_subgrupo146 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SAI_GRUPO_in_subgrupo150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLOSE_ELEMENT_in_conteudo161 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LETRAS_in_conteudo163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETRAS_in_conteudo167 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_SEPCAMPO_in_conteudo170 = new BitSet(new long[]{0x0000000000003E00L});
    public static final BitSet FOLLOW_literal_in_conteudo172 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ESCAPE_in_literal190 = new BitSet(new long[]{0x0000000000003FF0L});
    public static final BitSet FOLLOW_set_in_literal192 = new BitSet(new long[]{0x0000000000003E02L});
    public static final BitSet FOLLOW_set_in_literal215 = new BitSet(new long[]{0x0000000000003E02L});

}