package entities;

import entities.BusTripsPK;
import entities.Buses;
import entities.Mails;
import entities.Trips;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-03T09:18:39")
@StaticMetamodel(BusTrips.class)
public class BusTrips_ { 

    public static volatile SingularAttribute<BusTrips, Mails> mailsId;
    public static volatile SingularAttribute<BusTrips, BusTripsPK> busTripsPK;
    public static volatile SingularAttribute<BusTrips, Buses> buses;
    public static volatile SingularAttribute<BusTrips, Trips> trips;

}