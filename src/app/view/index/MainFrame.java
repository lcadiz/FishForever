/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.index;

import app.global.About;
import static app.config.DBConn.getConnection;
import app.view.user.Login;
import static java.awt.EventQueue.invokeLater;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import static java.lang.Class.forName;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JSeparator;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/**
 *
 * @author Engkoi Zidac
 */
public class MainFrame extends javax.swing.JFrame {

    public static int userid;
    public static int UGID, gender;
    static Statement stmt;
    public static String fname;

    public MainFrame() {
        initComponents();
        LoadStandardMenus(this);
        LoadMainMenus();
    }

    public static int getUserID() {
        return userid;
    }

    public static void ShowManageMemberOnAddNew(int MemberId) {
        try {
            JInternalFrame frm;
            try {
                frm = (JInternalFrame) forName("app.view.member.ManageMember").newInstance();
                MainFrame fm = new MainFrame();
                fm.myDesktop.add(frm);
                try {
                    frm.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    getLogger(MainFrame.class.getName()).log(SEVERE, null, ex);
                }
                frm.setVisible(true);
            } catch (ClassNotFoundException ex) {
                getLogger(MainFrame.class.getName()).log(SEVERE, null, ex);
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            getLogger(MainFrame.class.getName()).log(SEVERE, null, ex);
        }
    }

    void LoadStandardMenus(final JFrame frame) {
        menubar.removeAll();

        //Load Basic Main Menus
        JMenu mnu = new JMenu();
        JMenuItem iLogOff = new JMenuItem();
        JMenuItem iAbout = new JMenuItem();
        JMenuItem iExit = new JMenuItem();
        JMenuItem iSecSet = new JMenuItem();
        JSeparator s = new JSeparator();

        Icon ico1 = new javax.swing.ImageIcon(getClass().getResource("/img/aa.png"));
        mnu.setText("System");
        mnu.setIcon(ico1);
        mnu.setMnemonic('S');

        menubar.add(mnu);

        Icon ico4 = new javax.swing.ImageIcon(getClass().getResource("/img/secset.png"));
        iSecSet.setIcon(ico4);
        iSecSet.setText("My User Account Settings");
        iSecSet.setMnemonic('y');

        Icon ico5 = new javax.swing.ImageIcon(getClass().getResource("/img/myinquiry.png"));
        iAbout.setIcon(ico5);
        iAbout.setText("About");
        iAbout.setMnemonic('A');

        Icon ico2 = new javax.swing.ImageIcon(getClass().getResource("/img/logoff2.png"));
        iLogOff.setIcon(ico2);
        iLogOff.setText("Log-off");
        iLogOff.setMnemonic('L');

        Icon ico3 = new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"));
        iExit.setText("Exit");
        iExit.setIcon(ico3);
        iExit.setMnemonic('x');

        //iExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        mnu.add(iSecSet);
        mnu.add(iAbout);
        mnu.add(iLogOff);
        mnu.add(s);
        mnu.add(iExit);

        //--Basic Menus End Here
        //Action Listener for basic menus
        iSecSet.addActionListener((ActionEvent e) -> {
            //Execute when Logoff button is pressed
            //frame.dispose();
            //sec_set frm = new sec_set();
            //sec_set.userid = userid;
            //myDesktop.add(frm);
            //frm.setVisible(true);
        });

        iAbout.addActionListener((ActionEvent e) -> {
            //Execute when Logoff button is pressed
            // frame.dispose();
            
            About frm = new About();
            myDesktop.add(frm);
            // frm.setIconImage(Toolkit.getDefaultToolkit().getImage("ico.png"));
            frm.setVisible(true);
        });

        iLogOff.addActionListener((ActionEvent e) -> {
            //Execute when Logoff button is pressed
            frame.dispose();
            Login frm = new Login();
            frm.setIconImage(getDefaultToolkit().getImage("ico.png"));
            frm.setVisible(true);
        });

        iExit.addActionListener((ActionEvent e) -> {
            //Execute when Exit button is pressed
            exit(0);
        });

        frame.setJMenuBar(menubar);
        frame.pack();
    }

    void LoadMainMenus() {
        Connection conn = getConnection();
        String createString;
        //QUERY - GROUP ALL MENU HEADER TO BE ABLE TO DISPLAY IT IN MDI FORM
        createString = "SELECT mi.menu_id, m.menu_caption, m.mnemonic, m.icon_path FROM user_group_assigned uga, "
                + "user_group_privilege ugp, user_privilege up,  "
                + "gui_menu_item mi,gui_menu m  "
                + "WHERE uga.grp_id=ugp.grp_id AND ugp.privilege_id=up.privilege_id  "
                + "AND mi.menu_item_id=up.menu_item_id AND m.menu_id=mi.menu_id AND uga.user_id=" + userid + " "
                + "GROUP BY mi.menu_id ORDER BY m.seq";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                String shrt = rs.getString(3);
                char monic = shrt.charAt(0);
                Icon ico = new javax.swing.ImageIcon(getClass().getResource(rs.getString(4)));
//
                JMenu mnu = new JMenu();
                mnu.setMnemonic(monic);
                mnu.setIcon(ico);
                mnu.setText(rs.getString(2));
                menubar.add(mnu);

                LoadMenuItems(rs.getInt(1), mnu);
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
        }
    }

