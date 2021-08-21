package com.BankingProject.model;

public class Employee {
	private int employeeid;
	private String employeename;
	private String phonenumber;
	private int passwords;
	
	public Employee() {
	}

	public Employee(int employeeid, String employeename, String phonenumber, int passwords) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.phonenumber = phonenumber;
		this.passwords = passwords;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeid;
		result = prime * result + ((employeename == null) ? 0 : employeename.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeid != other.employeeid)
			return false;
		if (employeename == null) {
			if (other.employeename != null)
				return false;
		} else if (!employeename.equals(other.employeename))
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
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", phonenumber=" + phonenumber
				+ ", passwords=" + passwords + "]";
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getPasswords() {
		return passwords;
	}

	public void setPasswords(int passwords) {
		this.passwords = passwords;
	}
	
	
}
