package com.BankingProject.fuctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.BankingProject.util.DBConnection;

public class TransferAmountOneToAnotherAccount    {
		public void transferAmount(int senderId , int recevierId , int amount )	throws SQLException {
		Connection connection = DBConnection.getDBConnection();
		
		CallableStatement statement = connection.prepareCall("call project.transferAmount(?,?,?)");
		statement.setInt(1, senderId);
		statement.setInt(2, recevierId);
		statement.setInt(3, amount);
		
		statement.execute();
		
		System.out.println("Transaction successfully Completed!!!");
	}
}