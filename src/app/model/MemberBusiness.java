/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "member_business")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberBusiness.findAll", query = "SELECT m FROM MemberBusiness m")
    , @NamedQuery(name = "MemberBusiness.findByBusinessId", query = "SELECT m FROM MemberBusiness m WHERE m.businessId = :businessId")
    , @NamedQuery(name = "MemberBusiness.findByDescription", query = "SELECT m FROM MemberBusiness m WHERE m.description = :description")
    , @NamedQuery(name = "MemberBusiness.findByLocation", query = "SELECT m FROM MemberBusiness m WHERE m.location = :location")
    , @NamedQuery(name = "MemberBusiness.findByDailyIncome", query = "SELECT m FROM MemberBusiness m WHERE m.dailyIncome = :dailyIncome")
    , @NamedQuery(name = "MemberBusiness.findByFKMemberId", query = "SELECT m FROM MemberBusiness m WHERE m.fKMemberId = :fKMemberId")})
public class MemberBusiness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusinessId")
    private Integer businessId;
    @Column(name = "Description")
    private String description;
    @Column(name = "Location")
    private String location;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DailyIncome")
    private double dailyIncome;
    @Column(name = "FKMemberId")
    private Integer fKMemberId;

    public MemberBusiness() {
    }

    public MemberBusiness(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getFKMemberId() {
        return fKMemberId;
    }

    public void setFKMemberId(Integer fKMemberId) {
        this.fKMemberId = fKMemberId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessId != null ? businessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberBusiness)) {
            return false;
        }
        MemberBusiness other = (MemberBusiness) object;
        if ((this.businessId == null && other.businessId != null) || (this.businessId != null && !this.businessId.equals(other.businessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.MemberBusiness[ businessId=" + businessId + " ]";
    }
    
}
