package model;

public class CartItem {

	private String partNumber;
	private String thongTin;
	private int soLuong;
	private double donGia;  
	private double thanhTien;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(String partNumber, String thongTin, int soLuong, double donGia, double thanhTien) {
		super();
		this.partNumber = partNumber;
		this.thongTin = thongTin;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
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
		return "CartItemInfo [partNumber=" + partNumber + ", thongTin=" + thongTin + ", soLuong=" + soLuong
				+ ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
	}
}
