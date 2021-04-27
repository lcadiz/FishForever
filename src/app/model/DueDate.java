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
@Table(name = "due_date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DueDate.findAll", query = "SELECT d FROM DueDate d")
    , @NamedQuery(name = "DueDate.findByDueDateId", query = "SELECT d FROM DueDate d WHERE d.dueDateId = :dueDateId")
    , @NamedQuery(name = "DueDate.findBySalaryScheduleId", query = "SELECT d FROM DueDate d WHERE d.salaryScheduleId = :salaryScheduleId")
    , @NamedQuery(name = "DueDate.findById", query = "SELECT d FROM DueDate d WHERE d.id = :id")})
public class DueDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DueDateId")
    private Integer dueDateId;
    @Basic(optional = false)
    @Column(name = "SalaryScheduleId")
    private int salaryScheduleId;
    @Basic(optional = false)
    @Column(name = "Id")
    private int id;

    public DueDate() {
    }

    public DueDate(Integer dueDateId) {
        this.dueDateId = dueDateId;
    }

    public DueDate(Integer dueDateId, int salaryScheduleId, int id) {
        this.dueDateId = dueDateId;
        this.salaryScheduleId = salaryScheduleId;
        this.id = id;
    }

    public Integer getDueDateId() {
        return dueDateId;
    }

    public void setDueDateId(Integer dueDateId) {
        this.dueDateId = dueDateId;
    }

    public int getSalaryScheduleId() {
        return salaryScheduleId;
    }

    public void setSalaryScheduleId(int salaryScheduleId) {
        this.salaryScheduleId = salaryScheduleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dueDateId != null ? dueDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DueDate)) {
            return false;
        }
        DueDate other = (DueDate) object;
        if ((this.dueDateId == null && other.dueDateId != null) || (this.dueDateId != null && !this.dueDateId.equals(other.dueDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.DueDate[ dueDateId=" + dueDateId + " ]";
    }
    
}
