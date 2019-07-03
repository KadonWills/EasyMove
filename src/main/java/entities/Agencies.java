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
@Table(name = "agencies", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "Agencies.findAll", query = "SELECT a FROM Agencies a"),
    @NamedQuery(name = "Agencies.findByAgenciesId", query = "SELECT a FROM Agencies a WHERE a.agenciesId = :agenciesId"),
    @NamedQuery(name = "Agencies.findByAgenciesName", query = "SELECT a FROM Agencies a WHERE a.agenciesName = :agenciesName"),
    @NamedQuery(name = "Agencies.findByTown", query = "SELECT a FROM Agencies a WHERE a.town = :town"),
    @NamedQuery(name = "Agencies.findByQuarter", query = "SELECT a FROM Agencies a WHERE a.quarter = :quarter")})
public class Agencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agencies_id", nullable = false)
    private Integer agenciesId;
    @Size(max = 254)
    @Column(name = "agencies_name", length = 254)
    private String agenciesName;
    @Size(max = 254)
    @Column(name = "town", length = 254)
    private String town;
    @Size(max = 254)
    @Column(name = "quarter", length = 254)
    private String quarter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageAgenciesId", fetch = FetchType.LAZY)
    private Collection<Trips> tripsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agenciesId", fetch = FetchType.LAZY)
    private Collection<Trips> tripsCollection1;
    @OneToMany(mappedBy = "agenciesId", fetch = FetchType.LAZY)
    private Collection<Users> usersCollection;

    public Agencies() {
    }

    public Agencies(Integer agenciesId) {
        this.agenciesId = agenciesId;
    }

    public Integer getAgenciesId() {
        return agenciesId;
    }

    public void setAgenciesId(Integer agenciesId) {
        this.agenciesId = agenciesId;
    }

    public String getAgenciesName() {
        return agenciesName;
    }

    public void setAgenciesName(String agenciesName) {
        this.agenciesName = agenciesName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public Collection<Trips> getTripsCollection() {
        return tripsCollection;
    }

    public void setTripsCollection(Collection<Trips> tripsCollection) {
        this.tripsCollection = tripsCollection;
    }

    public Collection<Trips> getTripsCollection1() {
        return tripsCollection1;
    }

    public void setTripsCollection1(Collection<Trips> tripsCollection1) {
        this.tripsCollection1 = tripsCollection1;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agenciesId != null ? agenciesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agencies)) {
            return false;
        }
        Agencies other = (Agencies) object;
        if ((this.agenciesId == null && other.agenciesId != null) || (this.agenciesId != null && !this.agenciesId.equals(other.agenciesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Agencies[ agenciesId=" + agenciesId + " ]";
    }
        
}
