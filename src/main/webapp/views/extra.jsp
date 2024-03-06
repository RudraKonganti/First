<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<fieldset>
<h1>TRANSFER FORM</h1>
<c:form modelAttribute="bank" action="/trs">
AccountNo:<c:input path="Accountnumber"/><p></p>
Name:<c:input path="Name"/><p></p>
Password<c:password path="password"/><p></p>
Target AccountNo:<c:input path="targetaccount"/><p></p>
Amount<c:input path="Amount"/><p></p>
<input type="submit" value="submit"><p></p>
<center>
<a href="/home">Home</a>
</center>
</c:form>
</fieldset>
</body>
</html>
@RequestMapping("/transfer")
public String trnasferPage(ModelMap model,BankT bank) {
	model.addAttribute("bank", bank);
	return "transfer";
}
@RequestMapping("/trs")
public String page(@ModelAttribute BankT bank,ModelMap model) {
	
	List<Bank> lists=service.transfer(bank);
	if(lists!=bank) {
		return "false";
	}
	model.put("aa", lists.get(0).getAmount()+bank.getAmount());
	model.put("bb", lists.get(0).getAmount());
	
	model.put("dd", lists.get(1).getAmount());
	model.put("cc", lists.get(1).getAmount()-bank.getAmount());
	return "successtrs";
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