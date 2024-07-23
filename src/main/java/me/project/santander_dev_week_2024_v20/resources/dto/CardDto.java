package me.project.santander_dev_week_2024_v20.resources.dto;

import java.math.BigDecimal;

import me.project.santander_dev_week_2024_v20.domain.models.Card;

public class CardDto {

	// ATTRIBUTES -------------------------------------
	private Long id;
	private String number;
	private BigDecimal limit;
	
	// PRINCIPALS METHODS -----------------------------
	public CardDto() {}
	public CardDto(Long id, String number, BigDecimal limit) {
		this.id = id;
		this.number = number;
		this.limit = limit;
	}
	public CardDto(Card obj) {
		this.id = obj.getId();
		this.number = obj.getNumber();
		this.limit = obj.getLimit();
	}
	public Card toModel() {
		Card model = new Card();
		model.setId(this.id);
		model.setNumber(this.number);
		model.setLimit(this.limit);
		return model;
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
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
}
