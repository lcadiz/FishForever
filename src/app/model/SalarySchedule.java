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
@Table(name = "salary_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalarySchedule.findAll", query = "SELECT s FROM SalarySchedule s")
    , @NamedQuery(name = "SalarySchedule.findBySalaryScheduleId", query = "SELECT s FROM SalarySchedule s WHERE s.salaryScheduleId = :salaryScheduleId")
    , @NamedQuery(name = "SalarySchedule.findByDescription", query = "SELECT s FROM SalarySchedule s WHERE s.description = :description")
    , @NamedQuery(name = "SalarySchedule.findByRemarks", query = "SELECT s FROM SalarySchedule s WHERE s.remarks = :remarks")})
public class SalarySchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SalaryScheduleId")
    private Integer salaryScheduleId;
    @Column(name = "Description")
    private String description;
    @Column(name = "Remarks")
    private String remarks;

    public SalarySchedule() {
    }

    public SalarySchedule(Integer salaryScheduleId) {
        this.salaryScheduleId = salaryScheduleId;
    }

    public Integer getSalaryScheduleId() {
        return salaryScheduleId;
    }

    public void setSalaryScheduleId(Integer salaryScheduleId) {
        this.salaryScheduleId = salaryScheduleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryScheduleId != null ? salaryScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalarySchedule)) {
            return false;
        }
        SalarySchedule other = (SalarySchedule) object;
        if ((this.salaryScheduleId == null && other.salaryScheduleId != null) || (this.salaryScheduleId != null && !this.salaryScheduleId.equals(other.salaryScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.SalarySchedule[ salaryScheduleId=" + salaryScheduleId + " ]";
    }
    
}
