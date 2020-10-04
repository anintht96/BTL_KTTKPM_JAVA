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
public class LoaiSanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3672334253917373081L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLoaiSanPham;

	@Column(nullable = false)
	private String tenLoaiSanPham;

	@OneToMany(mappedBy = "loaiSanPham")
	private List<SanPham> listSanPhams;

	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoaiSanPham(int idLoaiSanPham) {
		super();
		this.idLoaiSanPham = idLoaiSanPham;
	}

	public LoaiSanPham(String tenLoaiSanPham) {
		super();
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public List<SanPham> getListSanPhams() {
		return listSanPhams;
	}

	public void setListSanPhams(List<SanPham> listSanPhams) {
		this.listSanPhams = listSanPhams;
	}

	public int getIdLoaiSanPham() {
		return idLoaiSanPham;
	}

	public void setIdLoaiSanPham(int idLoaiSanPham) {
		this.idLoaiSanPham = idLoaiSanPham;
	}

	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [idLoaiSanPham=" + idLoaiSanPham + ", tenLoaiSanPham=" + tenLoaiSanPham + "]";
	}

}
