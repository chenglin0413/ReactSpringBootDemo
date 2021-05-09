package com.fareastone.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fareastone.demo.entity.Category;

@RestController
@RequestMapping("/api")
public interface CategoryRepository extends JpaRepository<Category, Integer> , JpaSpecificationExecutor<Category>{

}
