/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import app.model.MemberModel;
import app.view.global.DefaultComboBoxView;
import app.view.global.DefaultTableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

/**
 *
 * @author EngkoiZidac
 */
public class MemberController extends MemberModel {
    
    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();
    
    public void PopulateTableData(JTable TableObject, String SearchParameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();
        
        String createString = "SELECT MemberId, CONCAT(FamilyName,', ',FirstName,' ',MiddleName,' ',NameExt), a.Description, mg.Description, ss.Description, ss.Remarks, m.Address FROM member m "
                + "INNER JOIN area a ON m.AreaId=a.AreaId "
                + "INNER JOIN salary_schedule ss ON m.SalaryScheduleId=ss.SalaryScheduleId "
                + "INNER JOIN member_group mg ON m.MemberGroupId=mg.GroupId "
                + "WHERE CONCAT(FamilyName,', ',FirstName,' ',MiddleName,' ',NameExt) LIKE '%" + SearchParameter + "%'";
        
        try {
            
            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);
            
            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) + " : " + rs.getString(6)});
            }
            
            Stmt.close();
            Conn.close();
            
        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
    
    public int Add() {
        int Id = 0;
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO member(FamilyName, FirstName, MiddleName, NameExt, AreaId, SalaryScheduleId, MemberGroupId, Address, BarangayId) "
                + "VALUES ('" + this.getFamilyName() + "','" + this.getFirstName() + "','" + this.getMiddleName() + "','" + this.getNameExt() + "'," + this.getAreaId() + "," + this.getSalaryScheduleId() + "," + this.getMemberGroupId() + ",'" + this.getAddress() + "'," + this.getBarangayId() + ")";
        
        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
        Id = GetInsertedId();
        return Id;
    }
    
    public int GetInsertedId() {
        int Id = 0;
        
        Connection conn = getConnection();
        String createString;
        createString = "SELECT MAX(MemberId) FROM member";
        
        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);
            
            while (rs.next()) {
                Id = rs.getInt(1);
            }
            
            Stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return Id;
    }
    
    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM member m "
                + "INNER JOIN area a ON m.AreaId=a.AreaId "
                + "INNER JOIN salary_schedule ss ON m.SalaryScheduleId=ss.SalaryScheduleId "
                + "INNER JOIN member_group mg ON m.MemberGroupId=mg.GroupId "
                + "WHERE MemberId=" + this.getMemberId() + " GROUP BY m.MemberId";
        
        try {
            
            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);
            
            while (rs.next()) {
                this.setFamilyName(rs.getString("m.FamilyName"));
                this.setFirstName(rs.getString("m.FirstName"));
                this.setMiddleName(rs.getString("m.MiddleName"));
                this.setNameExt(rs.getString("m.NameExt"));
                
                this.setAreaId(rs.getInt("m.AreaId"));
                this.setSalaryScheduleId(rs.getInt("m.SalaryScheduleId"));
                this.setMemberGroupId(rs.getInt("m.MemberGroupId"));
                
                this.setGenderId(rs.getInt("m.GenderId"));
                this.setCivilStatusId(rs.getInt("m.CivilStatusId"));
                this.setContactNo(rs.getString("ContactNo"));
                this.setBirthPlace(rs.getString("BirthPlace"));
                this.setSpouseFamilyName(rs.getString("SpouseFamilyName"));
                this.setSpouseFirstName(rs.getString("SpouseFirstName"));
                this.setSpouseMiddleName(rs.getString("SpouseMiddleName"));
                this.setSpouseNameExt(rs.getString("SpouseNameExt"));
                this.setSpouseBusiness(rs.getString("SpouseBusiness"));
                this.setSpouseEmployment(rs.getString("SpouseEmployment"));
                this.setBirthDate(rs.getDate("BirthDate"));
                this.setEmployment(rs.getString("Employment"));
                this.setMonthlySalary(rs.getDouble("MonthlySalary"));
                this.setContactNo2(rs.getString("ContactNo2"));
                this.setContactNoWP(rs.getString("ContactNoWP"));
                
                this.setAddress(rs.getString("Address"));
                this.setAddressProv(rs.getString("AddressProv"));
                
                this.setHouseId(rs.getInt("HouseId"));
                this.setHouseProvId(rs.getInt("HouseProvId"));
                
                this.setBarangayId(rs.getInt("m.BarangayId"));
                this.setBarangayProvId(rs.getInt("m.BarangayProvId"));
                
                this.setFkCityId(this.getValueCityId(this.getBarangayId()));
                this.setFkProvinceId(this.getValueProvinceId(this.getFkCityId()));
                this.setCityProvId(this.getValueCityId(this.getBarangayProvId()));
                this.setProvinceProvId(this.getValueProvinceId(this.getCityProvId()));
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
        
        createString = "UPDATE member "
                + "SET "
                + "FamilyName = '" + this.getFamilyName() + "', "
                + "FirstName = '" + this.getFirstName() + "', "
                + "MiddleName = '" + this.getMiddleName() + "', "
                + "NameExt = '" + this.getNameExt() + "', "
                + "AreaId = " + this.getAreaId() + ", "
                + "SalaryScheduleId = " + this.getSalaryScheduleId() + ", "
                + "MemberGroupId = " + this.getMemberGroupId() + ", "
                + "GenderId = '" + this.getGenderId() + "', "
                + "CivilStatusId = '" + this.getCivilStatusId() + "', "
                + "ContactNo = '" + this.getContactNo() + "', "
                + "ContactNo2 = '" + this.getContactNo2() + "', "
                + "ContactNoWP = '" + this.getContactNoWP() + "', "
                + "BirthPlace = '" + this.getBirthPlace() + "', "
                + "SpouseFamilyName = '" + this.getSpouseFamilyName() + "', "
                + "SpouseFirstName = '" + this.getSpouseFirstName() + "', "
                + "SpouseMiddleName = '" + this.getSpouseMiddleName() + "', "
                + "SpouseNameExt = '" + this.getSpouseNameExt() + "', "
                + "SpouseBusiness = '" + this.getSpouseBusiness() + "', "
                + "SpouseEmployment = '" + this.getSpouseEmployment() + "', "
                + "BirthDate = '" + new java.sql.Date(this.getBirthDate().getTime()) + "', "
                + "MonthlySalary = '" + this.getMonthlySalary() + "', "
                + "Employment = '" + this.getEmployment() + "', "
                + "Address = '" + this.getAddress() + "', "
                + "AddressProv = '" + this.getAddress() + "', "
                + "HouseId = " + this.getHouseId() + ", "
                + "HouseProvId = " + this.getHouseProvId() + ", "
                + "BarangayId = " + this.getBarangayId() + ", "
                + "BarangayProvId = " + this.getBarangayProvId() + " "
                + "WHERE MemberId=" + this.getMemberId();
        
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
    
    private int getValueCityId(int BrgyId) {
        int Id = 0;
        
        Connection conn = getConnection();
        String createString;
        createString = "SELECT CityId FROM barangay WHERE BarangayId=" + BrgyId;
        
        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);
            
            while (rs.next()) {
                Id = rs.getInt(1);
            }
            
            Stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return Id;
    }
    
    private int getValueProvinceId(int CityId) {
        int Id = 0;
        
        Connection conn = getConnection();
        String createString;
        createString = "SELECT ProvinceId FROM city WHERE CityId=" + CityId;
        
        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);
            
            while (rs.next()) {
                Id = rs.getInt(1);
            }
            
            Stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return Id;
    }
}
