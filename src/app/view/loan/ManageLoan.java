/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.loan;

import app.controller.MemberController;
import static app.view.loan.Loan.Id;
import static app.view.loan.Loan.MemberName;
import static java.lang.Short.valueOf;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.TableColumn;

/**
 *
 * @author EngkoiZidac
 */
public class ManageLoan extends javax.swing.JInternalFrame {

    MemberController Controller = new MemberController();
    public static Loan frmLoan;

    public ManageLoan() {
        initComponents();

        TableColumn idClmn = Table.getColumn("id");
        idClmn.setMaxWidth(0);
        idClmn.setMinWidth(0);
        idClmn.setPreferredWidth(0);
    }

    public void ShowFrmUpdate() {
        frmLoan = new Loan(this, true);
        frmLoan.setVisible(true);
    }

    public void PopulateData() {
        Controller.PopulateTableData(Table, TextSearch.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        TextSearch = new org.jdesktop.swingx.JXSearchField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        AddButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Loan Management");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name of Member", "Area", "Member Group", "Salary Schedule"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(Table);
        Table.getColumnModel().getColumn(1).setPreferredWidth(400);
        Table.getColumnModel().getColumn(2).setPreferredWidth(200);
        Table.getColumnModel().getColumn(3).setPreferredWidth(200);
        Table.getColumnModel().getColumn(4).setPreferredWidth(400);

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setBorderPainted(false);

        TextSearch.setLayoutStyle(org.jdesktop.swingx.JXSearchField.LayoutStyle.MAC);
        TextSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(TextSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar3.add(jPanel4);
        jToolBar3.add(jSeparator1);

        AddButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/book1.png"))); // NOI18N
        AddButton1.setMnemonic('p');
        AddButton1.setText("Open Loan Records    ");
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
        jToolBar3.add(jSeparator2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton1ActionPerformed
        int col = 0; //set column value to 0
        int row = Table.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (Table.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = Table.getValueAt(row, col).toString();
            String MemberName = Table.getValueAt(row, 1).toString();
            Loan.MemberName=MemberName;
            Loan.Id = Integer.valueOf(id);
            ShowFrmUpdate();
        }
    }//GEN-LAST:event_AddButton1ActionPerformed

    private void TextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSearchActionPerformed
        PopulateData();
    }//GEN-LAST:event_TextSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton1;
    private javax.swing.JTable Table;
    private org.jdesktop.swingx.JXSearchField TextSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar3;
    // End of variables declaration//GEN-END:variables
}
