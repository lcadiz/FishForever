package app.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-12T10:32:45")
@StaticMetamodel(Translog.class)
public class Translog_ { 

    public static volatile SingularAttribute<Translog, Date> transDate;
    public static volatile SingularAttribute<Translog, String> details;
    public static volatile SingularAttribute<Translog, Integer> id;
    public static volatile SingularAttribute<Translog, Integer> userId;

}