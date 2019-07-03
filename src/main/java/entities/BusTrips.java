/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nkengasong
 */
@Entity
@Table(name = "bus_trips", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "BusTrips.findAll", query = "SELECT b FROM BusTrips b"),
    @NamedQuery(name = "BusTrips.findById", query = "SELECT b FROM BusTrips b WHERE b.busTripsPK.id = :id"),
    @NamedQuery(name = "BusTrips.findByTripsId", query = "SELECT b FROM BusTrips b WHERE b.busTripsPK.tripsId = :tripsId")})
public class BusTrips implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusTripsPK busTripsPK;
    @OneToMany(mappedBy = "busTrips", fetch = FetchType.LAZY)
    private Collection<Mails> mailsCollection;
    @JoinColumn(name = "id_", referencedColumnName = "id_", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Buses buses;
    @JoinColumn(name = "trips_id", referencedColumnName = "trips_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trips trips;

    public BusTrips() {
    }

    public BusTrips(BusTripsPK busTripsPK) {
        this.busTripsPK = busTripsPK;
    }

    public BusTrips(int id, int tripsId) {
        this.busTripsPK = new BusTripsPK(id, tripsId);
    }

    public BusTripsPK getBusTripsPK() {
        return busTripsPK;
    }

    public void setBusTripsPK(BusTripsPK busTripsPK) {
        this.busTripsPK = busTripsPK;
    }

    public Collection<Mails> getMailsCollection() {
        return mailsCollection;
    }

    public void setMailsCollection(Collection<Mails> mailsCollection) {
        this.mailsCollection = mailsCollection;
    }

    public Buses getBuses() {
        return buses;
    }

    public void setBuses(Buses buses) {
        this.buses = buses;
    }

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busTripsPK != null ? busTripsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusTrips)) {
            return false;
        }
        BusTrips other = (BusTrips) object;
        if ((this.busTripsPK == null && other.busTripsPK != null) || (this.busTripsPK != null && !this.busTripsPK.equals(other.busTripsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BusTrips[ busTripsPK=" + busTripsPK + " ]";
    }
    
}
