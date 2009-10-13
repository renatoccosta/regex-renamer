
package br.com.renatoccosta.renamer.element.base;

/**
 * Elemento que não gera conteúdo após sua aplicação na substituição, e sim
 * altera o conteúdo dos próximos elementos.
 *
 * @author Renato Costa
 */
public abstract class StreamChangeElement extends Element {

    /**
     * Converte a string src para o formato de saida, de acordo com o propósito
     * do elemento.
     * 
     * @param src String de entrada
     * @return String convertida
     */
    public abstract String convert(String src);

}
