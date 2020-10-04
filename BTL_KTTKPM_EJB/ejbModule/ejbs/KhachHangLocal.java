package ejbs;

import java.util.List;

import javax.ejb.Local;

import entities.KhachHang;

@Local
public interface KhachHangLocal {

	public KhachHang findKhachHangById(String id);

	public KhachHang addKhachHang(KhachHang khachHang);

	public List<KhachHang> listKhachHangs();
}
