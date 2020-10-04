package ejbs;

import java.util.List;

import javax.ejb.Local;

import entities.LoaiSanPham;

@Local
public interface LoaiSanPhamLocal {

	public LoaiSanPham addLoaiSanPham(LoaiSanPham loaiSanPham);

	public List<LoaiSanPham> listLoaiSanPham();

	public void update(LoaiSanPham loaiSanPham);

	public void delete(int id);
}
