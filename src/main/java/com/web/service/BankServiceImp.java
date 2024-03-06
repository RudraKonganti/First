package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Bank;
import com.web.model.BankT;
import com.web.model.BankUse;
import com.web.repo.BankRepo;

@Service
public class BankServiceImp implements BankService{
    @Autowired
	private BankRepo repo;
	@Override
	public Bank customerreg(BankUse bank)
	{
		Bank b=new Bank();
		b.setAccountnumber(bank.getAccountnumber());
		b.setName(bank.getName());
		String p;
		String cp;
		if(bank.getPassword().equals(bank.getConformpassword()))
		{
			b.setPassword(bank.getConformpassword());
		b.setAddress(bank.getAddress());
		b.setAmount(bank.getAmount());
		b.setMobilenumber(bank.getMobilenumber());
	
        repo.save(b);
		}
		return b;
	}	

	

	@Override
	public Bank balance(Bank bank) {
	Bank b	=repo.findById(bank.getAccountnumber()).get();
	
	if(b.getAccountnumber()==bank.getAccountnumber()&&b.getName().equalsIgnoreCase(bank.getName()) && b.getPassword().equals(bank.getPassword()))
	{
		return b;       
	}	
	return null;
    }

	
	@Override
	public Bank deposit(Bank bank) {
		Bank b1=repo.findById(bank.getAccountnumber()).get();
		if(b1.getName().equalsIgnoreCase(bank.getName())&&b1.getPassword().equals(bank.getPassword()))
		{
        b1.setAmount(b1.getAmount()+bank.getAmount());
		repo.save(b1);	
        return b1;				
		}
		else 
			return null;
        }


	@Override
	public Bank withdraw(Bank bank) {
    Bank b=repo.findById(bank.getAccountnumber()).get();
    if(b.getAccountnumber()==bank.getAccountnumber()&&b.getName().equalsIgnoreCase(bank.getName())&&b.getPassword().equals(bank.getPassword())) {
    b.setAmount(b.getAmount()-bank.getAmount());
	  repo.save(b);
     return b;
	}
    else {
	  return null; 
  }		
}



	@Override
	public void close(Bank bank) {
		Bank b=repo.findById(bank.getAccountnumber()).get();
		if(b.getName().equalsIgnoreCase(bank.getName())&&b.getPassword().equals(bank.getPassword())) {			
			repo.deleteById(b.getAccountnumber());
		}		
	}


	@Override
	public List<Bank> transfer(BankT bank) {
	 Bank b1=repo.findById(bank.getAccountnumber()).get();
     Bank b2=repo.findById(bank.getTargetaccount()).get();
     if(b1.getName().equalsIgnoreCase(bank.getName())&&b1.getPassword().equals(bank.getPassword())) {
    	b1.setAmount(b1.getAmount()-bank.getAmount());
    	b2.setAmount(b2.getAmount()+bank.getAmount());
    	repo.save(b1);
    	repo.save(b2);
    	List<Bank>list=List.of(b1,b2);
    	return list;
     }     
		return null;	
 }



	@Override
	public Bank getOne(BankT bank) {
		Bank b1=repo.findById(bank.getAccountnumber()).get();
	     Bank b2=repo.findById(bank.getTargetaccount()).get();
	     if(b1.getName().equalsIgnoreCase(bank.getName())&&b1.getPassword().equals(bank.getPassword())) {
	    	return b2;
	     } 
		return null;
	}
}