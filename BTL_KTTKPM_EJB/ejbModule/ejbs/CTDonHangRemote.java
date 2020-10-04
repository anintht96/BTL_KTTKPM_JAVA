package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.CTDonHang;

@Remote
public interface CTDonHangRemote {

	public List<CTDonHang> listCtDonHangs (int id);
}
