package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.LoaiSanPhamRemote;
import entities.LoaiSanPham;

/**
 * Servlet implementation class LoaiSanPhamController
 */
@WebServlet(urlPatterns = { "/admin/loaisanpham", "/admin/addLoaiSanPham", "/admin/deleteLoaiSP","/admin/updateLoaiSP" })
public class LoaiSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private LoaiSanPhamRemote loaiSanPhamRemote;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoaiSanPhamController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<LoaiSanPham> list = loaiSanPhamRemote.listLoaiSanPham();
		request.setAttribute("ds", list);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/admin/loaiSanPham.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenLoaiSanPham = request.getParameter("tenLSP");
		String tenLSPUpdate=request.getParameter("tenLoaiSanPham");
		LoaiSanPham loaiSanPham = new LoaiSanPham(tenLoaiSanPham);

		String idLoaiSanPham = request.getParameter("idLoaiSanPham");
		String action = request.getParameter("action");
		
		if (action.equals("delete")) {
			loaiSanPhamRemote.delete(Integer.parseInt(idLoaiSanPham));
		} else if (action.equals("add") && !loaiSanPham.getTenLoaiSanPham().equals("")) {
			loaiSanPhamRemote.addLoaiSanPham(loaiSanPham);
		}else if(action.equals("update") && !tenLSPUpdate.equals("")) {
			LoaiSanPham loaiSanPhamUpdate=new LoaiSanPham(Integer.parseInt(idLoaiSanPham));
			loaiSanPhamUpdate.setTenLoaiSanPham(tenLSPUpdate);
			loaiSanPhamRemote.update(loaiSanPhamUpdate);
		}

		response.sendRedirect(request.getContextPath() + "/admin/loaisanpham");
	}

}
