package controller.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.KhachHangRemote;
import entities.KhachHang;
import entities.TaiKhoan;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet({"/register"})
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String USER_ROLE="USER";
	
	@EJB
	private KhachHangRemote khachHangRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/web/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameKhachHang=request.getParameter("nameKhachHang");
		String diaChi=request.getParameter("diaChi");
		String sdt=request.getParameter("sdt");
		String gioiTinh=request.getParameter("gioiTinh");
		String email=request.getParameter("email");
		String strNgaySinh=request.getParameter("ngaySinh");
		LocalDate ngaySinh=null;
		if(strNgaySinh !=null) {
			ngaySinh=LocalDate.parse(strNgaySinh);
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username!=null && password!=null) {
			TaiKhoan taiKhoan=new TaiKhoan(USER_ROLE, true, username, password);
			KhachHang khachHang=new KhachHang(nameKhachHang, diaChi, sdt, gioiTinh, email, ngaySinh);
			khachHang.setTaiKhoan(taiKhoan);
			khachHangRemote.addKhachHang(khachHang);
			System.out.println("DK thanh Cong.");
		}
		response.sendRedirect(this.getServletContext().getContextPath()+"/trang-chu");
	}

}
