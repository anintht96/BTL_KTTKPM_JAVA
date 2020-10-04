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

import ejbs.NhaSanXuatRemote;
import entities.NhaSanXuat;

/**
 * Servlet implementation class NhaSanXuatController
 */
@WebServlet({ "/admin/nhaSanXuat", "/admin/addNhaSX","/admin/updateNhaSX","/admin/deleteNhaSX" })
public class NhaSanXuatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private NhaSanXuatRemote nhaSanXuatRemote;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhaSanXuatController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<NhaSanXuat> list = nhaSanXuatRemote.listNhaSanXuats();
		request.setAttribute("ds", list);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/admin/nhaSanXuat.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten = request.getParameter("ten");
		String tenUpdate=request.getParameter("tenUpdate");
		String strId=(request.getParameter("idNhaSanXuat"));
		String action = request.getParameter("action");
		

		if (action.equals("add") && ! ten.equals("")) {
			nhaSanXuatRemote.addNhaSanXuat(new NhaSanXuat(ten));
		}else if(action.equals("update") && !tenUpdate.equals("")) {
			nhaSanXuatRemote.update(new NhaSanXuat(Integer.parseInt(strId), tenUpdate));
		}else if(action.equals("delete") && strId.equals("")==false) {
			nhaSanXuatRemote.delete(Integer.parseInt(strId));
		}
		
		response.sendRedirect(this.getServletContext().getContextPath()+"/admin/nhaSanXuat");
	}

}
