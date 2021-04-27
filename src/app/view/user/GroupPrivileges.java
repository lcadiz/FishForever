package app.view.user;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.global.FunctionFactory;
import static app.global.FunctionFactory.msgboxYesNo;
import static app.view.user.EditGroup.grpdesc;
import static app.view.user.EditGroup.grpid;
import java.awt.Component;
import java.awt.event.ItemEvent;
import static java.awt.event.ItemEvent.SELECTED;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class GroupPrivileges extends javax.swing.JInternalFrame {

    static Statement stmt;
    public static int scaleid;
    static DefaultTableCellRenderer cellAlignCenterRenderer = new DefaultTableCellRenderer();
    static DefaultTableCellRenderer cellAlignRightRenderer = new DefaultTableCellRenderer();
    static DefaultTableModel model;
    public static boolean chk;
    public static AddGroup frmNew;
    public static EditGroup frmEdit;
    protected CheckBoxHeader rendererComponent;
    protected boolean mousePressed = true;
    static int ugid;

    public GroupPrivileges() {
        initComponents();
        populatecombo();
        populateLst();
        chk = false;

        TableColumn tc = tbl.getColumnModel().getColumn(0);
        tc.setCellEditor(tbl.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tbl.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
        rendererComponent.setSelected(false);
        
        String txt="<html>List of User Group Privileges  <font color=#E7C30F>(NOTE: All Checked items are the modules that the user group is allowed to access.)</font></html>";
        lbl.setText(txt);
    }

    
        class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == SELECTED;
            for (int x = 0, y = tbl.getRowCount(); x < y; x++) {
                tbl.setValueAt(checked, x, 0);
            }
        }
    }

    ////////////////////////////////////////
    class CheckBoxHeader extends JCheckBox
            implements TableCellRenderer, MouseListener {

        protected int column;

        public CheckBoxHeader(ItemListener itemListener) {
            rendererComponent = this;
            rendererComponent.addItemListener(itemListener);
        }

        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    rendererComponent.setForeground(header.getForeground());
                    rendererComponent.setBackground(header.getBackground());
                    rendererComponent.setFont(header.getFont());


                    header.addMouseListener(rendererComponent);
                }
            }
            setColumn(column);
            rendererComponent.setText("Check All");
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return rendererComponent;
        }

        protected void setColumn(int column) {
            this.column = column;
        }

        public int getColumn() {
            return column;
        }

        protected void handleClickEvent(MouseEvent e) {

            if (mousePressed) {
                mousePressed = false;
                JTableHeader header = (JTableHeader) (e.getSource());
                JTable tableView = header.getTable();
                TableColumnModel columnModel = tableView.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int column = tableView.convertColumnIndexToModel(viewColumn);

                if (viewColumn == this.column && e.getClickCount() == 1 && column != -1) {
                    doClick();
                }
            }
        }

        public void mouseClicked(MouseEvent e) {
            handleClickEvent(e);
            ((Component) e.getSource()).repaint();
        }

        public void mousePressed(MouseEvent e) {
            mousePressed = true;
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    ////////////////////////////////////////
    
    
    public void ShowFrmNew() {
        frmNew = new AddGroup(this, true);
        frmNew.setVisible(true);
    }

    public void ShowFrmEdit() {
        frmEdit = new EditGroup(this, true);
        frmEdit.setVisible(true);
    }

    void populatecombo() {
        //Populate Combo Area
        cmbmenu.addItem("--ALL--");
        Connection conn = getConnection();
        String createString;
        createString = "SELECT menu_caption FROM gui_menu";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                cmbmenu.addItem(rs.getString(1));
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, "Error RSQuery/004: Query Select All Areas!");
        }
    }

    public void populateTBL(String wat) {
        Connection conn = getConnection();
        String createString;
        createString = "SELECT privilege_id, mi.menu_item_caption, privilege_desc, m.menu_caption, mi.mini_icon_path "
                + "FROM user_privilege up, gui_menu_item mi, gui_menu m "
                + "WHERE up.menu_item_id=mi.menu_item_id AND m.menu_id=mi.menu_id "
                + "AND m.menu_caption LIKE '" + wat + "%' AND mi.flg=0 "
                + "ORDER BY m.menu_id, mi.seq";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            model = (DefaultTableModel) tbl.getModel();

            cellAlignCenterRenderer.setHorizontalAlignment(0);
            cellAlignRightRenderer.setHorizontalAlignment(RIGHT);

            tbl.setRowHeight(22);
            //tbl.getColumnModel().getColumn(0).setCellRenderer(cellAlignCenterRenderer);
            tbl.getColumnModel().getColumn(1).setCellRenderer(cellAlignCenterRenderer);

            tbl.setColumnSelectionAllowed(false);

            TableColumn idClmn = tbl.getColumn("id");
            idClmn.setMaxWidth(0);
            idClmn.setMinWidth(0);
            idClmn.setPreferredWidth(0);

            model.setNumRows(0);

            int cnt = 0;

            while (rs.next()) {
                // String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                  //      + "<tr><td><img src="+getClass().getResource(rs.getString(5))+">&nbsp</td><td>"+rs.getString(2)+"</td></th>";
                model.addRow(new Object[]{chk, rs.getString(1),rs.getString(2), rs.getString(4), rs.getString(3)});
                cnt++;
            }

            stmt.close();
            conn.close();

            //lblitemcount.setText("Item/s Found: " + cnt);

        } catch (SQLException e) {
            showMessageDialog(this, e.getMessage());
        }
    }

    void populateLst() {
        //Populate Combo Area
        Connection conn = getConnection();
        String createString;
        createString = "SELECT grp_id, grp_desc FROM user_group ORDER BY grp_desc ";

        try {
            DefaultListModel model = new DefaultListModel();
            this.lst.setModel(model);

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);


            while (rs.next()) {
                String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src="+getClass().getResource("/img/group.png")+">&nbsp</td><td>"+rs.getString(2)+"</td></th>";
                model.addElement(new Item(rs.getInt(1),lbl));
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, "Error RSQuery/004: Query!");
        }
    }

    class Item {

        private int id;
        private String description;

        public Item(int id, String description) {
            this.id = id;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String toString() {
            return description;
        }
    }

    public void remove_group(int id) {
        Connection conn = getConnection();
        String createString;
        createString = "DELETE FROM user_group "
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

    void LoadAllowedModules() {
        try {
            Item item = (Item) lst.getSelectedValue();
            int id = item.getId();
            ugid=id;
            out.println(ugid);
            setPrevModules(id);
        } catch (Exception e) {
        }
    }

    public void setPrevModules(int ugid) {
        int col = 1;



        int rows = tbl.getModel().getRowCount();
        for (int i = 0; i < rows; i++) {
            String value = (String) tbl.getModel().getValueAt(i, col);
            //String selTF = tbl.getValueAt(i, 0).toString();

            boolean isAllowed = isAllowed(ugid, parseInt(value));

            if (isAllowed == true) {
                tbl.setValueAt(true, i, 0);
            } else if (isAllowed == false) {
                tbl.setValueAt(false, i, 0);
            }
        }
    }

    boolean isAllowed(int ugid, int previd) {
        boolean isallow = false;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT grp_privilege_id FROM user_group_privilege WHERE grp_id=" + ugid + " AND privilege_id=" + previd;
        //stmtIncomingShed

        int rfound = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                rfound++;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }


        if (rfound > 0) {
            isallow = true;
        }

        return isallow;
    }

    public void saveChanges(int ugid) {
        int col = 1;

        int rows = tbl.getModel().getRowCount();
        for (int i = 0; i < rows; i++) {
            String value = (String) tbl.getModel().getValueAt(i, col);
            String selTF = tbl.getValueAt(i, 0).toString();

            boolean isAllowed = isAllowed(ugid, parseInt(value));

            if (isAllowed == true) {
                if ("false".equals(selTF)) {
                    DeletePriv(ugid, parseInt(value));
                }
            } else if (isAllowed == false) {
                if ("true".equals(selTF)) {
                    AddPriv(ugid, parseInt(value));
                }
            }
        }
    }

    public static void AddPriv(int ugid, int previd) {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO user_group_privilege(grp_id, privilege_id) "
                + "VALUES (" + ugid + "," + previd + ")";


        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(createString);
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public static void DeletePriv(int ugid, int previd) {
        Connection conn = getConnection();
        String createString;
        createString = "DELETE FROM user_group_privilege WHERE grp_id=" + ugid + " AND privilege_id=" + previd;


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

        jScrollPane1 = new javax.swing.JScrollPane();
        lst = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        cmbmenu = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmdadd = new javax.swing.JButton();
        cmdrename = new javax.swing.JButton();
        cmdremove = new javax.swing.JButton();
        cmdsave = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("User Group Privileges Management");

        lst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstMouseReleased(evt);
            }
        });
        lst.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lst);

        jLabel1.setDisplayedMnemonic('p');
        jLabel1.setLabelFor(lst);
        jLabel1.setText("List of User Group");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "id", "Menu Item Caption", "Main Menu", "Privilege Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(1).setResizable(false);
        }
        tbl.getColumnModel().getColumn(0).setMaxWidth(18);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(410);

        cmbmenu.setEnabled(false);
        cmbmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmenuActionPerformed(evt);
            }
        });

        jLabel2.setDisplayedMnemonic('u');
        jLabel2.setLabelFor(cmbmenu);
        jLabel2.setText("Main Menu/s:");

        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        cmdadd.setMnemonic('A');
        cmdadd.setText("Add");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
            }
        });

        cmdrename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        cmdrename.setMnemonic('e');
        cmdrename.setText("Rename");
        cmdrename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdrenameActionPerformed(evt);
            }
        });

        cmdremove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        cmdremove.setMnemonic('m');
        cmdremove.setText("Remove");
        cmdremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdremoveActionPerformed(evt);
            }
        });

        cmdsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        cmdsave.setMnemonic('S');
        cmdsave.setText("Save Changes");
        cmdsave.setEnabled(false);
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
            }
        });

        cmdexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        cmdexit.setMnemonic('x');
        cmdexit.setText("Exit");
        cmdexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdexitActionPerformed(evt);
            }
        });

        lbl.setDisplayedMnemonic('u');
        lbl.setLabelFor(cmbmenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdadd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdrename)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdremove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdexit)
                        .addGap(5, 5, 5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdadd)
                    .addComponent(cmdrename)
                    .addComponent(cmdremove)
                    .addComponent(cmdsave)
                    .addComponent(cmdexit))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void cmbmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmenuActionPerformed
        if (cmbmenu.getSelectedItem() == "--ALL--") {
            populateTBL("");
        } else {
            populateTBL(valueOf(cmbmenu.getSelectedItem()));
        }

        LoadAllowedModules();
    }//GEN-LAST:event_cmbmenuActionPerformed

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
      ShowFrmNew();
    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdrenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdrenameActionPerformed
      if (ugid!=0){

            grpid = ugid;
            grpdesc = lst.getSelectedValue().toString();

            ShowFrmEdit();
      }else{   
            showMessageDialog(this, "No User Group Selected!");
      }
    }//GEN-LAST:event_cmdrenameActionPerformed

    private void cmdremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdremoveActionPerformed
        try {
            Item item = (Item) lst.getSelectedValue();
            int id = item.getId();
//            boolean ifexist = check_existance(id);

//            if (ifexist == true) {
//                JOptionPane.showMessageDialog(null, "Record cannot be remove! There are item depends on this Category!");
//            } else {

            int i = msgboxYesNo("Are you sure you want to delete this user group?");
            if (i == 0) {
                remove_group(id);
                this.populateLst();
                showMessageDialog(null, "User Group Removed!");

            } else if (i == 1) {
            } else if (i == 2) {
                this.dispose(); //exit window
            }
        } catch (Exception e) {
            showMessageDialog(this, "No User Group Selected!");
        }
    }//GEN-LAST:event_cmdremoveActionPerformed

    private void lstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstMouseClicked
      tbl.setEnabled(true);
        cmbmenu.setEnabled(true);
        cmdsave.setEnabled(true);
        LoadAllowedModules();
    }//GEN-LAST:event_lstMouseClicked

    private void lstValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstValueChanged
        LoadAllowedModules();
    }//GEN-LAST:event_lstValueChanged

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        try {
            Item item = (Item) lst.getSelectedValue();
            int id = item.getId();
            //JOptionPane.showMessageDialog(null, id);
            saveChanges(id);
            showMessageDialog(null, "Changes has been successfully saved!");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void lstMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstMouseReleased
                tbl.setEnabled(true);
        cmbmenu.setEnabled(true);
        cmdsave.setEnabled(true);
        LoadAllowedModules();
    }//GEN-LAST:event_lstMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbmenu;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdexit;
    private javax.swing.JButton cmdremove;
    private javax.swing.JButton cmdrename;
    private javax.swing.JButton cmdsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JList lst;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
