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
package br.com.renatoccosta.regexrenamer.api.meta;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renato Costa
 */
public class AnnotationsUtil {

    public static Field[] extractAnnotatedFields(Class clazz, 
            Class<? extends Annotation> annot) {
        List<Field> ret = new ArrayList<Field>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.getAnnotation(annot) != null) {
                ret.add(f);
            }
        }

        return ret.toArray(new Field[] {});
    }

}
