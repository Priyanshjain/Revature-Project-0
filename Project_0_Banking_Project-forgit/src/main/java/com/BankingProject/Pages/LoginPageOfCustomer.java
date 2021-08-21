package com.BankingProject.Pages;

import java.sql.SQLException;
import java.util.Scanner;
import com.BankingProject.dao.CustomerDAO;
import com.BankingProject.dao.CustomerDAOImplemention;
import com.BankingProject.exception.ValidateAmount;
import com.BankingProject.fuctionality.*;
import com.BankingProject.model.Customer;

public class LoginPageOfCustomer {
	
	Scanner sc = new Scanner(System.in);
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAOImplemention();
	LoginPageOfCustomer loginPage;
	int check =0 ;
	
	//******************************************************************************************
	//******************************************************************************************
	//***************Customer Login Page if customer correctly login into the App***************
	//******************************************************************************************
	//******************************************************************************************
	public void cusotmerlogin() {
		System.out.println("Please Enter your Bank ID : ");
		int bankid = sc.nextInt();
		System.out.println("Please Enter your Password : ");
		int passwords = sc.nextInt();
		if(customerDAO.CheckLogin(bankid,passwords))
		{
			System.out.println("<<--------Welcome Sir-------->> ");
			System.out.println("Press 1 Transfer Money ");
			System.out.println("Press 2 WidthDraw Money ");
			System.out.println("Press 3 Deposite Money ");
			System.out.println("Press 4 Check Balance ");
			System.out.println("Press 5 Go Back ");
			int choice = sc.nextInt();
			switch(choice) {
			
				//******************************************************************************************
				//*********Here, We are Sending the money from one account to another Bank Account**********
				//******************************************************************************************
			case 1:
				System.out.println("Please Enter the Receviers Bank Id : ");
				int recevierBankId = sc.nextInt();
				System.out.println("Please Enter Amount you want to transfer : ");
				int amountToTransfer = sc.nextInt();
				TransferAmountOneToAnotherAccount tranfermoney = new TransferAmountOneToAnotherAccount();
				StoringAmountTranferDetailsOfCustomer amountTranferDetailsOfCustomer = new  StoringAmountTranferDetailsOfCustomer();
				try {
					ValidateAmount validamount = new ValidateAmount();
					validamount.amounCheck(bankid,amountToTransfer);
					tranfermoney.transferAmount(bankid, recevierBankId, amountToTransfer);
					amountTranferDetailsOfCustomer.StoringAmountTranferDetails(bankid, recevierBankId, amountToTransfer);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
					System.out.println("<<-----Want to do anything else.... Press 1----->>");
					System.out.println("<<----------Otherwise....Press Any Key---------->>");
					check = sc.nextInt();
					if(check==1)
					{
						loginPage = new LoginPageOfCustomer();
						loginPage.cusotmerlogin();
					}
					else
					{
						System.out.println("*********Thanks for your our App************");
						System.exit(0);
					}
				break;
			
				//******************************************************************************************
				//***************Here, We are Withdrawing the amount form the Bank Account******************
				//******************************************************************************************
			case 2:
				System.out.println("Please Enter Amount you want Withdraw : ");
				int amountToWithdraw = sc.nextInt();
				StoringWithdrawInformationOfCustomer informationOfCustomer = new StoringWithdrawInformationOfCustomer();
				WithDrawAmountProcedure withDrawMoney = new WithDrawAmountProcedure();
				try {
					ValidateAmount validamount = new ValidateAmount();
					validamount.amounCheck(bankid,amountToWithdraw);
					withDrawMoney.withdrawAmount(bankid, amountToWithdraw);
					informationOfCustomer.StoringWithdrawInformation(bankid, amountToWithdraw);
						} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("<<-----Want to do anything else.... Press 1----->>");
				System.out.println("<<----------Otherwise....Press Any Key---------->>");
					check = sc.nextInt();
					if(check==1)
					{
						loginPage = new LoginPageOfCustomer();
						loginPage.cusotmerlogin();
					}
					else
					{
						System.out.println("*********Thanks for your our App************");
						System.exit(0);
					}
				break;
				
				//*****************************************************************************************
				//******************Here, We are Depositing the amount to the Bank Account*****************
				//*****************************************************************************************
			case 3:
				System.out.println("Please Enter Amount you want Deposite : ");
				int amountToAdd = sc.nextInt();
				DepositingAmountProcedure depositMoney = new DepositingAmountProcedure();
				StoringDepositInformationOfCustomer depositInformationOfCustomer = new StoringDepositInformationOfCustomer();
				try {
					depositMoney.DepositingAmount(bankid, amountToAdd);
					depositInformationOfCustomer.StoringDepositInformation(bankid, amountToAdd);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("<<-----Want to do anything else.... Press 1----->>");
				System.out.println("<<----------Otherwise....Press Any Key---------->>");
					check = sc.nextInt();
					if(check==1)
					{
						loginPage = new LoginPageOfCustomer();
						loginPage.cusotmerlogin();
					}
					else
					{
						System.out.println("*********Thanks for your our App************");
						System.exit(0);
					}
				break;
				
				//*****************************************************************************************
				//**************Here We are Viewing the Account Details of the Bank Account****************
				//*****************************************************************************************
			case 4:
					System.out.println("Your Balance is : ==> "+ customerDAO.getBalance(bankid));
					System.out.println();
					System.out.println("<<-----Want to do anything else.... Press 1----->>");
					System.out.println("<<----------Otherwise....Press Any Key---------->>");
						check = sc.nextInt();
						if(check==1)
						{
							loginPage = new LoginPageOfCustomer();
							loginPage.cusotmerlogin();
						}
						else
						{
							System.out.println("*********Thanks for your our App************");
							System.exit(0);
						}
				break;
			
				
				//*****************************************************************************************
				//*************************Going back to Customer's First Page*****************************
				//*****************************************************************************************
			case 5:
				CustomerFirstPage customerFirstPage = new CustomerFirstPage();
				customerFirstPage.firstPageOfCustomer();
				break;
				//*****************************************************************************************
				//***************************Please Choose Valid Number************************************
				//*****************************************************************************************
				default:
					System.err.println("<<<<<<Please Choose Valid Number>>>>>");
					loginPage = new LoginPageOfCustomer();
					loginPage.cusotmerlogin();
				break;
			}
		}
		
		//*****************************************************************************************
		//***************************If Enter Wrong id and Password********************************
		//*****************************************************************************************
		else
		{
			System.err.println("Please check your Customer ID or Password....(INCORRECT)");
			CustomerFirstPage customerFirstPage = new CustomerFirstPage();
			customerFirstPage.firstPageOfCustomer();
		}
	}
}