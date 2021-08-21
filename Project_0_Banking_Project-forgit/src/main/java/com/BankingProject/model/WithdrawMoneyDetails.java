package com.BankingProject.model;

public class WithdrawMoneyDetails {
	private int customerid;
	private int withdrawMoney;
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getWithdrawMoney() {
		return withdrawMoney;
	}
	public void setWithdrawMoney(int withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerid;
		result = prime * result + withdrawMoney;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WithdrawMoneyDetails other = (WithdrawMoneyDetails) obj;
		if (customerid != other.customerid)
			return false;
		if (withdrawMoney != other.withdrawMoney)
			return false;
		return true;
	}
	
	public WithdrawMoneyDetails(int customerid, int withdrawMoney) {
		this.customerid = customerid;
		this.withdrawMoney = withdrawMoney;
	}
	public WithdrawMoneyDetails() {
	}
	@Override
	public String toString() {
		return "\n[CustomerId = " + customerid + ", Withdraw Amount = " + withdrawMoney + "]";
	}
	
	
	
}
