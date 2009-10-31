package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.Renamer;

/**
 *
 * @author renato
 */
public class RenamerBeforeListModel extends RenamerListModel {

    public RenamerBeforeListModel(Renamer renamer) {
        super(renamer);
    }

    public Object getElementAt(int index) {
        return stripFileName(renamer.getFileNamesBefore().get(index));
    }

}
