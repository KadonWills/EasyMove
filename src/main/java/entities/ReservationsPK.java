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
public class ReservationsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users_id", nullable = false)
    private int usersId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trips_id", nullable = false)
    private int tripsId;

    public ReservationsPK() {
    }

    public ReservationsPK(int usersId, int tripsId) {
        this.usersId = usersId;
        this.tripsId = tripsId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
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
        hash += (int) usersId;
        hash += (int) tripsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationsPK)) {
            return false;
        }
        ReservationsPK other = (ReservationsPK) object;
        if (this.usersId != other.usersId) {
            return false;
        }
        if (this.tripsId != other.tripsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ReservationsPK[ usersId=" + usersId + ", tripsId=" + tripsId + " ]";
    }
    
}
