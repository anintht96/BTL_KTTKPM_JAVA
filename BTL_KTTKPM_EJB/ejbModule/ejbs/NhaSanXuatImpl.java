package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.NhaSanXuat;

/**
 * Session Bean implementation class NhaSanXuatImpl
 */
@Stateless
@LocalBean
public class NhaSanXuatImpl implements NhaSanXuatRemote, NhaSanXuatLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public NhaSanXuatImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public NhaSanXuat addNhaSanXuat(NhaSanXuat nhaSanXuat) {
		// TODO Auto-generated method stub
		entityManager.persist(nhaSanXuat);
		return nhaSanXuat;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<NhaSanXuat> listNhaSanXuats() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select p from NhaSanXuat p", NhaSanXuat.class).getResultList();
	}

	@Override
	public void update(NhaSanXuat nhaSanXuat) {
		// TODO Auto-generated method stub
		entityManager.merge(nhaSanXuat);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.find(NhaSanXuat.class, id));
	}

}
