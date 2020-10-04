package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.CTDonHang;
import entities.DonHang;

/**
 * Session Bean implementation class CTDonHangImpl
 */
@Stateless
@LocalBean
public class CTDonHangImpl implements CTDonHangRemote, CTDonHangLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CTDonHangImpl() {
	}

	@Override
	public List<CTDonHang> listCtDonHangs(int id) {
		return entityManager.createQuery("Select p from CTDonHang p where p.donHang=:id", CTDonHang.class).setParameter("id", new DonHang(id)).getResultList();
	}

}
