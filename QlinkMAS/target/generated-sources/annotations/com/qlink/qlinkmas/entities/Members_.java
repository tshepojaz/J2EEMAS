package com.qlink.qlinkmas.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2015-03-15T10:09:16")
@StaticMetamodel(Members.class)
public class Members_ { 

    public static volatile SingularAttribute<Members, Long> idNo;
    public static volatile SingularAttribute<Members, String> lastName;
    public static volatile SingularAttribute<Members, Integer> cellNo;
    public static volatile SingularAttribute<Members, String> initials;
    public static volatile SingularAttribute<Members, String> email;
    public static volatile SingularAttribute<Members, Date> dob;
    public static volatile SingularAttribute<Members, String> gender;
    public static volatile SingularAttribute<Members, Integer> memberId;
    public static volatile SingularAttribute<Members, String> firstName;

}