package com.fareastone.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fareastone.demo.entity.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Category findById(int theId);
	public Page<Category> findBySepc(String name,String url,String description,int pageNum);
}
