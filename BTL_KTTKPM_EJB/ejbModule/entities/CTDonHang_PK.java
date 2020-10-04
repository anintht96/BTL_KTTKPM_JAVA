package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CTDonHang_PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6333955192329349079L;
	private int donHang;
	private String sanPham;

	public CTDonHang_PK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CTDonHang_PK(int donHang, String sanPham) {
		super();
		this.donHang = donHang;
		this.sanPham = sanPham;
	}

	public int getDonHang() {
		return donHang;
	}

	public void setDonHang(int donHang) {
		this.donHang = donHang;
	}

	public String getSanPham() {
		return sanPham;
	}

	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + donHang;
		result = prime * result + ((sanPham == null) ? 0 : sanPham.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTDonHang_PK other = (CTDonHang_PK) obj;
		if (donHang != other.donHang)
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CTDonHang_PK [donHang=" + donHang + ", sanPham=" + sanPham + "]";
	}

}
