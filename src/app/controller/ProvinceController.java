/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.model.ComboBoxItem;
import app.model.Province;
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
public class ProvinceController extends Province {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String SearchParameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM Province WHERE Name LIKE '%" + SearchParameter + "%'";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getInt("ProvinceId"), rs.getString("Name")});
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
        createString = "SELECT * FROM province ORDER BY Name";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("ProvinceId"),rs.getString("Name")));
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
        ComboBoxObject.addItem(new ComboBoxItem(this.getProvinceId(), this.getName()));
        Connection conn = getConnection();
        String createString;

        createString = "SELECT * FROM province WHERE ProvinceId<>" + this.getProvinceId() + " ORDER BY Name";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("CityId"), rs.getString("Name")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    public void GetCurrentDescription() {

        Connection conn = getConnection();
        String createString;
        createString = "SELECT Name FROM province WHERE ProvinceId=" + this.getProvinceId();

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setName(rs.getString("Name"));
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
        createString = "INSERT INTO Province(Name) "
                + "VALUES ('" + this.getName() + "')";

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
        String createString = "SELECT * FROM province WHERE ProvinceId=" + this.getProvinceId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setName(rs.getString("Name"));

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
        createString = "UPDATE province "
                + "SET "
                + "Name = '" + this.getName() + "' "
                + "WHERE ProvinceId=" + this.getProvinceId();

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
        createString = "DELETE FROM province WHERE ProvinceId=" + this.getProvinceId();

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
