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
@Table(name = "loan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l")
    , @NamedQuery(name = "Loan.findByLoanId", query = "SELECT l FROM Loan l WHERE l.loanId = :loanId")
    , @NamedQuery(name = "Loan.findByTransDate", query = "SELECT l FROM Loan l WHERE l.transDate = :transDate")
    , @NamedQuery(name = "Loan.findByReferrence", query = "SELECT l FROM Loan l WHERE l.referrence = :referrence")
    , @NamedQuery(name = "Loan.findByLoanTypeId", query = "SELECT l FROM Loan l WHERE l.loanTypeId = :loanTypeId")
    , @NamedQuery(name = "Loan.findByInterest", query = "SELECT l FROM Loan l WHERE l.interest = :interest")
    , @NamedQuery(name = "Loan.findByTerm", query = "SELECT l FROM Loan l WHERE l.term = :term")
    , @NamedQuery(name = "Loan.findByPrincipalAmount", query = "SELECT l FROM Loan l WHERE l.principalAmount = :principalAmount")
    , @NamedQuery(name = "Loan.findByDateReleased", query = "SELECT l FROM Loan l WHERE l.dateReleased = :dateReleased")
    , @NamedQuery(name = "Loan.findByMemberId", query = "SELECT l FROM Loan l WHERE l.memberId = :memberId")})
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LoanId")
    private Integer loanId;
    @Basic(optional = false)
    @Column(name = "TransDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @Basic(optional = false)
    @Column(name = "Referrence")
    private String referrence;
    @Basic(optional = false)
    @Column(name = "LoanTypeId")
    private int loanTypeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Interest")
    private Double interest;
    @Column(name = "Term")
    private Integer term;
    @Column(name = "PrincipalAmount")
    private Double principalAmount;
    @Column(name = "DateReleased")
    @Temporal(TemporalType.DATE)
    private Date dateReleased;
    @Column(name = "MemberId")
    private Integer memberId;

    public Loan() {
    }

    public Loan(Integer loanId) {
        this.loanId = loanId;
    }

    public Loan(Integer loanId, Date transDate, String referrence, int loanTypeId) {
        this.loanId = loanId;
        this.transDate = transDate;
        this.referrence = referrence;
        this.loanTypeId = loanTypeId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getReferrence() {
        return referrence;
    }

    public void setReferrence(String referrence) {
        this.referrence = referrence;
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanId != null ? loanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.loanId == null && other.loanId != null) || (this.loanId != null && !this.loanId.equals(other.loanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.Loan[ loanId=" + loanId + " ]";
    }
    
}
