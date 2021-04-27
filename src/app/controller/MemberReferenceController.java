/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.model.MemberReference;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
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
public class MemberReferenceController extends MemberReference {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM member_reference WHERE FKMemberId=" + this.getFKMemberId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString("ReferenceId"), rs.getString("FullName"), rs.getString("Relationship"), rs.getString("Address"), rs.getString("SourceIncome"), rs.getString("ContactNo")});
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
        createString = "INSERT INTO member_reference(FullName, Relationship, Address, SourceIncome, ContactNo, FKMemberId) "
                + "VALUES ('" + this.getFullName() + "', '" + this.getRelationship() + "','" + this.getAddress() + "','" + this.getSourceIncome() + "','" + this.getContactNo() + "', " + this.getFKMemberId() + ")";

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
        createString = "UPDATE member_reference "
                + "SET "
                + "FullName = '" + this.getFullName() + "', "
                + "Relationship = '" + this.getRelationship() + "', "
                + "Address= '" + this.getAddress() + "', "
                + "SourceIncome= '" + this.getSourceIncome() + "', "
                + "ContactNo= '" + this.getContactNo() + "' "
                + "WHERE ReferenceId=" + this.getReferenceId();

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
        createString = "DELETE FROM member_reference WHERE ReferenceId=" + this.getReferenceId();

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
        String createString = "SELECT * FROM member_reference WHERE ReferenceId=" + this.getReferenceId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setFullName(rs.getString("FullName"));
                this.setRelationship(rs.getString("Relationship"));
                this.setAddress(rs.getString("Address"));
                this.setSourceIncome(rs.getString("SourceIncome"));
                this.setContactNo(rs.getString("ContactNo"));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
