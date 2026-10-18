package com.cansazak.controller;

import java.util.List;

import com.cansazak.dto.ProductDto;
import com.cansazak.dto.ProductDtoIU;
import com.cansazak.entity.Product;

public interface IProductController {

	public List<ProductDto> getAllProducts();
	
	public ProductDto saveProduct(ProductDtoIU productDto);
	
	public ProductDto getProductById(Long id);	
	
	public void deleteProduct(Long id);
	
	public List<Product> getProductByName(String productName);
}
