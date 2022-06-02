package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osf.academyosf.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

	Products findById(int id);
	Products deleteById(int id);
	Page<Products> findAll(Pageable pageable);

	@Query("SELECT product_name, COUNT (p) FROM Products")
	List<Products> findCountProducts_name(String product_name);
}
