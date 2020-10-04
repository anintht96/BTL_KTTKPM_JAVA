package ejbs;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.DonHang;
import entities.KhachHang;
import entities.SanPham;
import entities.ThanhToan;

/**
 * Session Bean implementation class DonHangImpl
 */
@Stateful
@LocalBean
public class DonHangImpl implements DonHangRemote, DonHangLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
	
	private DonHang donHang;
    /**
     * Default constructor. 
     */
    public DonHangImpl() {
    }

	@Override
	public DonHang addDonHang(String diaChi,double tongTien,ThanhToan thanhToan,KhachHang khachHang) {
		
		donHang.setDiaChiGiao(diaChi);
		donHang.setTongTien(tongTien);
		donHang.setThanhToan(thanhToan);
		donHang.setThoiGian(LocalDateTime.now());
		donHang.setKhachHang(khachHang);
		
		entityManager.persist(donHang);
		donHang=null;
		return donHang;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DonHang> listDonHangs() {
		return entityManager.createQuery("Select p from DonHang p", DonHang.class).getResultList();
	}

	@Override
	public void buy(SanPham sanPham, int soLuong, double donGia, double thanhTien) {
		if(donHang==null) {
			donHang=new DonHang();
		}
		donHang.addPurchases(sanPham, soLuong, donGia, thanhTien);
	}

	@Override
	public DonHang getDonHang() {
		return donHang;
	}

	@Override
	public DonHang donHangFindById(int id) {
		return entityManager.find(DonHang.class, id);
	}
	
	
}
