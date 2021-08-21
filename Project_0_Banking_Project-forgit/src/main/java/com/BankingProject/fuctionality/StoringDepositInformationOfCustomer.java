package com.BankingProject.fuctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.BankingProject.util.DBConnection;
	
	public class StoringDepositInformationOfCustomer {
		
		public void StoringDepositInformation(int senderId ,int amount )	throws SQLException {
			Connection connection = DBConnection.getDBConnection();
			
			CallableStatement statement = connection.prepareCall("call project.DepositAmountDetails(?,?)");
			statement.setInt(1, senderId);
			statement.setInt(2, amount);
			
			statement.execute();
			
			System.out.println("Storing Deposit details successfully!!!");
		}
}
