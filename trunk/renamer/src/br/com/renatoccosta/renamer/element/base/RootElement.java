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

/**
 * Implementação concreta que é utilizada como raiz da árvore que representa
 * a estrutura dos elementos criados no parse da string de localização.
 *
 * @author Renato Costa
 */
public class RootElement extends StreamChangeElement {

    @Override
    public String getId() {
        return "root";
    }

    @Override
    protected String convert(String src) {
        return src;
    }

    @Override
    public String[] getParameters() {
        return new String[] {};
    }

    @Override
    public void setParameters(String... content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
