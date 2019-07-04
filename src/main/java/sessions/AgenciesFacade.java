package sessions;

import entities.Agencies;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nkengasong
 */
@Stateless
public class AgenciesFacade extends AbstractFacade<Agencies> {

    @PersistenceContext(unitName = "com.mit2online_EasyMove_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenciesFacade() {
        super(Agencies.class);
    }

    /**
     * Note: This method takes the id of the agency of the current user and sends a list of all other agencies to be used as arrival agencies
     * @param id
     * @return List of Agencies
     */
    public List<Agencies> findArrivalAgencies(Integer id) {
        return em.createQuery("SELECT a FROM Agencies a WHERE a.agenciesId != :id", Agencies.class)
                .setParameter("id", id).getResultList();
    }
}
