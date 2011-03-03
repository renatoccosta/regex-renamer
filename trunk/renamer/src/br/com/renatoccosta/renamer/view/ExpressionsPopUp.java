/*
 *  Copyright 2010 Renato Couto da Costa.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.element.base.Element;
import br.com.renatoccosta.renamer.element.base.ElementsDirectory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.apache.log4j.Logger;

/**
 *
 * @author Renato Costa
 */
public class ExpressionsPopUp extends JPopupMenu implements ActionListener {

    private static Logger logger = Logger.getLogger(FrmPrincipal.class);

    private JTextComponent tc;

    private FrmElementParameters frm;

    /**
     * Constructs a new instance of ExpressionsPopUp passing the reference of
     * the textComponent that will have it's text completed whenever
     * {@code complete} method is called.
     *
     * @param tc textComponent that will be completed.
     */
    public ExpressionsPopUp(JTextComponent tc, FrmElementParameters frm) {
        this.tc = tc;
        this.frm = frm;
    }

    /**
     * Display the pop-up with the options that can complete the text of the
     * parameter
     */
    public void showOptions(List<String> options,
            JComponent relativePlacement) {
        this.removeAll();

        for (String exp : options) {
            JMenuItem mnu = createMenuItem(exp);
            add(mnu);
        }

        show(relativePlacement.getParent(),
                relativePlacement.getX() + relativePlacement.getParent().getX(),
                relativePlacement.getY() + relativePlacement.getParent().getY());
    }

    /**
     * Executes the completion of the text (where the cursor is) of the
     * textComponent reference.
     */
    public void actionPerformed(ActionEvent e) {
        String elementName = ((JMenuItem) e.getSource()).getText();
        Class<Element> elementClass = ElementsDirectory.getInstance().lookup(
                elementName);
        frm.setElementClass(elementClass);

        frm.setVisible(true);
        
        try {
            int caretPosition = tc.getCaretPosition();
            String textBefore = tc.getText(0, caretPosition);
            String textAfter = tc.getText(caretPosition,
                    tc.getText().length() - caretPosition);
            String textInsert = frm.getElement().toString();
            textInsert = stripCommonPart(textBefore, textInsert);

            tc.setText(textBefore + textInsert + textAfter);
            tc.setCaretPosition(caretPosition + textInsert.length());

        } catch (BadLocationException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    private JMenuItem createMenuItem(String exp) {
        JMenuItem mnu = new JMenuItem(exp);
        mnu.addActionListener(this);

        return mnu;
    }

    private String stripCommonPart(String textBefore, String textInsert) {
        for (int i = 0; i < textInsert.length(); i++) {
            String compare = textInsert.substring(0, textInsert.length() - i);

            if (textBefore.endsWith(compare)) {
                return textInsert.substring(textInsert.length() - i);
            }
        }

        return textInsert;
    }

}
