package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.SanPham;

/**
 * Session Bean implementation class SanPhamImpl
 */
@Stateless
@LocalBean
public class SanPhamImpl implements SanPhamRemote, SanPhamLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public SanPhamImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public SanPham addSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		entityManager.persist(sanPham);
		return sanPham;
	}

	@Override
	public SanPham findSanPhamById(String strId) {
		// TODO Auto-generated method stub
		return entityManager.find(SanPham.class, strId);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham> listSanPhams() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select p from SanPham p", SanPham.class).getResultList();
	}

	@Override
	public void update(SanPham sanPham) {
		// TODO Auto-generated method stub
		entityManager.merge(sanPham);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.find(SanPham.class, id));
	}

}
