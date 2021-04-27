/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.global.FunctionFactory;
import app.model.MemberCollateral;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

/**
 *
 * @author EngkoiZidac
 */
public class MemberCollateralController extends MemberCollateral {
     static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM member_collateral m INNER JOIN collateral c ON m.FKCollateralId=c.CollateralId WHERE FKMemberId=" + this.getFKMemberID();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString("MCollateralId"), rs.getString("c.Description"), rs.getString("Details"), FunctionFactory.amountFormat(rs.getDouble("Value"))});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Add() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO member_collateral(FKCollateralId, Details, Value, FKMemberId) "
                + "VALUES (" + this.getFKCollateralId() + ", '" + this.getDetails() + "','" + this.getValue() + "', " + this.getFKMemberID() + ")";

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

    public void Update() {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE member_collateral "
                + "SET "
                + "FKCollateralId = '" + this.getFKCollateralId() + "', "
                + "Details = '" + this.getDetails() + "', "
                + "Value = '" + this.getValue() + "' "
                + "WHERE MCollateralId=" + this.getMCollateralId();

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
        createString = "DELETE FROM member_collateral WHERE MCollateralId=" + this.getMCollateralId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM member_collateral WHERE MCollateralId=" + this.getMCollateralId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setFKCollateralId(rs.getInt("FKCollateralId"));
                this.setDetails(rs.getString("Details"));
                this.setValue(rs.getDouble("Value"));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
    
   

}
