package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.DonHang;
import entities.KhachHang;
import entities.SanPham;
import entities.ThanhToan;

@Remote
public interface DonHangRemote {

	public DonHang addDonHang(String diaChi,double tongTien,ThanhToan thanhToan,KhachHang khachHang);

	public List<DonHang> listDonHangs();
	
	public void buy(SanPham sanPham,int soLuong,double donGia,double thanhTien);
	
	public DonHang getDonHang();
	
	public DonHang donHangFindById(int id);
}
