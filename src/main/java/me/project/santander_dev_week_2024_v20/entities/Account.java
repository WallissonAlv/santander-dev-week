package me.project.santander_dev_week_2024_v20.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES -------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	private String agency;
	@Column(precision = 11, scale = 2)
	private BigDecimal balance;
	@Column(precision = 11, scale = 2)
	private BigDecimal creditLimit;

	@OneToOne
	private User user;

	// PRINCIPALS METHODS -----------------------------
	public Account() {
	}
	public Account(Long id, String number, String agency, BigDecimal balance, BigDecimal creditLimit, User user) {
		super();
		this.id = id;
		this.number = number;
		this.agency = agency;
		this.balance = balance;
		this.creditLimit = creditLimit;
		this.user = user;
	}


	// ACCESS METHODS ---------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBigDecimal() {
		return number;
	}

	public void setBigDecimal(String number) {
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
		return creditLimit;
	}

	public void setLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
