package entities;

import entities.BusTrips;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-03T09:18:39")
@StaticMetamodel(Buses.class)
public class Buses_ { 

    public static volatile SingularAttribute<Buses, String> colour;
    public static volatile CollectionAttribute<Buses, BusTrips> busTripsCollection;
    public static volatile SingularAttribute<Buses, Integer> numOfSits;
    public static volatile SingularAttribute<Buses, Integer> id;
    public static volatile SingularAttribute<Buses, String> busNumber;

}