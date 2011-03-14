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
import br.com.renatoccosta.renamer.i18n.Messages;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author renato
 */
public class FileListRenderer implements ListCellRenderer {

    private Renamer renamer;
    
    private ListCellRenderer nativeRenderer;

    public FileListRenderer(ListCellRenderer nativeRenderer, Renamer renamer) {
        this.nativeRenderer = nativeRenderer;
        this.renamer = renamer;
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        Component c = nativeRenderer.getListCellRendererComponent(list, 
                value, index, isSelected, cellHasFocus);

        //if the filename was changed, it's displayed in blue
        if (!renamer.getFiles().get(index).getRelativeFileNameBefore().endsWith(
                value.toString())) {
            c.setForeground(Color.BLUE);
        }

        //if the filename is conflicting with another file, it's displayed in red
        if (renamer.getConflicts().containsKey(
                renamer.getFiles().get(index).getFileNameAfter()) ||
                value.toString().endsWith(Messages.getErrorRenamingMessage())) {
            c.setForeground(Color.RED);
        }

        return c;
    }

}
