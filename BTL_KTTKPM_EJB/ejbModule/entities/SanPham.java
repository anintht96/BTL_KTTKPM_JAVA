package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6994125320097119461L;

	@Id
	private String idSanPham;

	@Column(nullable = false)
	private String tenSanPham;
	@Column(nullable = false, length = 2500)
	private String moTa;
	@Column(nullable = false)
	private int soLuong;
	@Column(nullable = false)
	private double donGia;
	private LocalDate ngaySanXuat;
	private LocalDate hanSuDung;
	@Lob
	private byte[] image;

	@OneToMany(mappedBy = "sanPham")
	private List<CTDonHang> listCtDonHangs;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "LOAISANPHAM_ID", referencedColumnName = "idLoaiSanPham")
	private LoaiSanPham loaiSanPham;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "NHASANXUAT_ID", referencedColumnName = "idNhaSanXuat")
	private NhaSanXuat nhaSanXuat;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanPham(String idSanPham) {
		super();
		this.idSanPham = idSanPham;
	}

	public SanPham(String idSanPham, String tenSanPham, String moTa, int soLuong, double donGia, LocalDate ngaySanXuat,
			LocalDate hanSuDung, byte[] image) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
		this.image = image;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public NhaSanXuat getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalDate getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(LocalDate hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "SanPham [idSanPham=" + idSanPham + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", soLuong="
				+ soLuong + ", donGia=" + donGia + ", ngaySanXuat=" + ngaySanXuat + ", hanSuDung=" + hanSuDung
				+ ", image=" + Arrays.toString(image) + ", loaiSanPham=" + loaiSanPham + ", nhaSanXuat=" + nhaSanXuat
				+ "]";
	}
	
}
