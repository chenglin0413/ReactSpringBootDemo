package com.fareastone.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blc_category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private  int category_id;
	
	@Column(name="name")
	private  String name;
	
	@Column(name="active_start_date")
	private  String active_start_date;
	
	@Column(name="url")
	private  String url;
	
	@Column(name="description")
	private String description;
	
	
	public Category() {
		
	}
	

	public Category(String name, String active_start_date, String url, String description) {
		this.name = name;
		this.active_start_date = active_start_date;
		this.url = url;
		this.description = description;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getActive_start_date() {
		return active_start_date;
	}


	public void setActive_start_date(String active_start_date) {
		this.active_start_date = active_start_date;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	


	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", active_start_date=" + active_start_date
				+ ", url=" + url + ", description=" + description + "]";
	}
	
	
	
	
}
