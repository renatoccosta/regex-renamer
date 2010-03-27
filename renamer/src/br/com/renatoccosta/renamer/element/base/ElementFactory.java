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
