package com.deloitte.limetray.main;

import java.util.*;

import com.deloitte.limetary.model.UserDetails;
import com.deloitte.limetray.services.UserImpl;

public class LimetrayDemo {

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String option;
		
		UserImpl userImpl = new UserImpl();
		List<UserDetails> userlist = new ArrayList<UserDetails>();

		while (true) {
			System.out.println("1. ADD USER" + "\n 2.DISPLAY USER" +"\n 3.DISPLAY USER" + "\n 4.EXIT");
			option = sc.next();

			switch (option) {
			case "1":			

				System.out.println("Enter username");
				String userName = sc.next();
				
				System.out.println("Enter user id");
				String userId = sc.next();

				System.out.println("Enter password");
				String password = sc.next();

				System.out.println("Enter phone no:");
				int phone = sc.nextInt();

				System.out.println("Enter email:");
				String email = sc.next();

				userImpl.addUser(userName, userId, password, phone, email);
			
				
				//userlist.add(userImpl.addUser(userName, userId, password, phone, email));
				break;

			case "2":
				userlist = userImpl.displayUser();
				for (UserDetails user : userlist)
					System.out.println(user);

				break;
				
			case "3":

			case "4":
				System.exit(0);
				break;

			}

		}

	}

}
