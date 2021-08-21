package com.BankingProject.exception;

public class ForDecoration {
	public void decoration() {
	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
