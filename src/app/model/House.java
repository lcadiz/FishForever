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
@Table(name = "house")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "House.findAll", query = "SELECT h FROM House h")
    , @NamedQuery(name = "House.findByHouseId", query = "SELECT h FROM House h WHERE h.houseId = :houseId")
    , @NamedQuery(name = "House.findByDescription", query = "SELECT h FROM House h WHERE h.description = :description")})
public class House implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HouseId")
    private Integer houseId;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;

    public House() {
    }

    public House(Integer houseId) {
        this.houseId = houseId;
    }

    public House(Integer houseId, String description) {
        this.houseId = houseId;
        this.description = description;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
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
        hash += (houseId != null ? houseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof House)) {
            return false;
        }
        House other = (House) object;
        if ((this.houseId == null && other.houseId != null) || (this.houseId != null && !this.houseId.equals(other.houseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.House[ houseId=" + houseId + " ]";
    }
    
}
