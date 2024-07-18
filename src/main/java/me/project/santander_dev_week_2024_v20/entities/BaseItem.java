package me.project.santander_dev_week_2024_v20.entities;

import java.io.Serializable;

public abstract class BaseItem implements Serializable{
	private static final long serialVersionUID = 1L;

	
	// ATTRIBUTES -------------------------------------
	private Long id;
	private String icon;
	private String description;

	
	// PRINCIPALS METHODS -----------------------------
	public BaseItem() {}
	public BaseItem(Long id, String icon, String description) {
		this.id = id;
		this.icon = icon;
		this.description = description;
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
		BaseItem other = (BaseItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
