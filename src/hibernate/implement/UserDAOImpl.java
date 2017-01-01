package hibernate.implement;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import hibernate.interfaces.UserDAO;
import hibernate.model.User;
import hibernate.utility.HibernateUtility;

public class UserDAOImpl implements UserDAO{

	Session session = HibernateUtility.getHibernateSession();

	/* Veritabanında yeni bir user oluşturduğumuz method */
	@Override
	public User insertUser(User u) {
		try{
		System.out.println("eklenen kullanıcının adı ve soyadı :"+u.getName()+" "+u.getSurname());
		session.beginTransaction();
		session.persist(u);
		session.getTransaction().commit();
		}
	    catch (HibernateException e) {
	    	if (session.getTransaction()!=null) session.getTransaction().rollback();
	    	e.printStackTrace(); 
		  }		
		return u;
	}
	/* Veritabanındaki tüm userları listelediğimiz method */
	@Override
	public List<User> getAllUsers() {
		List<User> users=null;
	      try{
	    	  
	    	  session.beginTransaction();
	          users = session.createQuery("FROM User").list(); 
	          System.out.println("Listelenen kullanıcılar ");
	          for (Iterator<User> iterator = 
	        		  users.iterator(); iterator.hasNext();){
	        	  User user = (User) iterator.next(); 
	             System.out.print("adı : " + user.getName()+"\t"); 
	             System.out.print("  soyadı : " + user.getSurname()+"\n"); 
	          }
	       }
	      catch (HibernateException e) {
	    	  if (session.getTransaction()!=null) session.getTransaction().rollback();
	    	  e.printStackTrace(); 
		  }
	   return users;
	}
	/* Id sini verdiğimiz userın adını güncellediğimiz method */
	@Override
	public void updateUser(int id, String name,String surname){
		try{
	         session.beginTransaction();
	         User user = session.get(User.class, id); 
	         System.out.println("güncellenecek olan kullanıcının adı :"+user.getName());
	         user.setName(name);
	         user.setSurname(surname);
			 session.update(user); 
			 session.getTransaction().commit();
	    }
		catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace(); 
	    }
	}
	/* Id sini verdiğimiz userı veritabanından sildiğimiz method */
	@Override
	public void removeUser(int id) {
		try{
	         User user = session.get(User.class, id); 
	         System.out.println(" silinecek olan kullanıcının adı : "+user.getName()+"  soyadı :"+user.getSurname());
	         session.delete(user); 
	         session.getTransaction().commit();
	    }
		catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace(); 
	      }
	}
	/* Id sini verdiğimiz userın bilgilerini getirdiğimiz method */
	@Override
	public User findUser(int id) {
		User user=session.get(User.class, id);
		System.out.println("bulunan kullanıcının adı : "+user.getName()+"  soyadı :"+user.getSurname());
		return user;
	}

}
