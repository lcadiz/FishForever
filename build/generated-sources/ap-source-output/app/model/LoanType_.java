package app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-12T10:32:45")
@StaticMetamodel(LoanType.class)
public class LoanType_ { 

    public static volatile SingularAttribute<LoanType, Double> interestRate;
    public static volatile SingularAttribute<LoanType, String> description;
    public static volatile SingularAttribute<LoanType, Integer> term;
    public static volatile SingularAttribute<LoanType, Integer> loanTypeId;

}