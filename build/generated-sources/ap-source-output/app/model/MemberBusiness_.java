package app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-12T10:32:45")
@StaticMetamodel(MemberBusiness.class)
public class MemberBusiness_ { 

    public static volatile SingularAttribute<MemberBusiness, Integer> businessId;
    public static volatile SingularAttribute<MemberBusiness, Double> dailyIncome;
    public static volatile SingularAttribute<MemberBusiness, String> description;
    public static volatile SingularAttribute<MemberBusiness, String> location;
    public static volatile SingularAttribute<MemberBusiness, Integer> fKMemberId;

}