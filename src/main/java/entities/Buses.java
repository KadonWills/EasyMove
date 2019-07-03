/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author nkengasong
 */
@Entity
@Table(name = "buses", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b"),
    @NamedQuery(name = "Buses.findById", query = "SELECT b FROM Buses b WHERE b.id = :id"),
    @NamedQuery(name = "Buses.findByBusNumber", query = "SELECT b FROM Buses b WHERE b.busNumber = :busNumber"),
    @NamedQuery(name = "Buses.findByColour", query = "SELECT b FROM Buses b WHERE b.colour = :colour"),
    @NamedQuery(name = "Buses.findByNumOfSits", query = "SELECT b FROM Buses b WHERE b.numOfSits = :numOfSits")})
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_", nullable = false)
    private Integer id;
    @Size(max = 254)
    @Column(name = "bus_number", length = 254)
    private String busNumber;
    @Size(max = 254)
    @Column(name = "colour", length = 254)
    private String colour;
    @Column(name = "num_of_sits")
    private Integer numOfSits;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buses", fetch = FetchType.LAZY)
    private Collection<BusTrips> busTripsCollection;

    public Buses() {
    }

    public Buses(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getNumOfSits() {
        return numOfSits;
    }

    public void setNumOfSits(Integer numOfSits) {
        this.numOfSits = numOfSits;
    }

    public Collection<BusTrips> getBusTripsCollection() {
        return busTripsCollection;
    }

    public void setBusTripsCollection(Collection<BusTrips> busTripsCollection) {
        this.busTripsCollection = busTripsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Buses[ id=" + id + " ]";
    }
    
}
