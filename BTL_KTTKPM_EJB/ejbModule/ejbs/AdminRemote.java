package ejbs;

import javax.ejb.Remote;

import entities.Admin;

@Remote
public interface AdminRemote {

	public void addAdmin(Admin admin);
}
