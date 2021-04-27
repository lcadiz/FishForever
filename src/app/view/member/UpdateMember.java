/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.member;

import app.controller.AreaController;
import app.controller.BarangayController;
import app.controller.CityController;
import app.controller.CivilStatusController;
import app.controller.GenderController;
import app.controller.HouseController;
import app.controller.MemberBusinessController;
import app.controller.MemberCollateralController;
import app.controller.MemberController;
import app.controller.MemberGroupController;
import app.controller.MemberPropertiesController;
import app.controller.MemberReferenceController;
import app.controller.ProvinceController;
import app.controller.SalaryScheduleController;
import app.global.FunctionFactory;
import static app.global.FunctionFactory.msgboxYesNo;
import app.model.ComboBoxItem;

import app.view.member.business.AddBusiness;
import app.view.member.business.EditBusiness;
import app.view.member.collateral.AddCollateral;
import app.view.member.collateral.EditCollateral;
import app.view.member.properties.AddProperty;
import app.view.member.properties.EditProperty;
import app.view.member.reference.AddReference;
import app.view.member.reference.EditReference;
import static java.awt.EventQueue.invokeLater;
import static java.lang.System.exit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/**
 *
 * @author EngkoiZidac
 */
public class UpdateMember extends javax.swing.JDialog {

    public static ManageMember frmParent;
    public static UpdateAddress frmUpdateAddress;
    public static UpdateAddressProv frmUpdateAddressProv;
    public static AddBusiness frmAddBusiness;
    public static EditBusiness frmEditBusiness;
    public static AddReference frmAddReference;
    public static EditReference frmEditReference;
    public static AddProperty frmAddProperty;
    public static EditProperty frmEditProperty;
    public static AddCollateral frmAddCollateral;
    public static EditCollateral frmEditCollateral;
    public static int Id;

    MemberController Controller = new MemberController();
    AreaController AreaController = new AreaController();
    SalaryScheduleController SalaryScheduleController = new SalaryScheduleController();
    MemberGroupController MemberGroupController = new MemberGroupController();
    BarangayController BarangayController = new BarangayController();
    CityController CityController = new CityController();
    ProvinceController ProvinceController = new ProvinceController();
    GenderController GenderController = new GenderController();
    CivilStatusController CivilStatusController = new CivilStatusController();
    MemberBusinessController MemBizController = new MemberBusinessController();
    MemberReferenceController MemRefController = new MemberReferenceController();
    MemberPropertiesController MemPropertyController = new MemberPropertiesController();
    MemberCollateralController MemberCollateralController = new MemberCollateralController();
    HouseController HouseController = new HouseController();

    private static int ComboBoxAreaId;
    private static int ComboBoxSalaryScheduleId;
    private static int ComboBoxMemberGroupId;
    public static int ComboBoxCityId, ComboBoxProvinceId, ComboBoxBarangayId, ComboBoxGenderId, ComboBoxCivilStatusId, ComboBoxHouseId, ComboBoxHouseProvId, ComboBoxBarangayProvId, ComboBoxCityProvId, ComboBoxProvinceProvId;

    static String nowDate = FunctionFactory.getSystemNowDateTimeString();

    public UpdateMember(ManageMember parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);

