package com.deloitte.limetray.services;

import java.util.ArrayList;

import com.deloitte.limetary.model.UserDetails;

public interface UserInterface {

	public UserDetails addUser(String name, String userId, String password, int phone, String email);

	public ArrayList<UserDetails> displayUser();

}
