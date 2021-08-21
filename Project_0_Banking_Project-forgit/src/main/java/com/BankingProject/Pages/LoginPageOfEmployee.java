package com.BankingProject.Pages;

import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

import com.BankingProject.dao.CustomerDAO;
import com.BankingProject.dao.CustomerDAOImplemention;
import com.BankingProject.dao.EmloyeeDAOimplemention;
import com.BankingProject.dao.EmployeeDAO;
import com.BankingProject.model.Customer;
import com.BankingProject.model.DepositingMoneyDetails;
import com.BankingProject.model.TranferMoneyDetails;
import com.BankingProject.model.WithdrawMoneyDetails;

public class LoginPageOfEmployee {

	Scanner sc = new Scanner(System.in);
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAOImplemention();
	EmployeeDAO employeeDAO = new EmloyeeDAOimplemention();
	LoginPageOfCustomer loginPage;
	
	public void employeelogin() {
		System.out.println("Please Enter your employee ID : ");
		int employeeid = sc.nextInt();
		System.out.println("Please Enter your Password : ");
		int passwords = sc.nextInt();
		if(employeeDAO.CheckLogin(employeeid,passwords))
		{
			System.out.println("<<--------Welcome Sir-------->> ");
			System.out.println("Press 1 Get Detailed list of Deposting Money ");
			System.out.println("Press 2 Get Detailed list of Withdraw Money");
			System.out.println("Press 3 Get Detailed list of Tranfer Money ");
			System.out.println("Press 4 Check Not Approvaed New customers ");
			System.out.println("Press 5 Check Balance of Any customer (Using CustomerId) ");
			System.out.println("Press 6 Go Back ");
			int Choose = sc.nextInt();
			switch(Choose)
			{
				case 1:
					List<DepositingMoneyDetails> depositeAmountOfcustomer = employeeDAO.getAllDepositeInformation();
					System.out.println("<<<<<List Of All the Deposted Money>>>>>");
					System.out.println("Depositing Money Details Of Customers");
					System.out.println(depositeAmountOfcustomer);
					break;
				case 2:
					List<WithdrawMoneyDetails> withdrawAmountofcustomer = employeeDAO.getAllWithdrawInformation();
					System.out.println("<<<<<List Of All the Withdraw Money>>>>>");
					System.out.println("Withdraw Money Details Of Customers");
					System.out.println(withdrawAmountofcustomer);
					break;
				case 3:
					List<TranferMoneyDetails> tranferAmountofcustomer = employeeDAO.getAllTranferMoneyInformation();
					System.out.println("<<<<<List Of All the Tranfer Money from one account to another>>>>>");
					System.out.println("Tranfer Money Details Of Customers");
					System.out.println(tranferAmountofcustomer);
					break;
				default :
					break;
			}
		}
		else
		{
			System.err.println("Please check your Employee ID or Password....(INCORRECT)");
			EmployeeFirstPage employeeFirstPage = new EmployeeFirstPage();
			employeeFirstPage.firstPageOfEmployee();
		}
		
	}
}
