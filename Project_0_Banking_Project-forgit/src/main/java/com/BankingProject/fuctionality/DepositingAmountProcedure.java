package com.BankingProject.fuctionality;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.BankingProject.util.DBConnection;

public class DepositingAmountProcedure    {
		public void DepositingAmount(int customerId , int amount) throws SQLException {
		Connection connection = DBConnection.getDBConnection();
		
		CallableStatement statement = connection.prepareCall("call project.DepositeAmount(?,?)");
		statement.setInt(1, customerId);
		statement.setInt(2, amount);
		
		statement.execute();
		
		System.out.println("Transaction successfully Completed!!!");
	}
}
