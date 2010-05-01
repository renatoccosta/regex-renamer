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
package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.Renamer;
import javax.swing.AbstractListModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author renato
 */
public abstract class RenamerListModel extends AbstractListModel {

    protected Renamer renamer;

    public RenamerListModel(Renamer renamer) {
        this.renamer = renamer;
    }

    public int getSize() {
        return renamer.getFileNamesBefore().size();
    }

    /**
     * Remove a parte em comum do nome do arquivo com a raiz de busca.
     *
     * Ex:
     * Raiz: /home/teste
     * Filename: /home/teste/filename01.txt
     * Result: /filename01.txt
     *
     * @param file Nome do arquivo
     * @return Diferença entre o nome do arquivo e a raiz.
     */
    protected String stripFileName(String file) {
        return StringUtils.difference(renamer.getRootFolder().getAbsolutePath(),
                file);
    }

    public void refresh() {
        fireContentsChanged(this, 0, getSize()-1);
    }

}
