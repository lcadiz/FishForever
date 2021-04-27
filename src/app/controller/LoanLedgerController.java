/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.global.FunctionFactory;
import app.model.LoanLedger;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

/**
 *
 * @author EngkoiZidac
 */
public class LoanLedgerController extends LoanLedger {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, int Id) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT *  FROM loan_ledger WHERE LoanId=" + Id;

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            dtv.ColumnAlignRight(4);
            dtv.ColumnAlignRight(5);
            dtv.ColumnAlignRight(6);
            while (rs.next()) {

                String dp = rs.getString("DatePaid");
                String dpval = "";

                if ("NULL".equals(dp)) {
                    dpval = "";
                } else {
                    dpval = dp;
                }

                dtv.TableModel.addRow(new Object[]{rs.getInt("Id"), rs.getDate("TransDate"), rs.getString("Referrence"), rs.getString("Particular"), FunctionFactory.amountFormat(rs.getDouble("PrincipalAmount")), FunctionFactory.amountFormat(rs.getDouble("AmountPaid")), FunctionFactory.amountFormat(rs.getDouble("Balance")), dpval});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public double GetRunningBalance(int LoanId) {
        double Balance = 0;
        Connection conn = getConnection();
        String createString;
        createString = "SELECT SUM(PrincipalAmount)-SUM(AmountPaid) FROM loan_ledger WHERE LoanId=" + LoanId;

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                Balance = rs.getDouble(1);
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return Balance;
    }

    public void Add() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO loan_ledger(Referrence, Particular, PrincipalAmount, AmountPaid, Balance, LoanId) "
                + "VALUES ('" + this.getReferrence() + "', '" + this.getParticular() + "', '" + this.getPrincipalAmount() + "', '" + this.getAmountPaid() + "', '" + this.getBalance() + "'," + this.getLoanId() + ")";

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

    public void PostPayment(String DatePaid) {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO loan_ledger(Referrence, Particular, PrincipalAmount, AmountPaid, Balance, LoanId, DatePaid) "
                + "VALUES ('" + this.getReferrence() + "', '" + this.getParticular() + "', '" + this.getPrincipalAmount() + "', '" + this.getAmountPaid() + "', '" + this.getBalance() + "'," + this.getLoanId() + ",'" + DatePaid + "')";

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
}
