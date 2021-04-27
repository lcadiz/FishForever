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
@Table(name = "loan_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanType.findAll", query = "SELECT l FROM LoanType l")
    , @NamedQuery(name = "LoanType.findByLoanTypeId", query = "SELECT l FROM LoanType l WHERE l.loanTypeId = :loanTypeId")
    , @NamedQuery(name = "LoanType.findByDescription", query = "SELECT l FROM LoanType l WHERE l.description = :description")
    , @NamedQuery(name = "LoanType.findByInterestRate", query = "SELECT l FROM LoanType l WHERE l.interestRate = :interestRate")
    , @NamedQuery(name = "LoanType.findByTerm", query = "SELECT l FROM LoanType l WHERE l.term = :term")})
public class LoanType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LoanTypeId")
    private Integer loanTypeId;
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "InterestRate")
    private Double interestRate;
    @Column(name = "Term")
    private Integer term;

    public LoanType() {
    }

    public LoanType(Integer loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public Integer getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(Integer loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanTypeId != null ? loanTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanType)) {
            return false;
        }
        LoanType other = (LoanType) object;
        if ((this.loanTypeId == null && other.loanTypeId != null) || (this.loanTypeId != null && !this.loanTypeId.equals(other.loanTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.LoanType[ loanTypeId=" + loanTypeId + " ]";
    }
    
}
