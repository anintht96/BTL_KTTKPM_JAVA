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

import ejbs.SanPhamRemote;
import entities.SanPham;

/**
 * Servlet implementation class HomAdminController
 */
@WebServlet("/admin")
public class HomAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private SanPhamRemote sanPhamRemote;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<SanPham> list = sanPhamRemote.listSanPhams();
		
		request.setAttribute("ds", list);
		
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
