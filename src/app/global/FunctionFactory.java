/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.global;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import java.awt.Component;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.toHexString;
import static java.lang.System.getProperty;
import static java.lang.System.getenv;
import static java.lang.System.out;
import java.security.MessageDigest;
import static java.security.MessageDigest.getInstance;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.getInstance;
import java.util.Date;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showConfirmDialog;

/**
 *
 * @author LESTER
 */
public class FunctionFactory {

    static Statement stmt;

    public static void main(String[] args) {

        out.print(GetDayofDate("2019-05-14"));
    }

    public static String amountFormat2(String amnt) {
        String output = "";
        if ("".equals(amnt)) {
        } else {
            DecimalFormat money = new DecimalFormat("#,##0.00");
            double aDouble = parseDouble(amnt);
            output = money.format(aDouble);
        }
        return output;
    }

    public static String amountFormat(double amnt) {
        DecimalFormat money = new DecimalFormat("#,##0.00");
        double aDouble = amnt;
        String output = money.format(aDouble);
        return output;
    }

    public static String convertMD5(String pass) {
        //        

        byte[] defaultBytes = pass.getBytes();
        try {
            MessageDigest algorithm = getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            //*** Testausgabe
            //System.out.println("pass " + pass + "   md5 version is " + hexString.toString());
            pass = hexString + "";
        } catch (NoSuchAlgorithmException nsae) {
        }

        return pass;

    }

    public static String getSystemInfo() {
        String sys = null;
        boolean is64bit = false;
        if (getProperty("os.name").contains("Windows")) {
            is64bit = (getenv("ProgramFiles(x86)") != null);
        } else {
            is64bit = (getProperty("os.arch").indexOf("64") != -1);
        }
        //System.out.println(is64bit);

        if (is64bit == true) {
            sys = "x64-based PC";
        } else {
            sys = "x86-based PC";
        }

        return sys;
    }

    public static int GetSystemNowMonthId() {
        int NowMonthId = 0;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT month(CURDATE()) AS NowDate";
        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                NowMonthId = rs.getInt(1);
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return NowMonthId;
    }

    public static String MemIdFormat(String mi) {
        DecimalFormat money = new DecimalFormat("0000000000");
        double aDouble = parseDouble(mi);
        String output = money.format(aDouble);
        return output;
    }

    public static String getMonthName(int month) {
        String nym = "";
        Calendar ca1 = getInstance();

        // set(year, month, date) month 0-11
        ca1.set(1999, month - 1, 1);

        // int iMonth=ca1.get(Calendar.MONTH);
        java.util.Date d = new java.util.Date(ca1.getTimeInMillis());

        //System.out.println("Month Name :"+new SimpleDateFormat("MMMM").format(d));
        //System.out.println("Month Name :"+new SimpleDateFormat("MMM").format(d));
        nym = new SimpleDateFormat("MMMM").format(d);
        return nym;
    }

    public static String getMonthId() {
        String NowDate = null;
        String DateStr = GetSystemNowDate().toString() + " " + GetSystemNowTime().toString();
        DateFormat dateFormat = new SimpleDateFormat("MM");
        NowDate = dateFormat.format(DateStr);
        out.println(NowDate);
//            String nym = "";
//        Calendar ca1 = Calendar.getInstance();
//
//        // set(year, month, date) month 0-11
//        ca1.set(1999, month - 1, 1);
//
//        // int iMonth=ca1.get(Calendar.MONTH);
//        java.util.Date d = new java.util.Date(ca1.getTimeInMillis());
//
//        //System.out.println("Month Name :"+new SimpleDateFormat("MMMM").format(d));
//        //System.out.println("Month Name :"+new SimpleDateFormat("MMM").format(d));
        //nym = new SimpleDateFormat("MMMM").format(d);
        return NowDate;
    }

    public static Date GetSystemNowDate() {
        Date NowDate = null;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT CURDATE() AS NowDate";
        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                NowDate = rs.getDate(1);
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return NowDate;
    }

    public static String GetSystemNowYear() {
        String NowYear = "";

        Connection conn = getConnection();
        String createString;
        createString = "SELECT YEAR(CURDATE()) AS NowDate";
        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                NowYear = rs.getString(1);
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return NowYear;
    }

    public static Time GetSystemNowTime() {
        Time NowTime = null;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT CURTIME() AS NowDate";
        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                NowTime = rs.getTime(1);
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return NowTime;
    }

    public static Date getSystemNowDateTime() {
        Date NowDate = null;
        String DateStr = GetSystemNowDate().toString() + " " + GetSystemNowTime().toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        try {
            NowDate = dateFormat.parse(DateStr);
        } catch (ParseException ex) {
            getLogger(FunctionFactory.class.getName()).log(SEVERE, null, ex);
        }
        return NowDate;
    }

    public static String getSystemNowDateTimeString() {
        //String NowDate = null;
        String DateStr = GetSystemNowDate().toString() + " " + GetSystemNowTime().toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        // NowDate = dateFormat.format(DateStr);
        return DateStr;
    }

    public static int msgOPT(String theMessage) {
        int result = showConfirmDialog(null, theMessage, "Alert", YES_NO_CANCEL_OPTION);
        return result;
    }

    public static int msgboxYesNoCancel(String theMessage) {
        int result = showConfirmDialog(null, theMessage, "Alert", YES_NO_CANCEL_OPTION);
        return result;
    }

    public static int msgboxYesNo(String theMessage) {
        int result = showConfirmDialog(null, theMessage, "Alert", YES_NO_OPTION);
        return result;
    }

    public static Date getSystemNowDate() {
        Date NowDate = null;
        String DateStr = GetSystemNowDate().toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            NowDate = dateFormat.parse(DateStr);
        } catch (ParseException ex) {
            getLogger(FunctionFactory.class.getName()).log(SEVERE, null, ex);
        }
        return NowDate;
    }

    public static Date DateFormatteryyyyMMdd(String dte) {
        Date NowDate = null;
        String DateStr = dte;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            NowDate = dateFormat.parse(DateStr);
        } catch (ParseException ex) {
            getLogger(FunctionFactory.class.getName()).log(SEVERE, null, ex);
        }
        return NowDate;
    }

    public static String getdateN() {

        String DateStr = GetSystemNowDate().toString() + " " + GetSystemNowTime().toString();
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        // NowDate = dateFormat.format(DateStr);
        return DateStr;
    }

    public static String GetDayofDate(String DateStr) {
        String daydate = "";

        Connection conn = getConnection();
        String createString;
        createString = "SELECT DAY('" + DateStr + "')";
        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                daydate = rs.getString(1);
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return daydate;
    }

    public static String NumFormatter(int num) {
        DecimalFormat outnum = new DecimalFormat("00");
        double aDouble = num;
        String output = outnum.format(aDouble);
        return output;
    }

//     public static void main(String[] args) {
//        String x= getSystemNowDateTimeStringMMDDYYYY();
//        System.out.println(x);
//     }
    public static String GetSignatoryName(int id) {
        String name = "";

        Connection conn = getConnection();
        String createString;
        createString = "SELECT name FROM signatory WHERE signatory_id=" + id;

        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                name = rs.getString(1);
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return name;
    }

    public static String GetSignatoryCaption(int id) {
        String caption = "";

        Connection conn = getConnection();
        String createString;
        createString = "SELECT caption FROM signatory WHERE signatory_id=" + id;

        //int rc = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(createString);

            while (rs.next()) {
                caption = rs.getString(1);
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return caption;
    }
}
