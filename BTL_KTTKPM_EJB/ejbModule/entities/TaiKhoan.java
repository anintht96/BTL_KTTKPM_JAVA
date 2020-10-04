package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TaiKhoan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4531861297601734802L;

	@Id
	@Column(length = 25, updatable = false)
	private String username;

	@Column(updatable = false)
	private String loaiTaiKhoan;

	@Column(nullable = false)
	private boolean trangThai;

	@Column(length = 60,name = "Password")
	private String password;

	@OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Admin admin;

	@OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private KhachHang khachHang;

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public TaiKhoan(String loaiTaiKhoan, boolean trangThai, String username, String password) {
		super();
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.trangThai = trangThai;
		this.username = username;
		this.password = password;
	}

	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TaiKhoan [username=" + username + ", loaiTaiKhoan=" + loaiTaiKhoan + ", trangThai=" + trangThai
				+ ", password=" + password + ", admin=" + admin + ", khachHang=" + khachHang + "]";
	}

}
