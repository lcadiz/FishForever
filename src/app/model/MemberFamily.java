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
@Table(name = "member_family")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberFamily.findAll", query = "SELECT m FROM MemberFamily m")
    , @NamedQuery(name = "MemberFamily.findByFamilyId", query = "SELECT m FROM MemberFamily m WHERE m.familyId = :familyId")
    , @NamedQuery(name = "MemberFamily.findByName", query = "SELECT m FROM MemberFamily m WHERE m.name = :name")
    , @NamedQuery(name = "MemberFamily.findByOccupation", query = "SELECT m FROM MemberFamily m WHERE m.occupation = :occupation")
    , @NamedQuery(name = "MemberFamily.findByContactNo", query = "SELECT m FROM MemberFamily m WHERE m.contactNo = :contactNo")
    , @NamedQuery(name = "MemberFamily.findByFKMemberID", query = "SELECT m FROM MemberFamily m WHERE m.fKMemberID = :fKMemberID")
    , @NamedQuery(name = "MemberFamily.findByRelation", query = "SELECT m FROM MemberFamily m WHERE m.relation = :relation")})
public class MemberFamily implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FamilyId")
    private Integer familyId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Occupation")
    private String occupation;
    @Column(name = "ContactNo")
    private String contactNo;
    @Column(name = "FKMemberID")
    private Integer fKMemberID;
    @Column(name = "Relation")
    private String relation;

    public MemberFamily() {
    }

    public MemberFamily(Integer familyId) {
        this.familyId = familyId;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Integer getFKMemberID() {
        return fKMemberID;
    }

    public void setFKMemberID(Integer fKMemberID) {
        this.fKMemberID = fKMemberID;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familyId != null ? familyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberFamily)) {
            return false;
        }
        MemberFamily other = (MemberFamily) object;
        if ((this.familyId == null && other.familyId != null) || (this.familyId != null && !this.familyId.equals(other.familyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.MemberFamily[ familyId=" + familyId + " ]";
    }
    
}
