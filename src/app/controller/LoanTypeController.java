/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.model.ComboBoxItem;
import app.model.LoanType;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import static java.lang.Double.valueOf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

public class LoanTypeController extends LoanType {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String SearchParameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM loan_type WHERE description LIKE '%" + SearchParameter + "%'";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString("LoanTypeId"), rs.getString("Description"), rs.getString("InterestRate") +" % per month", rs.getString("Term")+" Months"});
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
        createString = "SELECT * FROM loan_type";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("LoanTypeId"), rs.getString("Description")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

//        public void PopulateDataOnEdit() {
//        Connection Conn = DBConn.getConnection();
//        String createString = "SELECT * FROM loan_type WHERE LoanTypeId=" + this.getLoanTypeId();
//
//        try {
//
//            Stmt = Conn.createStatement();
//            ResultSet rs = Stmt.executeQuery(createString);
//
//            while (rs.next()) {
//                this.setInterestRate(rs.getDouble("InterestRate"));
//                this.setTerm(rs.getInt("Term"));
//            }
//
//            Stmt.close();
//            Conn.close();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }  


//    public void PopulateTableDataNotIn(JTable TableObject, String SearchParameter, int TransTypeId) {
//        Connection Conn = DBConn.getConnection();
//        dtv.setTableObject(TableObject);
//        dtv.InitializeTable();
//        dtv.RenderTable();
//
//        String createString = "SELECT * FROM coa WHERE COAId NOT IN (SELECT COAId FROM transaction_charges WHERE TransTypeId="+TransTypeId+") AND AccountTitle LIKE '%" + SearchParameter + "%'";
//
//        try {
//
//            Stmt = Conn.createStatement();
//            ResultSet rs = Stmt.executeQuery(createString);
//
//            while (rs.next()) {
//                dtv.TableModel.addRow(new Object[]{rs.getInt("COAId"), rs.getString("AccountCode"), rs.getString("AccountTitle")});
//            }
//
//            Stmt.close();
//            Conn.close();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
    public void Add() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO loan_type(Description, InterestRate, Term) "
                + "VALUES ('" + this.getDescription() + "','" + this.getInterestRate() + "','" + this.getTerm() + "')";

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

    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM loan_type WHERE LoanTypeId=" + this.getLoanTypeId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setDescription(rs.getString("Description"));
                this.setInterestRate(valueOf(rs.getString("InterestRate")));
                this.setTerm(rs.getInt("Term"));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Update() {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE loan_type "
                + "SET "
                + "Description = '" + this.getDescription() + "', "
                + "InterestRate = '" + this.getInterestRate() + "', "
                + "Term = '" + this.getTerm() + "' "
                + "WHERE LoanTypeId=" + this.getLoanTypeId();

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
        createString = "DELETE FROM loan_type WHERE LoanTypeId=" + this.getLoanTypeId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
