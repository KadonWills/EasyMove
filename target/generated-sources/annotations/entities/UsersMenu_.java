package entities;

import entities.Users;
import entities.UsersMenu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T20:50:48")
@StaticMetamodel(UsersMenu.class)
public class UsersMenu_ { 

    public static volatile SingularAttribute<UsersMenu, String> menuKey;
    public static volatile SingularAttribute<UsersMenu, UsersMenu> useIdmenu;
    public static volatile SingularAttribute<UsersMenu, String> menuName;
    public static volatile SingularAttribute<UsersMenu, Integer> idmenu;
    public static volatile CollectionAttribute<UsersMenu, Users> usersCollection;
    public static volatile CollectionAttribute<UsersMenu, UsersMenu> usersMenuCollection;

}