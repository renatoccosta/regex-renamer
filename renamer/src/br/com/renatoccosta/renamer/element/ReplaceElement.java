package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.StreamChangeElement;
import br.com.renatoccosta.renamer.i18n.Messages;
import org.apache.commons.lang.StringUtils;

/**
 * Elemento que substitui todas as ocorrências de um caractere por outro no
 * conteúdo dos próximos elementos.
 *
 * @author Renato Costa
 */
public class ReplaceElement extends StreamChangeElement {

    private String[] de = new String[] {""};

    private String[] para = new String[] {""};

    @Override
    public void setParameters(String... content) {
        if (content.length % 2 > 0) {
            throw new IllegalArgumentException(
                    Messages.getReplaceElementInvalidNumberParametersMessage());
        }

        de = new String[content.length / 2];

        para = new String[content.length / 2];

        for (int i = 0; i < content.length; i+=2) {
            de[i/2] = content[i];
            para[i/2] = content[i+1];
        }
    }

    @Override
    public String convert(String src) {
        return StringUtils.replaceEach(src, de, para);
    }

}
