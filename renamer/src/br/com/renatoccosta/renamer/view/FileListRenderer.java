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
import java.awt.Color;
import java.awt.Component;
import java.io.Serializable;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author renato
 */
public class FileListRenderer extends DefaultListCellRenderer implements
        ListCellRenderer, Serializable {

    private Renamer renamer;

    public FileListRenderer(Renamer renamer) {
        super();
//        setOpaque(true);
        //setPreferredSize(new Dimension(50, 16));
        
        this.renamer = renamer;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(list, value, index, 
                isSelected, cellHasFocus);

//        if (isSelected) {
//            setBackground(list.getSelectionBackground());
//            setForeground(list.getSelectionForeground());
//        } else {
//            setBackground(list.getBackground());
//            setForeground(list.getForeground());
//        }

        if (renamer.getConflicts().containsKey(
                renamer.getFileNamesAfter().get(index))) {
            setForeground(Color.red);
        }

//        setText(value.toString());

        return c;
    }

}
