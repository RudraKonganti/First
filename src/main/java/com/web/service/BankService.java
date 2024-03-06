package com.web.service;

import java.util.List;

import com.web.model.Bank;
import com.web.model.BankT;
import com.web.model.BankUse;

public interface BankService {
public Bank customerreg(BankUse bank);
public Bank balance(Bank bank);
public Bank deposit(Bank bank);
public Bank withdraw(Bank bank);
public List<Bank> transfer(BankT bank);
public void close(Bank bank);
public Bank getOne(BankT bank);
}
