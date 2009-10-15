// $ANTLR 3.2 Sep 23, 2009 12:02:23 G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g 2009-10-15 17:38:33

package br.com.renatoccosta.renamer.parser;

import br.com.renatoccosta.renamer.element.*;
import br.com.renatoccosta.renamer.element.base.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GramaticaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ESPACO", "CARACTERE", "NUMERO", "MARCADOR", "ENTRA_GRUPO", "SAI_GRUPO", "SEPCAMPO"
    };
    public static final int SEPCAMPO=10;
    public static final int NUMERO=6;
    public static final int EOF=-1;
    public static final int CARACTERE=5;
    public static final int MARCADOR=7;
    public static final int ESPACO=4;
    public static final int SAI_GRUPO=9;
    public static final int ENTRA_GRUPO=8;

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
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:19:1: inicio : ( ESPACO | CARACTERE | NUMERO | grupo )+ EOF ;
    public final void inicio() throws RecognitionException {
        Token ESPACO1=null;
        Token CARACTERE2=null;
        Token NUMERO3=null;
        Element grupo4 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:19:8: ( ( ESPACO | CARACTERE | NUMERO | grupo )+ EOF )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:20:2: ( ESPACO | CARACTERE | NUMERO | grupo )+ EOF
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:20:2: ( ESPACO | CARACTERE | NUMERO | grupo )+
            int cnt1=0;
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case ESPACO:
                    {
                    alt1=1;
                    }
                    break;
                case CARACTERE:
                    {
                    alt1=2;
                    }
                    break;
                case NUMERO:
                    {
                    alt1=3;
                    }
                    break;
                case MARCADOR:
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:21:2: ESPACO
            	    {
            	    ESPACO1=(Token)match(input,ESPACO,FOLLOW_ESPACO_in_inicio35); 

            	    		Element elem = new LiteralElement((ESPACO1!=null?ESPACO1.getText():null));
            	    		last.setNext(elem);
            	    		last = elem;
            	    	

            	    }
            	    break;
            	case 2 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:26:2: CARACTERE
            	    {
            	    CARACTERE2=(Token)match(input,CARACTERE,FOLLOW_CARACTERE_in_inicio43); 

            	    		Element elem = new LiteralElement((CARACTERE2!=null?CARACTERE2.getText():null));
            	    		last.setNext(elem);
            	    		last = elem;
            	    	

            	    }
            	    break;
            	case 3 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:31:2: NUMERO
            	    {
            	    NUMERO3=(Token)match(input,NUMERO,FOLLOW_NUMERO_in_inicio51); 

            	    		Element elem = new LiteralElement((NUMERO3!=null?NUMERO3.getText():null));
            	    		last.setNext(elem);
            	    		last = elem;
            	    	

            	    }
            	    break;
            	case 4 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:36:2: grupo
            	    {
            	    pushFollow(FOLLOW_grupo_in_inicio59);
            	    grupo4=grupo();

            	    state._fsp--;


            	    		Element elem = grupo4;
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

            match(input,EOF,FOLLOW_EOF_in_inicio66); 

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
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:42:1: grupo returns [Element elm] : MARCADOR ( NUMERO | subgrupo ) ;
    public final Element grupo() throws RecognitionException {
        Element elm = null;

        Token NUMERO5=null;
        Element subgrupo6 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:42:29: ( MARCADOR ( NUMERO | subgrupo ) )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:43:2: MARCADOR ( NUMERO | subgrupo )
            {
            match(input,MARCADOR,FOLLOW_MARCADOR_in_grupo81); 
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:44:2: ( NUMERO | subgrupo )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NUMERO) ) {
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
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:45:2: NUMERO
                    {
                    NUMERO5=(Token)match(input,NUMERO,FOLLOW_NUMERO_in_grupo88); 

                    		elm = new CaptureGroupElement(Integer.parseInt((NUMERO5!=null?NUMERO5.getText():null)));
                    	

                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:48:2: subgrupo
                    {
                    pushFollow(FOLLOW_subgrupo_in_grupo96);
                    subgrupo6=subgrupo();

                    state._fsp--;


                    		elm = subgrupo6;
                    	

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
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:52:1: subgrupo returns [Element elem] : ENTRA_GRUPO conteudo SAI_GRUPO ;
    public final Element subgrupo() throws RecognitionException {
        Element elem = null;

        GramaticaParser.conteudo_return conteudo7 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:52:33: ( ENTRA_GRUPO conteudo SAI_GRUPO )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:53:2: ENTRA_GRUPO conteudo SAI_GRUPO
            {
            match(input,ENTRA_GRUPO,FOLLOW_ENTRA_GRUPO_in_subgrupo114); 
            pushFollow(FOLLOW_conteudo_in_subgrupo118);
            conteudo7=conteudo();

            state._fsp--;

            match(input,SAI_GRUPO,FOLLOW_SAI_GRUPO_in_subgrupo122); 

            		elem = ElementFactory.compile((conteudo7!=null?input.toString(conteudo7.start,conteudo7.stop):null));
            	

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
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:59:1: conteudo : CARACTERE ( SEPCAMPO ( CARACTERE | NUMERO )+ )* ;
    public final GramaticaParser.conteudo_return conteudo() throws RecognitionException {
        GramaticaParser.conteudo_return retval = new GramaticaParser.conteudo_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:59:9: ( CARACTERE ( SEPCAMPO ( CARACTERE | NUMERO )+ )* )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:2: CARACTERE ( SEPCAMPO ( CARACTERE | NUMERO )+ )*
            {
            match(input,CARACTERE,FOLLOW_CARACTERE_in_conteudo132); 
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:12: ( SEPCAMPO ( CARACTERE | NUMERO )+ )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEPCAMPO) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:14: SEPCAMPO ( CARACTERE | NUMERO )+
            	    {
            	    match(input,SEPCAMPO,FOLLOW_SEPCAMPO_in_conteudo136); 
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:60:23: ( CARACTERE | NUMERO )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( ((LA3_0>=CARACTERE && LA3_0<=NUMERO)) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:
            	    	    {
            	    	    if ( (input.LA(1)>=CARACTERE && input.LA(1)<=NUMERO) ) {
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
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
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
    // $ANTLR end "conteudo"

    // Delegated rules


 

    public static final BitSet FOLLOW_ESPACO_in_inicio35 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_CARACTERE_in_inicio43 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_NUMERO_in_inicio51 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_grupo_in_inicio59 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_EOF_in_inicio66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARCADOR_in_grupo81 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_NUMERO_in_grupo88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subgrupo_in_grupo96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTRA_GRUPO_in_subgrupo114 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_conteudo_in_subgrupo118 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SAI_GRUPO_in_subgrupo122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARACTERE_in_conteudo132 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_SEPCAMPO_in_conteudo136 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_conteudo138 = new BitSet(new long[]{0x0000000000000462L});

}