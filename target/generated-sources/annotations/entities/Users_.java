package entities;

import entities.Agencies;
import entities.Mails;
import entities.Operations;
import entities.Reservations;
import entities.Trips;
import entities.Users;
import entities.UsersMenu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T20:50:48")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile SingularAttribute<Users, String> usersPassword;
    public static volatile CollectionAttribute<Users, Mails> mailsCollection1;
    public static volatile CollectionAttribute<Users, Reservations> reservationsCollection;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile CollectionAttribute<Users, Trips> tripsCollection;
    public static volatile SingularAttribute<Users, Users> useUsersId;
    public static volatile SingularAttribute<Users, String> idCard;
    public static volatile SingularAttribute<Users, String> photo;
    public static volatile SingularAttribute<Users, String> phoneNum;
    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile CollectionAttribute<Users, Operations> operationsCollection;
    public static volatile SingularAttribute<Users, String> usersStatus;
    public static volatile CollectionAttribute<Users, Mails> mailsCollection;
    public static volatile SingularAttribute<Users, Integer> usersId;
    public static volatile SingularAttribute<Users, String> lusersOgin;
    public static volatile SingularAttribute<Users, String> adresse;
    public static volatile SingularAttribute<Users, String> usersRole;
    public static volatile SingularAttribute<Users, Agencies> agenciesId;
    public static volatile CollectionAttribute<Users, Users> usersCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile CollectionAttribute<Users, UsersMenu> usersMenuCollection;

}