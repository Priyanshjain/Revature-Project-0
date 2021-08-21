package com.BankingProject.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.BankingProject.Pages.CustomerFirstPage;

public class ForValidatePhoneNumber {
	public void checkPhoneNumer(String phoneNumber)
	{
		String regex = "\\d{10}"; 
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		
//		try {
//			matcher.matches();
//			
//		}
//		catch(Exception e) {
//			System.out.println(e);
//			System.err.println("Please check your Phone Number");
//			CustomerFirstPage customerFirstPage= new CustomerFirstPage();
//			customerFirstPage.firstPageOfCustomer();
//		}
		
		if(matcher.matches()) {
		}
		else
		{
			System.err.println("Please check your Phone Number");
			CustomerFirstPage customerFirstPage= new CustomerFirstPage();
			customerFirstPage.firstPageOfCustomer();
		}
		
	}
}
