/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;

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
@Table(name = "member_collateral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberCollateral.findAll", query = "SELECT m FROM MemberCollateral m")
    , @NamedQuery(name = "MemberCollateral.findByMCollateralId", query = "SELECT m FROM MemberCollateral m WHERE m.mCollateralId = :mCollateralId")
    , @NamedQuery(name = "MemberCollateral.findByFKCollateralId", query = "SELECT m FROM MemberCollateral m WHERE m.fKCollateralId = :fKCollateralId")
    , @NamedQuery(name = "MemberCollateral.findByDetails", query = "SELECT m FROM MemberCollateral m WHERE m.details = :details")
    , @NamedQuery(name = "MemberCollateral.findByValue", query = "SELECT m FROM MemberCollateral m WHERE m.value = :value")
    , @NamedQuery(name = "MemberCollateral.findByFKMemberID", query = "SELECT m FROM MemberCollateral m WHERE m.fKMemberID = :fKMemberID")})
public class MemberCollateral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MCollateralId")
    private Integer mCollateralId;
    @Basic(optional = false)
    @Column(name = "FKCollateralId")
    private int fKCollateralId;
    @Column(name = "Details")
    private String details;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Value")
    private double value;
    @Basic(optional = false)
    @Column(name = "FKMemberID")
    private int fKMemberID;

    public MemberCollateral() {
    }

    public MemberCollateral(Integer mCollateralId) {
        this.mCollateralId = mCollateralId;
    }

    public MemberCollateral(Integer mCollateralId, int fKCollateralId, double value, int fKMemberID) {
        this.mCollateralId = mCollateralId;
        this.fKCollateralId = fKCollateralId;
        this.value = value;
        this.fKMemberID = fKMemberID;
    }

    public Integer getMCollateralId() {
        return mCollateralId;
    }

    public void setMCollateralId(Integer mCollateralId) {
        this.mCollateralId = mCollateralId;
    }

    public int getFKCollateralId() {
        return fKCollateralId;
    }

    public void setFKCollateralId(int fKCollateralId) {
        this.fKCollateralId = fKCollateralId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getFKMemberID() {
        return fKMemberID;
    }

    public void setFKMemberID(int fKMemberID) {
        this.fKMemberID = fKMemberID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mCollateralId != null ? mCollateralId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberCollateral)) {
            return false;
        }
        MemberCollateral other = (MemberCollateral) object;
        if ((this.mCollateralId == null && other.mCollateralId != null) || (this.mCollateralId != null && !this.mCollateralId.equals(other.mCollateralId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.MemberCollateral[ mCollateralId=" + mCollateralId + " ]";
    }
    
}
