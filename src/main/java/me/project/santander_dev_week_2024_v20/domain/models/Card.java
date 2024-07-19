package me.project.santander_dev_week_2024_v20.domain.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cards")
public class Card implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	// ATTRIBUTES -------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String number;
	@Column(name = "available_limit",precision = 11, scale = 2)
	private BigDecimal limit;
	
	// PRINCIPALS METHODS -----------------------------

	
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
		Card other = (Card) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
