package src.main.java.com.metehanmengen.example7.service;

import src.main.java.com.metehanmengen.example7.dao.UserDao;
import src.main.java.com.metehanmengen.example7.model.User;

import java.util.List;


public class UserService {
		
	private UserDao userDao = new UserDao();


	public void createUser(User user) {
		System.out.println("ben bir userDao objesiyim:" + userDao.toString());
		
		if (user.getPassword().length() < 5) {
			System.out.println("şifre en az 5 karakterli olmalı");
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
		getAllUser().stream()
				.filter(u -> u.equals(user))
				.forEach(u -> u.setPassword(newPassword));
	}

}
