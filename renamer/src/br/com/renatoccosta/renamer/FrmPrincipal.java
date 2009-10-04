/*
 * FrmPrincipal.java
 *
 * Created on 28/09/2009, 09:43:12
 */
package br.com.renatoccosta.renamer;

import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author cyk1
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private Renamer renamer;

    /** Creates new form FrmPrincipal */
    public FrmPrincipal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lblAlvo = new javax.swing.JLabel();
        txtAlvo = new javax.swing.JTextField();
        lblLocalizar = new javax.swing.JLabel();
        txtLocalizar = new javax.swing.JTextField();
        lblSubstituir = new javax.swing.JLabel();
        txtSubstituir = new javax.swing.JTextField();
        lblAntes = new javax.swing.JLabel();
        pnlAntes = new javax.swing.JScrollPane();
        txtAntes = new javax.swing.JTextArea();
        lblDepois = new javax.swing.JLabel();
        pnlDepois = new javax.swing.JScrollPane();
        txtDepois = new javax.swing.JTextArea();
        pnlBotoes = new javax.swing.JPanel();
        btnPrevisualizar = new javax.swing.JButton();
        btnAplicar = new javax.swing.JButton();
        btnArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/com/renatoccosta/renamer/i18n/Messages"); // NOI18N
        setTitle(bundle.getString("FrmPrincipal.title")); // NOI18N

        lblAlvo.setText(bundle.getString("FrmPrincipal.lblAlvo.text")); // NOI18N

        txtAlvo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlvoFocusLost(evt);
            }
        });

        lblLocalizar.setText(bundle.getString("FrmPrincipal.lblLocalizar.text")); // NOI18N

        lblSubstituir.setText(bundle.getString("FrmPrincipal.lblSubstituir.text")); // NOI18N

        lblAntes.setText(bundle.getString("FrmPrincipal.lblAntes.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pnlDepois, org.jdesktop.beansbinding.ELProperty.create("${horizontalScrollBar}"), pnlAntes, org.jdesktop.beansbinding.BeanProperty.create("horizontalScrollBar"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pnlDepois, org.jdesktop.beansbinding.ELProperty.create("${verticalScrollBar}"), pnlAntes, org.jdesktop.beansbinding.BeanProperty.create("verticalScrollBar"));
        bindingGroup.addBinding(binding);

        txtAntes.setColumns(20);
        txtAntes.setRows(5);
        pnlAntes.setViewportView(txtAntes);

        lblDepois.setText(bundle.getString("FrmPrincipal.lblDepois.text")); // NOI18N

        txtDepois.setColumns(20);
        txtDepois.setRows(5);
        pnlDepois.setViewportView(txtDepois);

        btnPrevisualizar.setText(bundle.getString("FrmPrincipal.btnPrevisualizar.text")); // NOI18N
        btnPrevisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevisualizarActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnPrevisualizar);

        btnAplicar.setText(bundle.getString("FrmPrincipal.btnAplicar.text")); // NOI18N
        pnlBotoes.add(btnAplicar);

        btnArquivo.setText(bundle.getString("FrmPrincipal.btnArquivo.text")); // NOI18N
        btnArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubstituir)
                            .addComponent(lblLocalizar)
                            .addComponent(lblAlvo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(txtSubstituir, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtAlvo, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnArquivo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAntes)
                            .addComponent(pnlAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDepois)
                                .addGap(218, 218, 218))
                            .addComponent(pnlDepois, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlvo)
                    .addComponent(txtAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocalizar)
                    .addComponent(txtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubstituir)
                    .addComponent(txtSubstituir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAntes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAntes, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblDepois)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDepois, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArquivoActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            txtAlvo.setText(file.getAbsolutePath());
            limparArquivos();
            listaArquivosAntes(file);
        }
    }//GEN-LAST:event_btnArquivoActionPerformed

    private void txtAlvoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlvoFocusLost
        File arquivo = new File(txtAlvo.getText());

        limparArquivos();

        if (arquivo.exists()) {
            listaArquivosAntes(arquivo);
        }
    }//GEN-LAST:event_txtAlvoFocusLost

    private void btnPrevisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevisualizarActionPerformed
        try {
            inicializarRenomeador();
            txtDepois.setText(null);
            
            File arquivo = new File(txtAlvo.getText());
            if (arquivo.exists()) {
                listaArquivosDepois(arquivo);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);

            Logger.getLogger(FrmPrincipal.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrevisualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnArquivo;
    private javax.swing.JButton btnPrevisualizar;
    private javax.swing.JLabel lblAlvo;
    private javax.swing.JLabel lblAntes;
    private javax.swing.JLabel lblDepois;
    private javax.swing.JLabel lblLocalizar;
    private javax.swing.JLabel lblSubstituir;
    private javax.swing.JScrollPane pnlAntes;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JScrollPane pnlDepois;
    private javax.swing.JTextField txtAlvo;
    private javax.swing.JTextArea txtAntes;
    private javax.swing.JTextArea txtDepois;
    private javax.swing.JTextField txtLocalizar;
    private javax.swing.JTextField txtSubstituir;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void listaArquivosAntes(File pastaOuArquivo) {
        if (pastaOuArquivo.isDirectory()) {
            for (File arq : pastaOuArquivo.listFiles()) {
                listaArquivosAntes(arq);
            }
        } else {
            txtAntes.append(StringUtils.difference(txtAlvo.getText(),
                    pastaOuArquivo.getAbsolutePath()));
            txtAntes.append("\n");
        }
    }

    private void listaArquivosDepois(File pastaOuArquivo) throws
            ParseException {
        if (pastaOuArquivo.isDirectory()) {
            for (File arq : pastaOuArquivo.listFiles()) {
                listaArquivosDepois(arq);
            }
        } else {
            File dest = renamer.preview(pastaOuArquivo);
            txtDepois.append(StringUtils.difference(txtAlvo.getText(),
                    dest.getAbsolutePath()));
            txtDepois.append("\n");
        }
    }

    private void limparArquivos() {
        txtAntes.setText(null);
        txtDepois.setText(null);
    }

    private void inicializarRenomeador() throws ParseException {
        renamer = new Renamer(txtLocalizar.getText(), txtSubstituir.getText());
    }

}
