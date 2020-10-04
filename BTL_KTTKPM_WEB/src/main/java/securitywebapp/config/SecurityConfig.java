package securitywebapp.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

	public static final String ROLE_MANAGER = "ADMIN";
	public static final String ROLE_EMPLOYEE = "USER";

	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

	static {
		init();
	}

	private static void init() {

		// Vai tro USER
		List<String> urlPatterns1 = new ArrayList<String>();

		urlPatterns1.add("/donHangDaDat");
		urlPatterns1.add("/checkOut");
		urlPatterns1.add("/cart/checkOut");
		
		mapConfig.put(ROLE_EMPLOYEE, urlPatterns1);

		//Vai tro ADMIN
		List<String> urlPatterns2 = new ArrayList<String>();

		urlPatterns2.add("/admin");
		urlPatterns2.add("/admin/donHang");
		urlPatterns2.add("/admin/addLoaiSanPham");
		urlPatterns2.add("/admin/adNhaSX");
		urlPatterns2.add("/admin/addsanpham");
		urlPatterns2.add("/admin/addThanhToan");
		urlPatterns2.add("/admin/deleteLoaiSP");
		urlPatterns2.add("/admin/deleteNhaSX");
		urlPatterns2.add("/admin/deleteSP");
		urlPatterns2.add("/admin/deleteThanhToan");
		urlPatterns2.add("/admin/loaisanpham");
		urlPatterns2.add("/admin/thanhToan");
		
		mapConfig.put(ROLE_MANAGER, urlPatterns2);
	}
	
	public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }
 
    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
 
}
