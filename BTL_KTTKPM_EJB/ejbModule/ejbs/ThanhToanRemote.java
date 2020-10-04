package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.ThanhToan;

@Remote
public interface ThanhToanRemote {

	public ThanhToan addThanhToan(ThanhToan thanhToan);

	public List<ThanhToan> listThanhToans();
	
	public void update(ThanhToan thanhToan);
	
	public void delete(int id);
}
