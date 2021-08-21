package com.BankingProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.BankingProject.model.Customer;
import com.BankingProject.util.DBConnection;

public class CustomerDAOImplemention implements CustomerDAO{
	Connection connection = DBConnection.getDBConnection();
	Customer customer = new Customer();
	
	private final String FIND_CUSTOMER_BY_ID_QUERY = "select * from project.customer where customerid= ?";
	private final String CHECK_LOGIN_QUERY = "select * from project.customer where customerid=? and passwords=?";
	private final String GET_BALANCE_QUERY = "select currentamount from project.customer where customerid = ?";
	private final String GET_CUSTOMERID_QUERY = "select customerid from project.newcustomer where phoneNumber = ?";
	
//	private final String CREATE_ACCOUNT_QUERY = "insert into project.newcustomer(customerName,phoneNumber,currentamount,passwords) values(?,?,?,?)";
//	private final String WITHDRAW_AMOUNT_QUERY = "update project.customer set currentamount = currentamount - ? where custosmerid = ?";
//	private final String ADD_MONEY_QUERY = "update project.customer set currentamount = currentamount + ? where custosmerid = ?";



	public boolean CheckLogin(int customerid, int passwords) {
		boolean result= false;
		try {
			PreparedStatement statement = connection.prepareStatement(CHECK_LOGIN_QUERY);
			statement.setInt(1,customerid);
			statement.setInt(2,passwords);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				result = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
//		if(result == true) {
//			return true;
//		}
//		else
//		{
////			System.out.println("Please check your Customer ID or Password...(INCORRECT)");
//			return false;
//		}
	}

	public Customer checkStatusById(int customerid) {
		Customer customer = new Customer();
		PreparedStatement stat = null;
		try {
			stat = connection.prepareStatement(FIND_CUSTOMER_BY_ID_QUERY);
			stat.setInt(1, customerid);
			ResultSet res = stat.executeQuery();
			res.next();

			customer.setCustomerid(res.getInt("customerid"));
			customer.setCustomername(res.getString("customername"));
			customer.setPhonenumber(res.getString("phonenumber"));
			customer.setCurrentamount(res.getInt("currentamount"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}



	public List<Customer> transferAmount() {
		
		return null;
	}


	public boolean iscustomerExists(int customerid) {
		boolean result = false;

		try {
			PreparedStatement stat = connection.prepareStatement(FIND_CUSTOMER_BY_ID_QUERY);
			stat.setInt(1, customerid);
			ResultSet res = stat.executeQuery();

			if (res.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}





	public int getBalance(int customerid) {
		int balance =0;
		ResultSet res;
		try {
			PreparedStatement statement = connection.prepareStatement(GET_BALANCE_QUERY);
			statement.setInt(1, customerid);

			res = statement.executeQuery();
			while (res.next()) {
				balance = res.getInt("currentamount");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (balance != 0)
			return balance;
		else {
			System.out.println("Something went Wrong ! Please try Again");
			return 0;
		}

	}


	public int getCustomerId(String phoneNumber) {
		int newcustomerid = 0;
		ResultSet res;
		try {
			PreparedStatement statement = connection.prepareStatement(GET_CUSTOMERID_QUERY);
			statement.setString(1, phoneNumber);

			res = statement.executeQuery();
			while (res.next()) {
				newcustomerid = res.getInt("customerid");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (newcustomerid != 0)
			return newcustomerid;
		else {
			System.out.println("Something went Wrong ! Please try Again");
			return 0;
		}
	}

	
	//	public boolean createAccount(Customer customer) {
//	int res=0;
//	try {
//		PreparedStatement statement = connection.prepareStatement(CREATE_ACCOUNT_QUERY);
//		statement.setString(1,customer.getCustomername());
//		statement.setString(2,customer.getPhonenumber());
//		statement.setInt(3,customer.getCurrentamount());
//		statement.setInt(4,customer.getPasswords());
//		
//		res = statement.executeUpdate();
//	}catch (SQLException e) {
//		e.printStackTrace();
//	}
//	if(res==0)
//		return false;
//	else
//		return true;
//}
	
//	public Customer addMoney(int amount) {
//	return null;
//}


//public Customer addMoney(int amount,int customerid) {
//	Customer customer = new Customer();
//	PreparedStatement stat = null;
//	int res = 0;
//	try {
//		stat = connection.prepareStatement(ADD_MONEY_QUERY);
//		stat.setInt(1, amount);
//		stat.setInt(2, customerid);
//		res = stat.executeUpdate();
//					
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//
//	return customer;
//}

//	public Customer checkStatusByName(String customername) {
//	
//	return null;
//}


//
//public Customer withDrawAmount(int amount) {
//	
//	return null;
//}

}
