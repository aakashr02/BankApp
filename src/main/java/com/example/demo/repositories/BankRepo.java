package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Account;
import java.util.List;

@Repository
public interface BankRepo extends JpaRepository<Account, Integer> {

	public List<Account> findByAccountNo(int accountNo);
	
	public List<Account> findByBalanceGreaterThan(int balance);
	
	public List<Account> findByBalanceLessThan(int balance);
	
}
