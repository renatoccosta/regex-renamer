/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.renatoccosta.renamer.view;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author renato
 */
public class FileListRenderer extends JLabel implements ListCellRenderer {

    public FileListRenderer() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setText(value.toString());

        return this;
    }

}
