package ejbs;

import java.util.List;

import javax.ejb.Local;

import entities.SanPham;

@Local
public interface SanPhamLocal {

	public SanPham addSanPham(SanPham sanPham);

	public SanPham findSanPhamById(String strId);

	public List<SanPham> listSanPhams();

	public void update(SanPham sanPham);

	public void delete(String id);
}
