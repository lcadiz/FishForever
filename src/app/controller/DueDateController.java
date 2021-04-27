/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.model.DueDate;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author EngkoiZidac
 */
public class DueDateController extends DueDate {

    static Statement Stmt;

    public void Add() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO due_date (SalaryScheduleId, Id)"
                + " VALUES (" + this.getSalaryScheduleId() + "," + this.getId() + ")";

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

    public boolean IsAdded(int Id, int SSId) {
        boolean IsOn = false;
        Connection conn = getConnection();
        String createString;
        createString = "SELECT Id FROM due_date WHERE SalaryScheduleId=" + SSId + " AND Id="+ Id;
//System.out.println(createString);
        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);
            int Cntr = 0;
            while (rs.next()) {
                Cntr++;
            }

            if (Cntr == 0) {
                IsOn = false;
            } else {
                IsOn = true;
            }
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
        return IsOn;
    }
    
       public void Remove(int Id, int SSId) {
        Connection Conn = getConnection();
        String createString;
        createString = "DELETE FROM due_date WHERE SalaryScheduleId=" + SSId +" AND Id="+Id;

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
    
     public static void main(String[] args) {
         SalaryScheduleController c = new SalaryScheduleController();
         
         out.println(c.GetInsertedId());
     }

}
