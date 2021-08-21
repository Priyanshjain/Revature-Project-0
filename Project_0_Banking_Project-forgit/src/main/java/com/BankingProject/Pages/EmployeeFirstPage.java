package com.BankingProject.Pages;

import java.util.Scanner;
import com.BankingProject.dao.EmloyeeDAOimplemention;
import com.BankingProject.dao.EmployeeDAO;
import com.BankingProject.model.Customer;
import com.BankingProject.model.Employee;

public class EmployeeFirstPage {
	
	Scanner sc = new Scanner(System.in);
	EmployeeDAO customerDAO = new EmloyeeDAOimplemention();
	Customer customer = new Customer();
	Employee employee = new Employee();
	boolean result;
	 
	public void firstPageOfEmployee() {
		System.out.println("<<--Thanks of been a valuable employeee of our bank Sir-->>");
		System.out.println("Press 1 LogIn");
		System.out.println("Press 2 Back Page");
		int choice = sc.nextInt();
		 switch (choice) {
			
			//******************************************************************************************
			//***************************HERE WE ARE LOGIN AS A EMPLOYEE********************************
			//******************************************************************************************
		case 1 :
			System.out.println("You choice the  " + choice + " option");
			LoginPageOfEmployee login = new LoginPageOfEmployee();
			login.employeelogin();
			break;
			
			//******************************************************************************************
			//**************************GOING BACK TO THE MAIN PAGE*************************************
			//******************************************************************************************
		case 2:
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
			EmployeeFirstPage employeeFirstPage = new EmployeeFirstPage();
			employeeFirstPage.firstPageOfEmployee();
	}
	}
}
