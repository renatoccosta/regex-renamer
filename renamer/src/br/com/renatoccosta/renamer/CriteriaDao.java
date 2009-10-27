package br.com.renatoccosta.renamer;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Classe que faz a persistência de um objeto SavedCriteria. Utiliza o XStream
 * como mapeador entre o XML e o objeto Java.
 *
 * @author renato
 */
public class CriteriaDao {

    public static void save(SavedCriteria criteria, File fileName) throws
            FileNotFoundException {
        XStream xstream = createXstream();
        xstream.toXML(criteria, new FileOutputStream(fileName));
    }

    public static void save(SavedCriteria criteria, String fileName) throws
            FileNotFoundException {
        save(criteria, new File(fileName));
    }

    public static SavedCriteria load(File fileName) throws 
            FileNotFoundException {
        XStream xStream = createXstream();
        return (SavedCriteria) xStream.fromXML(new FileInputStream(fileName));
    }

    public static SavedCriteria load(String fileName) throws
            FileNotFoundException {
        return load(new File(fileName));
    }

    private static XStream createXstream() {
        XStream xstream = new XStream();
        xstream.alias("criteria", SavedCriteria.class);

        return xstream;
    }

}
