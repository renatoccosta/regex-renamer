package br.com.renatoccosta.renamer;

/**
 *
 * @author renato
 */
public class SavedCriteria {

    private String path;

    private String search;

    private String replace;

    public SavedCriteria() {
    }

    public SavedCriteria(String path, String search, String replace) {
        this.path = path;
        this.search = search;
        this.replace = replace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

}
