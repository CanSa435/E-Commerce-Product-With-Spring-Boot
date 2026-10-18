package com.cansazak.entity;

 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	@Column(name = "product_image")
	private String productImage;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "product_stock")
	private int stockCount;
	
	@ManyToOne
	private Category category;
}
