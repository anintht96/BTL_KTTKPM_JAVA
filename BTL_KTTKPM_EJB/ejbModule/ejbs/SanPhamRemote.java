package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.SanPham;

@Remote
public interface SanPhamRemote {

	public SanPham addSanPham(SanPham sanPham);

	public SanPham findSanPhamById(String strId);

	public List<SanPham> listSanPhams();

	public void update(SanPham sanPham);

	public void delete(String id);
}
