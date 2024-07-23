package me.project.santander_dev_week_2024_v20.resources.dto;

import me.project.santander_dev_week_2024_v20.domain.models.News;

public class NewsDto {

	// ATTRIBUTES -------------------------------------
	private Long id;
	private String icon;
	private String description;
	
	// PRINCIPALS METHODS -----------------------------
	public NewsDto() {}
	public NewsDto(Long id, String icon, String description) {
		this.id = id;
		this.icon = icon;
		this.description = description;
	}
	public NewsDto(News obj) {
		this.id = obj.getId();
		this.icon = obj.getIcon();
		this.description = obj.getDescription();
	}
	public News toModel() {
		News model = new News();
		model.setId(this.id);
		model.setIcon(this.icon);
		model.setDescription(this.description);
		return model;
	}
	
	// ACCESS METHODS ---------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
