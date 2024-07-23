package me.project.santander_dev_week_2024_v20.resources.dto;

import java.util.List;
import java.util.stream.Collectors;

import me.project.santander_dev_week_2024_v20.domain.models.Feature;
import me.project.santander_dev_week_2024_v20.domain.models.News;
import me.project.santander_dev_week_2024_v20.domain.models.User;

public class UserDto {
	
	// ATTRIBUTES -------------------------------------
	private Long id;
	private String name;
	private AccountDto account;
	private CardDto card;
	private List<FeatureDto> features;
	private List<NewsDto> news;
	
	// PRINCIPALS METHODS -----------------------------
	public UserDto() {}
	
	public UserDto(Long id, String name, AccountDto account, CardDto card, List<FeatureDto> features,
			List<NewsDto> news) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.card = card;
		this.features = features;
		this.news = news;
	}

	public UserDto(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.account = obj.getAccount() != null ? new AccountDto(obj.getAccount()) : null;
		this.card = obj.getCard() != null? new CardDto(obj.getCard()) : null;
		this.features = obj.getFeatures()
				.stream()
				.map(FeatureDto::new)
				.collect(Collectors.toList());
		this.news = obj.getNews()
				.stream()
				.map(NewsDto::new)
				.collect(Collectors.toList());
	}

	public User toModel() {
		User model = new User();
		model.setId(this.id);
		model.setName(this.name);
		if(this.account != null) {
			model.setAccount(this.account.toModel());
		}
		if(this.card != null) {
			model.setCard(this.card.toModel());
		}
		if(this.features != null) {
			List<Feature> featuresList = this.features
												.stream()
												.map(FeatureDto::toModel)
												.collect(Collectors.toList());
			model.setFeatures(featuresList);
		}
		if(this.news != null) {
			List<News> newsList = this.news
									.stream()
									.map(NewsDto::toModel)
									.collect(Collectors.toList());
			model.setNews(newsList);
		}
		return model;
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
	
	public AccountDto getAccount() {
		return account;
	}
	
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	
	public CardDto getCard() {
		return card;
	}
	
	public void setCard(CardDto card) {
		this.card = card;
	}
	
	public List<FeatureDto> getFeatures() {
		return features;
	}
	
	public void setFeatures(List<FeatureDto> features) {
		this.features = features;
	}
	
	public List<NewsDto> getNews() {
		return news;
	}
	
	public void setNews(List<NewsDto> news) {
		this.news = news;
	}
	

}