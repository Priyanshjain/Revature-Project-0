package com.BankingProject.model;

public class DepositingMoneyDetails {
	private int customerid;
	private int despositedMoney;
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getDespositedMoney() {
		return despositedMoney;
	}
	public void setDespositedMoney(int despositedMoney) {
		this.despositedMoney = despositedMoney;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerid;
		result = prime * result + despositedMoney;
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
		DepositingMoneyDetails other = (DepositingMoneyDetails) obj;
		if (customerid != other.customerid)
			return false;
		if (despositedMoney != other.despositedMoney)
			return false;
		return true;
	}
	
	
	public DepositingMoneyDetails(int customerid, int despositedMoney) {
		super();
		this.customerid = customerid;
		this.despositedMoney = despositedMoney;
	}
	public DepositingMoneyDetails() {
	}
	@Override
	
	public String toString() {
		return "\n[CustomerId = " + customerid + ", Desposited Amount = " + despositedMoney + "]";
	}
	
	
	
	
}
