package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.NhaSanXuat;

@Remote
public interface NhaSanXuatRemote {

	public NhaSanXuat addNhaSanXuat(NhaSanXuat nhaSanXuat);

	public List<NhaSanXuat> listNhaSanXuats();
	
	public void update(NhaSanXuat nhaSanXuat);
	
	public void delete(int id);
}
