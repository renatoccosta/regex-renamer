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
package br.com.renatoccosta.regexrenamer.api.element;

import br.com.renatoccosta.regexrenamer.api.exception.InvalidElementException;
import br.com.renatoccosta.regexrenamer.api.exception.RenamerException;
import br.com.renatoccosta.regexrenamer.api.meta.ElementType;
import br.com.renatoccosta.regexrenamer.api.meta.Parameter;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * Base class that represents an element on the substitution string. Each
 * element points to the next one, making a chain of elements.
 * 
 * @author renato
 */
public abstract class Element {

    protected CompositeElement parent;

    /* ---------------------------------------------------------------------- */
    /**
     * Retorna o id do elemento. Este id é utilizado para identificação na
     * string de substituição
     *
     * @return Id do elemento ou null caso não seja possível obter o id
     */
    public String getId() {
        return this.getClass().getAnnotation(ElementType.class).id();
    }

    public CompositeElement getParent() {
        return parent;
    }

    public void setParent(CompositeElement parent) {
        this.parent = parent;
    }

    /* ---------------------------------------------------------------------- */
    /**
     * Retorna a string de acordo com a transformação do elemento
     *
     * @param find String de busca usando expressões regulares.
     * @param target String alvo que será alterada. Normalmente é o nome do
     * arquivo.
     * @param file Arquivo associado à string alvo.
     * @return Conteúdo do elemento
     */
    public abstract String getContent(String find, String target, File file)
            throws RenamerException;

    public abstract void add(Element element) throws
            InvalidElementException;

    /**
     * Volta o valor das variáveis internas de cada elemento para as originais
     * de quando foram criados.
     */
    public void resetState() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<").append(getId());

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields) {
            Parameter p = f.getAnnotation(Parameter.class);
            if (p != null) {
                String alias = p.alias().equals("") ? f.getName() : p.alias();

                try {
                    sb.append(" ").append(alias).append("='").append(
                            PropertyUtils.getProperty(this, f.getName())).
                            append("'");
                } catch (IllegalAccessException ex) {
                } catch (InvocationTargetException ex) {
                } catch (NoSuchMethodException ex) {
                }
            }
        }

        return sb.toString();
    }

}
