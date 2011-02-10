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

import br.com.renatoccosta.renamer.exception.InvalidElementException;
import br.com.renatoccosta.renamer.exception.InvalidParameterException;
import br.com.renatoccosta.renamer.exception.RenamerException;
import java.io.File;

/**
 * Base class that represents an element on the substitution string. Each
 * element points to the next one, making a chain of elements.
 * 
 * @author renato
 */
public abstract class Element {

    /**
     * Retorna o id do elemento. Este id é utilizado para identificação na
     * string de substituição
     *
     * @return Id do elemento ou null caso não seja possível obter o id
     */
    public String getId() {
        return ElementsDirectory.getInstance().lookup(this.getClass());
    }

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

//    /**
//     * Sets the value of the parameters. The order of the parameters are
//     * specified in the documentation of the variable expression
//     *
//     * @param content Array of values of the parameters
//     */
//    public abstract void setParameters(String... content);

    /**
     * Sets the value of the specified parameter
     *
     * @param name Parameter name
     * @param value Parameter value as a string
     */
    public abstract void setParameter(String name, String value) throws
            InvalidParameterException;

    /**
     * Gets the value of the specified parameter
     *
     * @param name Parameter name
     * @return Parameter value
     */
    public abstract String getParameter(String name) throws
            InvalidParameterException;

    public abstract String[] getParameterValues();

    public abstract String[] getParameterNames();

//    public abstract Class[] getParameterDataTypes();

    public abstract void add(Element element) throws
            InvalidElementException;

    @Override
    public abstract String toString();

    /**
     * Volta o valor das variáveis internas de cada elemento para as originais
     * de quando foram criados.
     */
    public abstract void resetState();

//    /**
//     * Converte o array de parâmetros na string separada por ':'
//     *
//     * @return Parâmetros separados por ':'
//     */
//    protected String getParametersAsString() {
//        StringBuilder sb = new StringBuilder();
//
//        for (String parm : getParameterValues()) {
//            sb.append(parm);
//            sb.append(":");
//        }
//
//        //remove o ':' do final
//        if (sb.length() > 0) {
//            sb.deleteCharAt(sb.length() - 1);
//        }
//
//        return sb.toString();
//    }

}
