package me.project.santander_dev_week_2024_v20.entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	
	// ATTRIBUTES -------------------------------------
	private Long id;
	private String name;
	private Account account;
	private Card card;
	private List<Feature> feature;
	private List<News> news;
	
	
	// PRINCIPALS METHODS -----------------------------
	public User() {}

	public User(Long id, String name, Account account, Card card, List<Feature> feature, List<News> news) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.card = card;
		this.feature = feature;
		this.news = news;
	}
	
	
	// ACCESS METHODS ---------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
