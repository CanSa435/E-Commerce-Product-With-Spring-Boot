package com.cansazak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private Long id;
	private String productName;
	private String productImage;
	private double productPrice;
	private int stockCount;
	private CategoryDto category;
}
