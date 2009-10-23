
package br.com.renatoccosta.renamer.element.base;

/**
 * Implementação concreta que é utilizada como raiz da árvore que representa
 * a estrutura dos elementos criados no parse da string de localização.
 *
 * @author Renato Costa
 */
public class RootElement extends StreamChangeElement {

    @Override
    protected String convert(String src) {
        return src;
    }

    @Override
    public void setParameters(String... content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
