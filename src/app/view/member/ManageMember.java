/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.member;

import app.controller.MemberController;
import static app.view.member.UpdateMember.Id;
import static java.lang.Short.valueOf;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.TableColumn;

/**
 *
 * @author EngkoiZidac
 */
public class ManageMember extends javax.swing.JInternalFrame {

    MemberController Controller = new MemberController();
    public static UpdateMember frmUpdate;

    public ManageMember() {
        initComponents();       
        PopulateData();
    }
    
    public void ShowFrmUpdate() {
        frmUpdate = new UpdateMember(this, true);
        frmUpdate.setVisible(true);
    }

    public void PopulateData() {
        Controller.PopulateTableData(Table, TextSearch.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        TextSearch = new org.jdesktop.swingx.JXSearchField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        AddButton1 = new javax.swing.JButton();
        AddButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Member Record Management");

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
        jScrollPane1.setViewportView(Table);
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
                .addContainerGap()
                .addComponent(TextSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar3.add(jPanel4);
        jToolBar3.add(jSeparator1);

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
        AddButton2.setText("Remove   ");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
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
            Id = valueOf(id);
            ShowFrmUpdate();
        }
    }//GEN-LAST:event_AddButton1ActionPerformed

    private void AddButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton2ActionPerformed

    }//GEN-LAST:event_AddButton2ActionPerformed

    private void TextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSearchActionPerformed
        PopulateData();
    }//GEN-LAST:event_TextSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton1;
    private javax.swing.JButton AddButton2;
    private javax.swing.JTable Table;
    private org.jdesktop.swingx.JXSearchField TextSearch;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar3;
    // End of variables declaration//GEN-END:variables
}
