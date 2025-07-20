package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	@GetMapping("/loans/{number}")
    public Loan getLoanDetails(@PathVariable String number) {
        Loan loan = new Loan();
        loan.setNumber(number);
        loan.setType("car");
        loan.setLoan(400000.0);
        loan.setEmi(3258.0);
        loan.setTenure(18);
        
        return loan;
    }

}

class Loan {
    private String number;
    private String type;
    private Double loan;
    private Double emi;
    private Integer tenure;
    
    public Loan() {}
    
    public Loan(String number, String type, Double loan, Double emi, Integer tenure) {
        this.number = number;
        this.type = type;
        this.loan = loan;
        this.emi = emi;
        this.tenure = tenure;
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
    
    public Double getLoan() {
        return loan;
    }
    
    public void setLoan(Double loan) {
        this.loan = loan;
    }
    
    public Double getEmi() {
        return emi;
    }
    
    public void setEmi(Double emi) {
        this.emi = emi;
    }
    
    public Integer getTenure() {
        return tenure;
    }
    
    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }
}
