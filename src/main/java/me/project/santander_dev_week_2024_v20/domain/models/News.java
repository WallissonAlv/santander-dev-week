package me.project.santander_dev_week_2024_v20.domain.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_news")
public class News extends BaseItem {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user;
}
