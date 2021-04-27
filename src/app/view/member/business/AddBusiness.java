/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.member.business;

import app.controller.MemberBusinessController;
import app.view.member.UpdateMember;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author EngkoiZidac
 */
public class AddBusiness extends javax.swing.JDialog {

    public static UpdateMember frmParent;
    public static int Id;
    MemberBusinessController MemBizController = new MemberBusinessController();

    public AddBusiness(UpdateMember parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextDescription = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextLocation = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TextDailyIncome = new javax.swing.JFormattedTextField();
        cmdadd = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Owned Business");

        jLabel1.setText("Name of Business");

        TextDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextDescription.setForeground(new java.awt.Color(51, 51, 51));
        TextDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextDescriptionFocusGained(evt);
            }
        });

        jLabel2.setText("Location");

        TextLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextLocation.setForeground(new java.awt.Color(51, 51, 51));
        TextLocation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextLocationFocusGained(evt);
            }
        });

        jLabel32.setText("Daily Income");

        TextDailyIncome.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        TextDailyIncome.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        cmdadd.setMnemonic('A');
        cmdadd.setText("Add");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextDailyIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TextDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TextDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TextLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel32)
                    .addComponent(TextDailyIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdadd)
                    .addComponent(cmdexit))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextDescriptionFocusGained

    }//GEN-LAST:event_TextDescriptionFocusGained

    private void TextLocationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextLocationFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextLocationFocusGained

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
        if (TextDescription.getText().isEmpty() == true || TextLocation.getText().isEmpty() == true || TextDailyIncome.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
        } else {
            MemBizController.setDescription(TextDescription.getText());
            MemBizController.setLocation(TextLocation.getText());
            MemBizController.setDailyIncome(Double.valueOf(TextDailyIncome.getText().replace(",", "")));
            MemBizController.setFKMemberId(Id);
            MemBizController.Add();
            
            frmParent.PopulateMemberBusinessData();
            this.dispose();
            showMessageDialog(null, "New record successfully added!");
        }
    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

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
            java.util.logging.Logger.getLogger(AddBusiness.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBusiness.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBusiness.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBusiness.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddBusiness dialog = new AddBusiness(frmParent, true);
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
    private javax.swing.JFormattedTextField TextDailyIncome;
    private javax.swing.JTextField TextDescription;
    private javax.swing.JTextField TextLocation;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdexit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    // End of variables declaration//GEN-END:variables
}
