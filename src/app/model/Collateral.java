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
@Table(name = "collateral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collateral.findAll", query = "SELECT c FROM Collateral c")
    , @NamedQuery(name = "Collateral.findByCollateralId", query = "SELECT c FROM Collateral c WHERE c.collateralId = :collateralId")
    , @NamedQuery(name = "Collateral.findByDescription", query = "SELECT c FROM Collateral c WHERE c.description = :description")})
public class Collateral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollateralId")
    private Integer collateralId;
    @Column(name = "Description")
    private String description;

    public Collateral() {
    }

    public Collateral(Integer collateralId) {
        this.collateralId = collateralId;
    }

    public Integer getCollateralId() {
        return collateralId;
    }

    public void setCollateralId(Integer collateralId) {
        this.collateralId = collateralId;
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
        hash += (collateralId != null ? collateralId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collateral)) {
            return false;
        }
        Collateral other = (Collateral) object;
        if ((this.collateralId == null && other.collateralId != null) || (this.collateralId != null && !this.collateralId.equals(other.collateralId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.Collateral[ collateralId=" + collateralId + " ]";
    }
    
}
