package com.cansazak.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cansazak.controller.IProductController;
import com.cansazak.dto.ProductDto;
import com.cansazak.dto.ProductDtoIU;
import com.cansazak.entity.Product;
import com.cansazak.services.IProductService;

@RestController
@RequestMapping("/rest/api/products")
@CrossOrigin
public class ProductControllerImpl implements IProductController {

 	private final IProductService productService;
	ProductControllerImpl(IProductService productService) {
		this.productService = productService;
	}	
	
	@GetMapping(path = "/product-list")
	@Override
	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		return productService.getAllProducts();
	}

	@PostMapping(path = "/save-product")
	@Override
	public ProductDto saveProduct(@RequestBody ProductDtoIU productDto) {
		// TODO Auto-generated method stub
		return productService.saveProduct(productDto);
	}

	@GetMapping("/product-list/{id}")
	@Override
	public ProductDto getProductById(@PathVariable(name = "id") Long id) {
 		return productService.getProductById(id);
	}

	@DeleteMapping("/delete-product/{id}")
	@Override
	public void deleteProduct(Long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/getProductByName")
	@Override
	public List<Product> getProductByName(@RequestParam(name = "productName",required = false) String productName) {
		return productService.getProductByName(productName);
	}

}
