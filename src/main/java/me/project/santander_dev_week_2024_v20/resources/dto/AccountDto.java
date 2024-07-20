package me.project.santander_dev_week_2024_v20.resources.dto;

import java.math.BigDecimal;

import me.project.santander_dev_week_2024_v20.domain.models.Account;

public class AccountDto {

	// ATTRIBUTES -------------------------------------
	private Long id;
	private String number;
	private String agency;
	private BigDecimal balance;
	private BigDecimal creditLimit;

	// PRINCIPALS METHODS -----------------------------
	public AccountDto(Account obj) {
		this.id = obj.getId();
		this.number = obj.getNumber();
		this.agency = obj.getAgency();
		this.balance = obj.getBalance();
		this.creditLimit = obj.getCreditLimit();
	}
	public Account toModel() {
		Account model = new Account();
		model.setId(this.id);
		model.setNumber(this.number);
		model.setAgency(this.agency);
		model.setBalance(this.balance);
		model.setCreditLimit(this.creditLimit);
		return model;
	}

	// ACCESS METHODS ---------------------------------
	
}
