package ejbs;

import java.util.List;

import javax.ejb.Local;

import entities.CTDonHang;

@Local
public interface CTDonHangLocal {

	public List<CTDonHang> listCtDonHangs (int id);
}
