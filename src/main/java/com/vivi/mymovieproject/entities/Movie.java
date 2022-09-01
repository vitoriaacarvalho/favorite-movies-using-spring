package com.vivi.mymovieproject.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_movies")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private Integer year;
	private Integer duration;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToMany
	@JoinTable(name = "tb_movie_category", joinColumns = @JoinColumn(name = "movie_name"), inverseJoinColumns = @JoinColumn(name = "category_name"))
	private Set<Category>categories=new HashSet<>();
	
	public Movie() {
	}

	public Movie(String name, String description, Integer year, Integer id) {
		this.name = name;
		this.description = description;
		this.year = year;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
	
	
	
}
