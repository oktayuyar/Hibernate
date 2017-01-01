package hibernate.test;

import hibernate.implement.UserDAOImpl;
import hibernate.model.User;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDAOImpl userDAOImpl=new UserDAOImpl();
		User user =new User();
		/* user ekleme */
		user.setName("oktay");
		user.setSurname("uyar");
		userDAOImpl.insertUser(user);
		/* user güncelleme */
		userDAOImpl.updateUser(13, "baris","akarsu");
		/* userları listeleme */
		userDAOImpl.getAllUsers();
		/* user silme */
		userDAOImpl.removeUser(14);
		/* user bilgilerini getirme */
		user=null;
		userDAOImpl.findUser(8);
	}
}
