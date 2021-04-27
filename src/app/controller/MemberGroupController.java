/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.model.ComboBoxItem;
import app.model.MemberGroup;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

public class MemberGroupController extends MemberGroup {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String SearchParameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM member_group WHERE description LIKE '%" + SearchParameter + "%'";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString("GroupId"), rs.getString("Description")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

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
        createString = "INSERT INTO member_group(Description) "
                + "VALUES ('" + this.getDescription() + "')";

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

    public void PopulateComboBoxData(JComboBox ComboBoxObject) {
        dcv.setComboBoxObject(ComboBoxObject);
        dcv.InitializeComboBox();
        ComboBoxObject.addItem("--SELECT--");
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM member_group";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("GroupId"), rs.getString("Description")));
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
        ComboBoxObject.addItem(new ComboBoxItem(this.getGroupId(), this.getDescription()));
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM member_group WHERE GroupId<>"+this.getGroupId();

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("GroupId"), rs.getString("Description")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    private void GetCurrentDescription(){

        Connection conn = getConnection();
        String createString;
        createString = "SELECT Description FROM member_group WHERE GroupId=" + this.getGroupId();

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setDescription(rs.getString("Description"));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }

    }
    
    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM member_group WHERE GroupId=" + this.getGroupId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setDescription(rs.getString("Description"));

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
        createString = "UPDATE member_group "
                + "SET "
                + "Description = '" + this.getDescription() + "' "
                + "WHERE GroupId=" + this.getGroupId();

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
        createString = "DELETE FROM member_group WHERE GroupId=" + this.getGroupId();

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
