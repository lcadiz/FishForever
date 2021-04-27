/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.model.ComboBoxItem;
import app.model.SalarySchedule;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

/**
 *
 * @author Engkoi Zidac
 */
public class SalaryScheduleController extends SalarySchedule {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    String GetDetail(int d1, int d2) {
        out.println(d1);
        out.println(d2);
        DayValueController dv = new DayValueController();

        String details = "";

        if (d1 > 0 && d2 > 0) {
            details = "Every " + dv.GetDayValue(d1) + " and " + dv.GetDayValue(d2) + " of the month";
        } else if (d1 > 0 && d2 == 0) {
            details = "Every " + dv.GetDayValue(d1) + " of the month";
        } else if (d1 == 0 && d2 == 0) {
            details = "";
        }

        return details;
    }

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM salary_schedule s";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {

                // String details = GetDetail(rs.getInt("Day1"), rs.getInt("Day2"));
                dtv.TableModel.addRow(new Object[]{rs.getInt("SalaryScheduleId"), rs.getString("Description"), rs.getString("Remarks")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM salary_schedule WHERE SalaryScheduleId=" + this.getSalaryScheduleId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setDescription(rs.getString("Description"));
                this.setRemarks(rs.getString("Remarks"));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void PopulateComboBoxData(JComboBox ComboBoxObject) {
        dcv.setComboBoxObject(ComboBoxObject);
        dcv.InitializeComboBox();
        ComboBoxObject.addItem("--SELECT--");
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM salary_schedule";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("SalaryScheduleId"), rs.getString("Description") + " : " + rs.getString("Remarks")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void PopulateComboBoxDataOnEdit(JComboBox ComboBoxObject) {
        dcv.setComboBoxObject(ComboBoxObject);
        dcv.InitializeComboBox();
        GetCurrentDescription();
        ComboBoxObject.addItem(new ComboBoxItem(this.getSalaryScheduleId(), this.getDescription() + " : " + this.getRemarks()));
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM salary_schedule WHERE SalaryScheduleId<>"+this.getSalaryScheduleId();

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("SalaryScheduleId"), rs.getString("Description") + " : " + rs.getString("Remarks")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    private void GetCurrentDescription() {

        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM salary_schedule WHERE SalaryScheduleId=" + this.getSalaryScheduleId();

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setDescription(rs.getString("Description"));
                this.setRemarks(rs.getString("Remarks"));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    public int Add() {
        int Id = 0;
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO salary_schedule (Description, Remarks)"
                + " VALUES ('" + this.getDescription() + "','" + this.getRemarks() + "')";

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();

            Stmt.executeUpdate(createString);

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
        Id = GetInsertedId();
        return Id;
    }

    public int GetInsertedId() {
        int Id = 0;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT MAX(SalaryScheduleId) FROM salary_schedule";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                Id = rs.getInt(1);
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return Id;
    }

    public void Update() {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE salary_schedule "
                + "SET "
                + "Description = '" + this.getDescription() + "', "
                + "Remarks = '" + this.getRemarks() + "' "
                + "WHERE SalaryScheduleId=" + this.getSalaryScheduleId();

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Remove() {
        Connection Conn = getConnection();
        String createString;
        createString = "DELETE FROM payroll_period WHERE SalaryScheduleId=" + this.getSalaryScheduleId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public static void main(String[] args) {
        SalaryScheduleController c = new SalaryScheduleController();

        out.println(c.GetInsertedId());
    }
}
