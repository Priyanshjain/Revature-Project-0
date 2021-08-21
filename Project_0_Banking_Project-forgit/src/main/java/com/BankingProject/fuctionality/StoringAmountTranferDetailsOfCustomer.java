package com.BankingProject.fuctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.BankingProject.util.DBConnection;

public class StoringAmountTranferDetailsOfCustomer {

	public void StoringAmountTranferDetails(int senderId ,int recevierId,int amount)throws SQLException {
		Connection connection = DBConnection.getDBConnection();
		
		CallableStatement statement = connection.prepareCall("call project.TranferAmountDetails(?,?,?)");
		statement.setInt(1, senderId);
		statement.setInt(2, recevierId);
		statement.setInt(3, amount);
		
		statement.execute();
		
		System.out.println("Storing Tranfer details successfully!!!");
	}
}
