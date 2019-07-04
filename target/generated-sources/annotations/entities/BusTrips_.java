package entities;

import entities.BusTripsPK;
import entities.Buses;
import entities.Mails;
import entities.Trips;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T20:50:48")
@StaticMetamodel(BusTrips.class)
public class BusTrips_ { 

    public static volatile SingularAttribute<BusTrips, BusTripsPK> busTripsPK;
    public static volatile CollectionAttribute<BusTrips, Mails> mailsCollection;
    public static volatile SingularAttribute<BusTrips, Buses> buses;
    public static volatile SingularAttribute<BusTrips, Trips> trips;

}