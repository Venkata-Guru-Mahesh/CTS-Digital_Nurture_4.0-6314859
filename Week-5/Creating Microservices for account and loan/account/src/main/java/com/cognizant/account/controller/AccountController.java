package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping("/accounts/{number}")
    public Account getAccountDetails(@PathVariable String number) {
        Account account = new Account();
        account.setNumber(number);
        account.setType("savings");
        account.setBalance(234343.0);
        
        return account;
    }
}

class Account {
    private String number;
    private String type;
    private Double balance;
    
    public Account() {
    	
    }
    
    public Account(String number, String type, Double balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Double getBalance() {
        return balance;
    }
    
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

