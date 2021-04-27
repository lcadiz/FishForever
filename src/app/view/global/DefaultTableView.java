package app.view.global;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.UIManager;
import static javax.swing.UIManager.getColor;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class DefaultTableView {

    private JTable TableObject;
    public static DefaultTableCellRenderer CellAlignCenter = new DefaultTableCellRenderer();
    static DefaultTableCellRenderer CellAlignRight = new DefaultTableCellRenderer();
    public DefaultTableModel TableModel;

    public void setTableObject(JTable TableObject) {
        this.TableObject = TableObject;
    }

    public void InitializeTable() {
        TableModel = (DefaultTableModel) TableObject.getModel();

        CellAlignCenter.setHorizontalAlignment(0);
        CellAlignRight.setHorizontalAlignment(RIGHT);

        TableObject.setRowHeight(22);
        TableObject.setColumnSelectionAllowed(false);
        TableModel.setNumRows(0);
    }

    public void ColumnAlignRight(int col) {
        TableObject.getColumnModel().getColumn(col).setCellRenderer(CellAlignRight);
    }

    public void ColumnCenter(int col) {
        TableObject.getColumnModel().getColumn(col).setCellRenderer(CellAlignCenter);
    }

    public void RenderTable() {
        TableColumn idClmn = TableObject.getColumn("id");
        idClmn.setMaxWidth(0);
        idClmn.setMinWidth(0);
        idClmn.setPreferredWidth(0);

        TableObject.setCellSelectionEnabled(false);
        TableObject.setRowSelectionAllowed(true);
        TableObject.setSelectionMode(SINGLE_SELECTION);
        TableObject.setSelectionBackground(new Color(153, 204, 255));
        TableObject.setSelectionForeground(BLACK);
    }

    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox, int x) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);

            button.addActionListener((ActionEvent e) -> {
                fireEditingStopped();
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            Icon ico1 = new javax.swing.ImageIcon(getClass().getResource("/img/timeshift.png"));
            button.setIcon(ico1);
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {

            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }

    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        int iflg;

        public ButtonRenderer(int ico) {
            setOpaque(true);
            iflg = ico;
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(getColor("Button.background"));
            }
            Icon ico1 = new javax.swing.ImageIcon(getClass().getResource("/img/innn.png"));
            Icon ico2 = new javax.swing.ImageIcon(getClass().getResource("/img/info.png"));
            if (iflg == 1) {
                setIcon(ico1);
            } else if (iflg == 2) {
                setIcon(ico2);
            }

            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

}
