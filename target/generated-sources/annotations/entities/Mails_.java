package entities;

import entities.BusTrips;
import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T20:50:48")
@StaticMetamodel(Mails.class)
public class Mails_ { 

    public static volatile SingularAttribute<Mails, Integer> mailsId;
    public static volatile SingularAttribute<Mails, String> receiverNumber;
    public static volatile SingularAttribute<Mails, BusTrips> busTrips;
    public static volatile SingularAttribute<Mails, String> senderName;
    public static volatile SingularAttribute<Mails, String> senderNumber;
    public static volatile SingularAttribute<Mails, Users> useUsersId;
    public static volatile SingularAttribute<Mails, String> receiverName;
    public static volatile SingularAttribute<Mails, Users> usersId;
    public static volatile SingularAttribute<Mails, String> mailState;
    public static volatile SingularAttribute<Mails, String> mailsType;
    public static volatile SingularAttribute<Mails, String> mailsName;

}