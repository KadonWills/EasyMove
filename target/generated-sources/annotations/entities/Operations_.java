package entities;

import entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-03T09:18:39")
@StaticMetamodel(Operations.class)
public class Operations_ { 

    public static volatile SingularAttribute<Operations, Date> operationDate;
    public static volatile SingularAttribute<Operations, Integer> idOperations;
    public static volatile SingularAttribute<Operations, String> operationTarget;
    public static volatile SingularAttribute<Operations, Users> usersId;
    public static volatile SingularAttribute<Operations, String> operationsName;

}