package com.BankingProject.model;

public class Customer {
	
	private int customerid;
	private String customername;
	private String phonenumber;
	private int currentamount;
	private int passwords;
	
	public Customer() {
		
	}
	
	public Customer(String customername, String phonenumber, int currentamount, int passwords) {
		this.customername = customername;
		this.phonenumber = phonenumber;
		this.currentamount = currentamount;
		this.passwords = passwords;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getCurrentamount() {
		return currentamount;
	}

	public void setCurrentamount(int currentamount) {
		this.currentamount = currentamount;
	}

	public int getPasswords() {
		return passwords;
	}

	public void setPasswords(int passwords) {
		this.passwords = passwords;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentamount;
		result = prime * result + customerid;
		result = prime * result + ((customername == null) ? 0 : customername.hashCode());
		result = prime * result + passwords;
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
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
		Customer other = (Customer) obj;
		if (currentamount != other.currentamount)
			return false;
		if (customerid != other.customerid)
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (passwords != other.passwords)
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", phonenumber=" + phonenumber
				+ ", currentamount=" + currentamount + "]";
	}	
}
