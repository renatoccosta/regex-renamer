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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

    /**
     * Constructs a new instance of ExpressionsPopUp passing the reference of
     * the textComponent that will have it's text completed whenever
     * {@code complete} method is called.
     *
     * @param tc textComponent that will be completed.
     */
    public ExpressionsPopUp(JTextComponent tc) {
        this.tc = tc;
    }

    /**
     * Display the pop-up with the options that can complete the text of the
     * parameter
     */
    public void showOptions(List<String> options) {
        this.removeAll();

        for (String exp : options) {
            JMenuItem mnu = createMenuItem(exp);
            add(mnu);
        }

        show(tc.getParent(), tc.getX() + tc.getParent().getX(),
                tc.getY() + tc.getParent().getY());
    }

    /**
     * Executes the completion of the text (where the cursor is) of the
     * textComponent reference.
     */
    public void actionPerformed(ActionEvent e) {
        try {
            int caretPosition = tc.getCaretPosition();
            String textBefore = tc.getText(0, caretPosition);
            String textAfter = tc.getText(caretPosition,
                    tc.getText().length() - caretPosition);
            String textInsert = ((JMenuItem) e.getSource()).getText();
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
