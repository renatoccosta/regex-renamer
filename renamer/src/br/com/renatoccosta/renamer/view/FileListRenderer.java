package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.Renamer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author renato
 */
public class FileListRenderer extends JLabel implements ListCellRenderer {

    private Renamer renamer;

    public FileListRenderer(Renamer renamer) {
        setOpaque(true);
        this.renamer = renamer;
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

        if (renamer.getConflicts().containsKey(
                renamer.getFileNamesAfter().get(index))) {
            setForeground(Color.red);
        }

        setText(value.toString());

        return this;
    }

}
