package com.deloitte.limetray.services;

import java.util.ArrayList;
import java.util.List;
import com.deloitte.limetary.model.UserDetails;
import com.deloitte.limetray.dao.UserDAO;

public  class UserImpl implements UserInterface {

	List<UserDetails> userlist = new ArrayList<UserDetails>();
	ArrayList<UserDetails> user = new ArrayList<UserDetails>();

	@Override
	public UserDetails addUser(String name, String userId, String password, int phone, String email) {
		// TODO Auto-generated method stub

		UserDetails user = new UserDetails();		
		user.setName(name);
		user.setUserId(userId);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		UserDAO.addUser(user);
		return user;
	}

	@Override
	public ArrayList<UserDetails> displayUser() {
		// TODO Auto-generated method stub
		return UserDAO.displayUser();
		
	}

}
