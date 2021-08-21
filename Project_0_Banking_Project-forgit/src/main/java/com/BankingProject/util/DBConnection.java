package com.BankingProject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getDBConnection() {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver"); 

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
