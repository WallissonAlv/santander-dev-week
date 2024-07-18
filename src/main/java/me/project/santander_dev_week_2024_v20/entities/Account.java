package me.project.santander_dev_week_2024_v20.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	
	// ATTRIBUTES -------------------------------------
	private Long id;
	private String number;
	private String agency;
	private BigDecimal balance;
	private BigDecimal limit;
	
	
	// PRINCIPALS METHODS -----------------------------
	public Account (){}
	public Account(Long id, String number, String agency, BigDecimal balance, BigDecimal limit) {
		this.id = id;
		this.number = number;
		this.agency = agency;
		this.balance = balance;
		this.limit = limit;
	}
	
	
	// ACCESS METHODS ---------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
