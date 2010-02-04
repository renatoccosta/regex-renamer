/*
 * FrmPrincipal.java
 *
 * Created on 28/09/2009, 09:43:12
 */
package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.*;
import br.com.renatoccosta.renamer.exception.ElementNotFoundException;
import br.com.renatoccosta.renamer.exception.RenamerException;
import br.com.renatoccosta.renamer.i18n.Messages;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author cyk1
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private static Logger logger = Logger.getLogger(FrmPrincipal.class);

    private Renamer renamer = new Renamer();

    private ExpressionsPopUp epu;

    private boolean lockSelect = false;

    private boolean lockScroll = false;

    /** Creates new form FrmPrincipal */
    public FrmPrincipal() {
        initComponents();
        initComponentsLocal();
    }

    public FrmPrincipal(String path) {
        initComponents();
        initComponentsLocal();

        txtAlvo.setText(path);
        try {
            renamer.setRootFiles(new File(path), false);
        } catch (RenamerException ex) {
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
        btnArquivo = new javax.swing.JButton();
        chkSubpastas = new javax.swing.JCheckBox();
        lblLocalizar = new javax.swing.JLabel();
        txtLocalizar = new javax.swing.JTextField();
        lblSubstituir = new javax.swing.JLabel();
        txtSubstituir = new javax.swing.JTextField();
        lblArquivos = new javax.swing.JLabel();
        pnlArquivos = new javax.swing.JSplitPane();
        pnlAntes = new javax.swing.JScrollPane();
        lstAntes = new javax.swing.JList();
        pnlDepois = new javax.swing.JScrollPane();
        lstDepois = new javax.swing.JList();
        pnlOrdenacao = new javax.swing.JPanel();
        btnCima = new javax.swing.JButton();
        btnBaixo = new javax.swing.JButton();
        btnSortName = new javax.swing.JButton();
        btnSortDate = new javax.swing.JButton();
        pnlBotoes = new javax.swing.JPanel();
        btnPrevisualizar = new javax.swing.JButton();
        btnAplicar = new javax.swing.JButton();
        pnlStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuAbrir = new javax.swing.JMenuItem();
        mnuSalvar = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/com/renatoccosta/renamer/i18n/Messages"); // NOI18N
        setTitle(bundle.getString("FrmPrincipal.title")); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        lblAlvo.setText(bundle.getString("FrmPrincipal.lblAlvo.text")); // NOI18N

        btnArquivo.setText(bundle.getString("FrmPrincipal.btnArquivo.text")); // NOI18N
        btnArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArquivoActionPerformed(evt);
            }
        });

        chkSubpastas.setText(bundle.getString("FrmPrincipal.chkSubpastas.text")); // NOI18N
        chkSubpastas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSubpastasActionPerformed(evt);
            }
        });

        lblLocalizar.setText(bundle.getString("FrmPrincipal.lblLocalizar.text")); // NOI18N

        lblSubstituir.setText(bundle.getString("FrmPrincipal.lblSubstituir.text")); // NOI18N

        txtSubstituir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSubstituirKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubstituirKeyTyped(evt);
            }
        });

        lblArquivos.setText(bundle.getString("FrmPrincipal.lblArquivos.text")); // NOI18N

        pnlArquivos.setDividerLocation(260);
        pnlArquivos.setContinuousLayout(true);

        lstAntes.setModel(new RenamerBeforeListModel(renamer));
        lstAntes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAntesValueChanged(evt);
            }
        });
        pnlAntes.setViewportView(lstAntes);

        pnlArquivos.setLeftComponent(pnlAntes);

        lstDepois.setModel(new RenamerAfterListModel(renamer));
        lstDepois.setCellRenderer(new FileListRenderer(this.renamer));
        lstDepois.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDepoisValueChanged(evt);
            }
        });
        pnlDepois.setViewportView(lstDepois);

        pnlArquivos.setRightComponent(pnlDepois);

        btnCima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/up.gif"))); // NOI18N
        btnCima.setText(bundle.getString("FrmPrincipal.btnCima.text")); // NOI18N
        btnCima.setToolTipText(bundle.getString("FrmPrincipal.btnCima.toolTipText")); // NOI18N
        btnCima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCimaActionPerformed(evt);
            }
        });

        btnBaixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/down.gif"))); // NOI18N
        btnBaixo.setText(bundle.getString("FrmPrincipal.btnBaixo.text")); // NOI18N
        btnBaixo.setToolTipText(bundle.getString("FrmPrincipal.btnBaixo.toolTipText")); // NOI18N
        btnBaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaixoActionPerformed(evt);
            }
        });

        btnSortName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az.gif"))); // NOI18N
        btnSortName.setText(bundle.getString("FrmPrincipal.btnSortName.text")); // NOI18N
        btnSortName.setToolTipText(bundle.getString("FrmPrincipal.btnSortName.toolTipText")); // NOI18N
        btnSortName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortNameActionPerformed(evt);
            }
        });

        btnSortDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar.gif"))); // NOI18N
        btnSortDate.setText(bundle.getString("FrmPrincipal.btnSortDate.text")); // NOI18N
        btnSortDate.setToolTipText(bundle.getString("FrmPrincipal.btnSortDate.toolTipText")); // NOI18N
        btnSortDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrdenacaoLayout = new javax.swing.GroupLayout(pnlOrdenacao);
        pnlOrdenacao.setLayout(pnlOrdenacaoLayout);
        pnlOrdenacaoLayout.setHorizontalGroup(
            pnlOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenacaoLayout.createSequentialGroup()
                .addGroup(pnlOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSortDate, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(btnSortName, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(btnCima, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(btnBaixo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap(6, Short.MAX_VALUE))
        );
        pnlOrdenacaoLayout.setVerticalGroup(
            pnlOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCima, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSortName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSortDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

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

        pnlStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlStatus.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblStatus.setText(bundle.getString("FrmPrincipal.lblStatus.text")); // NOI18N
        pnlStatus.add(lblStatus);

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
            .addComponent(pnlBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArquivos)
                .addContainerGap(450, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubstituir)
                    .addComponent(lblLocalizar)
                    .addComponent(lblAlvo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSubpastas)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtAlvo, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArquivo))
                    .addComponent(txtLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addComponent(txtSubstituir, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
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
                .addComponent(chkSubpastas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocalizar)
                    .addComponent(txtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubstituir)
                    .addComponent(txtSubstituir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblArquivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlOrdenacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-587)/2, (screenSize.height-481)/2, 587, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void initComponentsLocal() {
        try {
            initAppIcon();
            initSyncListsScroll();
            initExpressionPopUp();
        } catch (Exception ex) {
            logger.fatal(ex.getMessage(), ex);
        }
    }

    private void initAppIcon() throws IOException {
        //icone da aplicação
        InputStream is = this.getClass().getResourceAsStream("/icon.PNG");
        this.setIconImage(ImageIO.read(is));
    }

    private void initSyncListsScroll() {
        //movimentação vertical sincronizada entre as listas de arquivos
        pnlAntes.getVerticalScrollBar().
                addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!lockScroll) {
                    lockScroll = true;
                    pnlDepois.getVerticalScrollBar().setValue(e.getValue());
                    lockScroll = false;
                }
            }

        });

        pnlDepois.getVerticalScrollBar().
                addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!lockScroll) {
                    lockScroll = true;
                    pnlAntes.getVerticalScrollBar().setValue(e.getValue());
                    lockScroll = false;
                }
            }

        });
    }

    private void initExpressionPopUp() {
        this.epu = new ExpressionsPopUp(txtSubstituir);
    }

    private void btnArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArquivoActionPerformed
        final JFileChooser fc = new JFileChooser(txtAlvo.getText());
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();

                txtAlvo.setText(file.getAbsolutePath());

                configureRenamer(true);

            } catch (RenamerException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnArquivoActionPerformed

    private void btnPrevisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevisualizarActionPerformed
        try {
            validateFields();

            configureRenamer(false);

            renamer.previewRename();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

            logger.error(ex.getMessage(), ex);
        }

        refreshLists();
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

                configureRenamer(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

                logger.error(ex);
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
                boolean salvar = true;

                if (file.exists()) {
                    int result = JOptionPane.showConfirmDialog(this,
                            Messages.getConfirmReplaceMessage(file.getName()),
                            Messages.getTitle(), JOptionPane.YES_NO_OPTION);

                    if (result != JOptionPane.YES_OPTION) {
                        salvar = false;
                    }
                } else if (!file.getName().endsWith(SavedCriteria.FILE_EXT)) {
                    file = new File(file.getAbsolutePath() +
                            SavedCriteria.FILE_EXT);
                }

                if (salvar) {
                    SavedCriteria criteria = saveCriteria();
                    CriteriaDao.save(criteria, file);
                }

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

                logger.error(ex);
            }
        }
    }//GEN-LAST:event_mnuSalvarActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        try {
            validateFields();

            int result = JOptionPane.showConfirmDialog(this,
                    Messages.getConfirmRenameMessage(),
                    Messages.getTitle(), JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                configureRenamer(false);
                renamer.rename();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

            logger.error(ex);
        }
    }//GEN-LAST:event_btnAplicarActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        lblStatus.setText(this.getBounds().getWidth() + "");
        pnlArquivos.setDividerLocation(.5d);
    }//GEN-LAST:event_formComponentResized

    private void chkSubpastasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSubpastasActionPerformed
        try {
            configureRenamer(true);
        } catch (RenamerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

            logger.error(ex);
        }
    }//GEN-LAST:event_chkSubpastasActionPerformed

    private void lstAntesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAntesValueChanged
        if (!lockSelect) {
            lockSelect = true;
            lstDepois.setSelectedIndices(lstAntes.getSelectedIndices());
            lockSelect = false;
        }
    }//GEN-LAST:event_lstAntesValueChanged

    private void lstDepoisValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDepoisValueChanged
        if (!lockSelect) {
            lockSelect = true;
            lstAntes.setSelectedIndices(lstDepois.getSelectedIndices());
            lockSelect = false;
        }
    }//GEN-LAST:event_lstDepoisValueChanged

    private void btnCimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCimaActionPerformed
        try {
            if (lstAntes.getSelectedIndex() == -1) {
                return;
            }

            validadeSelection(lstAntes.getSelectedIndices());

            this.renamer.moveFilesUp(lstAntes.getMinSelectionIndex(),
                    lstAntes.getMaxSelectionIndex());

            refreshLists();
            updateSelection(-1);

        } catch (RenamerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

            logger.error(ex);
        }
    }//GEN-LAST:event_btnCimaActionPerformed

    private void btnBaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaixoActionPerformed
        try {
            if (lstAntes.getSelectedIndex() == -1) {
                return;
            }

            validadeSelection(lstAntes.getSelectedIndices());

            this.renamer.moveFilesDown(lstAntes.getMinSelectionIndex(),
                    lstAntes.getMaxSelectionIndex());

            refreshLists();
            updateSelection(1);

        } catch (RenamerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

            logger.error(ex);
        }
    }//GEN-LAST:event_btnBaixoActionPerformed

    private void btnSortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortNameActionPerformed
        renamer.setSortType(SortType.FILE_NAME);
        refreshLists();
    }//GEN-LAST:event_btnSortNameActionPerformed

    private void btnSortDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortDateActionPerformed
        renamer.setSortType(SortType.MODIFIED_DATE);
        refreshLists();
    }//GEN-LAST:event_btnSortDateActionPerformed

    private void txtSubstituirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubstituirKeyTyped
    }//GEN-LAST:event_txtSubstituirKeyTyped

    private void txtSubstituirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubstituirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE && evt.isControlDown()) {
            try {
                renamer.setReplace(txtSubstituir.getText().substring(0,
                        txtSubstituir.getCaretPosition()));
            } catch (RenamerException ex) {
                String expression = null;

                Throwable e = ex.getCause();
                while (e != null) {
                    if (e instanceof ElementNotFoundException) {
                        expression = ((ElementNotFoundException) e).getElement();
                        break;
                    }
                    e = e.getCause();
                }

                if (expression != null) {
                    epu.showOptions(expression);
                }
            }
        }
    }//GEN-LAST:event_txtSubstituirKeyPressed

    private void validateFields() throws Exception {
        if (txtAlvo.getText().trim().equals("") ||
                txtLocalizar.getText().trim().equals("") ||
                txtSubstituir.getText().trim().equals("")) {
            throw new Exception(Messages.getFieldValidationMessage());
        }
    }

    private void loadCriteria(SavedCriteria criteria) {
        txtAlvo.setText(criteria.getPath());
        txtLocalizar.setText(criteria.getSearch());
        txtSubstituir.setText(criteria.getReplace());
        chkSubpastas.setSelected(criteria.isIncludeSubfolders());
    }

    private SavedCriteria saveCriteria() {
        SavedCriteria sc = new SavedCriteria();
        sc.setPath(txtAlvo.getText());
        sc.setReplace(txtSubstituir.getText());
        sc.setSearch(txtLocalizar.getText());
        sc.setIncludeSubfolders(chkSubpastas.isSelected());

        return sc;
    }

    private void configureRenamer(boolean refreshLists) throws
            RenamerException {
        if (!"".equals(txtAlvo.getText())) {
            renamer.setRootFiles(new File(txtAlvo.getText()),
                    chkSubpastas.isSelected());
        }

        if (!"".equals(txtSubstituir.getText())) {
            renamer.setReplace(txtSubstituir.getText());
        }

        if (!"".equals(txtLocalizar.getText())) {
            renamer.setSearch(txtLocalizar.getText());
        }

        if (refreshLists) {
            refreshLists();
        }
    }

    /**
     * Valida se a seleção está contígua
     *
     * @param selectedIndices Array de indices dos elementos selecionados
     * @throws RenamerException
     */
    private void validadeSelection(int[] selectedIndices) throws
            RenamerException {
        int qtd = selectedIndices[selectedIndices.length - 1] - selectedIndices[0];

        if (qtd != selectedIndices.length - 1) {
            throw new RenamerException(Messages.getContiguousSelectionMessage());
        }
    }

    /**
     * Atualiza as listas
     */
    private void refreshLists() {
        ((RenamerListModel) lstAntes.getModel()).refresh();
        ((RenamerListModel) lstDepois.getModel()).refresh();
    }

    /**
     * Atualiza a seleção das listas, considerando o deslocamento
     *
     * @param i Delta de deslocamento
     */
    private void updateSelection(int i) {
        int[] sels = lstAntes.getSelectedIndices();

        for (int j = 0; j < sels.length; j++) {
            sels[j] = sels[j] + i;
        }

        lstAntes.setSelectedIndices(sels);
        lstDepois.setSelectedIndices(sels);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnArquivo;
    private javax.swing.JButton btnBaixo;
    private javax.swing.JButton btnCima;
    private javax.swing.JButton btnPrevisualizar;
    private javax.swing.JButton btnSortDate;
    private javax.swing.JButton btnSortName;
    private javax.swing.JCheckBox chkSubpastas;
    private javax.swing.JLabel lblAlvo;
    private javax.swing.JLabel lblArquivos;
    private javax.swing.JLabel lblLocalizar;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSubstituir;
    private javax.swing.JList lstAntes;
    private javax.swing.JList lstDepois;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuSalvar;
    private javax.swing.JScrollPane pnlAntes;
    private javax.swing.JSplitPane pnlArquivos;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JScrollPane pnlDepois;
    private javax.swing.JPanel pnlOrdenacao;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JTextField txtAlvo;
    private javax.swing.JTextField txtLocalizar;
    private javax.swing.JTextField txtSubstituir;
    // End of variables declaration//GEN-END:variables

}
