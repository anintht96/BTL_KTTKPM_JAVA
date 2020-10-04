package controller.admin;

import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.AdminRemote;
import entities.Admin;
import entities.TaiKhoan;

/**
 * Servlet implementation class AdminAdd
 */
@WebServlet("/admin/add-admin")
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADMIN_ROLE="ADMIN";
	
	@EJB
	private AdminRemote adminRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=new Admin("admin", "HCM", "Nam", "09854612", "admin1111@gmail.com", LocalDate.of(1996, 10, 12));
		TaiKhoan taiKhoan=new TaiKhoan(ADMIN_ROLE, true, "admin", "admin");
		admin.setTaiKhoan(taiKhoan);
		
		adminRemote.addAdmin(admin);
		
		response.sendRedirect(this.getServletContext().getContextPath()+"/trang-chu");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
