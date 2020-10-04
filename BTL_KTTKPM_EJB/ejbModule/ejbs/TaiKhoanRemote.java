package ejbs;

import javax.ejb.Remote;

import entities.TaiKhoan;

@Remote
public interface TaiKhoanRemote {

	public TaiKhoan findTaiKhoanByUserName(String userName,String password);
}
