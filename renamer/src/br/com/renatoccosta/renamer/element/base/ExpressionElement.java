package br.com.renatoccosta.renamer.element.base;

/**
 *
 * @author renato
 */
public abstract class ExpressionElement extends ContentElement {

    /**
     * Retorna a representação original do elemento no formato:
     *
     * ${<elem_id>:<params>}
     *
     * @return Representação original do elemento
     */
    @Override
    public String toString() {
        return "${" + getId() + ":" + getParametersAsString() + "}";
    }

}
