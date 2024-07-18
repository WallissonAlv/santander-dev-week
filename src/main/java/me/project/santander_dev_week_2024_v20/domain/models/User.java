package me.project.santander_dev_week_2024_v20.domain.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	
	// ATTRIBUTES -------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne
	private Account account;
	@OneToOne
	private Card card;
	@OneToMany
	private List<Feature> features;
	@OneToMany
	private List<News> news;
	
	// PRINCIPALS METHODS -----------------------------
	public User() {}
	public User(Long id, String name, Account account, Card card) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.card = card;
	}
	public User(Long id, String name, Account account, Card card, List<Feature> features, List<News> news) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.card = card;
		this.features = features;
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
