package com.BankingProject.Pages;

import java.util.Date;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.BankingProject.dao.CustomerDAO;
import com.BankingProject.dao.CustomerDAOImplemention;
import com.BankingProject.exception.ForDecoration;
import com.BankingProject.model.Customer;

public class FirstPageOfTheApp {
	
	Scanner sc = new Scanner(System.in);
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAOImplemention();
	boolean result;
	private static Logger logger = Logger.getLogger("FirstPageOfTheApp");
	
			//******************************************************************************************
			//******************************************************************************************
			//******************************************************************************************
			//*******************THIS IS THE FUNCTION WHICH IS FIRST PAGE OF THE APP********************
			//******************************************************************************************
			//******************************************************************************************
			//******************************************************************************************
			public void firstPage () {
				
				System.out.println("Please Enter your Name : ");
				String userName = sc.nextLine();
				
				logger.info("Welcome , "+userName+ " You logged in my app at : "+new Date());
				
		    	ForDecoration decoration = new ForDecoration();
		        System.err.println("<<-------------WELCOME TO BANKING APPS-------------->>");
		        decoration.decoration();
		        System.err.println("<<-----------Developed by PRIYANSHU JAIN------------>>");
		        decoration.decoration();
		        
		        System.out.println();
		        System.out.println("Are you Customer or employee of this bank");
		        System.out.println("Press 1. Customer");
		        System.out.println("Press 2. Employee");
		        System.out.println("Press 9. Exit");
		        
		        int choice = sc.nextInt();
		        switch (choice) {
		        
		        //******************************************************************************************
		        //*******************HERE YOU ARE CHOOSING {YOU ARE THE CUSTOMER OF BANK}*******************
		    	//******************************************************************************************
				case 1 :
					logger.info("You choice the option : "+choice);
					System.out.println();
					System.err.println("<<-----Welcome To Customer page----->>");
					CustomerFirstPage firstPage = new CustomerFirstPage();
					firstPage.firstPageOfCustomer();
					break;
				case 2 :
					logger.info("You choice the option : "+choice);
					System.out.println();
					System.err.println("<<-----Welcome To Employee page----->>");
					EmployeeFirstPage employeefirstPage = new EmployeeFirstPage();
					employeefirstPage.firstPageOfEmployee();
					break;
					
			    //******************************************************************************************
			    //**************************HERE USER WANTS TO EXIST THE PROGRAM****************************
				//******************************************************************************************
				case 9:
					System.out.println("********Thanks for using this App***********");
					System.out.println("*************Have a good Day****************");
					 System.exit(0);
					break;
				default :
					System.err.println("<<------You are Choosing a Wrong Number------>>");
					System.out.println("<<----------------Choose Again--------------->>");
					FirstPageOfTheApp firstPageOfTheApp = new FirstPageOfTheApp();
					firstPageOfTheApp.firstPage();
				} 
		        sc.close();
		    }
			
			public Customer acceptCustomerDetails() {
	    		System.out.println("Please Enter your Full Name : ");
	    		String customername = sc.next();
	    		System.out.println("Please Enter your Phone Number : ");
	    		String customerPhoneNumber = sc.next();
	    		System.out.println("Please Enter your Current balance in your Bank Account : ");
	    		int currentAmount = sc.nextInt();
	    		System.out.println("Please Enter your password of your Bank Account : ");
	    		int passwords = sc.nextInt();
	    		System.out.println("Please Enter your Comfirm password of your Bank Account : ");
	    		int confirmPasswords = sc.nextInt();
				if(passwords == confirmPasswords)
	    		{
					Customer customer = new Customer(customername,customerPhoneNumber,currentAmount,passwords);
		    		return customer;
	    		}
				else
				{
					System.err.println("Your password is not Matching..TRY AGAIN");
					return null;
				}
	    		 
	    	}
}
