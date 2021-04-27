/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.model.ComboBoxItem;
import app.model.ScheduleType;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author Engkoi Zidac
 */
public class ScheduleTypeController extends ScheduleType {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

  

    public void PopulateComboBoxData(JComboBox ComboBoxObject) {
        dcv.setComboBoxObject(ComboBoxObject);
        dcv.InitializeComboBox();
        ComboBoxObject.addItem("--SELECT--");
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM schedule_type WHERE ScheduleTypeId<>1 ORDER BY ScheduleTypeId" ;

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("ScheduleTypeId"), rs.getString("Description")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
