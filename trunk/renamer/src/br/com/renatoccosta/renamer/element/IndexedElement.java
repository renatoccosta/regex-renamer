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
package br.com.renatoccosta.renamer.element;

import br.com.renatoccosta.renamer.element.base.ExpressionElement;
import java.io.File;

/**
 * Elemento que retorna um índice numérico. Pode-se especificar o início do 
 * contador e quantos zeros precedem.
 *
 * Ex: ${idx}
 * Inicia de 0, sem zeros à esquerda
 * 0, 1, 2...
 *
 * Ex: ${idx:1}
 * Inicia de 1, sem zeros à esquerda.
 * 1, 2, 3...
 *
 * Ex: ${idx:5:3}
 * Inicia de 5 com 3 zeros precedentes.
 * 005, 006... 010... 204, 205...
 *
 * @author renato
 */
public class IndexedElement extends ExpressionElement {

    public static final String NAME = "idx";

    private int cont = 0;

    private int contOriginal = 0;

    private int leadingZeros = 1;

    @Override
    public Class[] getParameterDataTypes() {
        return new Class[]{Integer.class, Integer.class};
    }

    @Override
    public String[] getParameterValues() {
        return new String[]{String.valueOf(contOriginal),
                    String.valueOf(leadingZeros)};
    }

    /**
     * Itens do array:
     * 0 -> (Opcional) Valor inicial do contador
     * 1 -> (Opcional) Quantidade de zeros precedentes.
     *
     * @param content Parâmetros
     */
    @Override
    public void setParameters(String... content) {
        if (content.length > 0) {
            cont = Integer.parseInt(content[0]);
            contOriginal = cont;
        }

        if (content.length > 1) {
            leadingZeros = Integer.parseInt(content[1]);
        }
    }

    @Override
    public String getContent(String find, String target, File file) {
        return String.format("%0" + leadingZeros + "d", cont++);
    }

    @Override
    public void resetState() {
        this.cont = contOriginal;
    }

}
