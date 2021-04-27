/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.salaryschedule;

import app.controller.DayValueController;
import app.controller.DueDateController;
import app.view.loantype.*;
import app.controller.LoanTypeController;
import app.controller.SalaryScheduleController;
import static app.view.salaryschedule.AddSalarySchedule.model;
import java.awt.Component;
import static java.awt.EventQueue.invokeLater;
import java.awt.event.ItemEvent;
import static java.awt.event.ItemEvent.SELECTED;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.sql.Statement;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.UIManager;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Engkoi Zidac
 */
public class EditSalarySchedule extends javax.swing.JDialog {

    public static MainFrameSalarySchedule frmParent;
    static Statement stmt;
    SalaryScheduleController Controller = new SalaryScheduleController();
    DayValueController DayValueController = new DayValueController();
    DueDateController DueDateController = new DueDateController();

    public static int Id;

    static DefaultTableModel model;

    public static boolean chk;

    protected CheckBoxHeader rendererComponent;
    protected boolean mousePressed = true;

    public EditSalarySchedule(MainFrameSalarySchedule parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        getRootPane().setDefaultButton(cmdadd);

        model = (DefaultTableModel) Table.getModel();

        Controller.setSalaryScheduleId(Id);
        Controller.PopulateDataOnEdit();

        PopulateData();
        PopulateFieldsAndDueDates();
    }

    class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == SELECTED;
            for (int x = 0, y = Table.getRowCount(); x < y; x++) {
                Table.setValueAt(checked, x, 0);
            }
        }
    }

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
            rendererComponent.setText("");
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

    public void ManageDueDates() {
        int rc = model.getRowCount();
        int srow = 0;

        while (srow != rc) {
            String IsSel = Table.getValueAt(srow, 0).toString();
            String NId = Table.getValueAt(srow, 2).toString();
            boolean Is = parseBoolean(IsSel);

            if (Is == true) {
                boolean IsOn = DueDateController.IsAdded(parseInt(NId), Id);

                if (IsOn == false) {
                    DueDateController.setId(parseInt(NId));
                    DueDateController.setSalaryScheduleId(Id);
                    DueDateController.Add();
                }
            } else if (Is == false) {
                boolean IsOn = DueDateController.IsAdded(parseInt(NId), Id);

                if (IsOn == true) {
                    DueDateController.Remove(parseInt(NId), Id);
                }
            }
            srow++;
        }
    }

    void PopulateFieldsAndDueDates() {
        txtdesc.setText(Controller.getDescription());
        txtremarks.setText(Controller.getRemarks());

        int rc = model.getRowCount();
        int srow = 0;
        while (srow != rc) {
            String CId = Table.getValueAt(srow, 2).toString();
            boolean IsOn = DueDateController.IsAdded(parseInt(CId), Id);
            if (IsOn == true) {
                Table.setValueAt(true, srow, 0);
            }
            srow++;
        }
    }

    public void PopulateData() {
        DayValueController.PopulateTableData(Table);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdadd = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtremarks = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdesc = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit ");

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        cmdadd.setMnemonic('S');
        cmdadd.setText("Save");
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

        jLabel5.setText("Details");

        txtremarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtremarks.setForeground(new java.awt.Color(51, 51, 51));
        txtremarks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtremarksFocusGained(evt);
            }
        });

        jLabel6.setText("Description");

        txtdesc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtdesc.setForeground(new java.awt.Color(51, 51, 51));
        txtdesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdescFocusGained(evt);
            }
        });

        jLabel3.setText("Select due date/s");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Day", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(Table);
        Table.getColumnModel().getColumn(0).setMaxWidth(40);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtremarks, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtremarks, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdadd)
                    .addComponent(cmdexit))
                .addContainerGap(218, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
        if (txtdesc.getText().isEmpty() == true) {
            showMessageDialog(null, "Please fill-up the required fields!");
        } else {
            Controller.setDescription(txtdesc.getText());
            Controller.setRemarks(txtremarks.getText());
            Controller.Update();
            ManageDueDates();
            this.dispose();
            frmParent.PopulateData();
            showMessageDialog(null, "Changes Updated Successfully!");
        }
    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void txtremarksFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtremarksFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtremarksFocusGained

    private void txtdescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescFocusGained

    }//GEN-LAST:event_txtdescFocusGained

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
            getLogger(EditSalarySchedule.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        invokeLater(() -> {
            EditSalarySchedule dialog = new EditSalarySchedule(frmParent, true);
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
    private javax.swing.JTable Table;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdexit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtremarks;
    // End of variables declaration//GEN-END:variables
}
