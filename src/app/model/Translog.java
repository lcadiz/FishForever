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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EngkoiZidac
 */
@Entity
@Table(name = "translog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translog.findAll", query = "SELECT t FROM Translog t")
    , @NamedQuery(name = "Translog.findById", query = "SELECT t FROM Translog t WHERE t.id = :id")
    , @NamedQuery(name = "Translog.findByTransDate", query = "SELECT t FROM Translog t WHERE t.transDate = :transDate")
    , @NamedQuery(name = "Translog.findByDetails", query = "SELECT t FROM Translog t WHERE t.details = :details")
    , @NamedQuery(name = "Translog.findByUserId", query = "SELECT t FROM Translog t WHERE t.userId = :userId")})
public class Translog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TransDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @Basic(optional = false)
    @Column(name = "Details")
    private String details;
    @Basic(optional = false)
    @Column(name = "UserId")
    private int userId;

    public Translog() {
    }

    public Translog(Integer id) {
        this.id = id;
    }

    public Translog(Integer id, Date transDate, String details, int userId) {
        this.id = id;
        this.transDate = transDate;
        this.details = details;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Translog)) {
            return false;
        }
        Translog other = (Translog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.Translog[ id=" + id + " ]";
    }
    
}
