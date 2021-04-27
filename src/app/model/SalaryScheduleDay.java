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
@Table(name = "salary_schedule_day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalaryScheduleDay.findAll", query = "SELECT s FROM SalaryScheduleDay s")
    , @NamedQuery(name = "SalaryScheduleDay.findBySSId", query = "SELECT s FROM SalaryScheduleDay s WHERE s.sSId = :sSId")
    , @NamedQuery(name = "SalaryScheduleDay.findById", query = "SELECT s FROM SalaryScheduleDay s WHERE s.id = :id")})
public class SalaryScheduleDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SSId")
    private Integer sSId;
    @Column(name = "Id")
    private Integer id;

    public SalaryScheduleDay() {
    }

    public SalaryScheduleDay(Integer sSId) {
        this.sSId = sSId;
    }

    public Integer getSSId() {
        return sSId;
    }

    public void setSSId(Integer sSId) {
        this.sSId = sSId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sSId != null ? sSId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaryScheduleDay)) {
            return false;
        }
        SalaryScheduleDay other = (SalaryScheduleDay) object;
        if ((this.sSId == null && other.sSId != null) || (this.sSId != null && !this.sSId.equals(other.sSId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.SalaryScheduleDay[ sSId=" + sSId + " ]";
    }
    
}
