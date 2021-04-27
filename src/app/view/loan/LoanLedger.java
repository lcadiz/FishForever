/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.loan;

import app.controller.LoanLedgerController;
import app.global.FunctionFactory;
import static java.awt.EventQueue.invokeLater;
import static java.lang.System.exit;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.table.TableColumn;

/**
 *
 * @author EngkoiZidac
 */
public class LoanLedger extends javax.swing.JDialog {

    public static Loan frmParent;
    LoanLedgerController Controller = new LoanLedgerController();
    public static int Id;
    public static String nym;
    public static PostPayment frmPostPayment;
    public static AddOns frmAddOns;
    public static Renew frmRenew;

    public LoanLedger(Loan parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);

        TableColumn idClmn = Table.getColumn("id");
        idClmn.setMaxWidth(0);
        idClmn.setMinWidth(0);
        idClmn.setPreferredWidth(0);
        PopulateData();
        lblbal.setText(FunctionFactory.amountFormat(Controller.GetRunningBalance(Id)));
    }

    public void PopulateData() {
        Controller.PopulateTableData(Table, Id);
    }

    public void ShowFrmPostPayment() {
        frmPostPayment = new PostPayment(this, true);
        frmPostPayment.setVisible(true);
    }

    public void ShowFrmAddOns() {
        frmAddOns = new AddOns(this, true);
        frmAddOns.setVisible(true);
    }

    public void ShowFrmRenew() {
        frmRenew = new Renew(this, true);
        frmRenew.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar3 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        AddButton3 = new javax.swing.JButton();
        AddButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        AddButton = new javax.swing.JButton();
        AddButton1 = new javax.swing.JButton();
        AddButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblbal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loan Ledger");

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setBorderPainted(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jToolBar3.add(jPanel4);

        AddButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        AddButton3.setMnemonic('A');
        AddButton3.setText("Renew      ");
        AddButton3.setToolTipText("Open Loan Ledger");
        AddButton3.setFocusable(false);
        AddButton3.setHideActionText(true);
        AddButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton3.setIconTextGap(8);
        AddButton3.setVerifyInputWhenFocusTarget(false);
        AddButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton3ActionPerformed(evt);
            }
        });
        jToolBar3.add(AddButton3);

        AddButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/payroll.png"))); // NOI18N
        AddButton4.setMnemonic('A');
        AddButton4.setText("Add-ons      ");
        AddButton4.setToolTipText("Open Loan Ledger");
        AddButton4.setFocusable(false);
        AddButton4.setHideActionText(true);
        AddButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton4.setIconTextGap(8);
        AddButton4.setVerifyInputWhenFocusTarget(false);
        AddButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton4ActionPerformed(evt);
            }
        });
        jToolBar3.add(AddButton4);
        jToolBar3.add(jSeparator1);

        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loan.png"))); // NOI18N
        AddButton.setMnemonic('A');
        AddButton.setText("Post Payment      ");
        AddButton.setToolTipText("Add New Record");
        AddButton.setFocusable(false);
        AddButton.setHideActionText(true);
        AddButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton.setIconTextGap(8);
        AddButton.setVerifyInputWhenFocusTarget(false);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jToolBar3.add(AddButton);

        AddButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        AddButton1.setMnemonic('E');
        AddButton1.setText("Update    ");
        AddButton1.setToolTipText("Update Selected Record");
        AddButton1.setFocusable(false);
        AddButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton1.setIconTextGap(8);
        AddButton1.setVerifyInputWhenFocusTarget(false);
        AddButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton1ActionPerformed(evt);
            }
        });
        jToolBar3.add(AddButton1);

        AddButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton2.setMnemonic('R');
        AddButton2.setText("Cancel");
        AddButton2.setToolTipText("Remove Selected Record");
        AddButton2.setFocusable(false);
        AddButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton2.setIconTextGap(8);
        AddButton2.setVerifyInputWhenFocusTarget(false);
        AddButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton2ActionPerformed(evt);
            }
        });
        jToolBar3.add(AddButton2);
        jToolBar3.add(jSeparator2);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "TransDate", "Referrence", "Particular", "Principal Amount/Add-ons", "Amount Paid", "Balance", "DatePaid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(Table);
        Table.getColumnModel().getColumn(1).setPreferredWidth(100);
        Table.getColumnModel().getColumn(2).setPreferredWidth(100);
        Table.getColumnModel().getColumn(3).setPreferredWidth(200);
        Table.getColumnModel().getColumn(4).setPreferredWidth(200);
        Table.getColumnModel().getColumn(5).setPreferredWidth(100);
        Table.getColumnModel().getColumn(6).setPreferredWidth(100);
        Table.getColumnModel().getColumn(7).setPreferredWidth(100);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Balance");

        lblbal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblbal.setForeground(new java.awt.Color(255, 0, 0));
        lblbal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblbal.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblbal, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbal, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        PostPayment.Id = Id;
        PostPayment.nym = nym;
        ShowFrmPostPayment();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void AddButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton1ActionPerformed
        //        int col = 0; //set column value to 0
        //        int row = Table.getSelectedRow(); //get value of selected value
        //
        //        //trap user incase if no row selected
        //        if (Table.isRowSelected(row) != true) {
        //            JOptionPane.showMessageDialog(this, "No record selected! Please select a record from the list!");
        //        } else {
        //            String id = Table.getValueAt(row, col).toString();
        //            UpdateMember.Id = Short.valueOf(id);
        //            ShowFrmUpdate();
        //        }
    }//GEN-LAST:event_AddButton1ActionPerformed

    private void AddButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton2ActionPerformed

    }//GEN-LAST:event_AddButton2ActionPerformed

    private void AddButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton3ActionPerformed
        Renew.Id = Id;
        Renew.nym = nym;
        ShowFrmRenew();
    }//GEN-LAST:event_AddButton3ActionPerformed

    private void AddButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton4ActionPerformed
        AddOns.Id = Id;
        AddOns.nym = nym;
        ShowFrmAddOns();
    }//GEN-LAST:event_AddButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(LoanLedger.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        invokeLater(() -> {
            LoanLedger dialog = new LoanLedger(frmParent, true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton AddButton1;
    private javax.swing.JButton AddButton2;
    private javax.swing.JButton AddButton3;
    private javax.swing.JButton AddButton4;
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lblbal;
    // End of variables declaration//GEN-END:variables
}
