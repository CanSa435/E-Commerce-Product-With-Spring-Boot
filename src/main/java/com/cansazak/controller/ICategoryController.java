package com.cansazak.controller;

import java.util.List;

import com.cansazak.dto.CategoryDto;
 
public interface ICategoryController {

	public List<CategoryDto> getAllCategories();
	
	public CategoryDto saveCategory(CategoryDto categoryDto);
	
	public CategoryDto getCategoryById(Long id);
	
	public void deleteCategory(Long id);

 }
