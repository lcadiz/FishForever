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
@Table(name = "member_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberProperties.findAll", query = "SELECT m FROM MemberProperties m")
    , @NamedQuery(name = "MemberProperties.findByPropertyId", query = "SELECT m FROM MemberProperties m WHERE m.propertyId = :propertyId")
    , @NamedQuery(name = "MemberProperties.findByDescription", query = "SELECT m FROM MemberProperties m WHERE m.description = :description")
    , @NamedQuery(name = "MemberProperties.findByLocation", query = "SELECT m FROM MemberProperties m WHERE m.location = :location")
    , @NamedQuery(name = "MemberProperties.findByValue", query = "SELECT m FROM MemberProperties m WHERE m.value = :value")
    , @NamedQuery(name = "MemberProperties.findByFKMemberId", query = "SELECT m FROM MemberProperties m WHERE m.fKMemberId = :fKMemberId")})
public class MemberProperties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PropertyId")
    private Integer propertyId;
    @Column(name = "Description")
    private String description;
    @Column(name = "Location")
    private String location;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Value")
    private double value;
    @Column(name = "FKMemberId")
    private Integer fKMemberId;

    public MemberProperties() {
    }

    public MemberProperties(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
        hash += (propertyId != null ? propertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberProperties)) {
            return false;
        }
        MemberProperties other = (MemberProperties) object;
        if ((this.propertyId == null && other.propertyId != null) || (this.propertyId != null && !this.propertyId.equals(other.propertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.MemberProperties[ propertyId=" + propertyId + " ]";
    }

}
