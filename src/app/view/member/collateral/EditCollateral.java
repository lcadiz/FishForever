/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.member.collateral;

import app.controller.CollateralController;
import app.controller.MemberCollateralController;
import app.global.FunctionFactory;
import app.model.ComboBoxItem;
import app.view.member.UpdateMember;

/**
 *
 * @author EngkoiZidac
 */
public class EditCollateral extends javax.swing.JDialog {

    public static UpdateMember frmParent;
    public static int MCollateralId;
    CollateralController CollateralController = new CollateralController();
    MemberCollateralController Controller = new MemberCollateralController();
    public static int CollateralId;
    
    public EditCollateral(UpdateMember parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        PopulateFields();
    }

   
    void PopulateFields() {
        //System.out.println(Controller.getDetails());
        Controller.setMCollateralId(MCollateralId);
        Controller.PopulateDataOnEdit();
        TextDetails.setText(Controller.getDetails());
        TextValue.setText(FunctionFactory.amountFormat(Controller.getValue()));
        
        CollateralController.setCollateralId(Controller.getFKCollateralId());
        CollateralController.PopulateComboBoxDataOnEdit(ComboType);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel32 = new javax.swing.JLabel();
        TextValue = new javax.swing.JFormattedTextField();
        cmdadd = new javax.swing.JButton();
        ComboType = new javax.swing.JComboBox<>();
        cmdexit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextDetails = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Collateral");

        jLabel32.setText("Value");

        TextValue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        TextValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        cmdadd.setMnemonic('S');
        cmdadd.setText("Save");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
            }
        });

        ComboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTypeActionPerformed(evt);
            }
        });

        cmdexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        cmdexit.setMnemonic('C');
        cmdexit.setText("Cancel");
        cmdexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdexitActionPerformed(evt);
            }
        });

        jLabel1.setText("Type of Collateral");

        jLabel2.setText("Details");

        TextDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextDetails.setForeground(new java.awt.Color(51, 51, 51));
        TextDetails.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextDetailsFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextValue, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addComponent(TextDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel32)
                    .addComponent(TextValue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdadd)
                    .addComponent(cmdexit))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
//        if ("--SELECT--".equals(ComboType.getSelectedItem().toString()) || TextDetails.getText().isEmpty() == true || TextValue.getText().isEmpty() == true) {
//            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
//        } else {
//            Controller.setFKCollateralId(CollateralId);
//            Controller.setDetails(TextDetails.getText());
//            Controller.setValue(Double.valueOf(TextValue.getText().replace(",", "")));
//            Controller.setFKMemberID(Id);
//            Controller.Add();
//
//            frmParent.PopulateMemberControllerData();
//            this.dispose();
//            showMessageDialog(null, "New record successfully added!");
//        }
    }//GEN-LAST:event_cmdaddActionPerformed

    private void ComboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTypeActionPerformed
        CollateralId = 0;

        try {
            ComboBoxItem item = (ComboBoxItem) ComboType.getSelectedItem();
            CollateralId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboTypeActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void TextDetailsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextDetailsFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDetailsFocusGained

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditCollateral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCollateral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCollateral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCollateral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditCollateral dialog = new EditCollateral(frmParent, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboType;
    private javax.swing.JTextField TextDetails;
    private javax.swing.JFormattedTextField TextValue;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdexit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    // End of variables declaration//GEN-END:variables
}
