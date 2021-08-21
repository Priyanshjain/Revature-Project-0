package com.BankingProject.exception;

import com.BankingProject.Pages.LoginPageOfCustomer;
import com.BankingProject.dao.CustomerDAO;
import com.BankingProject.dao.CustomerDAOImplemention;

public class ValidateAmount {
	
	CustomerDAO customerDAO = new CustomerDAOImplemention();
	LoginPageOfCustomer loginPage;
	
	public int amounCheck(int customerid, int amount) {
		int currentBalance = customerDAO.getBalance(customerid);
		if(currentBalance < amount)
		{
				System.err.println("Entered Amount should not be greater than the Current Balance ");
				loginPage = new LoginPageOfCustomer();
				loginPage.cusotmerlogin();
				return 0;
		}
		else
		{
			return 1;
		}
	}
}

