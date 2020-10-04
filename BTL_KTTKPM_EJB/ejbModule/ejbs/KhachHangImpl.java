package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.KhachHang;

/**
 * Session Bean implementation class KhachHangImpl
 */
@Stateless
@LocalBean
public class KhachHangImpl implements KhachHangRemote, KhachHangLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public KhachHangImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public KhachHang findKhachHangById(String id) {
		return entityManager.find(KhachHang.class, id);
	}

	@Override
	public KhachHang addKhachHang(KhachHang khachHang) {
		entityManager.persist(khachHang);
		return khachHang;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<KhachHang> listKhachHangs() {
		return entityManager.createQuery("Select p from KhachHang p", KhachHang.class).getResultList();
	}

}
