package me.project.santander_dev_week_2024_v20.resources.dto;

import me.project.santander_dev_week_2024_v20.domain.models.News;

public class NewsDto {

	// ATTRIBUTES -------------------------------------
	private Long id;
	private String icon;
	private String description;
	
	// PRINCIPALS METHODS -----------------------------
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

}
