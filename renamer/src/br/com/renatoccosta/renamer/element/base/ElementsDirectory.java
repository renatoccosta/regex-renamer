package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que mantém um map entre o id de cada elemento e sua classe associada.
 * É utilizada pelo ElementFactory para criar instâncias dos elementos definidos
 * na string de substituição.
 * Ao ser inicializada, esta classe preenche o map com os elementos internos e
 * os externos (plug-ins).
 *
 * @author Renato Costa
 */
public class ElementsDirectory {

    private static ElementsDirectory discovery = new ElementsDirectory();

    private Map<String, Class<Element>> mapId =
            new HashMap<String, Class<Element>>();

    private ResourceBundle directory = ResourceBundle.getBundle(
            "br/com/renatoccosta/renamer/element/base/ElementsDirectory");

    /**
     * Carrega os elementos internos e externos no map
     */
    private ElementsDirectory() {
        loadInternalElements();
        loadExternalElements();
    }

    public static ElementsDirectory getInstance() {
        return discovery;
    }

    /**
     * Busca a classe correspondente ao id no map. Retorna null caso não
     * encontre.
     * 
     * @param id Nome descritivo da classe
     * @return Classe do elemento ou null caso não encontre
     */
    public Class<Element> lookup(String id) {
        Class<Element> cl = mapId.get(id);
        if (cl == null) {
            throw new ElementNotFoundException(id);
        }
        return cl;
    }

    /**
     * Busca o id correspondente à classe do parâmetro.
     * 
     * @param clasz Classe elemento
     * @return Id do elemento
     */
    public String lookup(Class<? extends Element> clasz) {
        for (Map.Entry<String, Class<Element>> entry : mapId.entrySet()) {
            if (entry.getValue().equals(clasz)) {
                return entry.getKey();
            }
        }

        throw new ElementNotFoundException(clasz.getName());
    }

    /**
     * Os elementos internos são carregados a partir do arquivo de recurso que
     * informa todos os ids e suas respectivas classes.
     */
    private void loadInternalElements() {
        Set keys = directory.keySet();
        for (Iterator it = keys.iterator(); it.hasNext();) {
            try {
                String id = (String) it.next();
                Class classElm = Class.forName(directory.getString(id));
                mapId.put(id, classElm);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ElementsDirectory.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Os elementos externos são carregados utilizando um classloader
     * personalizado.
     */
    private static void loadExternalElements() {
    }

}
