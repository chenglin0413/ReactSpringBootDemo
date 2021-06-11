package com.fareastone.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fareastone.demo.dao.CategoryRepository;
import com.fareastone.demo.entity.Category;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository theCategoryRepository) {
		categoryRepository = theCategoryRepository;
	}
	//多條件查詢分頁
	public Page<Category> findBySepc(String name,String url,String description,int pageNum ) {
		//條件
		Specification<Category> spec = new Specification<Category>() {
			/*
			 * @return Predicate : 定義了查詢條件
			 * @Param  Root<Category> root:根對象 封裝了查詢對象的對象
			 * @Param  CriteriaQuery<?> query , 實現了基本的查詢功能，一般不使用
			 * @param  CriteriaBuilder cb: 創建一個查詢條件
			 */
			@Override
			public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.and(cb.like(root.get("name"),"%"+name+"%"),
						      cb.like(root.get("url"), "%"+url+"%"),
						      cb.like(root.get("description"), "%"+description+"%")
						      );
			}
		};
		//排序
//		Sort sort = new Sort(Direction.DESC,"category_id");
		//分頁
		Pageable pageable = new PageRequest(pageNum-1,10);
		Page<Category> page = this.categoryRepository.findAll(spec,pageable);
		System.out.println("Total Pages: "+page.getTotalPages());
		System.out.println("Toal Elements: "+page.getTotalElements());
		return page ;
	}
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(int theId) {
		Optional<Category> result = categoryRepository.findById(theId);
		
		Category theCategory = null;
		
		if (result.isPresent()) {
			theCategory = result.get();
		}
		else {
			// we didn't find the category
			throw new RuntimeException("Did not find category id - " + theId);
		}
		
		return theCategory;	
	}

}
