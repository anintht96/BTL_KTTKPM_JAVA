package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
/* @IdClass(CTDonHang_PK.class) */
public class CTDonHang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146134680684457250L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCTDonHang;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SANPHAM_ID", referencedColumnName = "idSanPham")
	private SanPham sanPham;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DONHANG_ID", referencedColumnName = "idDonHang")
	private DonHang donHang;

	private int soLuong;
	private double donGia;
	private double thanhTien;

	public CTDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CTDonHang(DonHang donHang, SanPham sanPham, int soLuong, double donGia, double thanhTien) {
		super();
		this.donHang = donHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	
	public int getIdCTDonHang() {
		return idCTDonHang;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
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

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "CTDonHang [soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien="
				+ thanhTien + "]";
	}

}