        PopulateFields();
        PopulateMemberBusinessData();
        PopulateMemberReferenceData();
        PopulateMemberPropertiesData();
        PopulateMemberControllerData();
    }

    public void PopulateMemberControllerData() {
        MemberCollateralController.setFKMemberID(Id);
        MemberCollateralController.PopulateTableData(TableCollateral);
    }

    public void PopulateMemberBusinessData() {
        MemBizController.setFKMemberId(Id);
        MemBizController.PopulateTableData(TableBusiness);
    }

    public void PopulateMemberReferenceData() {
        MemRefController.setFKMemberId(Id);
        MemRefController.PopulateTableData(TableReference);
    }

    public void PopulateMemberPropertiesData() {
        MemPropertyController.setFKMemberId(Id);
        MemPropertyController.PopulateTableData(TableProperties);
    }

    private void SetDates() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date theDate = null;
        try {
            theDate = sdf.parse("1980-01-01");
        } catch (ParseException e) {
        }
        //txtdate.setDateFormatString(nowDate);
        TextBirthDate.setDate(theDate);
        //  txtend.setDate(theDate);
    }

    public void ShowFrmUpdateAddress() {
        frmUpdateAddress = new UpdateAddress(this, true);
        frmUpdateAddress.setVisible(true);
    }

    public void ShowFrmEditBusiness() {
        frmEditBusiness = new EditBusiness(this, true);
        frmEditBusiness.setVisible(true);
    }

    public void ShowFrmAddBusiness() {
        frmAddBusiness = new AddBusiness(this, true);
        frmAddBusiness.setVisible(true);
    }

    public void ShowFrmAddReference() {
        frmAddReference = new AddReference(this, true);
        frmAddReference.setVisible(true);
    }

    public void ShowFrmEditReference() {
        frmEditReference = new EditReference(this, true);
        frmEditReference.setVisible(true);
    }

    public void ShowFrmAddProperty() {
        frmAddProperty = new AddProperty(this, true);
        frmAddProperty.setVisible(true);
    }

    public void ShowFrmEditProperty() {
        frmEditProperty = new EditProperty(this, true);
        frmEditProperty.setVisible(true);
    }

    public void ShowFrmAddCollateral() {
        frmAddCollateral = new AddCollateral(this, true);
        frmAddCollateral.setVisible(true);
    }

    public void ShowFrmEditCollateral() {
        frmEditCollateral = new EditCollateral(this, true);
        frmEditCollateral.setVisible(true);
    }

    public void ShowFrmUpdateAddressProv() {
        frmUpdateAddressProv = new UpdateAddressProv(this, true);
        frmUpdateAddressProv.setVisible(true);
    }

    void PopulateFields() {
        Controller.setMemberId(Id);
        Controller.PopulateDataOnEdit();
        TextFamilyName.setText(Controller.getFamilyName());
        TextFirstName.setText(Controller.getFirstName());
        TextMiddleName.setText(Controller.getMiddleName());
        TextNameExt.setText(Controller.getNameExt());
        TextAddress.setText(Controller.getAddress());
        TextAddress1.setText(Controller.getAddressProv());
        TextContactNo1.setText(Controller.getContactNo());
        TextContactNo2.setText(Controller.getContactNo2());
        TextContactNoWP.setText(Controller.getContactNoWP());
        TextBirthPlace.setText(Controller.getBirthPlace());
        TextSpouseFamilyName.setText(Controller.getSpouseFamilyName());
        TextSpouseFirstName.setText(Controller.getSpouseFirstName());
        TextSpouseMiddleName.setText(Controller.getSpouseMiddleName());
        TextSpouseNameExt.setText(Controller.getSpouseNameExt());
        TextSpouseBusiness.setText(Controller.getSpouseBusiness());
        TextSpouseEmployment.setText(Controller.getSpouseEmployment());
        TextEmployment.setText(Controller.getEmployment());
        TextMonthlySalary.setText(FunctionFactory.amountFormat(Controller.getMonthlySalary()));

        AreaController.setAreaId(Controller.getAreaId());
        ComboBoxAreaId = Controller.getAreaId();
        AreaController.PopulateComboBoxDataOnEdit(ComboArea);

        SalaryScheduleController.setSalaryScheduleId(Controller.getSalaryScheduleId());
        ComboBoxSalaryScheduleId = Controller.getSalaryScheduleId();
        SalaryScheduleController.PopulateComboBoxDataOnEdit(ComboSalarySchedule);

        MemberGroupController.setGroupId(Controller.getMemberGroupId());
        ComboBoxMemberGroupId = Controller.getMemberGroupId();
        MemberGroupController.PopulateComboBoxDataOnEdit(ComboGroup);

        ComboBoxBarangayId = Controller.getBarangayId();
        BarangayController.setBarangayId(Controller.getBarangayId());
        BarangayController.GetCurrentDescription();
        lblbrgy.setText(BarangayController.getName());

        ComboBoxBarangayProvId = Controller.getBarangayProvId();
        BarangayController.setBarangayId(Controller.getBarangayProvId());
        BarangayController.GetCurrentDescription();
        lblbrgy1.setText(BarangayController.getName());

        CityController.setCityId(Controller.getFkCityId());
        CityController.GetCurrentDescription();
        lblcity.setText(CityController.getName());

        CityController.setCityId(Controller.getCityProvId());
        CityController.GetCurrentDescription();
        lblcity1.setText(CityController.getName());

        ProvinceController.setProvinceId(Controller.getFkProvinceId());
        ProvinceController.GetCurrentDescription();
        lblprovince.setText(ProvinceController.getName());

        ProvinceController.setProvinceId(Controller.getProvinceProvId());
        ProvinceController.GetCurrentDescription();
        lblprovince1.setText(ProvinceController.getName());

        ComboBoxGenderId = Controller.getGenderId();
        if (ComboBoxGenderId == 0) {
            GenderController.PopulateComboBoxData(ComboGender);
        } else {
            GenderController.setGenderId(ComboBoxGenderId);
            GenderController.PopulateComboBoxDataOnEdit(ComboGender);
        }

        ComboBoxCivilStatusId = Controller.getCivilStatusId();
        if (ComboBoxCivilStatusId == 0) {
            CivilStatusController.PopulateComboBoxData(ComboCivilStatus);
        } else {
            CivilStatusController.setCivilStatusId(ComboBoxCivilStatusId);
            CivilStatusController.PopulateComboBoxDataOnEdit(ComboCivilStatus);
        }

        if (Controller.getBirthDate() == null) {
            SetDates();
        } else {
            TextBirthDate.setDate(Controller.getBirthDate());
        }

        ComboBoxHouseId = Controller.getHouseId();
        if (ComboBoxHouseId == 0) {
            HouseController.PopulateComboBoxData(ComboHouse);
        } else {
            HouseController.setHouseId(Controller.getHouseId());
            HouseController.PopulateComboBoxDataOnEdit(ComboHouse);
        }

        ComboBoxHouseProvId = Controller.getHouseProvId();
        if (ComboBoxHouseProvId == 0) {
            HouseController.PopulateComboBoxData(ComboHouse1);
        } else {
            HouseController.setHouseId(Controller.getHouseProvId());
            HouseController.PopulateComboBoxDataOnEdit(ComboHouse1);
        }

    }

    public void populateComboAddress(String province, String city, String brgy, int pid, int cid, int bid) {
        lblprovince.setText(province);
        lblcity.setText(city);
        lblbrgy.setText(brgy);
        ComboBoxBarangayId = bid;
        ComboBoxCityId = cid;
        ComboBoxProvinceId = pid;
    }

    public void populateComboAddressProv(String province, String city, String brgy, int pid, int cid, int bid) {
        lblprovince1.setText(province);
        lblcity1.setText(city);
        lblbrgy1.setText(brgy);
        ComboBoxBarangayProvId = bid;
        ComboBoxCityProvId = cid;
        ComboBoxProvinceProvId = pid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ComboGroup = new javax.swing.JComboBox<>();
        TextMiddleName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TextNameExt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboSalarySchedule = new javax.swing.JComboBox<>();
        TextFirstName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ComboArea = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TextFamilyName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TextAddress = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblprovince = new javax.swing.JLabel();
        lblcity = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblbrgy = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ComboHouse = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        TextAddress1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        lblprovince1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        ComboHouse1 = new javax.swing.JComboBox<>();
        lblcity1 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lblbrgy1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ComboCivilStatus = new javax.swing.JComboBox<>();
        ComboGender = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TextContactNo1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TextBirthPlace = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TextSpouseFamilyName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TextSpouseFirstName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TextSpouseMiddleName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        TextSpouseNameExt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TextSpouseEmployment = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        TextSpouseBusiness = new javax.swing.JTextField();
        TextBirthDate = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        TextContactNo2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TextContactNoWP = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        TextEmployment = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TextMonthlySalary = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBusiness = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        AddButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableReference = new javax.swing.JTable();
        AddButton1 = new javax.swing.JButton();
        EditButton1 = new javax.swing.JButton();
        AddButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableProperties = new javax.swing.JTable();
        AddButton4 = new javax.swing.JButton();
        EditButton2 = new javax.swing.JButton();
        AddButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableCollateral = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        AddButton6 = new javax.swing.JButton();
        EditButton3 = new javax.swing.JButton();
        AddButton7 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        AddButton8 = new javax.swing.JButton();
        EditButton4 = new javax.swing.JButton();
        AddButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableCollateral1 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cmdadd = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Member Record");
        setResizable(false);

        jPanel1.setToolTipText("Update Member Record");

        ComboGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboGroupActionPerformed(evt);
            }
        });

        TextMiddleName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextMiddleName.setForeground(new java.awt.Color(51, 51, 51));
        TextMiddleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextMiddleNameFocusGained(evt);
            }
        });

        jLabel10.setText("Group");

        TextNameExt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextNameExt.setForeground(new java.awt.Color(51, 51, 51));
        TextNameExt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextNameExtFocusGained(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Middle Name");

        ComboSalarySchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSalaryScheduleActionPerformed(evt);
            }
        });

        TextFirstName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextFirstName.setForeground(new java.awt.Color(51, 51, 51));
        TextFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFirstNameFocusGained(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(153, 0, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Name Ext.");

        ComboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAreaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Family Name");

        TextFamilyName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextFamilyName.setForeground(new java.awt.Color(51, 51, 51));
        TextFamilyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFamilyNameFocusGained(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(153, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("First Name");

        jLabel6.setText("Area");

        jLabel8.setText("Salary Schedule");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboSalarySchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(TextFamilyName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextNameExt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(109, 158, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TextNameExt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TextFamilyName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(ComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(ComboSalarySchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(ComboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Membership", jPanel1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Current Address");

        TextAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextAddress.setForeground(new java.awt.Color(51, 51, 51));
        TextAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextAddressFocusGained(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(153, 0, 153));
        jLabel27.setText("Home No., Street No., Purok, Sitio or Landmark");

        jLabel28.setForeground(new java.awt.Color(153, 0, 153));
        jLabel28.setText("Province");

        lblprovince.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lblcity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel29.setForeground(new java.awt.Color(153, 0, 153));
        jLabel29.setText("Municipality/City");

        jLabel30.setForeground(new java.awt.Color(153, 0, 153));
        jLabel30.setText("Barangay");

        lblbrgy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editm.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ComboHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboHouseActionPerformed(evt);
            }
        });

        jLabel37.setForeground(new java.awt.Color(153, 0, 153));
        jLabel37.setText("House");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Provincial Address");

        jLabel38.setForeground(new java.awt.Color(153, 0, 153));
        jLabel38.setText("Home No., Street No., Purok, Sitio or Landmark");

        TextAddress1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextAddress1.setForeground(new java.awt.Color(51, 51, 51));
        TextAddress1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextAddress1FocusGained(evt);
            }
        });

        jLabel39.setForeground(new java.awt.Color(153, 0, 153));
        jLabel39.setText("Province");

        lblprovince1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel40.setForeground(new java.awt.Color(153, 0, 153));
        jLabel40.setText("House");

        ComboHouse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboHouse1ActionPerformed(evt);
            }
        });

        lblcity1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel41.setForeground(new java.awt.Color(153, 0, 153));
        jLabel41.setText("Municipality/City");

        jLabel42.setForeground(new java.awt.Color(153, 0, 153));
        jLabel42.setText("Barangay");

        lblbrgy1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editm.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboHouse1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblprovince1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcity1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblbrgy1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))))
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblprovince, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcity, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblbrgy, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbrgy, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcity, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprovince, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addGap(7, 7, 7)
                .addComponent(ComboHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel39)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbrgy1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcity1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprovince1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addGap(7, 7, 7)
                .addComponent(ComboHouse1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Address", jPanel8);

        jLabel11.setText("Gender");

        jLabel12.setText("Civil Status");

        ComboCivilStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCivilStatusActionPerformed(evt);
            }
        });

        ComboGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboGenderActionPerformed(evt);
            }
        });

        jLabel7.setText("Contact No. 1");

        TextContactNo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextContactNo1.setForeground(new java.awt.Color(51, 51, 51));
        TextContactNo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextContactNo1FocusGained(evt);
            }
        });

        jLabel13.setText("Place of Birth");

        TextBirthPlace.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextBirthPlace.setForeground(new java.awt.Color(51, 51, 51));
        TextBirthPlace.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextBirthPlaceFocusGained(evt);
            }
        });

        jLabel14.setText("Birthdate");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("IF MARRIED OR With Partner:");

        jLabel16.setText("Name");

        TextSpouseFamilyName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextSpouseFamilyName.setForeground(new java.awt.Color(51, 51, 51));
        TextSpouseFamilyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextSpouseFamilyNameFocusGained(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(153, 0, 153));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Family Name");

        TextSpouseFirstName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextSpouseFirstName.setForeground(new java.awt.Color(51, 51, 51));
        TextSpouseFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextSpouseFirstNameFocusGained(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(153, 0, 153));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("First Name");

        TextSpouseMiddleName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextSpouseMiddleName.setForeground(new java.awt.Color(51, 51, 51));
        TextSpouseMiddleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextSpouseMiddleNameFocusGained(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(153, 0, 153));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Middle Name");

        TextSpouseNameExt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextSpouseNameExt.setForeground(new java.awt.Color(51, 51, 51));
        TextSpouseNameExt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextSpouseNameExtFocusGained(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(153, 0, 153));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Name Ext.");

        jLabel25.setText("Employment");

        TextSpouseEmployment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextSpouseEmployment.setForeground(new java.awt.Color(51, 51, 51));
        TextSpouseEmployment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextSpouseEmploymentFocusGained(evt);
            }
        });

        jLabel26.setText("Business");

        TextSpouseBusiness.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextSpouseBusiness.setForeground(new java.awt.Color(51, 51, 51));
        TextSpouseBusiness.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextSpouseBusinessFocusGained(evt);
            }
        });

        TextBirthDate.setDateFormatString("yyyy/MM/dd ");

        jLabel19.setText("Contact No. 2");

        TextContactNo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextContactNo2.setForeground(new java.awt.Color(51, 51, 51));
        TextContactNo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextContactNo2FocusGained(evt);
            }
        });

        jLabel20.setText("Contact No.");

        TextContactNoWP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextContactNoWP.setForeground(new java.awt.Color(51, 51, 51));
        TextContactNoWP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextContactNoWPFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TextBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addGap(760, 760, 760))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextBirthPlace)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(ComboCivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextContactNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(ComboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(117, 117, 117)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextContactNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(80, 80, 80))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(TextSpouseFamilyName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextSpouseFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TextSpouseMiddleName)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TextSpouseNameExt)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(TextSpouseBusiness, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                                    .addComponent(TextSpouseEmployment)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(TextContactNoWP, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(TextContactNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel12)
                            .addComponent(ComboCivilStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel19)
                            .addComponent(TextContactNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TextBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel14)
                        .addGap(8, 8, 8))
                    .addComponent(TextBirthDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TextSpouseFamilyName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSpouseFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSpouseMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSpouseNameExt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(TextSpouseEmployment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextSpouseBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextContactNoWP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Personal Info", jPanel2);

        jLabel31.setText("Employment");

        TextEmployment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextEmployment.setForeground(new java.awt.Color(51, 51, 51));
        TextEmployment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextEmploymentFocusGained(evt);
            }
        });

        jLabel32.setText("Monthly Salary");

        TextMonthlySalary.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        TextMonthlySalary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        TableBusiness.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Business Name", "Location", "Daily Income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableBusiness);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Owned Business");

        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        AddButton.setMnemonic('A');
        AddButton.setText("Add      ");
        AddButton.setToolTipText("Add New Record");
        AddButton.setFocusable(false);
        AddButton.setHideActionText(true);
        AddButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton.setIconTextGap(8);
        AddButton.setVerifyInputWhenFocusTarget(false);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        EditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditButton.setMnemonic('E');
        EditButton.setText("Edit      ");
        EditButton.setToolTipText("Edit Selected Record");
        EditButton.setFocusable(false);
        EditButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        EditButton.setIconTextGap(8);
        EditButton.setVerifyInputWhenFocusTarget(false);
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        AddButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton2.setMnemonic('R');
        AddButton2.setText("Remove       ");
        AddButton2.setToolTipText("Remove Selected Record");
        AddButton2.setFocusable(false);
        AddButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton2.setIconTextGap(8);
        AddButton2.setVerifyInputWhenFocusTarget(false);
        AddButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextMonthlySalary, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextEmployment, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddButton2))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(51, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextEmployment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TextMonthlySalary, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Employment and Business", jPanel3);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Personal References");

        TableReference.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Relationship", "Complete Address", "Source of Income", "ContactNo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableReference);
        if (TableReference.getColumnModel().getColumnCount() > 0) {
            TableReference.getColumnModel().getColumn(4).setHeaderValue("Source of Income");
            TableReference.getColumnModel().getColumn(5).setHeaderValue("ContactNo");
        }

        AddButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        AddButton1.setMnemonic('A');
        AddButton1.setText("Add      ");
        AddButton1.setToolTipText("Add New Record");
        AddButton1.setFocusable(false);
        AddButton1.setHideActionText(true);
        AddButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton1.setIconTextGap(8);
        AddButton1.setVerifyInputWhenFocusTarget(false);
        AddButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton1ActionPerformed(evt);
            }
        });

        EditButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditButton1.setMnemonic('E');
        EditButton1.setText("Edit      ");
        EditButton1.setToolTipText("Edit Selected Record");
        EditButton1.setFocusable(false);
        EditButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        EditButton1.setIconTextGap(8);
        EditButton1.setVerifyInputWhenFocusTarget(false);
        EditButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton1ActionPerformed(evt);
            }
        });

        AddButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton3.setMnemonic('R');
        AddButton3.setText("Remove       ");
        AddButton3.setToolTipText("Remove Selected Record");
        AddButton3.setFocusable(false);
        AddButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton3.setIconTextGap(8);
        AddButton3.setVerifyInputWhenFocusTarget(false);
        AddButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(AddButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddButton3))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("References", jPanel4);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Owned Properties");

        TableProperties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Description", "Location", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TableProperties);
        if (TableProperties.getColumnModel().getColumnCount() > 0) {
            TableProperties.getColumnModel().getColumn(2).setHeaderValue("Location");
        }

        AddButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        AddButton4.setMnemonic('A');
        AddButton4.setText("Add      ");
        AddButton4.setToolTipText("Add New Record");
        AddButton4.setFocusable(false);
        AddButton4.setHideActionText(true);
        AddButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton4.setIconTextGap(8);
        AddButton4.setVerifyInputWhenFocusTarget(false);
        AddButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton4ActionPerformed(evt);
            }
        });

        EditButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditButton2.setMnemonic('E');
        EditButton2.setText("Edit      ");
        EditButton2.setToolTipText("Edit Selected Record");
        EditButton2.setFocusable(false);
        EditButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        EditButton2.setIconTextGap(8);
        EditButton2.setVerifyInputWhenFocusTarget(false);
        EditButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton2ActionPerformed(evt);
            }
        });

        AddButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton5.setMnemonic('R');
        AddButton5.setText("Remove       ");
        AddButton5.setToolTipText("Remove Selected Record");
        AddButton5.setFocusable(false);
        AddButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton5.setIconTextGap(8);
        AddButton5.setVerifyInputWhenFocusTarget(false);
        AddButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(AddButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddButton5))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Owned Properties", jPanel5);

        TableCollateral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Type of Collateral", "Details", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TableCollateral);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Collateral");

        AddButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        AddButton6.setMnemonic('A');
        AddButton6.setText("Add      ");
        AddButton6.setToolTipText("Add New Record");
        AddButton6.setFocusable(false);
        AddButton6.setHideActionText(true);
        AddButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton6.setIconTextGap(8);
        AddButton6.setVerifyInputWhenFocusTarget(false);
        AddButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton6ActionPerformed(evt);
            }
        });

        EditButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditButton3.setMnemonic('E');
        EditButton3.setText("Edit      ");
        EditButton3.setToolTipText("Edit Selected Record");
        EditButton3.setFocusable(false);
        EditButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        EditButton3.setIconTextGap(8);
        EditButton3.setVerifyInputWhenFocusTarget(false);
        EditButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton3ActionPerformed(evt);
            }
        });

        AddButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton7.setMnemonic('R');
        AddButton7.setText("Remove       ");
        AddButton7.setToolTipText("Remove Selected Record");
        AddButton7.setFocusable(false);
        AddButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton7.setIconTextGap(8);
        AddButton7.setVerifyInputWhenFocusTarget(false);
        AddButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(AddButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddButton7))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Collateral", jPanel7);

        AddButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        AddButton8.setMnemonic('A');
        AddButton8.setText("Add      ");
        AddButton8.setToolTipText("Add New Record");
        AddButton8.setFocusable(false);
        AddButton8.setHideActionText(true);
        AddButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton8.setIconTextGap(8);
        AddButton8.setVerifyInputWhenFocusTarget(false);
        AddButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton8ActionPerformed(evt);
            }
        });

        EditButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditButton4.setMnemonic('E');
        EditButton4.setText("Edit      ");
        EditButton4.setToolTipText("Edit Selected Record");
        EditButton4.setFocusable(false);
        EditButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        EditButton4.setIconTextGap(8);
        EditButton4.setVerifyInputWhenFocusTarget(false);
        EditButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton4ActionPerformed(evt);
            }
        });

        AddButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        AddButton9.setMnemonic('R');
        AddButton9.setText("Remove       ");
        AddButton9.setToolTipText("Remove Selected Record");
        AddButton9.setFocusable(false);
        AddButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddButton9.setIconTextGap(8);
        AddButton9.setVerifyInputWhenFocusTarget(false);
        AddButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton9ActionPerformed(evt);
            }
        });

        TableCollateral1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Relation", "Occupation", "ContactNo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TableCollateral1);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Family Member");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(AddButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddButton9))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Family Member", jPanel9);

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        cmdadd.setMnemonic('A');
        cmdadd.setText("Save");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdadd)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboGroupActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboGroup.getSelectedItem();
            ComboBoxMemberGroupId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboGroupActionPerformed

    private void TextMiddleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextMiddleNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextMiddleNameFocusGained

    private void TextNameExtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextNameExtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNameExtFocusGained

    private void ComboSalaryScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSalaryScheduleActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboSalarySchedule.getSelectedItem();
            ComboBoxSalaryScheduleId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboSalaryScheduleActionPerformed

    private void TextFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFirstNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFirstNameFocusGained

    private void ComboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAreaActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboArea.getSelectedItem();
            ComboBoxAreaId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboAreaActionPerformed

    private void TextFamilyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFamilyNameFocusGained

    }//GEN-LAST:event_TextFamilyNameFocusGained

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
//        System.out.println(ComboBoxBarangayId);
        if (TextFamilyName.getText().isEmpty() == true
                || TextFirstName.getText().isEmpty() == true
                || TextAddress.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
        } else {
            Controller.setFamilyName(TextFamilyName.getText().trim());
            Controller.setFirstName(TextFirstName.getText().trim());
            Controller.setMiddleName(TextMiddleName.getText().trim());
            Controller.setNameExt(TextNameExt.getText().trim());
            Controller.setAreaId(ComboBoxAreaId);
            Controller.setSalaryScheduleId(ComboBoxSalaryScheduleId);
            Controller.setMemberGroupId(ComboBoxMemberGroupId);
            Controller.setAddress(TextAddress.getText());
            Controller.setBarangayId(ComboBoxBarangayId);
            Controller.setGenderId(ComboBoxGenderId);
            Controller.setCivilStatusId(ComboBoxCivilStatusId);
            Controller.setContactNo(TextContactNo1.getText());
            Controller.setBirthPlace(TextBirthPlace.getText());
            Controller.setSpouseFamilyName(TextSpouseFamilyName.getText());
            Controller.setSpouseFirstName(TextSpouseFirstName.getText());
            Controller.setSpouseMiddleName(TextSpouseMiddleName.getText());
            Controller.setSpouseNameExt(TextSpouseNameExt.getText());
            Controller.setSpouseBusiness(TextSpouseBusiness.getText());
            Controller.setSpouseEmployment(TextSpouseEmployment.getText());
            Controller.setBirthDate(TextBirthDate.getDate());
            Controller.setContactNo2(TextContactNo2.getText());
            Controller.setContactNoWP(TextContactNoWP.getText());
            Controller.setHouseId(ComboBoxHouseId);
            Controller.setBarangayProvId(ComboBoxBarangayProvId);
            Controller.setAddressProv(TextAddress1.getText());
            Controller.setHouseProvId(ComboBoxHouseProvId);
            

            double ms = 0;

            if (TextMonthlySalary.getText().isEmpty() != true) {
                ms = Double.parseDouble(TextMonthlySalary.getText().replace(",", ""));
            }

            Controller.setMonthlySalary(ms);
            Controller.setEmployment(TextEmployment.getText());

            //System.out.println(Controller.getBirthDate());
            Controller.Update();
            frmParent.PopulateData();
            this.dispose();
            JOptionPane.showMessageDialog(null, "Changes has been successfully saved!");
        }
    }//GEN-LAST:event_cmdaddActionPerformed

    private void ComboCivilStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCivilStatusActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboCivilStatus.getSelectedItem();
            ComboBoxCivilStatusId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboCivilStatusActionPerformed

    private void ComboGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboGenderActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboGender.getSelectedItem();
            ComboBoxGenderId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboGenderActionPerformed

    private void TextContactNo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextContactNo1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextContactNo1FocusGained

    private void TextBirthPlaceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextBirthPlaceFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextBirthPlaceFocusGained

    private void TextSpouseFamilyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextSpouseFamilyNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSpouseFamilyNameFocusGained

    private void TextSpouseFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextSpouseFirstNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSpouseFirstNameFocusGained

    private void TextSpouseMiddleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextSpouseMiddleNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSpouseMiddleNameFocusGained

    private void TextSpouseNameExtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextSpouseNameExtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSpouseNameExtFocusGained

    private void TextSpouseEmploymentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextSpouseEmploymentFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSpouseEmploymentFocusGained

    private void TextSpouseBusinessFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextSpouseBusinessFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSpouseBusinessFocusGained

    private void TextAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextAddressFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextAddressFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ShowFrmUpdateAddress();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextEmploymentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextEmploymentFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEmploymentFocusGained

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        AddBusiness.Id = Id;
        ShowFrmAddBusiness();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int col = 0; //set column value to 0
        int row = TableBusiness.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableBusiness.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableBusiness.getValueAt(row, col).toString();
            EditBusiness.BusinessId = Integer.valueOf(id);
            ShowFrmEditBusiness();
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void AddButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton2ActionPerformed
        int col = 0; //set column value to 0
        int row = TableBusiness.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableBusiness.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableBusiness.getValueAt(row, col).toString();
            int i = msgboxYesNo("Are you sure you want to delete this record");
            switch (i) {
                case 0:
                    MemBizController.setBusinessId(Integer.valueOf(id));
                    MemBizController.Remove();
                    PopulateMemberBusinessData();
                    showMessageDialog(null, "Successfully Removed!");
                    break;
                case 1:
                    break;
                case 2:
                    this.dispose(); //exit window
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_AddButton2ActionPerformed

    private void AddButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton1ActionPerformed
        AddReference.Id = Id;
        ShowFrmAddReference();
    }//GEN-LAST:event_AddButton1ActionPerformed

    private void EditButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton1ActionPerformed
        int col = 0; //set column value to 0
        int row = TableReference.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableReference.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableReference.getValueAt(row, col).toString();
            EditReference.ReferenceId = Integer.valueOf(id);
            ShowFrmEditReference();
        }
    }//GEN-LAST:event_EditButton1ActionPerformed

    private void AddButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton3ActionPerformed
        int col = 0; //set column value to 0
        int row = TableReference.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableReference.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableReference.getValueAt(row, col).toString();
            int i = msgboxYesNo("Are you sure you want to delete this record");
            switch (i) {
                case 0:
                    MemRefController.setReferenceId(Integer.valueOf(id));
                    MemRefController.Remove();
                    PopulateMemberReferenceData();
                    showMessageDialog(null, "Successfully Removed!");
                    break;
                case 1:
                    break;
                case 2:
                    this.dispose(); //exit window
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_AddButton3ActionPerformed

    private void AddButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton4ActionPerformed
        AddProperty.Id = Id;
        ShowFrmAddProperty();
    }//GEN-LAST:event_AddButton4ActionPerformed

    private void EditButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton2ActionPerformed

        int col = 0; //set column value to 0
        int row = TableProperties.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableProperties.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableProperties.getValueAt(row, col).toString();
            EditProperty.PropertyId = Integer.valueOf(id);
            ShowFrmEditProperty();
        }

    }//GEN-LAST:event_EditButton2ActionPerformed

    private void AddButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton5ActionPerformed
        int col = 0; //set column value to 0
        int row = TableProperties.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableProperties.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableProperties.getValueAt(row, col).toString();
            int i = msgboxYesNo("Are you sure you want to delete this record");
            switch (i) {
                case 0:
                    MemPropertyController.setPropertyId(Integer.valueOf(id));
                    MemPropertyController.Remove();
                    PopulateMemberPropertiesData();
                    showMessageDialog(null, "Successfully Removed!");
                    break;
                case 1:
                    break;
                case 2:
                    this.dispose(); //exit window
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_AddButton5ActionPerformed

    private void TextContactNo2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextContactNo2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextContactNo2FocusGained

    private void TextContactNoWPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextContactNoWPFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextContactNoWPFocusGained

    private void AddButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton6ActionPerformed
        AddCollateral.Id = Id;
        ShowFrmAddCollateral();
    }//GEN-LAST:event_AddButton6ActionPerformed

    private void EditButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton3ActionPerformed

        int col = 0; //set column value to 0
        int row = TableCollateral.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableCollateral.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableCollateral.getValueAt(row, col).toString();
            EditCollateral.MCollateralId = Integer.valueOf(id);
            System.out.println(Integer.valueOf(id));
            ShowFrmEditCollateral();
        }
    }//GEN-LAST:event_EditButton3ActionPerformed

    private void AddButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton7ActionPerformed
        int col = 0; //set column value to 0
        int row = TableCollateral.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (TableCollateral.isRowSelected(row) != true) {
            showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = TableCollateral.getValueAt(row, col).toString();
            int i = msgboxYesNo("Are you sure you want to delete this record");
            switch (i) {
                case 0:
                    MemberCollateralController.setMCollateralId(Integer.valueOf(id));
                    MemberCollateralController.Remove();
                    PopulateMemberControllerData();
                    showMessageDialog(null, "Successfully Removed!");
                    break;
                case 1:
                    break;
                case 2:
                    this.dispose(); //exit window
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_AddButton7ActionPerformed

    private void ComboHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboHouseActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboHouse.getSelectedItem();
            ComboBoxHouseId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboHouseActionPerformed

    private void TextAddress1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextAddress1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TextAddress1FocusGained

    private void ComboHouse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboHouse1ActionPerformed
         try {
            ComboBoxItem item = (ComboBoxItem) ComboHouse1.getSelectedItem();
            ComboBoxHouseProvId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboHouse1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ShowFrmUpdateAddressProv();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AddButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButton8ActionPerformed

    private void EditButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditButton4ActionPerformed

    private void AddButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(UpdateMember.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        invokeLater(() -> {
            UpdateMember dialog = new UpdateMember(frmParent, true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton AddButton1;
    private javax.swing.JButton AddButton2;
    private javax.swing.JButton AddButton3;
    private javax.swing.JButton AddButton4;
    private javax.swing.JButton AddButton5;
    private javax.swing.JButton AddButton6;
    private javax.swing.JButton AddButton7;
    private javax.swing.JButton AddButton8;
    private javax.swing.JButton AddButton9;
    private javax.swing.JComboBox<String> ComboArea;
    private javax.swing.JComboBox<String> ComboCivilStatus;
    private javax.swing.JComboBox<String> ComboGender;
    private javax.swing.JComboBox<String> ComboGroup;
    private javax.swing.JComboBox<String> ComboHouse;
    private javax.swing.JComboBox<String> ComboHouse1;
    private javax.swing.JComboBox<String> ComboSalarySchedule;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton EditButton1;
    private javax.swing.JButton EditButton2;
    private javax.swing.JButton EditButton3;
    private javax.swing.JButton EditButton4;
    private javax.swing.JTable TableBusiness;
    private javax.swing.JTable TableCollateral;
    private javax.swing.JTable TableCollateral1;
    private javax.swing.JTable TableProperties;
    private javax.swing.JTable TableReference;
    private javax.swing.JTextField TextAddress;
    private javax.swing.JTextField TextAddress1;
    private com.toedter.calendar.JDateChooser TextBirthDate;
    private javax.swing.JTextField TextBirthPlace;
    private javax.swing.JTextField TextContactNo1;
    private javax.swing.JTextField TextContactNo2;
    private javax.swing.JTextField TextContactNoWP;
    private javax.swing.JTextField TextEmployment;
    private javax.swing.JTextField TextFamilyName;
    private javax.swing.JTextField TextFirstName;
    private javax.swing.JTextField TextMiddleName;
    private javax.swing.JFormattedTextField TextMonthlySalary;
    private javax.swing.JTextField TextNameExt;
    private javax.swing.JTextField TextSpouseBusiness;
    private javax.swing.JTextField TextSpouseEmployment;
    private javax.swing.JTextField TextSpouseFamilyName;
    private javax.swing.JTextField TextSpouseFirstName;
    private javax.swing.JTextField TextSpouseMiddleName;
    private javax.swing.JTextField TextSpouseNameExt;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblbrgy;
    private javax.swing.JLabel lblbrgy1;
    private javax.swing.JLabel lblcity;
    private javax.swing.JLabel lblcity1;
    private javax.swing.JLabel lblprovince;
    private javax.swing.JLabel lblprovince1;
    // End of variables declaration//GEN-END:variables

}
