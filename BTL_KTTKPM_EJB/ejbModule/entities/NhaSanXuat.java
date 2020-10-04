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
public class NhaSanXuat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5990807199522092277L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNhaSanXuat;

	@Column(nullable = false)
	private String tenNhaSanXuat;

	@OneToMany(mappedBy = "nhaSanXuat")
	private List<SanPham> listSanPhams;

	public NhaSanXuat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhaSanXuat(int idNhaSanXuat) {
		super();
		this.idNhaSanXuat = idNhaSanXuat;
	}

	public List<SanPham> getListSanPhams() {
		return listSanPhams;
	}

	public void setListSanPhams(List<SanPham> listSanPhams) {
		this.listSanPhams = listSanPhams;
	}

	public NhaSanXuat(String tenNhaSanXuat) {
		super();
		this.tenNhaSanXuat = tenNhaSanXuat;
	}

	public NhaSanXuat(int idNhaSanXuat, String tenNhaSanXuat) {
		super();
		this.idNhaSanXuat = idNhaSanXuat;
		this.tenNhaSanXuat = tenNhaSanXuat;
	}

	public int getIdNhaSanXuat() {
		return idNhaSanXuat;
	}

	public void setIdNhaSanXuat(int idNhaSanXuat) {
		this.idNhaSanXuat = idNhaSanXuat;
	}

	public String getTenNhaSanXuat() {
		return tenNhaSanXuat;
	}

	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		this.tenNhaSanXuat = tenNhaSanXuat;
	}

	@Override
	public String toString() {
		return "NhaSanXuat [idNhaSanXuat=" + idNhaSanXuat + ", tenNhaSanXuat=" + tenNhaSanXuat + "]";
	}

}
