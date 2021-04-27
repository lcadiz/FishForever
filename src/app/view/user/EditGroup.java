package app.view.user;


import app.config.DBConn;
import static app.config.DBConn.getConnection;
import static java.awt.EventQueue.invokeLater;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;



public class EditGroup extends javax.swing.JDialog {

    public static GroupPrivileges frmParent;
    static Statement stmt;
    static int grpid;
    static String grpdesc;

    public EditGroup(GroupPrivileges parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        getRootPane().setDefaultButton(cmdsave);
        populateFields();
    }

    public void populateFields() {
        Connection conn = getConnection();
        String createString;
        createString = "SELECT grp_desc "
                + "FROM user_group "
                + "WHERE grp_id=" + grpid;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                txtdesc.setText(rs.getString(1).trim());
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(this, e.getMessage());
        }
    }

    public static void edit_group(String desc, int id) {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE user_group SET grp_desc='" + desc + "' "
                + "WHERE grp_id=" + id;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(createString);
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdcancel = new javax.swing.JButton();
        cmdsave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtdesc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit User Group");
        setResizable(false);

        cmdcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit_1.png"))); // NOI18N
        cmdcancel.setMnemonic('C');
        cmdcancel.setText("Cancel");
        cmdcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcancelActionPerformed(evt);
            }
        });

        cmdsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        cmdsave.setMnemonic('S');
        cmdsave.setText("Save");
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Group Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdcancel))
                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdcancel)
                    .addComponent(cmdsave))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdcancelActionPerformed

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        String grp_desc = txtdesc.getText();

        if (grp_desc.isEmpty() == true) {
            showMessageDialog(null, "Please fill-up all the required fields!");
        } else {
            edit_group(grp_desc, grpid);
            frmParent.populateLst();
            this.dispose();
            showMessageDialog(null, "Changes Successfully Saved!");
        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    public static void main(String args[]) {
        invokeLater(() -> {
            EditGroup dialog = new EditGroup(frmParent, true);
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
    private javax.swing.JButton cmdcancel;
    private javax.swing.JButton cmdsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtdesc;
    // End of variables declaration//GEN-END:variables
}
