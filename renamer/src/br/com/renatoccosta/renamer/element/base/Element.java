package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.renamer.element.ElementsDirectory;
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
     * @return
     */
    public String getId() {
        return ElementsDirectory.getInstance().lookup(this.getClass());
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

}
