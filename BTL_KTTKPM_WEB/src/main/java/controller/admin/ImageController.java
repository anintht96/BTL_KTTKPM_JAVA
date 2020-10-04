package controller.admin;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.SanPhamRemote;
import entities.SanPham;

/**
 * Servlet implementation class ImageController
 */
@WebServlet("/sanPhamImage")
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private SanPhamRemote sanPhamRemote;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSanPham=request.getParameter("idSanPham");
		SanPham sanPham=null;
		if(idSanPham !=null) {
			sanPham=sanPhamRemote.findSanPhamById(idSanPham);
		}
		
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		try {
			response.getOutputStream().write(sanPham.getImage());
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
