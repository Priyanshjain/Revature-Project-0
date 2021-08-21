package com.BankingProject.dao;



import java.util.List;
//import com.BankingProject.model.Customer;
import com.BankingProject.model.DepositingMoneyDetails;
import com.BankingProject.model.Employee;
import com.BankingProject.model.TranferMoneyDetails;
import com.BankingProject.model.WithdrawMoneyDetails;

public interface EmployeeDAO {
	
	public Employee checkStatusById(int employeeid);
	public boolean CheckLogin(int employeeid,int passwords);
	public List<DepositingMoneyDetails> getAllDepositeInformation();
	public List<WithdrawMoneyDetails> getAllWithdrawInformation();
	public List<TranferMoneyDetails> getAllTranferMoneyInformation();
	
}
