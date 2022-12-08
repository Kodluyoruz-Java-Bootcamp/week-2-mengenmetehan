package src.main.java.com.metehanmengen.example3.dao;

import java.util.ArrayList;
import java.util.List;

import src.main.java.com.metehanmengen.example3.model.User;

public class UserDao implements IRepository<User, Long > {
	
	private static List<User> userList = new ArrayList<>();


	@Override
	public void save(User user) {
		userList.add(user);
	}

	@Override
	public Iterable<User> findAll() {
		return userList;
	}
}
