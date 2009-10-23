package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.renamer.element.ElementDiscovery;
import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import br.com.renatoccosta.renamer.exception.InvalidElementException;
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
    public StreamChangeElement add(Element element) {
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
    public StreamChangeElement close(String id) {
        Class<Element> ce = ElementDiscovery.lookup(id);
        
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
    public String getContent(String find, String target, File file) {
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

}
