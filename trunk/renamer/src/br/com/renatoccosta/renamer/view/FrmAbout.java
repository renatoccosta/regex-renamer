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
package br.com.renatoccosta.renamer.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Renato Couto da Costa
 */
public class FrmAbout extends javax.swing.JDialog {

    public FrmAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initLocal();
    }

    @Override
    protected JRootPane createRootPane() {
        final ImageIcon imageIcon = new ImageIcon(
                getClass().getResource("/background.png"));

        return new JRootPane() {

            Image image = imageIcon.getImage();

            {
                setOpaque(false);
            }

            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, this);
                super.paintComponent(g);
            }

        };
    }

    private void doClose() {
        setVisible(false);
        dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        pnlDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        txtDeveloper = new javax.swing.JLabel();
        txtHomepage = new javax.swing.JLabel();
        txtBlog = new javax.swing.JLabel();
        pnlInfo = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        btnOk = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/com/renatoccosta/renamer/i18n/Messages"); // NOI18N
        setTitle(bundle.getString("FrmAbout.title")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_48.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Arial", 0, 36));
        lblTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle.setText(bundle.getString("FrmAbout.lblTitle.text")); // NOI18N

        lblSubtitle.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblSubtitle.setText(bundle.getString("FrmAbout.lblSubtitle.text")); // NOI18N

        pnlDescription.setBorder(null);
        pnlDescription.setOpaque(false);

        txtDescription.setContentType(bundle.getString("FrmAbout.txtDescription.contentType")); // NOI18N
        txtDescription.setText(bundle.getString("FrmAbout.txtDescription.text")); // NOI18N
        txtDescription.setOpaque(false);
        pnlDescription.setViewportView(txtDescription);

        txtDeveloper.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtDeveloper.setText(bundle.getString("FrmAbout.txtDeveloper.text")); // NOI18N

        txtHomepage.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtHomepage.setText(bundle.getString("FrmAbout.txtHomepage.text")); // NOI18N

        txtBlog.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtBlog.setText(bundle.getString("FrmAbout.txtBlog.text")); // NOI18N

        pnlInfo.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlInfo.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtInfo.setColumns(20);
        txtInfo.setRows(3);
        txtInfo.setText(bundle.getString("FrmAbout.txtInfo.text")); // NOI18N
        pnlInfo.setViewportView(txtInfo);

        btnOk.setText(bundle.getString("FrmAbout.btnOk.text")); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(imgLogo)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(lblSubtitle)))
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBlog, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHomepage, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDeveloper, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubtitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(imgLogo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(pnlDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDeveloper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHomepage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBlog)
                .addGap(18, 18, 18)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-488)/2, (screenSize.height-514)/2, 488, 514);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        doClose();
    }//GEN-LAST:event_btnOkActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
	doClose();
    }//GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane pnlDescription;
    private javax.swing.JScrollPane pnlInfo;
    private javax.swing.JLabel txtBlog;
    private javax.swing.JTextPane txtDescription;
    private javax.swing.JLabel txtDeveloper;
    private javax.swing.JLabel txtHomepage;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables

    private void initLocal() {
        ((JPanel)this.getContentPane()).setOpaque(false);

        txtDeveloper.setText(StringUtils.replace(txtDeveloper.getText(),
                "${devname}", "Renato Couto da Costa"));

        String vmachine = System.getProperty("java.runtime.name") + " " +
                System.getProperty("java.runtime.version");

        String so = System.getProperty("os.name") + " " +
                System.getProperty("os.arch");

        txtInfo.setText(StringUtils.replaceEach(txtInfo.getText(),
                new String[] {"${vmachine}", "${so}"},
                new String[] {vmachine, so}));
    }

}