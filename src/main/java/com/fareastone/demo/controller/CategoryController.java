package com.fareastone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fareastone.demo.entity.Category;
import com.fareastone.demo.service.CategoryService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CategoryController {
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService theCategoryService) {
		categoryService = theCategoryService;
	}
	
	// expose "/categories/query" and return page of categories
		@GetMapping("/categories/query")
		public Page findBySepc(@RequestParam String name,@RequestParam String url 
								,@RequestParam String description,@RequestParam int pageNum) {
			return categoryService.findBySepc(name, url,description,pageNum);
	}
	
	
	// expose "/categories" and return list of categories
	@GetMapping("/categories")
	public List<Category> findAll() {
		return categoryService.findAll();
	}

	// add mapping for GET /categories/{categoryId}
	
	@GetMapping("/categories/{categoryId}")
	public Category getCategory(@PathVariable int categoryId) {
		
		Category theCategory = categoryService.findById(categoryId);
		
		if (theCategory == null) {
			throw new RuntimeException("Category id not found - " + categoryId);
		}
		
		return theCategory;
	}
}
