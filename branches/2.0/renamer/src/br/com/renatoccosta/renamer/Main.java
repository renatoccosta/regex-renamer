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
package br.com.renatoccosta.renamer;

import br.com.renatoccosta.renamer.element.base.ElementsDirectory;
import br.com.renatoccosta.renamer.view.FrmPrincipal;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Renato
 */
public class Main {

    private static Logger logger;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            loadLog4J();
            loadElements();
            setLookAndFeel();
            loadMainForm(args);
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    /* ---------------------------------------------------------------------- */

    private static void loadLog4J() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("log4j.properties"));
        PropertyConfigurator.configure(props);

        logger = Logger.getLogger(Main.class);
    }

    private static void setLookAndFeel() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    private static void loadMainForm(String[] args) {
        if (args.length > 0) {
            new FrmPrincipal(args[0]).setVisible(true);
        } else {
            new FrmPrincipal().setVisible(true);
        }
    }

    private static void loadElements() {
        //force class initialization
        ElementsDirectory.getInstance();
    }

}
