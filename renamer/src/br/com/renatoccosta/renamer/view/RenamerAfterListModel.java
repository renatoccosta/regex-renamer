package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.Renamer;

/**
 *
 * @author renato
 */
public class RenamerAfterListModel extends RenamerListModel {

    public RenamerAfterListModel(Renamer renamer) {
        super(renamer);
    }

    public Object getElementAt(int index) {
        return stripFileName(renamer.getFileNamesAfter().get(index));
    }

}
