package com.BankingProject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.BankingProject.model.Customer;
import com.BankingProject.model.DepositingMoneyDetails;
import com.BankingProject.model.Employee;
import com.BankingProject.model.TranferMoneyDetails;
import com.BankingProject.model.WithdrawMoneyDetails;
import com.BankingProject.util.DBConnection;

public class EmloyeeDAOimplemention implements EmployeeDAO {

	Connection connection = DBConnection.getDBConnection();
	Customer customer = new Customer();
	Employee employee = new Employee();
	
	private final String CHECK_LOGIN_QUERY = "select * from project.employee where employeeid=? and passwords=?";
	private final String All_CUSTOMER_DEPOSITE = "select * from project.depositdetails";
	private final String All_CUSTOMER_WITHDRAW = "select * from project.withdrawdetails";
	private final String All_CUSTOMER_TRANFER_MONEY_DETAILS = "select * from project.MoneyTransferDetails";
	
	public Employee checkStatusById(int employeeid) {
		return null;
	}

	//******************************************************************************************************************************************
	//***********************************CHECKING THE LOGIN ID AND PASSWORD TO LOGIN IN BANK AS EMPLOYEE****************************************
	//******************************************************************************************************************************************
		public boolean CheckLogin(int employeeid, int passwords) {
			boolean result= false;
			try {
				PreparedStatement statement = connection.prepareStatement(CHECK_LOGIN_QUERY);
				statement.setInt(1,employeeid);
				statement.setInt(2,passwords);
				ResultSet res = statement.executeQuery();
				if(res.next()) {
					result = true;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

	//******************************************************************************************************************************************
	//*****************************GETTING ALL THE DETAILS OF CUSTOMER WHO DEPOSIT THE AMOUNT FROM BANK ACCOUNT*********************************
	//******************************************************************************************************************************************
		public List<DepositingMoneyDetails> getAllDepositeInformation() {
			List<DepositingMoneyDetails> DepositeList = new ArrayList<DepositingMoneyDetails>();
			try {
				Statement  statement = connection.createStatement();
				ResultSet res = statement.executeQuery(All_CUSTOMER_DEPOSITE);
				while(res.next())
				{
					DepositingMoneyDetails customer = new DepositingMoneyDetails();
					customer.setCustomerid(res.getInt(1));
					customer.setDespositedMoney(res.getInt(2));
					DepositeList.add(customer);
				} 
			}catch(SQLException e) {
					e.printStackTrace();
				}
			return DepositeList;
		}

	//******************************************************************************************************************************************
	//*****************************GETTING ALL THE DETAILS OF CUSTOMER WHO WITHDRAW THE AMOUNT FROM BANK ACCOUNT********************************
	//******************************************************************************************************************************************
			public List<WithdrawMoneyDetails> getAllWithdrawInformation() {
				List<WithdrawMoneyDetails> DepositeList = new ArrayList<WithdrawMoneyDetails>();
				try {
					Statement  statement = connection.createStatement();
					ResultSet res = statement.executeQuery(All_CUSTOMER_WITHDRAW);
					while(res.next())
					{
						WithdrawMoneyDetails customer = new WithdrawMoneyDetails();
						customer.setCustomerid(res.getInt(1));
						customer.setWithdrawMoney(res.getInt(2));
						DepositeList.add(customer);
					} 
				}catch(SQLException e) {
						e.printStackTrace();
					}
				return DepositeList;
			}

	//******************************************************************************************************************************************
	//**********************GETTING ALL THE DETAILS OF CUSTOMER WHO TRANFER THE AMOUNT FROM ONE BANK ACCOUNT TO ANOTHER*************************
	//******************************************************************************************************************************************
		public List<TranferMoneyDetails> getAllTranferMoneyInformation() {
			List<TranferMoneyDetails> TranferMoneyList = new ArrayList<TranferMoneyDetails>();
			try {
				Statement  statement = connection.createStatement();
				ResultSet res = statement.executeQuery(All_CUSTOMER_TRANFER_MONEY_DETAILS);
				while(res.next())
				{
					TranferMoneyDetails customer = new TranferMoneyDetails();
					customer.setSenderId(res.getInt(1));
					customer.setRecevierId(res.getInt(2));
					customer.setTranferAmount(res.getInt(3));
					TranferMoneyList.add(customer);
				} 
			}catch(SQLException e) {
					e.printStackTrace();
				}
			return TranferMoneyList;
			}
}
	
