package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.ThanhToan;

/**
 * Session Bean implementation class ThanhToanImpl
 */
@Stateless
@LocalBean
public class ThanhToanImpl implements ThanhToanRemote, ThanhToanLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ThanhToanImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ThanhToan addThanhToan(ThanhToan thanhToan) {
		// TODO Auto-generated method stub
		entityManager.persist(thanhToan);
		return thanhToan;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ThanhToan> listThanhToans() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select p from ThanhToan p", ThanhToan.class).getResultList();
	}

	@Override
	public void update(ThanhToan thanhToan) {
		// TODO Auto-generated method stub
		entityManager.merge(thanhToan);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.find(ThanhToan.class, id));
	}

}
