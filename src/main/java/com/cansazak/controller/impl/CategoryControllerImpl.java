package com.cansazak.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cansazak.controller.ICategoryController;
import com.cansazak.dto.CategoryDto;
import com.cansazak.services.ICategoryService;

@RestController
@RequestMapping("/rest/api/categories")
@CrossOrigin
public class CategoryControllerImpl implements ICategoryController {
	
	private final ICategoryService categoryService;
	CategoryControllerImpl(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping(path = "/category-list")
	@Override
	public List<CategoryDto> getAllCategories() {
 		return categoryService.getAllCategories();
	}

	@PostMapping(path = "/save-category")
	@Override
	public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
 		return categoryService.saveCategory(categoryDto);
	}

	@GetMapping("/category-list/{id}")
	@Override
	public CategoryDto getCategoryById(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		return categoryService.getCategoryById(id);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryService.deleteCategory(id);
	}

}
