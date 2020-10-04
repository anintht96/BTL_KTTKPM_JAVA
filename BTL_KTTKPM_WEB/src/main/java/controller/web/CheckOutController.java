package controller.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbs.DonHangRemote;
import ejbs.ThanhToanRemote;
import entities.KhachHang;
import entities.SanPham;
import entities.ThanhToan;
import model.CartBean;
import model.CartItem;

/**
 * Servlet implementation class CheckOutController
 */
@WebServlet({"/cart/checkOut","/checkOut"})
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ThanhToanRemote thanhToanRemote;
	
	@EJB
	private DonHangRemote donHangRemote;
	
	private CartBean cartBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ThanhToan> list = thanhToanRemote.listThanhToans();
		
		request.setAttribute("ds", list);
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/web/checkOut.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String diaChi=request.getParameter("diaChiGiao");
		String strIdTT=request.getParameter("idThanhToan");
		
		if(strIdTT!=null && action.equals("Save")) {
			buyDonHang(request, diaChi, strIdTT,1);
			removeCart(request);
			System.out.println("Check out thanh cong.");
		}
		
		response.sendRedirect(this.getServletContext().getContextPath()+"/trang-chu");
	}

	private void buyDonHang(HttpServletRequest request,String diaChi,String idThanhToan,int idKhachHang) {
		HttpSession session=request.getSession();
		Object objCartInfo = session.getAttribute("cart");
		if(objCartInfo!=null) {
			cartBean= (CartBean) objCartInfo;
		}else {
			cartBean=new CartBean();
		}
		if(cartBean !=null) {
			for(CartItem caItem : cartBean.getListAllCartItem()) {
				donHangRemote.buy(new SanPham(caItem.getPartNumber()), caItem.getSoLuong(), caItem.getDonGia(), caItem.getThanhTien());
			}
			ThanhToan thanhToan=new ThanhToan(Integer.parseInt(idThanhToan));
			KhachHang khachHang=new KhachHang(idKhachHang);
			donHangRemote.addDonHang(diaChi, cartBean.getTongTien(), thanhToan, khachHang);
		}
	}
	
	private void removeCart(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("cart");
	}
}
