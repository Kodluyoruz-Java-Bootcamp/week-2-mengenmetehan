package src.main.java.com.metehanmengen.example7.dao;

import src.main.java.com.metehanmengen.example7.model.User;

import java.util.ArrayList;
import java.util.List;

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
