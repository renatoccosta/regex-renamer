/*
 * FrmPrincipal.java
 *
 * Created on 28/09/2009, 09:43:12
 */
package br.com.renatoccosta.renamer;

import br.com.renatoccosta.renamer.exception.RenamerException;
import br.com.renatoccosta.renamer.i18n.Messages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author cyk1
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private static Logger logger = Logger.getLogger(
            FrmPrincipal.class.getName());

    private Renamer renamer;

    /** Creates new form FrmPrincipal */
    public FrmPrincipal() {
        initComponents();

        try {
            InputStream is = this.getClass().getResourceAsStream("/icon.PNG");
            this.setIconImage(ImageIO.read(is));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAlvo = new javax.swing.JLabel();
        txtAlvo = new javax.swing.JTextField();
        lblLocalizar = new javax.swing.JLabel();
        txtLocalizar = new javax.swing.JTextField();
        lblSubstituir = new javax.swing.JLabel();
        txtSubstituir = new javax.swing.JTextField();
        pnlBotoes = new javax.swing.JPanel();
        btnPrevisualizar = new javax.swing.JButton();
        btnAplicar = new javax.swing.JButton();
        btnArquivo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnlArquivos = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAntes = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDepois = new javax.swing.JList();
        barMenu = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuAbrir = new javax.swing.JMenuItem();
        mnuSalvar = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/com/renatoccosta/renamer/i18n/Messages"); // NOI18N
        setTitle(bundle.getString("FrmPrincipal.title")); // NOI18N

        lblAlvo.setText(bundle.getString("FrmPrincipal.lblAlvo.text")); // NOI18N

        lblLocalizar.setText(bundle.getString("FrmPrincipal.lblLocalizar.text")); // NOI18N

        lblSubstituir.setText(bundle.getString("FrmPrincipal.lblSubstituir.text")); // NOI18N

        btnPrevisualizar.setText(bundle.getString("FrmPrincipal.btnPrevisualizar.text")); // NOI18N
        btnPrevisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevisualizarActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnPrevisualizar);

        btnAplicar.setText(bundle.getString("FrmPrincipal.btnAplicar.text")); // NOI18N
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnAplicar);

        btnArquivo.setText(bundle.getString("FrmPrincipal.btnArquivo.text")); // NOI18N
        btnArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArquivoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        pnlArquivos.setDividerLocation(280);

        lstAntes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstAntes);

        pnlArquivos.setLeftComponent(jScrollPane1);

        lstDepois.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstDepois);

        pnlArquivos.setRightComponent(jScrollPane2);

        mnuArquivo.setText(bundle.getString("FrmPrincipal.mnuArquivo.text")); // NOI18N

        mnuAbrir.setText(bundle.getString("FrmPrincipal.mnuAbrir.text")); // NOI18N
        mnuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAbrirActionPerformed(evt);
            }
        });
        mnuArquivo.add(mnuAbrir);

        mnuSalvar.setText(bundle.getString("FrmPrincipal.mnuSalvar.text")); // NOI18N
        mnuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalvarActionPerformed(evt);
            }
        });
        mnuArquivo.add(mnuSalvar);

        barMenu.add(mnuArquivo);

        mnuHelp.setText(bundle.getString("FrmPrincipal.mnuHelp.text")); // NOI18N
        barMenu.add(mnuHelp);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubstituir)
                    .addComponent(lblLocalizar)
                    .addComponent(lblAlvo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtAlvo, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArquivo))
                    .addComponent(txtSubstituir, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(txtLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(pnlArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-625)/2, (screenSize.height-467)/2, 625, 467);
    }// </editor-fold>//GEN-END:initComponents

    private void btnArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArquivoActionPerformed
        final JFileChooser fc = new JFileChooser(txtAlvo.getText());
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                txtAlvo.setText(file.getAbsolutePath());
                Renamer ren = new Renamer(file);

                limparArquivos();

                preencherArquivosAntes(ren.getFileNamesBefore());

                preencherArquivosDepois(ren.getFileNamesBefore());

            } catch (RenamerException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);

                logger.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnArquivoActionPerformed

    private void btnPrevisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevisualizarActionPerformed
        try {
            validarCampos();

            limparArquivos();

            inicializarRenomeador();

            preencherArquivosAntes(renamer.getFileNamesBefore());

            preencherArquivosDepois(renamer.getFileNamesAfter());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);

            logger.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrevisualizarActionPerformed

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                SavedCriteria criteria = CriteriaDao.load(file);
                loadCriteria(criteria);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);

                logger.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuAbrirActionPerformed

    private void mnuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalvarActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                SavedCriteria criteria = saveCriteria();
                CriteriaDao.save(criteria, file);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);

                logger.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuSalvarActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAplicarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnArquivo;
    private javax.swing.JButton btnPrevisualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlvo;
    private javax.swing.JLabel lblLocalizar;
    private javax.swing.JLabel lblSubstituir;
    private javax.swing.JList lstAntes;
    private javax.swing.JList lstDepois;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuSalvar;
    private javax.swing.JSplitPane pnlArquivos;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JTextField txtAlvo;
    private javax.swing.JTextField txtLocalizar;
    private javax.swing.JTextField txtSubstituir;
    // End of variables declaration//GEN-END:variables

    private void limparArquivos() {
        txtAntes.setText(null);
        txtDepois.setText(null);
    }

    private void inicializarRenomeador() throws RenamerException {
        renamer = new Renamer(new File(txtAlvo.getText()),
                txtLocalizar.getText(), txtSubstituir.getText());
    }

    private void validarCampos() throws Exception {
        if (txtAlvo.getText().trim().equals("") ||
                txtLocalizar.getText().trim().equals("") ||
                txtSubstituir.getText().trim().equals("")) {
            throw new Exception(Messages.getFieldValidationMessage());
        }
    }

    private void preencherArquivosAntes(List<String> fileNames) {
        for (String file : fileNames) {
            txtAntes.append(StringUtils.difference(txtAlvo.getText(), file));
            txtAntes.append("\n");
        }
    }

    private void preencherArquivosDepois(List<String> fileNames) {
        for (String file : fileNames) {
            txtDepois.append(StringUtils.difference(txtAlvo.getText(), file));
            txtDepois.append("\n");
        }
    }

    private void loadCriteria(SavedCriteria criteria) {
        txtAlvo.setText(criteria.getPath());
        txtLocalizar.setText(criteria.getSearch());
        txtSubstituir.setText(criteria.getReplace());
    }

    private SavedCriteria saveCriteria() {
        SavedCriteria sc = new SavedCriteria();
        sc.setPath(txtAlvo.getText());
        sc.setReplace(txtSubstituir.getText());
        sc.setSearch(txtLocalizar.getText());

        return sc;
    }

}
