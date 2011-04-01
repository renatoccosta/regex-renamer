/*
 *  Copyright 2011 Renato Couto da Costa.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package br.com.renatoccosta.renamer.element.meta;

import br.com.renatoccosta.renamer.element.base.Element;
import br.com.renatoccosta.renamer.util.AnnotationsUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * Helper class to read metadata annotations on Elements.
 * It caches all metadata information on elements
 *
 * @author Renato Couto da Costa
 */
public class MetaElement {

    private static Map<Class<? extends Element>, MetaElement> mElements =
            new HashMap<Class<? extends Element>, MetaElement>();

    private ElementType elementType;

    private Map<String, MetaParameter> params =
            new TreeMap<String, MetaParameter>();

    ResourceBundle bundle;

    /* ---------------------------------------------------------------------- */
    public static MetaElement getInstance(
            Class<? extends Element> elementClass) {
        MetaElement me = mElements.get(elementClass);

        if (me == null) {
            me = new MetaElement(elementClass);
            mElements.put(elementClass, me);
        }

        return me;
    }

    /* ---------------------------------------------------------------------- */
    protected MetaElement(Class<? extends Element> elementClass) {
        this.elementType = elementClass.getAnnotation(ElementType.class);

        if (!elementType.i18n().equals("")) {
            bundle = ResourceBundle.getBundle(elementType.i18n());
        }

        Field[] fields = AnnotationsUtil.extractAnnotatedFields(elementClass,
                Parameter.class);
        for (Field f : fields) {
            MetaParameter mt = new MetaParameter(this, f);
            params.put(mt.getAlias(), mt);
        }
    }

    /* ---------------------------------------------------------------------- */
    public String getId() {
        return elementType.id();
    }

    public String getDescription() {
        String description = elementType.description();

        if (bundle != null) {
            //if the bundle is set, means that the i18n is set.
            //tries to query the i18n string value
            try {
                description = bundle.getString(description);
            } catch (Exception e1) {
                //key doesn't exists
                //tries to query the default key
                try {
                    description = bundle.getString(getDefaultI18nKey()
                            + ".description");
                } catch (Exception e2) {
                    //the default key doesn't exists either
                    //will return the original value
                }
            }
        }

        return description;
    }

    public MetaParameter[] getParams() {
        return params.values().toArray(new MetaParameter[]{});
    }

    public MetaParameter getParamByName(String name) {
        return params.get(name);
    }

    /* ---------------------------------------------------------------------- */
    protected String getDefaultI18nKey() {
        return "element." + getId();
    }

}
