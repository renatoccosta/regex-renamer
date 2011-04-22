/*
 *  Copyright 2011 Renato Couto da Costa.
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
package br.com.renatoccosta.regexrenamer.view;

import br.com.renatoccosta.regexrenamer.api.element.Element;
import br.com.renatoccosta.regexrenamer.api.meta.MetaElement;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Renato Couto da Costa
 */
public class FrmElementParameters extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;

    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    /* ---------------------------------------------------------------------- */
    /** Creates new form FrmProperties */
    public FrmElementParameters(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initLocal();
    }

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    public Element getElement() {
        return ((ElementParametersTableModel)tblParams.getModel()).getElement();
    }

    /**
     * Sets the element class to display it's parameters
     *
     * @param elementClass Element Class
     */
    public void setElementClass(Class<Element> elementClass) {
        MetaElement me = MetaElement.getInstance(elementClass);

        lblSummary.setText("<html>" + me.getDescription() + "</html>");
        tblParams.setModel(new ElementParametersTableModel(elementClass));
        initColumnSizes(tblParams);
    }

    /* ---------------------------------------------------------------------- */
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSummary = new javax.swing.JLabel();
        lblParams = new javax.swing.JLabel();
        pnlParams = new javax.swing.JScrollPane();
        tblParams = new br.com.renatoccosta.regexrenamer.view.JPropertyTable();
        lblDescription = new javax.swing.JLabel();
        pnlDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/com/renatoccosta/renamer/i18n/Messages"); // NOI18N
        setTitle(bundle.getString("FrmElementParameters.title")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        lblSummary.setText(bundle.getString("FrmElementParameters.lblSummary.text")); // NOI18N
        lblSummary.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblParams.setText(bundle.getString("FrmElementParameters.lblParams.text")); // NOI18N

        tblParams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblParams.setColumnSelectionAllowed(true);
        tblParams.getTableHeader().setReorderingAllowed(false);
        pnlParams.setViewportView(tblParams);
        tblParams.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        lblDescription.setText(bundle.getString("FrmElementParameters.lblDescription.text")); // NOI18N

        txtDescription.setColumns(20);
        txtDescription.setEditable(false);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(1);
        pnlDescription.setViewportView(txtDescription);

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok.png"))); // NOI18N
        okButton.setText(bundle.getString("FrmElementParameters.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        cancelButton.setText(bundle.getString("FrmElementParameters.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblParams)
                .addContainerGap(258, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSummary, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlParams, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescription)
                .addContainerGap(207, Short.MAX_VALUE))
            .addComponent(pnlDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblParams)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlParams, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-335)/2, (screenSize.height-384)/2, 335, 384);
    }// </editor-fold>//GEN-END:initComponents

    private void initLocal() {
        tblParams.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                int idx = lsm.getLeadSelectionIndex();

                if (idx >= 0) {
                    ElementParametersTableModel model =
                            (ElementParametersTableModel) tblParams.getModel();
                    String description = model.getRowDescription(idx);

                    txtDescription.setText(description);
                }
            }

        });
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    /*
     * This method picks good column sizes.
     * If all column heads are wider than the column's cells'
     * contents, then you can just use column.sizeWidthToFit().
     */
    private void initColumnSizes(JTable table) {
        TableModel model = table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        TableCellRenderer headerRenderer =
                table.getTableHeader().getDefaultRenderer();

        //the work is done only on the firs column (parameter name)
        column = table.getColumnModel().getColumn(0);

        //calculate header width
        comp = headerRenderer.getTableCellRendererComponent(
                null, column.getHeaderValue(),
                false, false, 0, 0);
        headerWidth = comp.getPreferredSize().width;

        for (int i = 0; i < model.getRowCount(); i++) {
            //calculate cell width
            comp = table.getDefaultRenderer(model.getColumnClass(0)).
                    getTableCellRendererComponent(
                    table, model.getValueAt(i, 0),
                    false, false, 0, 0);
            cellWidth = comp.getPreferredSize().width;

            headerWidth = Math.max(headerWidth, cellWidth);
        }

        column.setPreferredWidth(headerWidth);
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /* ---------------------------------------------------------------------- */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblParams;
    private javax.swing.JLabel lblSummary;
    private javax.swing.JButton okButton;
    private javax.swing.JScrollPane pnlDescription;
    private javax.swing.JScrollPane pnlParams;
    private br.com.renatoccosta.regexrenamer.view.JPropertyTable tblParams;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;

}