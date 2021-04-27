/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.model.Collateral;
import app.model.ComboBoxItem;
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
public class CollateralController extends Collateral {
        static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String SearchParameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM collateral WHERE description LIKE '%" + SearchParameter + "%'";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString("CollateralId"), rs.getString("Description")});
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
        createString = "SELECT * FROM collateral";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("CollateralId"), rs.getString("Description")));
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
        GetCurrentCollateralName();
        ComboBoxObject.addItem(new ComboBoxItem(this.getCollateralId(), this.getDescription()));
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM collateral WHERE CollateralId<>"+this.getCollateralId();

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("CollateralId"), rs.getString("Description")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
    private void GetCurrentCollateralName(){

        Connection conn = getConnection();
        String createString;
        createString = "SELECT Description FROM collateral WHERE CollateralId=" + this.getCollateralId();

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

    public void Add() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO collateral(Description) "
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

    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM collateral WHERE CollateralId=" + this.getCollateralId();

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
        createString = "UPDATE collateral "
                + "SET "
                + "Description = '" + this.getDescription() + "' "
                + "WHERE CollateralId=" + this.getCollateralId();

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
        createString = "DELETE FROM collateral WHERE CollateralId=" + this.getCollateralId();

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
