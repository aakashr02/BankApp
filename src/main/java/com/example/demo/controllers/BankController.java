package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Account;
import com.example.demo.models.Login;
import com.example.demo.repositories.BankRepo;

@RestController
public class BankController {

	@Autowired
	BankRepo repo;
	
	@GetMapping("/login")
	public Boolean validateLogin(@RequestBody Login l)
	{
		Optional<Account> a = repo.findById(l.getCustomerID());
		if(a.get().getPassword().equals(l.getPassword())) return true;
		return false;
	}
	
	
	@PostMapping("/register")
	public String createAccount(@RequestBody Account a)
	{
		repo.save(a);
		return "Account Successfully created";
		
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
	public String changePassword(@PathVariable int cid, @PathVariable String oldPswd, @PathVariable String newPswd)
	{
		if(repo.existsById(cid))
		{
			Account a  = repo.findById(cid).get();
			if(a.getPassword().equals(oldPswd))
			{
				a.setPassword(newPswd);
				repo.save(a);
				return "Password Updated Successfully";
			}
		}
		return "Cannot Update Password";
	}
	
	
	@PutMapping("/transfer")
	public String transfer(int amount, int from, int to, int ifsc)
	{
		Account a1 =  repo.findByAccountNo(from).get(0);
		Account a2 =  repo.findByAccountNo(to).get(0);
		if (a1.getBalance()>amount)
		{
			a1.setBalance(a1.getBalance()-amount);
			a2.setBalance(a2.getBalance()+amount);
			repo.save(a1);
			repo.save(a2);
			return "Transfer Success";
		}
		return "Transfer Failed";
	}
	
	@GetMapping("/balance")
	public int getBalance(@PathVariable int accountNO)
	{
		return repo.findByAccountNo(accountNO).get(0).getBalance();
	}
	
	
	@GetMapping("/accounts/below")
	public List<Account> getAccountBalanceBelow(@RequestParam int amount)
	{
		return repo.findByBalanceLessThan(amount);
	}
	
	@GetMapping("/accounts/above")
	public List<Account> getAccountBalanceAbove( @RequestParam int amount)
	{
		return repo.findByBalanceGreaterThan(amount);
	}
	
	
}



/*
 /login				- Customer ID & Password => true/false
 
/register			- Customer ID, Password, Account No., IFSC, Type, Mobile
 
/changepwd/cid/abc/xyz		- Customer ID, old password, new password (where cid is custID, abc is old pwd & xyz is new pwd)
 
/transfer?amount=5000		- From_Acctno., To_Account, IFSC, Amount
 
/balance/accountNo		- Display the balance amount in that account (accountNo needs to be passed)
 
/accounts/below?amount=5000 	- Display all accounts below the given balance
 
/accounts/above?amount=100000 	- Display all accounts above the given balance
 */


