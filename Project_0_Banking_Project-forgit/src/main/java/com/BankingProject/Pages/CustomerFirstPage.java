package com.BankingProject.Pages;

import com.BankingProject.model.Customer;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.BankingProject.dao.CustomerDAO;
import com.BankingProject.dao.CustomerDAOImplemention;
import com.BankingProject.exception.ForValidatePhoneNumber;
import com.BankingProject.fuctionality.*;

public class CustomerFirstPage {
	
	
	Scanner sc = new Scanner(System.in);
	CustomerDAO customerDAO = new CustomerDAOImplemention();
	Customer customer = new Customer();
	boolean result;
	
	
	public void firstPageOfCustomer() {
		System.out.println("<<--Thanks of been a valuable customer of our bank Sir-->>");
		System.out.println("Press 1 Create Account ");
		System.out.println("Press 2 LogIn");
		System.out.println("Press 3 Back Page");
		int choice = sc.nextInt();
        switch (choice) {
	
			//******************************************************************************************
			//**********************HERE WE ARE CREATING NEW ACCOUNT OF THE CUSTOMER********************
			//******************************************************************************************
		case 1 :
			
			System.out.println("You choice the  " + choice + " option");
			System.out.println("Here , We are creating your new bank account");
			System.out.println("Please provide your some details ");
			
			//*****************************************************
			//*********TAKING DETAILS OF CUSTOMER******************
			//*****************************************************
			
			System.out.println("Please Enter your Name : ");
			String customerName = sc.next();
			System.out.println("Please Enter your Phone Number : ");
			String phoneNumber = sc.next();
			ForValidatePhoneNumber forValidatePhoneNumber = new ForValidatePhoneNumber();
			forValidatePhoneNumber.checkPhoneNumer(phoneNumber);
			System.out.println("Please Enter your Opening balance : ");
			int balance = sc.nextInt();
			System.out.println("Please Enter password : ");
			int passwords = sc.nextInt();
			System.out.println("Please Enter Confirm Password : ");
			int ConfirmPassword = sc.nextInt();
			String status = "NOT APPROVED";
			CreateNewBackAccount newaccount = new CreateNewBackAccount();
			
			
			//*****************************************************
			//***************CHECKING PASSWORDS********************
			//*****************************************************
			if(passwords == ConfirmPassword) {
			try {
				newaccount.newCustomerDetails(customerName, phoneNumber, balance, passwords, status);
				System.err.println("Please save/write your CustomerId in Any Safe Place :  "+ customerDAO.getCustomerId(phoneNumber));
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
				}
				System.out.println("*******Thanks for using this App sir********");
				System.exit(0);
			}
			else {
				System.err.println("Please check your Passwords!!!");
				CustomerFirstPage firstpage = new CustomerFirstPage();
				firstpage.firstPageOfCustomer();
			}
			break;
			
			//******************************************************************************************
			//***************************HERE WE ARE LOGIN AS A CUSTOMER********************************
			//******************************************************************************************
		case 2 :
			System.out.println("You choice the  " + choice + " option");
			LoginPageOfCustomer login = new LoginPageOfCustomer();
			login.cusotmerlogin();
			break;
			
			//******************************************************************************************
			//**************************GOING BACK TO THE MAIN PAGE*************************************
			//******************************************************************************************
		case 3:
			System.out.println("You choice the  " + choice + " option");
			FirstPageOfTheApp firstMainPage = new FirstPageOfTheApp();
			firstMainPage.firstPage();
			break;
			

			//******************************************************************************************
			//****************IF YOU CHOICE WRONG CHIOCE THEN STAY ON THAT PAGE*************************
			//******************************************************************************************
		default :
			System.out.println("You choice the  " + choice + " option");
			System.err.println(".....Please Enter the Option....");
			CustomerFirstPage customerFirstPage = new CustomerFirstPage();
			customerFirstPage.firstPageOfCustomer();
	}

  }
}