    void LoadMenuItems(int menuid, JMenu mnu) {
        Connection conn = getConnection();
        String createString;
        //QUERY - LOAD MENUITEMS
        createString = "SELECT mi.menu_item_id, mi.menu_item_caption, mi.mnemonic, up.class_path, mi.icon_path, up.type, mi.flg FROM user_group_assigned uga, "
                + "user_group_privilege ugp, user_privilege up, "
                + "gui_menu_item mi,gui_menu m "
                + "WHERE uga.grp_id=ugp.grp_id AND ugp.privilege_id=up.privilege_id  "
                + "AND mi.menu_item_id=up.menu_item_id AND m.menu_id=mi.menu_id AND uga.user_id=" + userid + " AND mi.menu_id=" + menuid + " "
                + "GROUP BY menu_item_id ORDER BY mi.seq ";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                if (rs.getInt("flg") == 1) {
                    mnu.addSeparator();
                } else {
                    Icon ico = new javax.swing.ImageIcon(getClass().getResource(rs.getString(5)));

                    String shrt = rs.getString(3);
                    char monic = shrt.charAt(0);

                    JMenuItem mnuI = new JMenuItem();

                    mnuI.setText(rs.getString(2));
                    mnuI.setMnemonic(monic);
                    mnuI.setIcon(ico);
                    mnu.add(mnuI);

                    //Action Listener for basic menus
                    final String cls = rs.getString(4);
                    final int disp = rs.getInt(6);

                    mnuI.addActionListener((ActionEvent e) -> {
                        //Execute when Logoff button is pressed
                        try {
                            try {
                                if (disp < 3) {
                                    JInternalFrame frame = (JInternalFrame) forName(cls).newInstance();
                                    myDesktop.add(frame);
                                    if (disp == 1) {
                                        try {
                                            frame.setMaximum(true);
                                        } catch (PropertyVetoException ex) {
                                            getLogger(MainFrame.class.getName()).log(SEVERE, null, ex);
                                        }
                                    }
                                    frame.setVisible(true);
                                } else {
                                    JFrame frame = (JFrame) forName(cls).newInstance();
                                    frame.setVisible(true);
                                }
                            } catch (IllegalAccessException | InstantiationException ex) {
                                getLogger(MainFrame.class.getName()).log(SEVERE, null, ex);
                            }
                        } catch (java.lang.ClassNotFoundException se) {
                            showMessageDialog(null, se.getMessage());
                        }
                    } //PUT ACTION ON MENUITEM CLICK
                    );
                }
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myDesktop = new javax.swing.JDesktopPane();
        menubar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NSQ Team Norman Lending Inc.");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        myDesktop.setBackground(new java.awt.Color(153, 153, 153));
        myDesktop.setToolTipText("");
        myDesktop.setName("mmmm"); // NOI18N

        javax.swing.GroupLayout myDesktopLayout = new javax.swing.GroupLayout(myDesktop);
        myDesktop.setLayout(myDesktopLayout);
        myDesktopLayout.setHorizontalGroup(
            myDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        myDesktopLayout.setVerticalGroup(
            myDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(myDesktop))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //       bck.setBounds(0, 0, myDesktop.getWidth(), myDesktop.getHeight());
        //bck.requestFocus();
    }//GEN-LAST:event_formWindowOpened

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
            getLogger(MainFrame.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menubar;
    private javax.swing.JDesktopPane myDesktop;
    // End of variables declaration//GEN-END:variables
}
