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
@Table(name = "loan_ledger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanLedger.findAll", query = "SELECT l FROM LoanLedger l")
    , @NamedQuery(name = "LoanLedger.findById", query = "SELECT l FROM LoanLedger l WHERE l.id = :id")
    , @NamedQuery(name = "LoanLedger.findByTransDate", query = "SELECT l FROM LoanLedger l WHERE l.transDate = :transDate")
    , @NamedQuery(name = "LoanLedger.findByParticular", query = "SELECT l FROM LoanLedger l WHERE l.particular = :particular")
    , @NamedQuery(name = "LoanLedger.findByPrincipalAmount", query = "SELECT l FROM LoanLedger l WHERE l.principalAmount = :principalAmount")
    , @NamedQuery(name = "LoanLedger.findByAmountPaid", query = "SELECT l FROM LoanLedger l WHERE l.amountPaid = :amountPaid")
    , @NamedQuery(name = "LoanLedger.findByBalance", query = "SELECT l FROM LoanLedger l WHERE l.balance = :balance")
    , @NamedQuery(name = "LoanLedger.findByLoanId", query = "SELECT l FROM LoanLedger l WHERE l.loanId = :loanId")
    , @NamedQuery(name = "LoanLedger.findByReferrence", query = "SELECT l FROM LoanLedger l WHERE l.referrence = :referrence")
    , @NamedQuery(name = "LoanLedger.findByDatePaid", query = "SELECT l FROM LoanLedger l WHERE l.datePaid = :datePaid")})
public class LoanLedger implements Serializable {

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
    @Column(name = "Particular")
    private String particular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrincipalAmount")
    private Double principalAmount;
    @Column(name = "AmountPaid")
    private Double amountPaid;
    @Column(name = "Balance")
    private Double balance;
    @Column(name = "LoanId")
    private Integer loanId;
    @Column(name = "Referrence")
    private String referrence;
    @Column(name = "DatePaid")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaid;

    public LoanLedger() {
    }

    public LoanLedger(Integer id) {
        this.id = id;
    }

    public LoanLedger(Integer id, Date transDate) {
        this.id = id;
        this.transDate = transDate;
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

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getReferrence() {
        return referrence;
    }

    public void setReferrence(String referrence) {
        this.referrence = referrence;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
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
        if (!(object instanceof LoanLedger)) {
            return false;
        }
        LoanLedger other = (LoanLedger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.LoanLedger[ id=" + id + " ]";
    }
    
}
