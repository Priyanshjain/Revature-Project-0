package com.BankingProject.model;

public class TranferMoneyDetails {
	private int senderId;
	private int recevierId;
	private int TranferAmount;
	
	public TranferMoneyDetails() {
		super();
	}
	
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getRecevierId() {
		return recevierId;
	}
	public void setRecevierId(int recevierId) {
		this.recevierId = recevierId;
	}
	public int getTranferAmount() {
		return TranferAmount;
	}
	public void setTranferAmount(int tranferAmount) {
		TranferAmount = tranferAmount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TranferAmount;
		result = prime * result + recevierId;
		result = prime * result + senderId;
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
		TranferMoneyDetails other = (TranferMoneyDetails) obj;
		if (TranferAmount != other.TranferAmount)
			return false;
		if (recevierId != other.recevierId)
			return false;
		if (senderId != other.senderId)
			return false;
		return true;
	}
	
	public TranferMoneyDetails(int senderId, int recevierId, int tranferAmount) {
		super();
		this.senderId = senderId;
		this.recevierId = recevierId;
		TranferAmount = tranferAmount;
	}

	@Override
	public String toString() {
		return "\n[SenderId = " + senderId + ", RecevierId = " + recevierId + ", Tranfer Amount = "
				+ TranferAmount + "]";
	} 
	
	
}
