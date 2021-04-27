/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import static app.config.DBConn.getConnection;
import app.model.ComboBoxItem;
import app.model.Gender;
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
public class GenderController extends Gender {
    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateComboBoxData(JComboBox ComboBoxObject) {
        dcv.setComboBoxObject(ComboBoxObject);
        dcv.InitializeComboBox();
        ComboBoxObject.addItem("--SELECT--");
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM gender";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("GenderId"), rs.getString("Description")));
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
        GetCurrentName();
        ComboBoxObject.addItem(new ComboBoxItem(this.getGenderId(), this.getDescription()));
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM gender WHERE GenderId<>"+this.getGenderId();

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("GenderId"), rs.getString("Description")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
    private void GetCurrentName(){

        Connection conn = getConnection();
        String createString;
        createString = "SELECT Description FROM gender WHERE GenderId=" + this.getGenderId();

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

}
