/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.BusTrips;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nkengasong
 */
@Stateless
public class BusTripsFacade extends AbstractFacade<BusTrips> {

    @PersistenceContext(unitName = "com.mit2online_EasyMove_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BusTripsFacade() {
        super(BusTrips.class);
    }
    
}
