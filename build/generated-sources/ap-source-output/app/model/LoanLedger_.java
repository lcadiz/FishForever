package app.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-12T10:32:45")
@StaticMetamodel(LoanLedger.class)
public class LoanLedger_ { 

    public static volatile SingularAttribute<LoanLedger, String> referrence;
    public static volatile SingularAttribute<LoanLedger, Date> datePaid;
    public static volatile SingularAttribute<LoanLedger, Double> amountPaid;
    public static volatile SingularAttribute<LoanLedger, Double> balance;
    public static volatile SingularAttribute<LoanLedger, Date> transDate;
    public static volatile SingularAttribute<LoanLedger, String> particular;
    public static volatile SingularAttribute<LoanLedger, Integer> id;
    public static volatile SingularAttribute<LoanLedger, Double> principalAmount;
    public static volatile SingularAttribute<LoanLedger, Integer> loanId;

}