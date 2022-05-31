package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osf.academyosf.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

	Products findById(int id);
	Products deleteById(int id);
	Page<Products> findAll(Pageable var1);

	@Query(value = "SELECT * FROM Tb_products p WHERE p.product_name LIKE %:product_name%", countQuery = "SELECT count(product_name) FROM Tb_products p WHERE p.product_name LIKE %:product_name% ORDER BY product_name")
	public List<Products> findByOrderByProducts(@Param("p") String product_name);

}
