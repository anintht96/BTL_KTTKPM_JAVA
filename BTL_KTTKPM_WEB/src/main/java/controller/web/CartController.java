package controller.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbs.DonHangRemote;
import model.CartBean;

/**
 * Servlet implementation class CartController
 */
@WebServlet({"/cart/udCart","/shoppingCart"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DonHangRemote donHangRemote;
	
	protected CartBean cartBean;
	
    public CartBean getCartBean() {
		return cartBean;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/web/shoppingCart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String strSoLuong=request.getParameter("soLuong");
		String strItemIndex=request.getParameter("itemIndex");
		
		if(action.equals("updateCart")) {
			updateCart(request, strSoLuong, strItemIndex);
		}else if(action.equals("removeCart")) {
			delete(request, strItemIndex);
		}
		
		response.sendRedirect(this.getServletContext().getContextPath()+"/shoppingCart");
		
	}

	private void delete(HttpServletRequest request,String strItemIndex) {
		HttpSession session=request.getSession();
		Object objCartInfo = session.getAttribute("cart");
		if(objCartInfo!=null) {
			cartBean= (CartBean) objCartInfo;
		}else {
			cartBean=new CartBean();
		}
		int itemIndex=Integer.parseInt(strItemIndex);
		cartBean.deleteCartItem(itemIndex);
	}
	
	private void updateCart(HttpServletRequest request,String strSoLuong,String strItemIndex) {
		int itemIndex=Integer.parseInt(strItemIndex);
		HttpSession session=request.getSession();
		Object objCartInfo=session.getAttribute("cart");
		if(objCartInfo!=null) {
			cartBean= (CartBean) objCartInfo;
		}else {
			cartBean=new CartBean();
		}
		int soLuong=Integer.parseInt(strSoLuong);
		cartBean.updateCartItem(itemIndex, soLuong);
	}
	
}
