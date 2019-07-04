package entities;

import entities.ReservationsPK;
import entities.Trips;
import entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T20:50:48")
@StaticMetamodel(Reservations.class)
public class Reservations_ { 

    public static volatile SingularAttribute<Reservations, Integer> quantity;
    public static volatile SingularAttribute<Reservations, Trips> trips;
    public static volatile SingularAttribute<Reservations, ReservationsPK> reservationsPK;
    public static volatile SingularAttribute<Reservations, Date> reservationDate;
    public static volatile SingularAttribute<Reservations, Users> users;

}