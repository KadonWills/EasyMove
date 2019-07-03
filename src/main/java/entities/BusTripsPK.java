/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nkengasong
 */
@Embeddable
public class BusTripsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_", nullable = false)
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trips_id", nullable = false)
    private int tripsId;

    public BusTripsPK() {
    }

    public BusTripsPK(int id, int tripsId) {
        this.id = id;
        this.tripsId = tripsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTripsId() {
        return tripsId;
    }

    public void setTripsId(int tripsId) {
        this.tripsId = tripsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) tripsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusTripsPK)) {
            return false;
        }
        BusTripsPK other = (BusTripsPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.tripsId != other.tripsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BusTripsPK[ id=" + id + ", tripsId=" + tripsId + " ]";
    }
    
}
