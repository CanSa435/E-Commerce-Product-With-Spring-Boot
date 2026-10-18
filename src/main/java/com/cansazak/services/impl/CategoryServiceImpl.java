package com.cansazak.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cansazak.dto.CategoryDto;
import com.cansazak.entity.Category;
import com.cansazak.repository.CategoryRepository;
import com.cansazak.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{

	private final CategoryRepository categoryRepository;
	CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		List<CategoryDto> dtoCategories = new ArrayList<>();
		List<Category> dbCategories = categoryRepository.findAll();
		for (Category category : dbCategories) {
			CategoryDto dtoCategory = new CategoryDto();
			BeanUtils.copyProperties(category, dtoCategory);
			dtoCategories.add(dtoCategory);
		}
		return dtoCategories;
	}

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryDto, category);
		
		Category dbCategory = categoryRepository.save(category);
		
		CategoryDto response = new CategoryDto();
		BeanUtils.copyProperties(dbCategory, response);
		return response;
	}

	@Override
	public CategoryDto getCategoryById(Long id) {
		CategoryDto categoryDto = new CategoryDto();
		Optional<Category> optional = categoryRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Category dbCategory = optional.get();
		BeanUtils.copyProperties(dbCategory, categoryDto);
		return categoryDto;
	}
	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
