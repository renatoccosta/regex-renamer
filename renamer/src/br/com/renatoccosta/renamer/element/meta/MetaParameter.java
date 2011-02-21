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

import java.lang.reflect.Field;

/**
 * Helper class to read metadata annotations on parameters
 *
 * @author Renato Couto da Costa
 */
public class MetaParameter {

    private Field field;

    private Parameter param;

    private MetaElement parent;

    /* ---------------------------------------------------------------------- */

    public MetaParameter(MetaElement parent, Field f) {
        this.field = f;
        this.param = f.getAnnotation(Parameter.class);
        this.parent = parent;
    }

    /* ---------------------------------------------------------------------- */

    public Field getField() {
        return field;
    }

    public String getAlias() {
        return param.alias().equals("") ? field.getName() : param.alias();
    }

    public String getCaption() {
        String caption = param.caption();

        if (parent.bundle != null) {
            //if the bundle is set, means that the i18n is set.
            //tries to query the i18n string value
            try {
                caption = parent.bundle.getString(caption);
            } catch (Exception e1) {
                //key doesn't exists
                //tries to query the default key
                try {
                    caption = parent.bundle.getString(getDefaultI18nKey() +
                           getAlias() + ".caption");
                } catch (Exception e2) {
                    //the default key doesn't exists either
                    //will return the original value
                }
            }
        }

        if (caption.equals("")) {
            return field.getName();
        }

        return caption;
    }

    public String getDescription() {
        String description = param.description();

        if (parent.bundle != null) {
            try {
                description = parent.bundle.getString(description);
            } catch (Exception e1) {
                //key doesn't exists
                //tries to query the default key
                try {
                    description = parent.bundle.getString(getDefaultI18nKey() +
                           getAlias() + ".description");
                } catch (Exception e2) {
                    //the default key doesn't exists either
                    //will return the original value
                }
            }
        }

        return description;
    }

    /* ---------------------------------------------------------------------- */

    protected String getDefaultI18nKey() {
        return parent.getDefaultI18nKey() + ".param.";
    }

}
