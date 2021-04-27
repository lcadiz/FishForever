/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.model.DayValue;
import app.view.global.DefaultTableView;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

public class DayValueController extends DayValue {

    static Statement Stmt;
   

    DefaultTableView dtv = new DefaultTableView();

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM day_value";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{false, rs.getString("Day"), rs.getString("Id")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
    
    public String GetDayValue(int id) {
    String DayVal="";
        Connection conn = getConnection();
        String createString;
        createString = "SELECT Day FROM day_value WHERE Id=" + id;

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);
            while (rs.next()) {
                DayVal = rs.getString(1);
            }
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
        return DayVal;
    }

    
        public static void main(String[] args) {
           DayValueController dv = new DayValueController();
           String d=dv.GetDayValue(2);
            out.println(d);
        }
}
