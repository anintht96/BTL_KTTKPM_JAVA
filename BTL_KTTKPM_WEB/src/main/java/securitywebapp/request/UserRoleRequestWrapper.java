package securitywebapp.request;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

	private String user;
	private String roles = null;
	private HttpServletRequest realRequest;

	public UserRoleRequestWrapper(String user, String roles2, HttpServletRequest request) {
		super(request);
		this.user = user;
		this.roles = roles2;
		this.realRequest = request;
	}

	@Override
	public boolean isUserInRole(String role) {

		if (roles == null) {
			return this.realRequest.isUserInRole(role);
		}
		return roles.contains(role);
	}

	@Override
	public Principal getUserPrincipal() {
		
		if (this.user == null) {
			return realRequest.getUserPrincipal();
		}

		return new Principal() {
			@Override
			public String getName() {
				return user;
			}
		};
	}

}
