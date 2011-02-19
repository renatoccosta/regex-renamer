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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Renato Costa
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.FIELD)
public @interface Parameter {

    /**
     * Field alias to be used on the text representation
     * i.e: Field name: index, Alias: idx
     * &lt;group idx='1'/&gt;
     *
     * <p>This attribute can't be internationalized</p>
     *
     * @return Alias
     */
    String alias() default "";

    /**
     * Field name to be displayed on user interfaces.
     * 
     * <p>Can point to the i18n key on the resource file, defined in the
     * <code>ElementType</code> annotation. If this attribute is not set,
     * it will point to the default key:
     * <code>element.[id].param.[paramName].caption</code></p>
     *
     * @return Caption
     */
    String caption() default "";

    /**
     * Brief description of the parameter to help user know how to use it.
     * It will be displayed for the end user.
     *
     * <p>Can point to the i18n key on the resource file, defined in the
     * <code>ElementType</code> annotation. If this attribute is not set,
     * it will point to the default key:
     * <code>element.[id].param.[paramName].description</code></p></p>
     *
     * @return Description
     */
    String description() default "";

}
