package src.main.java.com.metehanmengen.example3.service;

import java.util.List;

import src.main.java.com.metehanmengen.example3.dao.UserDao;
import src.main.java.com.metehanmengen.example3.model.User;


public class SingletonUserService {
		
	private UserDao userDao = new UserDao();

	private static SingletonUserService userService = new SingletonUserService();
	
	private SingletonUserService() {
		
	}
	
	public static SingletonUserService getDifferentInstance() {
		return  new SingletonUserService();
	}

	public void createUser(User user) {
		//UserDao userDao = new UserDao(); tekrar tekrar oluÅŸturmamÄ±za gerek yok
		System.out.println("ben bir userDao objesiyim:" + userDao.toString());
		
		if (user.getPassword().length() < 5) {
			System.out.println("Å�ifre en az 5 karakterli olmalÄ±");
		}			
		userDao.save(user);
	}
	
	public List<User> getAllUser() {
		//UserDao userDao = new UserDao();		
		return (List<User>)userDao.findAll();
	}
	
	public void printAllUser() {
		
		getAllUser().forEach(user -> System.out.println(user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		// Ã¶nce hangi user bul ve passwordÃ¼ update et.
	}

}
