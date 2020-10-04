package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Admin;

/**
 * Session Bean implementation class AdminImpl
 */
@Stateless(mappedName = "")
@LocalBean
public class AdminImpl implements AdminRemote, AdminLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public AdminImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAdmin(Admin admin) {
		entityManager.persist(admin);
	}

}
