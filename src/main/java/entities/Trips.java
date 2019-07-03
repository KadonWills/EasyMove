/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author nkengasong
 */
@Entity
@Table(name = "trips", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "Trips.findAll", query = "SELECT t FROM Trips t"),
    @NamedQuery(name = "Trips.findByTripsId", query = "SELECT t FROM Trips t WHERE t.tripsId = :tripsId"),
    @NamedQuery(name = "Trips.findByDeparture", query = "SELECT t FROM Trips t WHERE t.departure = :departure"),
    @NamedQuery(name = "Trips.findByArrival", query = "SELECT t FROM Trips t WHERE t.arrival = :arrival"),
    @NamedQuery(name = "Trips.findByDepartAgency", query = "SELECT t FROM Trips t WHERE t.departAgency = :departAgency"),
    @NamedQuery(name = "Trips.findByArrivalAgency", query = "SELECT t FROM Trips t WHERE t.arrivalAgency = :arrivalAgency"),
    @NamedQuery(name = "Trips.findByTripsType", query = "SELECT t FROM Trips t WHERE t.tripsType = :tripsType"),
    @NamedQuery(name = "Trips.findByPrice", query = "SELECT t FROM Trips t WHERE t.price = :price")})
public class Trips implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trips_id", nullable = false)
    private Integer tripsId;
    @Column(name = "departure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departure;
    @Column(name = "arrival")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrival;
    @Size(max = 254)
    @Column(name = "depart_agency", length = 254)
    private String departAgency;
    @Size(max = 254)
    @Column(name = "arrival_agency", length = 254)
    private String arrivalAgency;
    @Size(max = 254)
    @Column(name = "trips_type", length = 254)
    private String tripsType;
    @Size(max = 254)
    @Column(name = "price", length = 254)
    private String price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trips", fetch = FetchType.LAZY)
    private Collection<BusTrips> busTripsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trips", fetch = FetchType.LAZY)
    private Collection<Reservations> reservationsCollection;
    @JoinColumn(name = "age_agencies_id", referencedColumnName = "agencies_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agencies ageAgenciesId;
    @JoinColumn(name = "agencies_id", referencedColumnName = "agencies_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agencies agenciesId;
    @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users usersId;

    public Trips() {
    }

    public Trips(Integer tripsId) {
        this.tripsId = tripsId;
    }

    public Integer getTripsId() {
        return tripsId;
    }

    public void setTripsId(Integer tripsId) {
        this.tripsId = tripsId;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getDepartAgency() {
        return departAgency;
    }

    public void setDepartAgency(String departAgency) {
        this.departAgency = departAgency;
    }

    public String getArrivalAgency() {
        return arrivalAgency;
    }

    public void setArrivalAgency(String arrivalAgency) {
        this.arrivalAgency = arrivalAgency;
    }

    public String getTripsType() {
        return tripsType;
    }

    public void setTripsType(String tripsType) {
        this.tripsType = tripsType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Collection<BusTrips> getBusTripsCollection() {
        return busTripsCollection;
    }

    public void setBusTripsCollection(Collection<BusTrips> busTripsCollection) {
        this.busTripsCollection = busTripsCollection;
    }

    public Collection<Reservations> getReservationsCollection() {
        return reservationsCollection;
    }

    public void setReservationsCollection(Collection<Reservations> reservationsCollection) {
        this.reservationsCollection = reservationsCollection;
    }

    public Agencies getAgeAgenciesId() {
        return ageAgenciesId;
    }

    public void setAgeAgenciesId(Agencies ageAgenciesId) {
        this.ageAgenciesId = ageAgenciesId;
    }

    public Agencies getAgenciesId() {
        return agenciesId;
    }

    public void setAgenciesId(Agencies agenciesId) {
        this.agenciesId = agenciesId;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tripsId != null ? tripsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trips)) {
            return false;
        }
        Trips other = (Trips) object;
        if ((this.tripsId == null && other.tripsId != null) || (this.tripsId != null && !this.tripsId.equals(other.tripsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trips[ tripsId=" + tripsId + " ]";
    }
    
}
