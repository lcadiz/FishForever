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
@Table(name = "civil_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CivilStatus.findAll", query = "SELECT c FROM CivilStatus c")
    , @NamedQuery(name = "CivilStatus.findByCivilStatusId", query = "SELECT c FROM CivilStatus c WHERE c.civilStatusId = :civilStatusId")
    , @NamedQuery(name = "CivilStatus.findByDescription", query = "SELECT c FROM CivilStatus c WHERE c.description = :description")})
public class CivilStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CivilStatusId")
    private Integer civilStatusId;
    @Column(name = "Description")
    private String description;

    public CivilStatus() {
    }

    public CivilStatus(Integer civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public Integer getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(Integer civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (civilStatusId != null ? civilStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CivilStatus)) {
            return false;
        }
        CivilStatus other = (CivilStatus) object;
        if ((this.civilStatusId == null && other.civilStatusId != null) || (this.civilStatusId != null && !this.civilStatusId.equals(other.civilStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.CivilStatus[ civilStatusId=" + civilStatusId + " ]";
    }
    
}
