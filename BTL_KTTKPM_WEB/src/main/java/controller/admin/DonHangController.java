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

import ejbs.CTDonHangRemote;
import ejbs.DonHangRemote;
import entities.CTDonHang;
import entities.DonHang;

/**
 * Servlet implementation class DonHangController
 */
@WebServlet({"/admin/donHang","/admin/chiTietDH"})
public class DonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DonHangRemote donHangRemote;
	
	@EJB
	private CTDonHangRemote ctDonHangRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonHangController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DonHang> list=donHangRemote.listDonHangs();
		request.setAttribute("ds", list);
		
		String action=request.getParameter("action");
		String strIdDonHang=request.getParameter("idDonHang");
		System.out.println("iD don hang:"+strIdDonHang);
		List<CTDonHang> ctDonHangs=null; 
		DonHang donHang=null;
		
		if(action!=null && action.equals("detail")) {
			donHang=donHangRemote.donHangFindById(Integer.parseInt(strIdDonHang));
			ctDonHangs=ctDonHangRemote.listCtDonHangs(donHang.getIdDonHang());
			System.out.println("Don Hang:"+ctDonHangs);
			request.setAttribute("dsDH", ctDonHangs);
		}
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/donHang.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
