package br.com.renatoccosta.renamer.element.base;

import java.io.File;

/**
 * Elemento que gera algum conteúdo após sua aplicação na substituição 
 *
 * @author renato
 */
public abstract class ContentElement extends Element {

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

}
