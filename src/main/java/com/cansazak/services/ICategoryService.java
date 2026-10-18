package com.cansazak.services;

import java.util.List;

import com.cansazak.dto.CategoryDto;

public interface ICategoryService {
	
	public List<CategoryDto> getAllCategories();
	
	public CategoryDto saveCategory(CategoryDto result);
	
	public CategoryDto getCategoryById(Long id);
	
	public void deleteCategory(Long id);
	
}
