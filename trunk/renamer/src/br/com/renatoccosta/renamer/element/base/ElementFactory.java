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

import br.com.renatoccosta.renamer.element.meta.Parameter;
import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import br.com.renatoccosta.renamer.exception.InvalidParameterException;
import br.com.renatoccosta.renamer.i18n.Messages;
import java.lang.reflect.Field;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author renato
 */
public class ElementFactory {

    private static Logger LOGGER = Logger.getLogger(ElementFactory.class);

    public static Element compile(String alias) throws
            ElementNotFoundException {
//        String campos[] = conteudo.split(":");
//        String xpName = campos[0];
//        String params[] = (String[]) ArrayUtils.remove(campos, 0);

        Element ee = null;
        try {
            Class<Element> c = ElementsDirectory.getInstance().lookup(alias);

            if (c == null) {
                throw new ElementNotFoundException(alias);
            }

            ee = c.newInstance();

        } catch (InstantiationException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (IllegalAccessException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

//        ee.setParameters(params);

        return ee;
    }

    public static void setProperty(Element element, String name, String value)
            throws InvalidParameterException {
        try {
            Field f = element.getClass().getDeclaredField(name);

            if (f.getAnnotation(Parameter.class) != null) {
                Object v = ConvertUtils.convert(value, f.getType());
                PropertyUtils.setProperty(element, name, v);
            } else {
                throw createInvalidParameter(name, null);
            }

        } catch (Exception ex) {
                throw createInvalidParameter(name, ex);
        }
    }

    /* ---------------------------------------------------------------------- */

    private static InvalidParameterException createInvalidParameter(
            String paramName, Exception rootCause) {
        if (rootCause == null) {
            return new InvalidParameterException(
                    Messages.getInvalidParameterName(paramName));
        } else {
            return new InvalidParameterException(
                    Messages.getInvalidParameterName(paramName), rootCause);
        }
    }

}
