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
@Table(name = "payment_mode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentMode.findAll", query = "SELECT p FROM PaymentMode p")
    , @NamedQuery(name = "PaymentMode.findById", query = "SELECT p FROM PaymentMode p WHERE p.id = :id")
    , @NamedQuery(name = "PaymentMode.findByPaymentMethod", query = "SELECT p FROM PaymentMode p WHERE p.paymentMethod = :paymentMethod")
    , @NamedQuery(name = "PaymentMode.findByDivisor", query = "SELECT p FROM PaymentMode p WHERE p.divisor = :divisor")})
public class PaymentMode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @Column(name = "Divisor")
    private Integer divisor;

    public PaymentMode() {
    }

    public PaymentMode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getDivisor() {
        return divisor;
    }

    public void setDivisor(Integer divisor) {
        this.divisor = divisor;
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
        if (!(object instanceof PaymentMode)) {
            return false;
        }
        PaymentMode other = (PaymentMode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.PaymentMode[ id=" + id + " ]";
    }
    
}
