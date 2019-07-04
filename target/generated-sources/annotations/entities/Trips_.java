package entities;

import entities.Agencies;
import entities.BusTrips;
import entities.Reservations;
import entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T20:50:48")
@StaticMetamodel(Trips.class)
public class Trips_ { 

    public static volatile SingularAttribute<Trips, String> arrivalAgency;
    public static volatile CollectionAttribute<Trips, BusTrips> busTripsCollection;
    public static volatile CollectionAttribute<Trips, Reservations> reservationsCollection;
    public static volatile SingularAttribute<Trips, String> departAgency;
    public static volatile SingularAttribute<Trips, Date> arrival;
    public static volatile SingularAttribute<Trips, String> price;
    public static volatile SingularAttribute<Trips, Users> usersId;
    public static volatile SingularAttribute<Trips, String> tripsType;
    public static volatile SingularAttribute<Trips, Agencies> agenciesId;
    public static volatile SingularAttribute<Trips, Date> departure;
    public static volatile SingularAttribute<Trips, Agencies> ageAgenciesId;
    public static volatile SingularAttribute<Trips, Integer> tripsId;

}