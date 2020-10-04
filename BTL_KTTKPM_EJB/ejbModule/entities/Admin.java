package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Column;

@Entity
public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8213733268540333833L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdmin;

	@Column(length = 25)
	private String tenAdmin;
	private String diaChi;
	private String gioiTinh;
	@Column(length = 10)
	private String sdt;
	private String email;
	private LocalDate ngaySinh;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USERNAME", updatable = false)
	private TaiKhoan taiKhoan;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String tenAdmin, String diaChi, String gioiTinh, String sdt, String email, LocalDate ngaySinh) {
		super();
		this.tenAdmin = tenAdmin;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.email = email;
		this.ngaySinh = ngaySinh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getTenAdmin() {
		return tenAdmin;
	}

	public void setTenAdmin(String tenAdmin) {
		this.tenAdmin = tenAdmin;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", tenAdmin=" + tenAdmin + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh
				+ ", sdt=" + sdt + ", email=" + email + ", ngaySinh=" + ngaySinh + "]";
	}

}
