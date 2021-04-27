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
@Table(name = "schedule_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduleType.findAll", query = "SELECT s FROM ScheduleType s")
    , @NamedQuery(name = "ScheduleType.findByScheduleTypeId", query = "SELECT s FROM ScheduleType s WHERE s.scheduleTypeId = :scheduleTypeId")
    , @NamedQuery(name = "ScheduleType.findByDescription", query = "SELECT s FROM ScheduleType s WHERE s.description = :description")})
public class ScheduleType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ScheduleTypeId")
    private Integer scheduleTypeId;
    @Column(name = "Description")
    private String description;

    public ScheduleType() {
    }

    public ScheduleType(Integer scheduleTypeId) {
        this.scheduleTypeId = scheduleTypeId;
    }

    public Integer getScheduleTypeId() {
        return scheduleTypeId;
    }

    public void setScheduleTypeId(Integer scheduleTypeId) {
        this.scheduleTypeId = scheduleTypeId;
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
        hash += (scheduleTypeId != null ? scheduleTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduleType)) {
            return false;
        }
        ScheduleType other = (ScheduleType) object;
        if ((this.scheduleTypeId == null && other.scheduleTypeId != null) || (this.scheduleTypeId != null && !this.scheduleTypeId.equals(other.scheduleTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.ScheduleType[ scheduleTypeId=" + scheduleTypeId + " ]";
    }
    
}
