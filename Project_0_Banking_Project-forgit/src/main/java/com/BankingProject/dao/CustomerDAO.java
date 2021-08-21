package com.BankingProject.dao;

import java.util.List;

import com.BankingProject.model.Customer;

public interface CustomerDAO {
	
//	public boolean createAccount(Customer customer);
//	public Customer addMoney(int amount,int customerid);
//	public Customer withDrawAmount(int amount);
//	public Customer checkStatusByName(String customername);
	
	public boolean CheckLogin(int customerid,int passwords);
	public Customer checkStatusById(int customerid);
	public List<Customer> transferAmount();
	public boolean iscustomerExists(int customerid);
	public int getBalance(int customerid);
	public int getCustomerId(String phoneNumber);
	
	}
