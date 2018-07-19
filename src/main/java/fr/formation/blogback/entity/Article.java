package fr.formation.blogback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Article {

	@Column(columnDefinition = "TEXT")
	private String description;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@Length(min = 6, max = 255, message = "Le titre doit comporter entre 6 et 255 caractères.")
	private String title;

	public String getDescription() {
		return this.description;
	}

	public Integer getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

}
