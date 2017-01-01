package hibernate.interfaces;

import java.util.List;

import hibernate.model.User;

public interface UserDAO {
	public User insertUser(User u);
	
	public List<User> getAllUsers();

	public void updateUser(int id,String name,String surname);
	
	public void removeUser(int id);
	
	public User findUser(int id);

}
