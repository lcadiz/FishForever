package app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-12T10:32:45")
@StaticMetamodel(MemberCollateral.class)
public class MemberCollateral_ { 

    public static volatile SingularAttribute<MemberCollateral, Integer> mCollateralId;
    public static volatile SingularAttribute<MemberCollateral, Integer> fKCollateralId;
    public static volatile SingularAttribute<MemberCollateral, String> details;
    public static volatile SingularAttribute<MemberCollateral, Double> value;
    public static volatile SingularAttribute<MemberCollateral, Integer> fKMemberID;

}