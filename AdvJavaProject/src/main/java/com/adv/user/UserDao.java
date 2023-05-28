package com.adv.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	public static int saveData(UserData user) {
		int res = 0;
		try {
			Connection connection = TestConnection.createConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?,?)");
			System.out.println(user);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCountry());
			preparedStatement.setString(5, user.getQualification());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getTechnologies());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.setString(9, user.getComments());
			res = preparedStatement.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static boolean checkLogin(String email, String password) {
		boolean result = false;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("select email,password from user_details where email='" + email
					+ "'and password='" + password + "'");

			if (set.next()) {
				result = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	public static ResultSet listOfUser() {
		ResultSet set = null;
		Connection connection = TestConnection.createConnection();
		try {
			Statement statement = connection.createStatement();
			set = statement.executeQuery(
					"select username,password,email,country,qualification,gender,technologies,address,comments from user_details");
			;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;

	}

	public static ResultSet searchByName(String username) throws IOException {
		ResultSet set = null;
		Connection connection = null;
		Statement statement = null;
		try {
			connection = TestConnection.createConnection();
			statement = connection.createStatement();
			set = statement.executeQuery("select * from user_details where username='" + username + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return set;
	}

}
