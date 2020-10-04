package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.LoaiSanPham;

/**
 * Session Bean implementation class LoaiSanPhamImpl
 */
@Stateless
@LocalBean
public class LoaiSanPhamImpl implements LoaiSanPhamRemote, LoaiSanPhamLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public LoaiSanPhamImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public LoaiSanPham addLoaiSanPham(LoaiSanPham loaiSanPham) {
		// TODO Auto-generated method stub
		entityManager.persist(loaiSanPham);
		return loaiSanPham;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<LoaiSanPham> listLoaiSanPham() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select p from LoaiSanPham p", LoaiSanPham.class).getResultList();
	}

	@Override
	public void update(LoaiSanPham loaiSanPham) {
		// TODO Auto-generated method stub
		entityManager.merge(loaiSanPham);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.find(LoaiSanPham.class, id));
	}

}
