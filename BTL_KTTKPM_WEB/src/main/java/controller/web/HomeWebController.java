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

import ejbs.SanPhamRemote;
import entities.SanPham;
import model.CartBean;
import model.CartItem;

/**
 * Servlet implementation class HomeWebController
 */
@WebServlet(urlPatterns = { "/","/home","/trang-chu","/addToCart" })
public class HomeWebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(lookup = "java:global/BTL_KTTKPM_EAR/BTL_KTTKPM_EJB/SanPhamImpl!ejbs.SanPhamRemote")
	private SanPhamRemote sanPhamRemote;
	
	private CartBean cartBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeWebController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> list=sanPhamRemote.listSanPhams();
		
		request.setAttribute("ds", list);
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/web/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)  
	 */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partNumber=request.getParameter("partNumber");
		String thongTin=request.getParameter("thongTin");
		String strSoLuong=request.getParameter("soLuong");
		String strDonGia=request.getParameter("donGia");
		
		addToCart(request, partNumber, thongTin, strSoLuong, strDonGia);
		
		response.sendRedirect(this.getServletContext().getContextPath()+"/shoppingCart");
	}

	private void addToCart(HttpServletRequest request,String partNumber,String thongTin,String strSoLuong,String strDonGia) {
		HttpSession session=request.getSession();
		Object objectCart=session.getAttribute("cart");
		if(objectCart!=null) {
			cartBean =(CartBean) objectCart; 
		}else {
			cartBean =new CartBean();
			session.setAttribute("cart", cartBean);
		}
		double donGia=Double.parseDouble(strDonGia);
		int soLuong=Integer.parseInt(strSoLuong);
		double thanhTien=soLuong*donGia;
		CartItem cartItem=new CartItem(partNumber, thongTin, soLuong, donGia, thanhTien);
		if(cartBean.getListAllCartItem().size()==0) {
			cartBean.addCartItem(cartItem);
		}else {
			for(CartItem cartItem2:cartBean.getListAllCartItem()) {
				if(cartItem2.getPartNumber().equals(cartItem.getPartNumber())) {
					cartItem2.setSoLuong(cartItem.getSoLuong()+cartItem2.getSoLuong());
					cartItem2.setThanhTien(cartItem2.getDonGia()*cartItem2.getSoLuong());
					cartBean.calculateTongTien(); 
					return;
				}
			}
			cartBean.addCartItem(cartItem);
		}
	}
}
