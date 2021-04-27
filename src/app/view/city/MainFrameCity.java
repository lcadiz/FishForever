/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.city;

import app.controller.CityController;
import app.controller.ProvinceController;
import static app.global.FunctionFactory.msgboxYesNo;
import app.model.ComboBoxItem;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Engkoi Zidac
 */
public final class MainFrameCity extends javax.swing.JInternalFrame {

    public static AddCity frmNew;
    public static EditCity frmEdit;
    private static int ComboBoxProvinceId;
    ProvinceController ProvinceController = new ProvinceController();

    CityController Controller = new CityController();

    public MainFrameCity() {
        initComponents();
        ProvinceController.PopulateComboBoxData(ComboProvince);
        PopulateData();
    }

    public void PopulateData() {
        Controller.PopulateTableData(Table, ComboBoxProvinceId, txtsearch.getText());
    }

    public void ShowFrmNew() {
        frmNew = new AddCity(this, true);
        frmNew.setVisible(true);
    }

    public void ShowFrmEdit() {
        frmEdit = new EditCity(this, true);
        frmEdit.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        txtsearch = new org.jdesktop.swingx.JXSearchField();
        ComboProvince = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        AddButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        AddButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("City/Municipality");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "City/Municipality"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Table);
        Table.getColumnModel().getColumn(1).setPreferredWidth(850);

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        ComboProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProvinceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Province");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ComboProvince, 0, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(ComboProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jToolBar1.add(jPanel2);
        jToolBar1.add(jSeparator1);

        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        AddButton.setMnemonic('A');
        AddButton.setText("Add      ");
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
        jToolBar1.add(AddButton);

        EditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditButton.setMnemonic('E');
        EditButton.setText("Edit      ");
        EditButton.setToolTipText("Edit Selected Record");
        EditButton.setFocusable(false);
        EditButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        EditButton.setIconTextGap(8);
        EditButton.setVerifyInputWhenFocusTarget(false);
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(EditButton);

        AddButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton2.setMnemonic('R');
        AddButton2.setText("Remove       ");
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
        jToolBar1.add(AddButton2);
        jToolBar1.add(jSeparator2);

        AddButton3.setMnemonic('e');
        AddButton3.setText("                ");
        AddButton3.setToolTipText("Reset Password to Default");
        AddButton3.setFocusable(false);
        AddButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddButton3.setIconTextGap(8);
        AddButton3.setVerifyInputWhenFocusTarget(false);
        jToolBar1.add(AddButton3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        int col = 0; //set column value to 0
        int row = Table.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (ComboBoxProvinceId == 0) {
            showMessageDialog(this, "No record selected! Please select a province from the list!");
        } else {
            AddCity.ComboBoxProvinceId = ComboBoxProvinceId;
            ShowFrmNew();
        }


    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int col = 0; //set column value to 0
        int row = Table.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (Table.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = Table.getValueAt(row, col).toString();
            EditCity.id = Integer.valueOf(id);

            ShowFrmEdit();
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void AddButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton2ActionPerformed
        int col = 0; //set column value to 0
        int row = Table.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (Table.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = Table.getValueAt(row, col).toString();
            int i = msgboxYesNo("Are you sure you want to delete this record");
            switch (i) {
                case 0:
                    Controller.setCityId(Integer.valueOf(id));
                    Controller.Remove();
                    PopulateData();
                    showMessageDialog(null, "Successfully Removed!");
                    break;
                case 1:
                    break;
                case 2:
                    this.dispose(); //exit window
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_AddButton2ActionPerformed

    private void ComboProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProvinceActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboProvince.getSelectedItem();
            ComboBoxProvinceId = item.getId();
        } catch (Exception e) {
        }
        PopulateData();
    }//GEN-LAST:event_ComboProvinceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton AddButton2;
    private javax.swing.JButton AddButton3;
    private javax.swing.JComboBox<String> ComboProvince;
    private javax.swing.JButton EditButton;
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.swingx.JXSearchField txtsearch;
    // End of variables declaration//GEN-END:variables
}
