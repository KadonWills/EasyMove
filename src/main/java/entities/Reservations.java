/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nkengasong
 */
@Entity
@Table(name = "reservations", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "Reservations.findAll", query = "SELECT r FROM Reservations r"),
    @NamedQuery(name = "Reservations.findByUsersId", query = "SELECT r FROM Reservations r WHERE r.reservationsPK.usersId = :usersId"),
    @NamedQuery(name = "Reservations.findByTripsId", query = "SELECT r FROM Reservations r WHERE r.reservationsPK.tripsId = :tripsId"),
    @NamedQuery(name = "Reservations.findByReservationDate", query = "SELECT r FROM Reservations r WHERE r.reservationDate = :reservationDate"),
    @NamedQuery(name = "Reservations.findByQuantity", query = "SELECT r FROM Reservations r WHERE r.quantity = :quantity")})
public class Reservations implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationsPK reservationsPK;
    @Column(name = "reservation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationDate;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "trips_id", referencedColumnName = "trips_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trips trips;
    @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users users;

    public Reservations() {
    }

    public Reservations(ReservationsPK reservationsPK) {
        this.reservationsPK = reservationsPK;
    }

    public Reservations(int usersId, int tripsId) {
        this.reservationsPK = new ReservationsPK(usersId, tripsId);
    }

    public ReservationsPK getReservationsPK() {
        return reservationsPK;
    }

    public void setReservationsPK(ReservationsPK reservationsPK) {
        this.reservationsPK = reservationsPK;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationsPK != null ? reservationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservations)) {
            return false;
        }
        Reservations other = (Reservations) object;
        if ((this.reservationsPK == null && other.reservationsPK != null) || (this.reservationsPK != null && !this.reservationsPK.equals(other.reservationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservations[ reservationsPK=" + reservationsPK + " ]";
    }
    
}
