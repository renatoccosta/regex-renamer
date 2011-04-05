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
package br.com.renatoccosta.regexrenamer.view;

import br.com.renatoccosta.regexrenamer.RenamedFile;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author renato
 */
public abstract class RenamerListModel extends AbstractListModel {

    protected List<RenamedFile> files;

    public RenamerListModel(List<RenamedFile> files) {
        this.files = files;
    }

    public int getSize() {
        return files.size();
    }

    public void refresh() {
        fireContentsChanged(this, 0, getSize()-1);
    }

}
