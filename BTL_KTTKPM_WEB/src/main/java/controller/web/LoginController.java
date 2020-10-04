package controller.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.TaiKhoanRemote;
import entities.TaiKhoan;
import securitywebapp.utils.AppUtils;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({ "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private TaiKhoanRemote taiKhoanRemote;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		TaiKhoan taiKhoan = taiKhoanRemote.findTaiKhoanByUserName(userName, password);

		if (taiKhoan == null) {
			String errorMessage = "Sai username hoặc password";

			request.setAttribute("errorMessage", errorMessage);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		AppUtils.storeLoginedUser(request.getSession(), taiKhoan);

		//
		int redirectId = -1;
		try {
			redirectId = Integer.parseInt(request.getParameter("redirectId"));
		} catch (Exception e) {
			
		}

		String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
		System.out.println("requestURI:" + requestUri);
		if (requestUri != null) {
			response.sendRedirect(requestUri);
		} else {
			// Mặc định sau khi đăng nhập thành công
			// chuyển hướng về trang /userInfo
			response.sendRedirect(request.getServletContext().getContextPath() + "/home");
		}
	}

}
