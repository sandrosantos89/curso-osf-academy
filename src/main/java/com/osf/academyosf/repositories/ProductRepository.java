package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osf.academyosf.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

	@Query("SELECT p from products p where p.product_name like %product_name%")
	public List<Products> findByProductsNameContaining(@Param("product_name") String product_name);

}
