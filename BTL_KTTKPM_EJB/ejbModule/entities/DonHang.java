package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DonHang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2388817316358021409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDonHang;

	private LocalDateTime thoiGian;

	@Column(nullable = false)
	private String diaChiGiao;

	private double tongTien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "THANHTOAN_ID", referencedColumnName = "idThanhToan")
	private ThanhToan thanhToan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "KHACHHANG_ID", referencedColumnName = "idKhachHang", updatable = false)
	private KhachHang khachHang;

	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
	private List<CTDonHang> listCtDonHangs;

	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonHang(int idDonHang) {
		super();
		this.idDonHang = idDonHang;
	}

	public DonHang(LocalDateTime thoiGian, String diaChiGiao, double tongTien) {
		super();
		this.thoiGian = thoiGian;
		this.diaChiGiao = diaChiGiao;
		this.tongTien = tongTien;
	}

	public void addPurchases(SanPham pham, int soLuong, double donGia, double thanhTien) {
		if (listCtDonHangs == null) {
			listCtDonHangs = new ArrayList<CTDonHang>();
		}
		CTDonHang ctDonHang = new CTDonHang(this, pham, soLuong, donGia, thanhTien);
		listCtDonHangs.add(ctDonHang);
	}

	public String getDiaChiGiao() {
		return diaChiGiao;
	}

	public void setDiaChiGiao(String diaChiGiao) {
		this.diaChiGiao = diaChiGiao;
	}

	public List<CTDonHang> getListCtDonHangs() {
		return listCtDonHangs;
	}

	public void setListCtDonHangs(List<CTDonHang> listCtDonHangs) {
		this.listCtDonHangs = listCtDonHangs;
	}

	public ThanhToan getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(ThanhToan thanhToan) {
		this.thanhToan = thanhToan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getIdDonHang() {
		return idDonHang;
	}

	public LocalDateTime getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(LocalDateTime thoiGian) {
		this.thoiGian = thoiGian;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "DonHang [idDonHang=" + idDonHang + ", thoiGian=" + thoiGian + ", diaChiGiao=" + diaChiGiao
				+ ", tongTien=" + tongTien + ", listCtDonHangs=" + listCtDonHangs + ", thanhToan=" + thanhToan
				+ ", khachHang=" + khachHang + "]";
	}

}
