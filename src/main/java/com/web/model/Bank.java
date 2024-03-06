package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
@Id
private long Accountnumber;
private String Name;
private String password;
private double Amount;
private String Address;
private long mobilenumber;
public Bank() {
	super();
}
public Bank(long accountnumber, String name, String password, double amount, String address, long mobilenumber) {
	super();
	Accountnumber = accountnumber;
	Name = name;
	this.password = password;
	Amount = amount;
	Address = address;
	this.mobilenumber = mobilenumber;
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
public double getAmount() {
	return Amount;
}
public void setAmount(double amount) {
	Amount = amount;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public long getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(long mobilenumber) {
	this.mobilenumber = mobilenumber;
}
@Override
public String toString() {
	return "Bank [Accountnumber=" + Accountnumber + ", Name=" + Name + ", password=" + password + ", Amount=" + Amount
			+ ", Address=" + Address + ", mobilenumber=" + mobilenumber + "]";
}
}