package ejbs;

import java.util.List;

import javax.ejb.Local;

import entities.ThanhToan;

@Local
public interface ThanhToanLocal {

	public ThanhToan addThanhToan(ThanhToan thanhToan);

	public List<ThanhToan> listThanhToans();
	
	public void update(ThanhToan thanhToan);
	
	public void delete(int id);
}
