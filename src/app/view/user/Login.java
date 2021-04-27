package app.view.user;

import app.view.index.MainFrame;
import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.global.FunctionFactory;
import static app.global.FunctionFactory.convertMD5;
import static app.view.index.MainFrame.userid;
import static java.awt.EventQueue.invokeLater;
import java.awt.Toolkit;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.lang.Class.forName;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login extends javax.swing.JFrame {

    static Statement stmt;
    //public static mdi frmmdi;

    public Login() {
        initComponents();
        setLocationRelativeTo(this);
        getRootPane().setDefaultButton(cmdlogin);
        // this.setSize(548, 342);
    }

    boolean IsValidUser(String uname, String pword) {
        boolean found = false;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM user WHERE user_name='" + uname + "' AND password='" + pword + "'";

        int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                rc++;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        if (rc > 0) {
            found = true;
        }

        return found;
    }

    int GetUserID(String uname, String pword) {
        int UserID = 0;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT user_id FROM user WHERE user_name='" + uname + "' AND password='" + pword + "'";

        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                UserID = rs.getInt(1);
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return UserID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cmdlogin = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();
        txtpword = new javax.swing.JPasswordField();
        txtuname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmdlogin1 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login - Build 20200210");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cmdlogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        cmdlogin.setMnemonic('L');
        cmdlogin.setText("Login");
        cmdlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdloginActionPerformed(evt);
            }
        });

        cmdexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        cmdexit.setMnemonic('x');
        cmdexit.setText("Exit");
        cmdexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdexitActionPerformed(evt);
            }
        });

        txtpword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpword.setForeground(new java.awt.Color(51, 51, 51));
        txtpword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpwordFocusGained(evt);
            }
        });

        txtuname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtuname.setForeground(new java.awt.Color(51, 51, 51));
        txtuname.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txtunameHierarchyChanged(evt);
            }
        });
        txtuname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtunameFocusGained(evt);
            }
        });
        txtuname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtunameMouseClicked(evt);
            }
        });
        txtuname.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtunameCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtuname.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtunameVetoableChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Password:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo5.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Lending Inc.");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("For brevity purpose, Team Norman Lending");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Developed by Bindoy Web Works Inc..");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Licensed to NSQTNLI");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo6.png"))); // NOI18N

        cmdlogin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdlogin1.setMnemonic('L');
        cmdlogin1.setText("Update");
        cmdlogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdlogin1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(cmdlogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cmdexit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(txtuname)
                            .add(txtpword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 225, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel8))
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .add(cmdlogin1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9)
                    .add(layout.createSequentialGroup()
                        .add(11, 11, 11)
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel6)))
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel1)
                    .add(txtuname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(txtpword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdexit)
                    .add(cmdlogin))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 27, Short.MAX_VALUE)
                .add(cmdlogin1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtuname.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void txtunameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtunameFocusGained
        txtuname.selectAll();
    }//GEN-LAST:event_txtunameFocusGained

    private void txtpwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpwordFocusGained
        txtpword.selectAll();
    }//GEN-LAST:event_txtpwordFocusGained

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        exit(0);
    }//GEN-LAST:event_cmdexitActionPerformed

    private void cmdloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdloginActionPerformed
        String uname = txtuname.getText();
        String pword = txtpword.getText();

        String md5pword = convertMD5(pword);

        boolean val = IsValidUser(uname, md5pword); //VALIDATE USER IF VALID

        if (val == false) {
            showMessageDialog(this, "Access Denied! Unauthorized User.");
            txtuname.selectAll();
            txtuname.requestFocus();
            return;
        } else if (val == true) {

            //GET USER ID
            int uid = GetUserID(uname, md5pword);

            //PASS VARIABLE TO MDI CLASS
            userid = uid;

            //            GetFnameAndGender(uname, md5pword);
            //            mdi.fname = fname;
            //            mdi.gender = gender;
            this.dispose();
            try {
                try {
                    try {
                        JFrame frame;
                        frame = (JFrame) forName("app.view.index.MainFrame").newInstance();
                        frame.setIconImage(getDefaultToolkit().getImage("ico.png"));
                        frame.setVisible(true);
                    } catch (IllegalAccessException ex) {
                        getLogger(Login.class.getName()).log(SEVERE, null, ex);
                    }
                } catch (InstantiationException ex) {
                    getLogger(Login.class.getName()).log(SEVERE, null, ex);
                }
            } catch (java.lang.ClassNotFoundException e) {
                showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_cmdloginActionPerformed

    private void txtunameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtunameMouseClicked
        txtuname.selectAll();
    }//GEN-LAST:event_txtunameMouseClicked

    private void txtunameHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txtunameHierarchyChanged

    }//GEN-LAST:event_txtunameHierarchyChanged

    private void txtunameCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtunameCaretPositionChanged

    }//GEN-LAST:event_txtunameCaretPositionChanged

    private void txtunameVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtunameVetoableChange
        txtuname.selectAll();
    }//GEN-LAST:event_txtunameVetoableChange

    private void cmdlogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdlogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdlogin1ActionPerformed

    public static void main(String args[]) {
        invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdexit;
    private javax.swing.JButton cmdlogin;
    private javax.swing.JButton cmdlogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtpword;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
