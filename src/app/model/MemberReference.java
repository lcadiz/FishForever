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
@Table(name = "member_reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberReference.findAll", query = "SELECT m FROM MemberReference m")
    , @NamedQuery(name = "MemberReference.findByReferenceId", query = "SELECT m FROM MemberReference m WHERE m.referenceId = :referenceId")
    , @NamedQuery(name = "MemberReference.findByFullName", query = "SELECT m FROM MemberReference m WHERE m.fullName = :fullName")
    , @NamedQuery(name = "MemberReference.findByRelationship", query = "SELECT m FROM MemberReference m WHERE m.relationship = :relationship")
    , @NamedQuery(name = "MemberReference.findByAddress", query = "SELECT m FROM MemberReference m WHERE m.address = :address")
    , @NamedQuery(name = "MemberReference.findBySourceIncome", query = "SELECT m FROM MemberReference m WHERE m.sourceIncome = :sourceIncome")
    , @NamedQuery(name = "MemberReference.findByContactNo", query = "SELECT m FROM MemberReference m WHERE m.contactNo = :contactNo")
    , @NamedQuery(name = "MemberReference.findByFKMemberId", query = "SELECT m FROM MemberReference m WHERE m.fKMemberId = :fKMemberId")})
public class MemberReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReferenceId")
    private Integer referenceId;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Relationship")
    private String relationship;
    @Column(name = "Address")
    private String address;
    @Column(name = "SourceIncome")
    private String sourceIncome;
    @Column(name = "ContactNo")
    private String contactNo;
    @Column(name = "FKMemberId")
    private Integer fKMemberId;

    public MemberReference() {
    }

    public MemberReference(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSourceIncome() {
        return sourceIncome;
    }

    public void setSourceIncome(String sourceIncome) {
        this.sourceIncome = sourceIncome;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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
        hash += (referenceId != null ? referenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberReference)) {
            return false;
        }
        MemberReference other = (MemberReference) object;
        if ((this.referenceId == null && other.referenceId != null) || (this.referenceId != null && !this.referenceId.equals(other.referenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.MemberReference[ referenceId=" + referenceId + " ]";
    }
    
}
