package app.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-12T10:32:45")
@StaticMetamodel(Loan.class)
public class Loan_ { 

    public static volatile SingularAttribute<Loan, String> referrence;
    public static volatile SingularAttribute<Loan, Double> interest;
    public static volatile SingularAttribute<Loan, Date> transDate;
    public static volatile SingularAttribute<Loan, Integer> term;
    public static volatile SingularAttribute<Loan, Date> dateReleased;
    public static volatile SingularAttribute<Loan, Integer> loanId;
    public static volatile SingularAttribute<Loan, Integer> loanTypeId;
    public static volatile SingularAttribute<Loan, Double> principalAmount;
    public static volatile SingularAttribute<Loan, Integer> memberId;

}