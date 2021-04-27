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
@Table(name = "barangay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barangay.findAll", query = "SELECT b FROM Barangay b")
    , @NamedQuery(name = "Barangay.findByBarangayId", query = "SELECT b FROM Barangay b WHERE b.barangayId = :barangayId")
    , @NamedQuery(name = "Barangay.findByName", query = "SELECT b FROM Barangay b WHERE b.name = :name")
    , @NamedQuery(name = "Barangay.findByCityId", query = "SELECT b FROM Barangay b WHERE b.cityId = :cityId")})
public class Barangay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BarangayId")
    private Integer barangayId;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "CityId")
    private Integer cityId;

    public Barangay() {
    }

    public Barangay(Integer barangayId) {
        this.barangayId = barangayId;
    }

    public Barangay(Integer barangayId, String name) {
        this.barangayId = barangayId;
        this.name = name;
    }

    public Integer getBarangayId() {
        return barangayId;
    }

    public void setBarangayId(Integer barangayId) {
        this.barangayId = barangayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barangayId != null ? barangayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barangay)) {
            return false;
        }
        Barangay other = (Barangay) object;
        if ((this.barangayId == null && other.barangayId != null) || (this.barangayId != null && !this.barangayId.equals(other.barangayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.Barangay[ barangayId=" + barangayId + " ]";
    }
    
}
