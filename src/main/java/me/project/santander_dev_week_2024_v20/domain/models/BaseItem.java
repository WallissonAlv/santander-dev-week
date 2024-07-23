package me.project.santander_dev_week_2024_v20.domain.models;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseItem implements Serializable{
	private static final long serialVersionUID = 1L;

	
	// ATTRIBUTES -------------------------------------
	private String icon;
	private String description;

	
	// PRINCIPALS METHODS -----------------------------

	
	// ACCESS METHODS ---------------------------------
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
