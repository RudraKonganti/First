package com.web.model;

public class BankT {
	private long Accountnumber;
	private String Name;
	private String password;
	private long targetaccount;
	private double Amount;
	public BankT() {
		super();
	}
	public BankT(long accountnumber, String name, String password, long targetaccount, double amount) {
		super();
		Accountnumber = accountnumber;
		Name = name;
		this.password = password;
		this.targetaccount = targetaccount;
		Amount = amount;
	}
	public long getAccountnumber() {
		return Accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		Accountnumber = accountnumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getTargetaccount() {
		return targetaccount;
	}
	public void setTargetaccount(long targetaccount) {
		this.targetaccount = targetaccount;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "BankT [Accountnumber=" + Accountnumber + ", Name=" + Name + ", password=" + password
				+ ", targetaccount=" + targetaccount + ", Amount=" + Amount + "]";
	}
	
}
