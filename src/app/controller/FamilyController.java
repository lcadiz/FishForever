/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.model.ComboBoxItem;
import app.model.MemberFamily;
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
public class FamilyController extends MemberFamily {
           static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String SearchParameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM member_family WHERE name LIKE '%" + SearchParameter + "%'";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString("FamilyId"), rs.getString("Name"), rs.getString("Relation"), rs.getString("Occupation"), rs.getString("ContactNo")});
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
        createString = "INSERT INTO member_family(Name, Relation, Occupation, ContactNo, FKMemberId) "
                + "VALUES ('" + this.getName() + "','" + this.getRelation() + "','" + this.getOccupation() + "','" + this.getContactNo() + "'," + this.getFKMemberID() + ")";

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

//    public void PopulateDataOnEdit() {
//        Connection Conn = getConnection();
//        String createString = "SELECT * FROM member_family WHERE CollateralId=" + this.getCollateralId();
//
//        try {
//
//            Stmt = Conn.createStatement();
//            ResultSet rs = Stmt.executeQuery(createString);
//
//            while (rs.next()) {
//                this.setDescription(rs.getString("Description"));
//
//            }
//
//            Stmt.close();
//            Conn.close();
//
//        } catch (SQLException e) {
//            showMessageDialog(null, e.getMessage());
//        }
//    }

//    public void Update() {
//        Connection conn = getConnection();
//        String createString;
//        createString = "UPDATE member_family "
//                + "SET "
//                + "Description = '" + this.getDescription() + "' "
//                + "WHERE CollateralId=" + this.getCollateralId();
//
//        try {
//            Connection Conn = getConnection();
//            Stmt = Conn.createStatement();
//            Stmt.executeUpdate(createString);
//            Stmt.close();
//            conn.close();
//
//        } catch (SQLException e) {
//            showMessageDialog(null, e.getMessage());
//        }
//    }

//    public void Remove() {
//        Connection Conn = getConnection();
//        String createString;
//        createString = "DELETE FROM member_family WHERE CollateralId=" + this.getCollateralId();
//
//        try {
//            Stmt = Conn.createStatement();
//            Stmt.executeUpdate(createString);
//            Stmt.close();
//            Conn.close();
//
//        } catch (SQLException e) {
//            showMessageDialog(null, e.getMessage());
//        }
//    }
}
