/*
 * FrmPrincipal.java
 *
 * Created on 28/09/2009, 09:43:12
 */
package br.com.renatoccosta.renamer.view;

import br.com.renatoccosta.renamer.*;
import br.com.renatoccosta.renamer.element.base.ElementsDirectory;
import br.com.renatoccosta.renamer.exception.RenamerException;
import br.com.renatoccosta.renamer.i18n.Messages;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
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

        txtTarget.setText(path);
        try {
            renamer.setRootFolder(new File(path), false);
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

        grpCriteria = new javax.swing.ButtonGroup();
        lblTarget = new javax.swing.JLabel();
        txtTarget = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();
        lblFind = new javax.swing.JLabel();
        btnFindRegex = new javax.swing.JToggleButton();
        btnFindAll = new javax.swing.JToggleButton();
        btnFindSelected = new javax.swing.JToggleButton();
        lblExpression = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        lblReplace = new javax.swing.JLabel();
        txtReplace = new javax.swing.JTextField();
        btnFunctions = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        lblBeforeAfter = new javax.swing.JLabel();
        pnlFiles = new javax.swing.JSplitPane();
        pnlBefore = new javax.swing.JScrollPane();
        lstAntes = new javax.swing.JList();
        pnlAfter = new javax.swing.JScrollPane();
        lstDepois = new javax.swing.JList();
        pnlOrder = new javax.swing.JPanel();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnSortName = new javax.swing.JButton();
        btnSortDate = new javax.swing.JButton();
        pnlButtons = new javax.swing.JPanel();
        btnPreview = new javax.swing.JButton();
        btnApply = new javax.swing.JButton();
        pnlStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuOpen = new javax.swing.JMenuItem();
        mnuSave = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        mnuExit = new javax.swing.JMenuItem();
        mnuOptions = new javax.swing.JMenu();
        mnuOrderName = new javax.swing.JMenuItem();
        mnuOrderDate = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mnuIncludeType = new javax.swing.JCheckBoxMenuItem();
        mnuSubfolders = new javax.swing.JCheckBoxMenuItem();
        mnuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/com/renatoccosta/renamer/i18n/Messages"); // NOI18N
        setTitle(bundle.getString("FrmPrincipal.title")); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        lblTarget.setText(bundle.getString("FrmPrincipal.lblTarget.text")); // NOI18N

        btnFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png"))); // NOI18N
        btnFile.setText(bundle.getString("FrmPrincipal.btnFile.text")); // NOI18N
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        lblFind.setText(bundle.getString("FrmPrincipal.lblFind.text")); // NOI18N

        grpCriteria.add(btnFindRegex);
        btnFindRegex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regex.png"))); // NOI18N
        btnFindRegex.setSelected(true);
        btnFindRegex.setText(bundle.getString("FrmPrincipal.btnFindRegex.text")); // NOI18N
        btnFindRegex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindRegexActionPerformed(evt);
            }
        });

        grpCriteria.add(btnFindAll);
        btnFindAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/all.png"))); // NOI18N
        btnFindAll.setText(bundle.getString("FrmPrincipal.btnFindAll.text")); // NOI18N
        btnFindAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindAllActionPerformed(evt);
            }
        });

        grpCriteria.add(btnFindSelected);
        btnFindSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/selected.png"))); // NOI18N
        btnFindSelected.setText(bundle.getString("FrmPrincipal.btnFindSelected.text")); // NOI18N
        btnFindSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindSelectedActionPerformed(evt);
            }
        });

        lblExpression.setText(bundle.getString("FrmPrincipal.lblExpression.text")); // NOI18N

        lblReplace.setText(bundle.getString("FrmPrincipal.lblReplace.text")); // NOI18N

        txtReplace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReplaceKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReplaceKeyPressed(evt);
            }
        });

        btnFunctions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/function.png"))); // NOI18N
        btnFunctions.setText(bundle.getString("FrmPrincipal.btnFunctions.text")); // NOI18N
        btnFunctions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunctionsActionPerformed(evt);
            }
        });

        lblBeforeAfter.setText(bundle.getString("FrmPrincipal.lblBeforeAfter.text")); // NOI18N

        pnlFiles.setDividerLocation(250);
        pnlFiles.setContinuousLayout(true);

        lstAntes.setModel(new RenamerBeforeListModel(renamer));
        lstAntes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAntesValueChanged(evt);
            }
        });
        pnlBefore.setViewportView(lstAntes);

        pnlFiles.setLeftComponent(pnlBefore);

        lstDepois.setModel(new RenamerAfterListModel(renamer));
        lstDepois.setCellRenderer(new FileListRenderer(this.renamer));
        lstDepois.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDepoisValueChanged(evt);
            }
        });
        pnlAfter.setViewportView(lstDepois);

        pnlFiles.setRightComponent(pnlAfter);

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/up.png"))); // NOI18N
        btnUp.setText(bundle.getString("FrmPrincipal.btnUp.text")); // NOI18N
        btnUp.setToolTipText(bundle.getString("FrmPrincipal.btnUp.toolTipText")); // NOI18N
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/down.png"))); // NOI18N
        btnDown.setText(bundle.getString("FrmPrincipal.btnDown.text")); // NOI18N
        btnDown.setToolTipText(bundle.getString("FrmPrincipal.btnDown.toolTipText")); // NOI18N
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnSortName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az.png"))); // NOI18N
        btnSortName.setText(bundle.getString("FrmPrincipal.btnSortName.text")); // NOI18N
        btnSortName.setToolTipText(bundle.getString("FrmPrincipal.btnSortName.toolTipText")); // NOI18N
        btnSortName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortNameActionPerformed(evt);
            }
        });

        btnSortDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar.png"))); // NOI18N
        btnSortDate.setText(bundle.getString("FrmPrincipal.btnSortDate.text")); // NOI18N
        btnSortDate.setToolTipText(bundle.getString("FrmPrincipal.btnSortDate.toolTipText")); // NOI18N
        btnSortDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrderLayout = new javax.swing.GroupLayout(pnlOrder);
        pnlOrder.setLayout(pnlOrderLayout);
        pnlOrderLayout.setHorizontalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSortDate, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(btnSortName, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(btnUp, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(btnDown, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap(6, Short.MAX_VALUE))
        );
        pnlOrderLayout.setVerticalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSortName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSortDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pnlButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/preview.png"))); // NOI18N
        btnPreview.setText(bundle.getString("FrmPrincipal.btnPreview.text")); // NOI18N
        btnPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviewActionPerformed(evt);
            }
        });
        pnlButtons.add(btnPreview);

        btnApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apply.png"))); // NOI18N
        btnApply.setText(bundle.getString("FrmPrincipal.btnApply.text")); // NOI18N
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });
        pnlButtons.add(btnApply);

        pnlStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlStatus.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblStatus.setText(bundle.getString("FrmPrincipal.lblStatus.text")); // NOI18N
        pnlStatus.add(lblStatus);

        mnuFile.setText(bundle.getString("FrmPrincipal.mnuFile.text")); // NOI18N

        mnuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png"))); // NOI18N
        mnuOpen.setText(bundle.getString("FrmPrincipal.mnuOpen.text")); // NOI18N
        mnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        mnuFile.add(mnuOpen);

        mnuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        mnuSave.setText(bundle.getString("FrmPrincipal.mnuSave.text")); // NOI18N
        mnuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveActionPerformed(evt);
            }
        });
        mnuFile.add(mnuSave);
        mnuFile.add(jSeparator2);

        mnuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        mnuExit.setText(bundle.getString("FrmPrincipal.mnuExit.text")); // NOI18N
        mnuFile.add(mnuExit);

        barMenu.add(mnuFile);

        mnuOptions.setText(bundle.getString("FrmPrincipal.mnuOptions.text")); // NOI18N

        mnuOrderName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az.png"))); // NOI18N
        mnuOrderName.setText(bundle.getString("FrmPrincipal.mnuOrderName.text")); // NOI18N
        mnuOrderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortNameActionPerformed(evt);
            }
        });
        mnuOptions.add(mnuOrderName);

        mnuOrderDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar.png"))); // NOI18N
        mnuOrderDate.setText(bundle.getString("FrmPrincipal.mnuOrderDate.text")); // NOI18N
        mnuOrderDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortDateActionPerformed(evt);
            }
        });
        mnuOptions.add(mnuOrderDate);
        mnuOptions.add(jSeparator1);

        mnuIncludeType.setSelected(true);
        mnuIncludeType.setText(bundle.getString("FrmPrincipal.mnuIncludeType.text")); // NOI18N
        mnuIncludeType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/type.png"))); // NOI18N
        mnuOptions.add(mnuIncludeType);

        mnuSubfolders.setSelected(true);
        mnuSubfolders.setText(bundle.getString("FrmPrincipal.mnuSubfolders.text")); // NOI18N
        mnuSubfolders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/subfolder.png"))); // NOI18N
        mnuSubfolders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSubpastasActionPerformed(evt);
            }
        });
        mnuOptions.add(mnuSubfolders);

        barMenu.add(mnuOptions);

        mnuHelp.setText(bundle.getString("FrmPrincipal.mnuHelp.text")); // NOI18N
        barMenu.add(mnuHelp);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBeforeAfter)
                .addContainerGap(409, Short.MAX_VALUE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReplace)
                    .addComponent(lblTarget)
                    .addComponent(lblFind)
                    .addComponent(lblExpression))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFind, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTarget, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFile))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtReplace, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFunctions))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFindRegex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindSelected)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTarget)
                    .addComponent(txtTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFind)
                    .addComponent(btnFindRegex)
                    .addComponent(btnFindAll)
                    .addComponent(btnFindSelected))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpression))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReplace)
                    .addComponent(txtReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFunctions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBeforeAfter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-587)/2, (screenSize.height-574)/2, 587, 574);
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
        InputStream is = this.getClass().getResourceAsStream("/icon.png");
        this.setIconImage(ImageIO.read(is));
    }

    private void initSyncListsScroll() {
        //movimentação vertical sincronizada entre as listas de arquivos
        pnlBefore.getVerticalScrollBar().
                addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!lockScroll) {
                    lockScroll = true;
                    pnlAfter.getVerticalScrollBar().setValue(e.getValue());
                    lockScroll = false;
                }
            }

        });

        pnlAfter.getVerticalScrollBar().
                addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!lockScroll) {
                    lockScroll = true;
                    pnlBefore.getVerticalScrollBar().setValue(e.getValue());
                    lockScroll = false;
                }
            }

        });
    }

    private void initExpressionPopUp() {
        this.epu = new ExpressionsPopUp(txtReplace);
    }

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        final JFileChooser fc = new JFileChooser(txtTarget.getText());
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();

                txtTarget.setText(file.getAbsolutePath());

                configureRenamer(true);

            } catch (RenamerException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        Messages.getErrorCaption(), JOptionPane.ERROR_MESSAGE);

                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviewActionPerformed
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
    }//GEN-LAST:event_btnPreviewActionPerformed

    private void mnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenActionPerformed
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
    }//GEN-LAST:event_mnuOpenActionPerformed

    private void mnuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveActionPerformed
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
    }//GEN-LAST:event_mnuSaveActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
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
    }//GEN-LAST:event_btnApplyActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        pnlFiles.setDividerLocation(.5d);
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

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
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
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
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
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnSortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortNameActionPerformed
        renamer.setSortType(SortType.FILE_NAME);
        refreshLists();
    }//GEN-LAST:event_btnSortNameActionPerformed

    private void btnSortDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortDateActionPerformed
        renamer.setSortType(SortType.MODIFIED_DATE);
        refreshLists();
    }//GEN-LAST:event_btnSortDateActionPerformed

    private void txtReplaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReplaceKeyTyped
    }//GEN-LAST:event_txtReplaceKeyTyped

    private void txtReplaceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReplaceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE && evt.isControlDown()) {
            List<String> completeOptions = renamer.queryAutoCompleteOptions(
                    txtReplace.getText(), txtReplace.getCaretPosition());
            if (completeOptions != null && !completeOptions.isEmpty()) {
                epu.showOptions(completeOptions,(JComponent) evt.getSource());
            }

        }
    }//GEN-LAST:event_txtReplaceKeyPressed

    private void btnFindRegexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindRegexActionPerformed
        txtFind.setEnabled(true);
    }//GEN-LAST:event_btnFindRegexActionPerformed

    private void btnFindAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindAllActionPerformed
        txtFind.setEnabled(false);
    }//GEN-LAST:event_btnFindAllActionPerformed

    private void btnFindSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindSelectedActionPerformed
        txtFind.setEnabled(false);
    }//GEN-LAST:event_btnFindSelectedActionPerformed

    private void btnFunctionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunctionsActionPerformed
        List elems = new ArrayList(ElementsDirectory.getInstance().getMapId().
                keySet());
        if (elems != null && !elems.isEmpty()) {
            epu.showOptions(elems,(JComponent) evt.getSource());
        }
    }//GEN-LAST:event_btnFunctionsActionPerformed

    private void validateFields() throws Exception {
        if (txtTarget.getText().trim().equals("") ||
                txtFind.getText().trim().equals("") ||
                txtReplace.getText().trim().equals("")) {
            throw new Exception(Messages.getFieldValidationMessage());
        }
    }

    private void loadCriteria(SavedCriteria criteria) {
        txtTarget.setText(criteria.getPath());
        txtFind.setText(criteria.getSearch());
        txtReplace.setText(criteria.getReplace());
        mnuSubfolders.setSelected(criteria.isIncludeSubfolders());
        mnuIncludeType.setSelected(criteria.isIncludeType());
    }

    private SavedCriteria saveCriteria() {
        SavedCriteria sc = new SavedCriteria();
        sc.setPath(txtTarget.getText());
        sc.setReplace(txtReplace.getText());
        sc.setSearch(txtFind.getText());
        sc.setIncludeSubfolders(mnuSubfolders.isSelected());
        sc.setIncludeType(mnuIncludeType.isSelected());

        return sc;
    }

    private void configureRenamer(boolean refreshLists) throws
            RenamerException {
        if (!"".equals(txtTarget.getText())) {
            renamer.setRootFolder(new File(txtTarget.getText()),
                    mnuSubfolders.isSelected());
        }

        if (!"".equals(txtReplace.getText())) {
            renamer.setReplace(txtReplace.getText());
        }

        if (!"".equals(txtFind.getText())) {
            renamer.setSearch(txtFind.getText());
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
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnFile;
    private javax.swing.JToggleButton btnFindAll;
    private javax.swing.JToggleButton btnFindRegex;
    private javax.swing.JToggleButton btnFindSelected;
    private javax.swing.JButton btnFunctions;
    private javax.swing.JButton btnPreview;
    private javax.swing.JButton btnSortDate;
    private javax.swing.JButton btnSortName;
    private javax.swing.JButton btnUp;
    private javax.swing.ButtonGroup grpCriteria;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblBeforeAfter;
    private javax.swing.JLabel lblExpression;
    private javax.swing.JLabel lblFind;
    private javax.swing.JLabel lblReplace;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTarget;
    private javax.swing.JList lstAntes;
    private javax.swing.JList lstDepois;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JCheckBoxMenuItem mnuIncludeType;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JMenu mnuOptions;
    private javax.swing.JMenuItem mnuOrderDate;
    private javax.swing.JMenuItem mnuOrderName;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JCheckBoxMenuItem mnuSubfolders;
    private javax.swing.JScrollPane pnlAfter;
    private javax.swing.JScrollPane pnlBefore;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JSplitPane pnlFiles;
    private javax.swing.JPanel pnlOrder;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtReplace;
    private javax.swing.JTextField txtTarget;
    // End of variables declaration//GEN-END:variables

}
