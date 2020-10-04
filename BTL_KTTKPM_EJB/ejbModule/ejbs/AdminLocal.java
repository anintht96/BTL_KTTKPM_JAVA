package ejbs;

import javax.ejb.Local;

import entities.Admin;

@Local
public interface AdminLocal {

	public void addAdmin(Admin admin);
}
