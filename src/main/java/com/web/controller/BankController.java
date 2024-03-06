package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Bank;
import com.web.model.BankT;
import com.web.model.BankUse;
import com.web.service.BankService;

@Controller 
public class BankController {
	@Autowired
	private BankService service;
@RequestMapping("/")
	public String homePage() {
		return "home";
	}
@RequestMapping("/home")
public String Page() {
	return "home1";
}
@RequestMapping("/newaccount")
public String newAccount(ModelMap model) {
	BankUse bank= new BankUse();
	model.put("bank", bank);
	return "reg";
}
@RequestMapping("/register")
public String account(@ModelAttribute BankUse bank,ModelMap model) {
	Bank b=service.customerreg(bank);
	return "success";	
}
@RequestMapping("/balance")
public String checkBalance(ModelMap model) {
	Bank bank=new Bank();
	model.addAttribute("bank", bank);
	return "balance";
}
@RequestMapping("/re")
public String balance(@ModelAttribute Bank bank,ModelMap model) {
	model.addAttribute("bank", service.balance(bank));
	Bank b=new Bank();	
	return "enqury";	
}
@RequestMapping("/deposit")
public String amntDeposit(ModelMap model,Bank bank) {
	model.addAttribute("bank", bank);
	return "deposit";
}
@RequestMapping("/dep")
public String deposit(@ModelAttribute Bank bank,ModelMap model) {
	Bank b1 =service.deposit(bank);
	model.addAttribute("orgbal", b1.getAmount()-bank.getAmount());
	model.addAttribute("depositamnt",bank.getAmount());
	model.addAttribute("Aftrdepbl", b1.getAmount());
	return "viewdeposit";
}
@RequestMapping("/withdraw")
public String whithdrawPage(ModelMap model,Bank bank) {
	model.addAttribute("bank", bank);	
	return "withdraw";
}
@RequestMapping("/Vthdra")
public String viewWithdraw(@ModelAttribute Bank bank,ModelMap model) {
	Bank b=service.withdraw(bank);
	model.addAttribute("orgamnt",b.getAmount()+bank.getAmount());
	model.addAttribute("vthdraamnt",bank.getAmount());
	model.addAttribute("total", b.getAmount());
	return "vthdraw";
}
@RequestMapping("/transfer")
public String trnasferPage(ModelMap model,BankT bank) {
	model.addAttribute("bank", bank);
	return "transfer";
}
@RequestMapping("/trs")
public String page(@ModelAttribute BankT bank,ModelMap model) {
	
	List<Bank> lists=service.transfer(bank);
	if(lists==bank) {
		return "false";
	}
	model.put("aa", lists.get(0).getAmount()+bank.getAmount());
	model.put("bb", lists.get(0).getAmount());
	
	model.put("dd", lists.get(1).getAmount());
	model.put("cc", lists.get(1).getAmount()-bank.getAmount());
	return "successtrs";
}
@RequestMapping("/close")
public String closePage(ModelMap model,Bank bank) {
 	model.addAttribute("bank", bank);
	return "close";
}
@RequestMapping("/delete")
public String deltePage(@ModelAttribute Bank bank,ModelMap model) {
 service.close(bank);	
	return "delete";
}
@RequestMapping("/aboutUs")
public String aboutPage() {
	return "about";
}

@RequestMapping("/confirm")
public String confirmPage(ModelMap model,BankT bank) {
	model.addAttribute("bank1", service.getOne(bank));
	model.addAttribute("bank", bank);
	return "confirm";
}


}
