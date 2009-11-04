package br.com.renatoccosta.renamer;

/**
 *
 * @author renato
 */
public class SavedCriteria {

    public static final String FILE_EXT = ".xml";

    private String path;

    private String search;

    private String replace;

    private boolean includeSubfolders = false;

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

    public boolean isIncludeSubfolders() {
        return includeSubfolders;
    }

    public void setIncludeSubfolders(boolean includeSubfolders) {
        this.includeSubfolders = includeSubfolders;
    }

}
