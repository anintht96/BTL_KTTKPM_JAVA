package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
public class ThanhToan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -103747108277562684L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idThanhToan;

	@Column(nullable = false, length = 25)
	private String hinhThucTT;

	@OneToMany(mappedBy = "thanhToan")
	private List<DonHang> listDonHangs;

	public ThanhToan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThanhToan(int idThanhToan) {
		super();
		this.idThanhToan = idThanhToan;
	}

	public ThanhToan(int idThanhToan, String hinhThucTT) {
		super();
		this.idThanhToan = idThanhToan;
		this.hinhThucTT = hinhThucTT;
	}

	public List<DonHang> getListDonHangs() {
		return listDonHangs;
	}

	public void setListDonHangs(List<DonHang> listDonHangs) {
		this.listDonHangs = listDonHangs;
	}

	public ThanhToan(String hinhThucTT) {
		super();
		this.hinhThucTT = hinhThucTT;
	}

	public int getIdThanhToan() {
		return idThanhToan;
	}

	public void setIdThanhToan(int idThanhToan) {
		this.idThanhToan = idThanhToan;
	}

	public String getHinhThucTT() {
		return hinhThucTT;
	}

	public void setHinhThucTT(String hinhThucTT) {
		this.hinhThucTT = hinhThucTT;
	}

	@Override
	public String toString() {
		return "ThanhToan [idThanhToan=" + idThanhToan + ", hinhThucTT=" + hinhThucTT + "]";
	}

}
