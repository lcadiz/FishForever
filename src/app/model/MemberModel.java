/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EngkoiZidac
 */
@Entity
@Table(name = "member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m")
    , @NamedQuery(name = "Member1.findByMemberId", query = "SELECT m FROM Member1 m WHERE m.memberId = :memberId")
    , @NamedQuery(name = "Member1.findByFamilyName", query = "SELECT m FROM Member1 m WHERE m.familyName = :familyName")
    , @NamedQuery(name = "Member1.findByFirstName", query = "SELECT m FROM Member1 m WHERE m.firstName = :firstName")
    , @NamedQuery(name = "Member1.findByMiddleName", query = "SELECT m FROM Member1 m WHERE m.middleName = :middleName")
    , @NamedQuery(name = "Member1.findByNameExt", query = "SELECT m FROM Member1 m WHERE m.nameExt = :nameExt")
    , @NamedQuery(name = "Member1.findByAreaId", query = "SELECT m FROM Member1 m WHERE m.areaId = :areaId")
    , @NamedQuery(name = "Member1.findBySalaryScheduleId", query = "SELECT m FROM Member1 m WHERE m.salaryScheduleId = :salaryScheduleId")
    , @NamedQuery(name = "Member1.findByMemberGroupId", query = "SELECT m FROM Member1 m WHERE m.memberGroupId = :memberGroupId")
    , @NamedQuery(name = "Member1.findByAddress", query = "SELECT m FROM Member1 m WHERE m.address = :address")
    , @NamedQuery(name = "Member1.findByBarangayId", query = "SELECT m FROM Member1 m WHERE m.barangayId = :barangayId")})
public class MemberModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MemberId")
    private Integer memberId;
    @Basic(optional = false)
    @Column(name = "FamilyName")
    private String familyName;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Column(name = "NameExt")
    private String nameExt;
    @Basic(optional = false)
    @Column(name = "AreaId")
    private int areaId;
    @Basic(optional = false)
    @Column(name = "SalaryScheduleId")
    private int salaryScheduleId;
    @Basic(optional = false)
    @Column(name = "MemberGroupId")
    private int memberGroupId;
    @Column(name = "GenderId")
    private Integer genderId;
    @Column(name = "CivilStatusId")
    private Integer civilStatusId;
    @Column(name = "ContactNo")
    private String contactNo;
    @Column(name = "BirthPlace")
    private String birthPlace;
    @Column(name = "SpouseFamilyName")
    private String spouseFamilyName;
    @Column(name = "SpouseFirstName")
    private String spouseFirstName;
    @Column(name = "SpouseMiddleName")
    private String spouseMiddleName;
    @Column(name = "SpouseNameExt")
    private String spouseNameExt;
    @Column(name = "SpouseEmployment")
    private String spouseEmployment;
    @Column(name = "SpouseBusiness")
    private String spouseBusiness;
    @Column(name = "BirthDate")
    private Date birthDate;
    @Column(name = "Employment")
    private String employment;
    @Column(name = "MonthlySalary")
    private double monthlySalary;
    @Column(name = "ContactNo2")
    private String contactNo2;
    @Column(name = "ContactNoWP")
    private String contactNoWP;
    @Column(name = "HouseId")
    private Integer houseId;
    @Column(name = "BarangayProvId")
    private Integer barangayProvId;
    @Column(name = "ProvinceProvId")
    private Integer provinceProvId;
    @Column(name = "CityProvId")
    private Integer cityProvId;
    @Column(name = "HouseProvId")
    private Integer houseProvId;
    @Column(name = "BarangayId")
    private Integer barangayId;
    @Column(name = "FKCityId")
    private Integer fkCityId;
    @Column(name = "FKProvinceId")
    private Integer fkProvinceId;
    @Column(name = "Address")
    private String address;
    @Column(name = "AddressProv")
    
    private String addressProv;

    public String getAddressProv() {
        return addressProv;
    }

    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv;
    }

    public Integer getProvinceProvId() {
        return provinceProvId;
    }

    public void setProvinceProvId(Integer provinceProvId) {
        this.provinceProvId = provinceProvId;
    }

    public Integer getCityProvId() {
        return cityProvId;
    }

    public void setCityProvId(Integer cityProvId) {
        this.cityProvId = cityProvId;
    }

    public Integer getHouseProvId() {
        return houseProvId;
    }

    public void setHouseProvId(Integer houseProvId) {
        this.houseProvId = houseProvId;
    }

    public Integer getBarangayProvId() {
        return barangayProvId;
    }

    public void setBarangayProvId(Integer barangayProvId) {
        this.barangayProvId = barangayProvId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getContactNoWP() {
        return contactNoWP;
    }

    public void setContactNoWP(String contactNoWP) {
        this.contactNoWP = contactNoWP;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getSpouseFamilyName() {
        return spouseFamilyName;
    }

    public void setSpouseFamilyName(String spouseFamilyName) {
        this.spouseFamilyName = spouseFamilyName;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseMiddleName() {
        return spouseMiddleName;
    }

    public void setSpouseMiddleName(String spouseMiddleName) {
        this.spouseMiddleName = spouseMiddleName;
    }

    public String getSpouseNameExt() {
        return spouseNameExt;
    }

    public void setSpouseNameExt(String spouseNameExt) {
        this.spouseNameExt = spouseNameExt;
    }

    public String getSpouseEmployment() {
        return spouseEmployment;
    }

    public void setSpouseEmployment(String spouseEmployment) {
        this.spouseEmployment = spouseEmployment;
    }

    public String getSpouseBusiness() {
        return spouseBusiness;
    }

    public void setSpouseBusiness(String spouseBusiness) {
        this.spouseBusiness = spouseBusiness;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(Integer civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public Integer getFkCityId() {
        return fkCityId;
    }

    public void setFkCityId(Integer fkCityId) {
        this.fkCityId = fkCityId;
    }

    public Integer getFkProvinceId() {
        return fkProvinceId;
    }

    public void setFkProvinceId(Integer fkProvinceId) {
        this.fkProvinceId = fkProvinceId;
    }

    public MemberModel() {
    }

    public MemberModel(Integer memberId) {
        this.memberId = memberId;
    }

    public MemberModel(Integer memberId, String familyName, String firstName, int areaId, int salaryScheduleId, int memberGroupId) {
        this.memberId = memberId;
        this.familyName = familyName;
        this.firstName = firstName;
        this.areaId = areaId;
        this.salaryScheduleId = salaryScheduleId;
        this.memberGroupId = memberGroupId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNameExt() {
        return nameExt;
    }

    public void setNameExt(String nameExt) {
        this.nameExt = nameExt;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getSalaryScheduleId() {
        return salaryScheduleId;
    }

    public void setSalaryScheduleId(int salaryScheduleId) {
        this.salaryScheduleId = salaryScheduleId;
    }

    public int getMemberGroupId() {
        return memberGroupId;
    }

    public void setMemberGroupId(int memberGroupId) {
        this.memberGroupId = memberGroupId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBarangayId() {
        return barangayId;
    }

    public void setBarangayId(Integer barangayId) {
        this.barangayId = barangayId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberModel)) {
            return false;
        }
        MemberModel other = (MemberModel) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.Member1[ memberId=" + memberId + " ]";
    }

}
