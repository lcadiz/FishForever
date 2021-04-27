/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.global.FunctionFactory;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import app.model.Loan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

/**
 *
 * @author EngkoiZidac
 */
public class LoanController extends Loan {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, int Id) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM loan l INNER JOIN loan_type lt ON l.LoanTypeID=lt.LoanTypeId WHERE MemberId=" + Id;

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            dtv.ColumnCenter(4);
            dtv.ColumnCenter(5);
            dtv.ColumnAlignRight(6);
            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString("LoanId"), rs.getDate("TransDate"), rs.getString("Referrence"), rs.getString("Description"), rs.getString("Interest"), rs.getString("Term"), FunctionFactory.amountFormat(rs.getDouble("PrincipalAmount")), rs.getDate("DateReleased")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public int Add(String DateReleased) {
        int Id = 0;
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO Loan(Referrence, LoanTypeId, Interest, Term, PrincipalAmount, DateReleased, MemberId) "
                + "VALUES ('" + this.getReferrence() + "', " + this.getLoanTypeId() + ", '" + this.getInterest() + "', '" + this.getTerm() + "', '" + this.getPrincipalAmount() + "', '" + DateReleased + "', " + this.getMemberId() + ")";

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
        createString = "SELECT MAX(LoanId) FROM loan";

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
    
    

}
