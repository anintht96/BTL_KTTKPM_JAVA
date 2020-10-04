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

import ejbs.ThanhToanRemote;
import entities.ThanhToan;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet({"/admin/thanhToan","/admin/addThanhToan","/admin/updateThanhToan","/admin/deleteThanhToan"})
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ThanhToanRemote thanhToanRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ThanhToan> list=thanhToanRemote.listThanhToans();
		
		request.setAttribute("ds", list);
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/thanhToan.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getParameter("action");
		String idThanhToan=request.getParameter("idThanhToan");
		String hinhThucTT=request.getParameter("hinhThucTT");
		
		if(action!=null && action.equals("add") &&hinhThucTT !=null) {
			thanhToanRemote.addThanhToan(new ThanhToan(hinhThucTT));
		}else if(action!=null && action.equals("update") && hinhThucTT!=null ) {
			thanhToanRemote.update(new ThanhToan(Integer.parseInt(idThanhToan),hinhThucTT));
		}else if(action!=null && action.equals("delete") && idThanhToan!=null) {
			thanhToanRemote.delete(Integer.parseInt(idThanhToan));
		}
		
		response.sendRedirect(this.getServletContext().getContextPath()+"/admin/thanhToan");
	}

}
