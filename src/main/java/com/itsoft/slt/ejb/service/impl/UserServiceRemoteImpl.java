package com.itsoft.slt.ejb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.itsoft.slt.ejb.domain.User;
import com.itsoft.slt.ejb.service.UserServiceRemote;

@Stateless
public class UserServiceRemoteImpl implements UserServiceRemote<User> {

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();

		users.add(new User("user1", "jonh", "Doe"));
		users.add(new User("user2", "jonh", "Smith"));

		return users;
	}

	@Override
	public User findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub

	}

}
