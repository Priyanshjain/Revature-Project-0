package com.BankingProject.fuctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import com.BankingProject.util.DBConnection;

public class CreateNewBackAccount {
	Scanner sc = new Scanner(System.in);
	
		public void newCustomerDetails(String customername , String phonenumber , int currentamount, int passwords, String status ) throws SQLException {
		Connection connection = DBConnection.getDBConnection();
		
		CallableStatement statement = connection.prepareCall("call project.CreateAccount(?,?,?,?,?)");
		statement.setString(1, customername);
		statement.setString(2, phonenumber);
		statement.setInt(3, currentamount);
		statement.setInt(4, passwords);
		statement.setString(5, status);
	
		statement.execute();
		
		System.out.println("Successfully Created your Account!!!");
		System.out.println("Any Bank member get back to you within 24hrs!!!");
	}
}
