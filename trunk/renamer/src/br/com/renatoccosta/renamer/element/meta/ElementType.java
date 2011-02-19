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
@Target(java.lang.annotation.ElementType.TYPE)
/**
 * Marks a class as a special element that may be used on the
 * <em>replace string</em>.
 */
public @interface ElementType {

    /**
     * Element identification on the replace string
     *
     * i.e: Id: case
     * &lt;case&gt;abc&lt;/case&gt;
     *
     * This attribute can't be internationalized
     *
     * @return Identification
     */
    String id();

    /**
     * Brief description of the purpose of the element and how to use it.
     * It will be displayed for the end user.
     *
     * <p>Can point to the i18n key on the resource file. If this attribute is
     * not set, it will point to the default key:
     * <code>element.[id].description</code></p>
     *
     * @return Description of the element
     */
    String description() default "";

    /**
     * Points to the resource file (in classpath) that contains the
     * internationalized strings for this parameter.
     *
     * If set, means that other attributes can point to a key in the
     * resource file instead of the string itself
     *
     * @return Resource file location
     */
    String i18n() default "";

}
