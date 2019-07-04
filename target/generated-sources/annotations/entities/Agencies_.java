package entities;

import entities.Trips;
import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T20:50:48")
@StaticMetamodel(Agencies.class)
public class Agencies_ { 

    public static volatile SingularAttribute<Agencies, String> agenciesName;
    public static volatile SingularAttribute<Agencies, String> town;
    public static volatile CollectionAttribute<Agencies, Trips> tripsCollection;
    public static volatile SingularAttribute<Agencies, Integer> agenciesId;
    public static volatile CollectionAttribute<Agencies, Trips> tripsCollection1;
    public static volatile CollectionAttribute<Agencies, Users> usersCollection;
    public static volatile SingularAttribute<Agencies, String> quarter;

}