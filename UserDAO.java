package com.deloitte.limetray.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.deloitte.limetary.model.UserDetails;

public class UserDAO {
	public static Connection connectToDB() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static void addUser(UserDetails user) {
		try {

			Connection con = connectToDB();
			PreparedStatement stmt = con.prepareStatement("insert into signup values(?,?,?,?,?)");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getUserId());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getPhone());
			stmt.setString(5, user.getEmail());

			// Step 4: Execute SQL Query
			int affectedRows = stmt.executeUpdate();
			System.out.println("Affected rows " + affectedRows);

			// Step 5:Close Connection
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<UserDetails> displayUser() {
		ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
		try {
			Connection con = connectToDB();
			PreparedStatement stmt = con.prepareStatement("select *from signup");

			// Step 4: Execute SQL Query
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserDetails user = new UserDetails();

				user.setName(rs.getString(1));
				user.setUserId(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhone(rs.getInt(4));
				user.setEmail(rs.getString(5));
				userList.add(user);
			}
			// Step 5:Close Connection
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;

	}

}
