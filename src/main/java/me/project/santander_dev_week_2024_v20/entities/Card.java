package me.project.santander_dev_week_2024_v20.entities;

import java.io.Serializable;

public class Card implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	// ATTRIBUTES -------------------------------------
	private Long id;
	private String number;
	private String description;
	
	
	// PRINCIPALS METHODS -----------------------------
	public Card() {}
	public Card(Long id, String number, String description) {
		this.id = id;
		this.number = number;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
