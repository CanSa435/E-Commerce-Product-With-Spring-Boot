package com.cansazak.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cansazak.dto.CategoryDto;
import com.cansazak.dto.ProductDto;
import com.cansazak.dto.ProductDtoIU;
import com.cansazak.entity.Category;
import com.cansazak.entity.Product;
import com.cansazak.repository.CategoryRepository;
import com.cansazak.repository.ProductRepository;
import com.cansazak.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> dbProducts = productRepository.findAll();
		for (Product product : dbProducts) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			
			if(product.getCategory() != null) {
				CategoryDto categoryDto = new CategoryDto();
				BeanUtils.copyProperties(product.getCategory(), categoryDto);
				productDto.setCategory(categoryDto);
			}
			productDtos.add(productDto);
		}
		return productDtos;
	}

	@Override
	public ProductDto saveProduct(ProductDtoIU productDtoIU) {
		Product product = new Product();
		BeanUtils.copyProperties(productDtoIU,product);
		
		Category category = categoryRepository.findById(productDtoIU.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Kategory Bulunamadı : " + productDtoIU.getCategoryId())); 
		product.setCategory(category);
		
		Product dbNewProduct = productRepository.save(product);
		
		ProductDto dtoProduct = new ProductDto();
		BeanUtils.copyProperties(dbNewProduct, dtoProduct);
		
		CategoryDto dtoCategory = new CategoryDto();
		BeanUtils.copyProperties(dbNewProduct.getCategory(),dtoCategory);
		dtoProduct.setCategory(dtoCategory);
		
		return dtoProduct;
	}
	
	@Override
	public ProductDto getProductById(Long id) {
		ProductDto dtoProduct = new ProductDto();
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Product dbProduct = optional.get();
		BeanUtils.copyProperties(dbProduct, dtoProduct);
		return dtoProduct;
	}
	
	@Override
	public void deleteProduct(Long id) {
 		productRepository.deleteById(id);
	}
	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> dbProducts = productRepository.getProductByName("%" + productName + "%");
		for (Product product : dbProducts) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			
			if(product.getCategory() != null) {
				CategoryDto categoryDto = new CategoryDto();
				BeanUtils.copyProperties(product.getCategory(), categoryDto);
				productDto.setCategory(categoryDto);
			}
		}
		return dbProducts;
	}

}
