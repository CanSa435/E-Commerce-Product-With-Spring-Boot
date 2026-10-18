package com.cansazak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cansazak.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

	@Query("FROM Product WHERE LOWER(productName) LIKE LOWER(CONCAT('%',:productName,'%'))")
	public List<Product> getProductByName(@Param("productName") String productName);
}
