/**
 * Copyright 2009 Renato Couto da Costa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.renatoccosta.renamer.element.base;

import br.com.renatoccosta.renamer.element.meta.ElementType;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import org.apache.log4j.Logger;
import org.scannotation.AnnotationDB;
import org.scannotation.ClasspathUrlFinder;

/**
 * Class that keeps the references of the element's id and it's respective
 * classes.
 * The classpath is searched for all classes that have the 'ElementType'
 * annotation. When a class is found, it's put in the map. The class will be
 * loaded only when it's needed.
 *
 * @author Renato Costa
 */
public class ElementsDirectory {

    private static final Logger LOGGER = Logger.getLogger(
            ElementsDirectory.class);

    private static ElementsDirectory discovery = new ElementsDirectory();

    private Map<String, Class<Element>> mapId =
            new HashMap<String, Class<Element>>();

    /**
     * Carrega os elementos internos e externos no map
     */
    private ElementsDirectory() {
        loadElements();
        loadExternalElements();
    }

    public static ElementsDirectory getInstance() {
        return discovery;
    }

    public Map<String, Class<Element>> getMapId() {
        return mapId;
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

        return null;
    }

    /**
     * Os elementos internos são carregados a partir do arquivo de recurso que
     * informa todos os ids e suas respectivas classes.
     */
    private void loadElements() {
        try {
            //scan the classpath for annotated classes
            URL[] urls = ClasspathUrlFinder.findClassPaths();
            AnnotationDB db = new AnnotationDB();
            db.setScanFieldAnnotations(false);
            db.setScanMethodAnnotations(false);
            db.setScanParameterAnnotations(false);
            db.scanArchives(urls);

            //grabs only the 'ElementType' annotated classes
            Set<String> elements = db.getAnnotationIndex().get(
                    ElementType.class.getName());

            //loads the class and query it's alias
            for (String className : elements) {
                Class c = Class.forName(className);
                ElementType et = (ElementType) c.getAnnotation(
                        ElementType.class);
                mapId.put(et.id(), c);
            }

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    /**
     * Os elementos externos são carregados utilizando um classloader
     * personalizado.
     */
    private static void loadExternalElements() {
    }

}
