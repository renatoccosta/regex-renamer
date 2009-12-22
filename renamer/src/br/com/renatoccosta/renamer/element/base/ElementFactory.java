package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author renato
 */
public class ElementFactory {

    public static Element compile(String conteudo) throws
            ElementNotFoundException {
        String campos[] = conteudo.split(":");
        String xpName = campos[0];
        String params[] = (String[]) ArrayUtils.remove(campos, 0);

        Element ee = null;
        try {
            ee = ElementsDirectory.getInstance().lookup(xpName).newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(ElementFactory.class.getName()).log(
                    Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ElementFactory.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        ee.setParameters(params);

        return ee;
    }

}
