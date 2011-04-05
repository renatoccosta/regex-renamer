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
package br.com.renatoccosta.regexrenamer.api.element;

import br.com.renatoccosta.regexrenamer.api.element.Element;
import br.com.renatoccosta.regexrenamer.api.exception.InvalidElementException;
import br.com.renatoccosta.regexrenamer.api.exception.RenamerException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Element that contains child elements and may change the contents of then
 * upon execution.
 *
 * @author Renato Costa
 */
public abstract class CompositeElement extends Element {

    protected boolean elementoAberto = true;

    protected List<Element> childs = new ArrayList<Element>();

    /**
     * Add an element as a child. Other classes may override this method to add
     * further functionality
     */
    public void add(Element element) throws
            InvalidElementException {
        childs.add(element);
        element.setParent(this);
    }

    /**
     * Obtém o conteúdo de todos os filhos e então executa a conversão de acordo
     * com a implementação.
     *
     * @param find String de busca usando expressões regulares.
     * @param target String alvo que será alterada. Normalmente é o nome do
     * arquivo.
     * @param file Arquivo associado à string alvo.
     * @return Conteúdo do elemento
     */
    @Override
    public String getContent(String find, String target, File file) throws
            RenamerException {
        StringBuilder sb = new StringBuilder();

        for (Element element : childs) {
            sb.append(element.getContent(find, target, file));
        }

        return convert(sb.toString());
    }

    /**
     * Converte a string src para o formato de saida, de acordo com o propósito
     * do elemento.
     * 
     * @param src String de entrada
     * @return String convertida
     */
    protected abstract String convert(String src);

    @Override
    public void resetState() {
        for (Element element : childs) {
            element.resetState();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        sb.append(">");

        for (Element element : childs) {
            sb.append(element.toString());
        }

        sb.append("</").append(getId()).append(">");

        return sb.toString();
    }

}
