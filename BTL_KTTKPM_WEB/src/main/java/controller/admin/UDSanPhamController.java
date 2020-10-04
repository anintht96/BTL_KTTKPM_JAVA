package controller.admin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ejbs.LoaiSanPhamRemote;
import ejbs.NhaSanXuatRemote;
import ejbs.SanPhamRemote;
import entities.LoaiSanPham;
import entities.NhaSanXuat;
import entities.SanPham;

/**
 * Servlet implementation class UDSanPhamController
 */
@WebServlet({"/admin/deleteSP","/admin/updateSP"})
@MultipartConfig(maxFileSize = 16177215)
public class UDSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private SanPhamRemote sanPhamRemote;
	
	@EJB
	private LoaiSanPhamRemote loaiSanPhamRemote;

	@EJB
	private NhaSanXuatRemote nhaSanXuatRemote;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UDSanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("idSanPham");
		String action=request.getParameter("action");
		
		if(action.equals("delete")  &&! id.equals("")) {
			sanPhamRemote.delete(id);
			response.sendRedirect(this.getServletContext().getContextPath()+"/admin");
		}else if(action.equals("update") && id.equals("")==false) {
			SanPham sanPham=sanPhamRemote.findSanPhamById(id);
			List<LoaiSanPham> loaiSanPhams = loaiSanPhamRemote.listLoaiSanPham();
			List<NhaSanXuat> nhaSanXuats = nhaSanXuatRemote.listNhaSanXuats();

			request.setAttribute("dsLoaiSP", loaiSanPhams);
			request.setAttribute("dsNhaSX", nhaSanXuats);
			request.setAttribute("sp", sanPham);
			
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/updateSP.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part part = request.getPart("fileData");
		InputStream inputStream = part.getInputStream();
		String id=request.getParameter("idSanPham");
		String ten=request.getParameter("tenSanPham");
		String moTa=request.getParameter("moTa");
		String strSoLuong=request.getParameter("soLuong");
		String strDonGia=request.getParameter("donGia");
		String strNgaySanXuat=request.getParameter("ngaySanXuat");
		String strHanSuDung=request.getParameter("hanSuDung");
		String idLoaiSanPham=request.getParameter("idLoaiSanPham");
		String idNhaSanXuat=request.getParameter("idNhaSanXuat");
		
		byte[] image=readFileConvertByte(inputStream).toByteArray();

		LocalDate ngaySanXuat=LocalDate.parse(strNgaySanXuat);
		LocalDate hanSuDung=LocalDate.parse(strHanSuDung);
		
		if(!strSoLuong.equals("") && !strDonGia.equals("")) {
			int soLuong=Integer.parseInt(strSoLuong);
			double donGia=Double.parseDouble(strDonGia);
			SanPham sanPham=new  SanPham(id, ten, moTa, soLuong, donGia, ngaySanXuat, hanSuDung, image);
			sanPham.setLoaiSanPham(new LoaiSanPham(Integer.parseInt(idLoaiSanPham)));
			sanPham.setNhaSanXuat(new NhaSanXuat(Integer.parseInt(idNhaSanXuat)));
			sanPhamRemote.update(sanPham);
		}
		
		
		response.sendRedirect(this.getServletContext().getContextPath()+"/admin");
		
	}

	private ByteArrayOutputStream readFileConvertByte(InputStream inputStream ) {
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		byte[] data = new byte[16384];
		int nRead;
		try {
			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				byteArrayOutputStream.write(data,0,nRead);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArrayOutputStream;
	}
}
