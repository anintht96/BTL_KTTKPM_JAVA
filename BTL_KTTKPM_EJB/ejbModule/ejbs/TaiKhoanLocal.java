package ejbs;

import javax.ejb.Local;

import entities.TaiKhoan;

@Local
public interface TaiKhoanLocal {

	public TaiKhoan findTaiKhoanByUserName(String userName,String password);
}
