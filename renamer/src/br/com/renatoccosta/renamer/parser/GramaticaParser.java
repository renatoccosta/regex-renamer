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

import br.com.renatoccosta.renamer.element.base.ElementFactory;
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


    public StreamChangeElement root = new RootElement();
    private StreamChangeElement last = root;



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
            	    		last = last.add(elem);;
            	    	

            	    }
            	    break;
            	case 2 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:35:2: grupo
            	    {
            	    pushFollow(FOLLOW_grupo_in_inicio86);
            	    grupo2=grupo();

            	    state._fsp--;


            	    		if (grupo2 != null) 
            	    			last = last.add(grupo2);
            	    	

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
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:41:1: grupo returns [Element elm] : MARCADOR ( NUMEROS | subgrupo ) ;
    public final Element grupo() throws RecognitionException {
        Element elm = null;

        Token NUMEROS3=null;
        Element subgrupo4 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:41:29: ( MARCADOR ( NUMEROS | subgrupo ) )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:42:2: MARCADOR ( NUMEROS | subgrupo )
            {
            match(input,MARCADOR,FOLLOW_MARCADOR_in_grupo109); 
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:43:2: ( NUMEROS | subgrupo )
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
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:44:2: NUMEROS
                    {
                    NUMEROS3=(Token)match(input,NUMEROS,FOLLOW_NUMEROS_in_grupo116); 

                    		elm = new CaptureGroupElement(Integer.parseInt((NUMEROS3!=null?NUMEROS3.getText():null)));
                    	

                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:47:2: subgrupo
                    {
                    pushFollow(FOLLOW_subgrupo_in_grupo124);
                    subgrupo4=subgrupo();

                    state._fsp--;


                    		elm = subgrupo4;
                    	

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
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:51:1: subgrupo returns [Element elem] : ENTRA_GRUPO conteudo SAI_GRUPO ;
    public final Element subgrupo() throws RecognitionException {
        Element elem = null;

        GramaticaParser.conteudo_return conteudo5 = null;


        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:51:33: ( ENTRA_GRUPO conteudo SAI_GRUPO )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:52:2: ENTRA_GRUPO conteudo SAI_GRUPO
            {
            match(input,ENTRA_GRUPO,FOLLOW_ENTRA_GRUPO_in_subgrupo142); 
            pushFollow(FOLLOW_conteudo_in_subgrupo144);
            conteudo5=conteudo();

            state._fsp--;

            match(input,SAI_GRUPO,FOLLOW_SAI_GRUPO_in_subgrupo146); 

            		elem = (conteudo5!=null?conteudo5.elem:null);
            	

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
        public Element elem;
    };

    // $ANTLR start "conteudo"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:56:1: conteudo returns [Element elem] : ( closeElement | otherElement ) ;
    public final GramaticaParser.conteudo_return conteudo() throws RecognitionException {
        GramaticaParser.conteudo_return retval = new GramaticaParser.conteudo_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:56:33: ( ( closeElement | otherElement ) )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:57:2: ( closeElement | otherElement )
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:57:2: ( closeElement | otherElement )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==CLOSE_ELEMENT) ) {
                alt3=1;
            }
            else if ( (LA3_0==LETRAS) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:57:4: closeElement
                    {
                    pushFollow(FOLLOW_closeElement_in_conteudo163);
                    closeElement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:59:2: otherElement
                    {
                    pushFollow(FOLLOW_otherElement_in_conteudo171);
                    otherElement();

                    state._fsp--;


                    		retval.elem = ElementFactory.compile(input.toString(retval.start,input.LT(-1)));
                    	

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


    // $ANTLR start "closeElement"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:63:1: closeElement : CLOSE_ELEMENT LETRAS ;
    public final void closeElement() throws RecognitionException {
        Token LETRAS6=null;

        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:64:2: ( CLOSE_ELEMENT LETRAS )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:65:2: CLOSE_ELEMENT LETRAS
            {
            match(input,CLOSE_ELEMENT,FOLLOW_CLOSE_ELEMENT_in_closeElement186); 
            LETRAS6=(Token)match(input,LETRAS,FOLLOW_LETRAS_in_closeElement188); 

            		last.close((LETRAS6!=null?LETRAS6.getText():null));
            	

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
    // $ANTLR end "closeElement"


    // $ANTLR start "otherElement"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:69:1: otherElement : LETRAS ( SEPCAMPO literal )* ;
    public final void otherElement() throws RecognitionException {
        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:70:2: ( LETRAS ( SEPCAMPO literal )* )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:71:2: LETRAS ( SEPCAMPO literal )*
            {
            match(input,LETRAS,FOLLOW_LETRAS_in_otherElement200); 
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:71:9: ( SEPCAMPO literal )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEPCAMPO) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:71:10: SEPCAMPO literal
            	    {
            	    match(input,SEPCAMPO,FOLLOW_SEPCAMPO_in_otherElement203); 
            	    pushFollow(FOLLOW_literal_in_otherElement205);
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
    // $ANTLR end "otherElement"

    public static class literal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "literal"
    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:73:1: literal : ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+ ;
    public final GramaticaParser.literal_return literal() throws RecognitionException {
        GramaticaParser.literal_return retval = new GramaticaParser.literal_return();
        retval.start = input.LT(1);

        try {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:73:9: ( ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+ )
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:74:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+
            {
            // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:74:2: ( ESCAPE ~ ( '\\r' | '\\n' ) | ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' ) )+
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
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:74:6: ESCAPE ~ ( '\\r' | '\\n' )
            	    {
            	    match(input,ESCAPE,FOLLOW_ESCAPE_in_literal222); 
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
            	    // G:\\Documents\\Projetos\\renamer\\src\\br\\com\\renatoccosta\\renamer\\parser\\Gramatica.g:75:13: ~ ( CLOSE_ELEMENT | SEPCAMPO | MARCADOR | ENTRA_GRUPO | SAI_GRUPO | ESCAPE | '\\r' | '\\n' )
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
    public static final BitSet FOLLOW_conteudo_in_subgrupo144 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SAI_GRUPO_in_subgrupo146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_closeElement_in_conteudo163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_otherElement_in_conteudo171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLOSE_ELEMENT_in_closeElement186 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LETRAS_in_closeElement188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETRAS_in_otherElement200 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_SEPCAMPO_in_otherElement203 = new BitSet(new long[]{0x0000000000003E00L});
    public static final BitSet FOLLOW_literal_in_otherElement205 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ESCAPE_in_literal222 = new BitSet(new long[]{0x0000000000003FF0L});
    public static final BitSet FOLLOW_set_in_literal224 = new BitSet(new long[]{0x0000000000003E02L});
    public static final BitSet FOLLOW_set_in_literal247 = new BitSet(new long[]{0x0000000000003E02L});

}