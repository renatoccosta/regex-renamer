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
package br.com.renatoccosta.regexrenamer.element.base;

import br.com.renatoccosta.regexrenamer.api.element.Element;
import br.com.renatoccosta.regexrenamer.api.meta.MetaElement;
import br.com.renatoccosta.regexrenamer.api.meta.Parameter;
import br.com.renatoccosta.regexrenamer.exception.ElementNotFoundException;
import br.com.renatoccosta.regexrenamer.exception.InvalidParameterException;
import br.com.renatoccosta.regexrenamer.i18n.Messages;
import java.lang.reflect.Field;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author renato
 */
public class ElementFactory {

    private static Logger LOGGER = Logger.getLogger(ElementFactory.class);

    private static BeanUtilsBean utilsBean = new BeanUtilsBean(
            new ConvertUtilsBean() {

                @Override
                public Object convert(String value, Class clazz) {
                    if (clazz.isEnum()) {
                        for (Object en : clazz.getEnumConstants()) {
                            if (value.toString().equalsIgnoreCase(
                                    en.toString())) {
                                return en;
                            }
                        }

                        return null;

                    } else {
                        return super.convert(value, clazz);
                    }

                }

            });

    public static Element compile(String alias) throws
            ElementNotFoundException {
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

        return ee;
    }

    public static void setParameter(Element element, String paramName,
            Object value) throws InvalidParameterException {
        MetaElement me = MetaElement.getInstance(element.getClass());
        Field f = me.getParamByName(paramName).getField();

        setParameter(element, f, value);
    }

    public static void setParameter(Element element, Field field, Object value)
            throws InvalidParameterException {
        try {
            //for security reasons, only parameters can be set with this method
            if (field.getAnnotation(Parameter.class) != null) {
                if (value instanceof String) {
                    value = utilsBean.getConvertUtils().convert(
                            (String) value, field.getType());
                }

                PropertyUtils.setProperty(element, field.getName(), value);
            } else {
                throw createInvalidParameterException(field.getName(), null);
            }
        } catch (Exception ex) {
            throw createInvalidParameterException(field.getName(), ex);
        }
    }

    /* ---------------------------------------------------------------------- */
    private static InvalidParameterException createInvalidParameterException(
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
