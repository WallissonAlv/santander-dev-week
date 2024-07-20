package me.project.santander_dev_week_2024_v20.resources.dto;

import java.math.BigDecimal;

import me.project.santander_dev_week_2024_v20.domain.models.Card;

public class CardDto {

	// ATTRIBUTES -------------------------------------
	private Long id;
	private String number;
	private BigDecimal limit;
	
	// PRINCIPALS METHODS -----------------------------
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

}
