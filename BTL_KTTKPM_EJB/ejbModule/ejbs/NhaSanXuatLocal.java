package ejbs;

import java.util.List;

import javax.ejb.Local;

import entities.NhaSanXuat;

@Local
public interface NhaSanXuatLocal {

	public NhaSanXuat addNhaSanXuat(NhaSanXuat nhaSanXuat);

	public List<NhaSanXuat> listNhaSanXuats();
	
	public void update(NhaSanXuat nhaSanXuat);
	
	public void delete(int id);
}
