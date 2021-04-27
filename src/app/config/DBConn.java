package app.config;

import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Class.forName;
import static java.lang.System.getProperty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class DBConn {

    static String userid, password, user;
    static String url;
    static Connection conn;
    static String connStr;

    public static Connection getConnection() {
        try {
            forName("com.mysql.jdbc.Driver");

        } catch (java.lang.ClassNotFoundException e) {
            showMessageDialog(null, "Database Driver error. Please check the configuration!");
        }

        try {

            String filePath = getProperty("user.dir") + "\\config.properties";

            Properties properties = new Properties();

            try {
                properties.load(new FileInputStream(filePath));
            } catch (IOException ex) {
                getLogger(DBConn.class.getName()).log(SEVERE, null, ex);
            }

            String port = properties.getProperty("port");
            String host = properties.getProperty("host");
            String database = properties.getProperty("database");

            url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            user = "tnuser";
            password = "tnuser";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error in Connection!");
            showMessageDialog(null, e.getMessage());

        }

        return conn;
    }
}