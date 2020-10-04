package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.KhachHang;

@Remote
public interface KhachHangRemote {

	public KhachHang findKhachHangById(String id);

	public KhachHang addKhachHang(KhachHang khachHang);

	public List<KhachHang> listKhachHangs();
}
