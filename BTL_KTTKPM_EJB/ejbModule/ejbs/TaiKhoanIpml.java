package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.TaiKhoan;

/**
 * Session Bean implementation class TaiKhoanIpml
 */
@Stateless
@LocalBean
public class TaiKhoanIpml implements TaiKhoanRemote, TaiKhoanLocal {

	@PersistenceContext(unitName = "BTL_KTTKPM_EJB")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public TaiKhoanIpml() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public TaiKhoan findTaiKhoanByUserName(String userName,String password) {
		TaiKhoan taiKhoan= entityManager.find(TaiKhoan.class, userName);
		if(taiKhoan!=null && taiKhoan.getPassword().equals(password)) {
			return taiKhoan;
		}
		return null;
	}

}
