
package br.com.renatoccosta.renamer.element.base;

/**
 * Implementação concreta que é utilizada como raiz da árvore que representa
 * a estrutura dos elementos criados no parse da string de localização.
 *
 * @author Renato Costa
 */
public class RootElement extends StreamChangeElement {

    @Override
    public String getId() {
        return "root";
    }

    @Override
    protected String convert(String src) {
        return src;
    }

    @Override
    public String[] getParameters() {
        return new String[] {};
    }

    @Override
    public void setParameters(String... content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
