package br.com.renatoccosta.renamer;

import java.io.File;

/**
 *
 * @author renato
 */
public class CriteriaDao {

    public static void save(SavedCriteria criteria, File fileName) {

    }

    public static void save(SavedCriteria criteria, String fileName) {
        save(criteria, new File(fileName));
    }

    public static SavedCriteria load(File fileName) {
        return null;
    }

    public static SavedCriteria load(String fileName) {
        return load(new File(fileName));
    }

}
