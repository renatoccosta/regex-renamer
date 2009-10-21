package br.com.renatoccosta.renamer.element.base;

import java.io.File;

/**
 * Classe base que representa um elemento na string de substituição. Cada
 * elemento aponta para o próximo, formando uma cadeia de elementos.
 * 
 * @author renato
 */
public abstract class Element {

    private Element next;

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    /**
     * Adiciona um elemento à cadeia. O comportamento e o retorno varia de
     * acordo com o tipo e estado deste elemento e com o parâmetro.
     *
     * @param element Elemento a ser adicionado à cadeia
     * @return Depende dos fatores citados acima.
     */
    public abstract Element add(Element element);

    /**
     * Retorna a string de acordo com a transformação do elemento
     *
     * @param find String de busca usando expressões regulares.
     * @param target String alvo que será alterada. Normalmente é o nome do
     * arquivo.
     * @param file Arquivo associado à string alvo.
     * @return
     */
    public abstract String getContent(String find, String target, File file);

    public abstract void setParameters(String... content);

}
