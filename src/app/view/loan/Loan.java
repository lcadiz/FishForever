/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.loan;

import app.controller.LoanController;
import static java.awt.EventQueue.invokeLater;
import static java.lang.System.exit;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.table.TableColumn;

/**
 *
 * @author EngkoiZidac
 */
public class Loan extends javax.swing.JDialog {

    public static ManageLoan frmParent;
    public static int Id;
    public static String MemberName;
    public static NewLoan frmNewLoan;
    public static LoanLedger frmLoanLedger;
    LoanController Controller = new LoanController();

    public Loan(ManageLoan parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);

        this.setTitle("Loan Records : " + MemberName);
        PopulateData();

    }

    public void ShowFrmNewLoan() {
        frmNewLoan = new NewLoan(this, true);
        frmNewLoan.setVisible(true);
    }

    public void ShowFrmLoanLedger() {
        frmLoanLedger = new LoanLedger(this, true);
        frmLoanLedger.setVisible(true);
    }

    public void PopulateData() {
        Controller.PopulateTableData(Table, Id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar3 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        AddButton1 = new javax.swing.JButton();
        AddButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        AddButton = new javax.swing.JButton();
        AddButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loan Records");

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setBorderPainted(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jToolBar3.add(jPanel4);

        AddButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/printer.png"))); // NOI18N
        AddButton1.setMnemonic('P');
        AddButton1.setText("Print Loan Disclosure      ");
        AddButton1.setToolTipText("Print Loan Disclosure      ");
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

        AddButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new1.png"))); // NOI18N
        AddButton3.setMnemonic('A');
        AddButton3.setText("Loan Ledger      ");
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
        jToolBar3.add(jSeparator1);

        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loan.png"))); // NOI18N
        AddButton.setMnemonic('A');
        AddButton.setText("New Loan      ");
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

        AddButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton2.setMnemonic('R');
        AddButton2.setText("Cancel Loan      ");
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
                "id", "TransDate", "Referrence", "Loan Type", "Interest", "Term", "Principal Amount", "Date Released"
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
        Table.getColumnModel().getColumn(1).setPreferredWidth(200);
        Table.getColumnModel().getColumn(2).setPreferredWidth(200);
        Table.getColumnModel().getColumn(3).setPreferredWidth(200);
        Table.getColumnModel().getColumn(4).setPreferredWidth(100);
        Table.getColumnModel().getColumn(5).setPreferredWidth(100);
        Table.getColumnModel().getColumn(6).setPreferredWidth(150);
        Table.getColumnModel().getColumn(7).setPreferredWidth(150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed

        NewLoan.Id = Id;
        NewLoan.nym = MemberName;
        ShowFrmNewLoan();

    }//GEN-LAST:event_AddButtonActionPerformed

    private void AddButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton3ActionPerformed
        int col = 0; //set column value to 0
        int row = Table.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (Table.isRowSelected(row) != true) {
            JOptionPane.showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = Table.getValueAt(row, col).toString();
            LoanLedger.Id = Integer.parseInt(id);
            LoanLedger.nym=  MemberName;
            ShowFrmLoanLedger();
        }
    }//GEN-LAST:event_AddButton3ActionPerformed

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
            getLogger(Loan.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        invokeLater(() -> {
            Loan dialog = new Loan(frmParent, true);
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
    private javax.swing.JTable Table;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar3;
    // End of variables declaration//GEN-END:variables
}
