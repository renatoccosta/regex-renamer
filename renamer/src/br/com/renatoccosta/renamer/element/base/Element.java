package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import java.io.File;

/**
 * Classe base que representa um elemento na string de substituição. Cada
 * elemento aponta para o próximo, formando uma cadeia de elementos.
 * 
 * @author renato
 */
public abstract class Element {

    /**
     * Retorna o id do elemento. Este id é utilizado para identificação na
     * string de substituição
     *
     * @return Id do elemento ou null caso não seja possível obter o id
     */
    public String getId() {
        try {
            return ElementsDirectory.getInstance().lookup(this.getClass());
        } catch (ElementNotFoundException ex) {
            return null;
        }
    }

    /**
     * Retorna a string de acordo com a transformação do elemento
     *
     * @param find String de busca usando expressões regulares.
     * @param target String alvo que será alterada. Normalmente é o nome do
     * arquivo.
     * @param file Arquivo associado à string alvo.
     * @return Conteúdo do elemento
     */
    public abstract String getContent(String find, String target, File file);

    public abstract void setParameters(String... content);

    public abstract String[] getParameters();

    @Override
    public abstract String toString();

    /**
     * Volta o valor das variáveis internas de cada elemento para as originais
     * de quando foram criados.
     */
    public abstract void resetState();

    /**
     * Converte o array de parâmetros na string separada por ':'
     * 
     * @return Parâmetros separados por ':'
     */
    protected String getParametersAsString() {
        StringBuffer sb = new StringBuffer();

        for (String parm : getParameters()) {
            sb.append(parm);
            sb.append(":");
        }

        //remove o ':' do final
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

}
