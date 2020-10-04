package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.LoaiSanPham;

@Remote
public interface LoaiSanPhamRemote {

	public LoaiSanPham addLoaiSanPham(LoaiSanPham loaiSanPham);

	public List<LoaiSanPham> listLoaiSanPham();

	public void update(LoaiSanPham loaiSanPham);

	public void delete(int id);
}
