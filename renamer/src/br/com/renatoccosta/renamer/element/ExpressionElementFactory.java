/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.renatoccosta.renamer.element;

import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author renato
 */
public class ExpressionElementFactory {

    public static ExpressionElement compile(String conteudo) {
        String campos[] = conteudo.split(":");
        String xpName = campos[0];
        String params[] = (String[]) ArrayUtils.remove(campos, 0);
        ExpressionElement ee = null;

        if (IndexedElement.NAME.equals(xpName)) {
            ee = new IndexedElement();
        } else {
            throw new ExpressionNotFoundException(xpName);
        }
        
        ee.setContent(params);

        return ee;
    }

}
