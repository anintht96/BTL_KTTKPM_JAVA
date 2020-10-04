package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Column;

@Entity
public class KhachHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6525446059103715069L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKhachHang;

	@Column(length = 50, nullable = false)
	private String nameKhachHang;
	private String diaChi;
	@Column(length = 10, nullable = false)
	private String sdt;
	private String gioiTinh;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private LocalDate ngaySinh;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USERNAME",updatable = false)
	private TaiKhoan taiKhoan;

	@OneToMany(mappedBy = "khachHang")
	private List<DonHang> listDonHangs;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(int idKhachHang) {
		super();
		this.idKhachHang = idKhachHang;
	}

	public KhachHang(String nameKhachHang, String diaChi, String sdt, String gioiTinh, String email,
			LocalDate ngaySinh) {
		super();
		this.nameKhachHang = nameKhachHang;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.ngaySinh = ngaySinh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<DonHang> getListDonHangs() {
		return listDonHangs;
	}

	public void setListDonHangs(List<DonHang> listDonHangs) {
		this.listDonHangs = listDonHangs;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public String getNameKhachHang() {
		return nameKhachHang;
	}

	public void setNameKhachHang(String nameKhachHang) {
		this.nameKhachHang = nameKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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
		return "KhachHang [idKhachHang=" + idKhachHang + ", nameKhachHang=" + nameKhachHang + ", diaChi=" + diaChi
				+ ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", email=" + email + ", ngaySinh=" + ngaySinh + "]";
	}

}
