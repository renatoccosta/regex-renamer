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
package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import br.com.renatoccosta.renamer.exception.InvalidElementException;
import br.com.renatoccosta.renamer.exception.RenamerException;
import br.com.renatoccosta.renamer.exception.RuntimeRenamerException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Elemento que não gera conteúdo após sua aplicação na substituição, e sim
 * altera o conteúdo dos elementos contidos.
 *
 * @author Renato Costa
 */
public abstract class StreamChangeElement extends Element {

    protected boolean elementoAberto = true;

    protected StreamChangeElement parent;

    protected List<Element> childs = new ArrayList<Element>();

    public boolean isElementoAberto() {
        return elementoAberto;
    }

    public void setElementoAberto(boolean elementoAberto) {
        this.elementoAberto = elementoAberto;
    }

    public StreamChangeElement getParent() {
        return parent;
    }

    public void setParent(StreamChangeElement parent) {
        this.parent = parent;
    }

    /**
     * Adiciona um elemento à cadeia.
     */
    public StreamChangeElement add(Element element) throws
            InvalidElementException {
        if (elementoAberto) {
            //quando este está aberto, o elemento é adicionado como filho
            childs.add(element);

            if (element instanceof StreamChangeElement) {
                StreamChangeElement sce = (StreamChangeElement) element;
                sce.setParent(this);
                return sce;
            } else {
                return this;
            }
        } else {
            //quando este está fechado, não pode adicionar novos elementos
            throw new InvalidElementException(element.getId());
        }
    }

    /**
     * Fecha o StreamChangeElement, não aceitando mais filhos.
     * Será lançado um InvalidElementException caso o fechamento seja executado
     * em um momento errado.
     *
     * @param id Id do elemento a ser fechado.
     */
    public StreamChangeElement close(String id) throws RuntimeRenamerException {
        Class<Element> ce = ElementsDirectory.getInstance().lookup(id);

        if (ce == null) {
            throw new ElementNotFoundException(id);
        }

        //itera nos pais até encontrar o elemento igual ao parâmetro.
        //caso não encontre, lança um InvalidElementException
        if (this.getClass().equals(ce)) {
            elementoAberto = false;
        } else {
            if (parent != null) {
                parent.close(id);
                elementoAberto = false;
            } else {
                throw new InvalidElementException(id);
            }
        }

        return this.parent;
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
        StringBuffer sb = new StringBuffer();

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
        StringBuffer sb = new StringBuffer();

        sb.append("${").append(getId());

        String params = getParametersAsString();
        if (!"".equals(params)) {
            sb.append(":").append(params);
        }

        sb.append("}");

        for (Element element : childs) {
            sb.append(element.toString());
        }

        sb.append("${/").append(getId()).append("}");

        return sb.toString();
    }

}
