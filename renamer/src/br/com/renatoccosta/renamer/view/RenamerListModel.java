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
        return StringUtils.difference(renamer.getRootFile().getAbsolutePath(),
                file);
    }

    public void refresh() {
        fireContentsChanged(this, 0, getSize()-1);
    }

}
