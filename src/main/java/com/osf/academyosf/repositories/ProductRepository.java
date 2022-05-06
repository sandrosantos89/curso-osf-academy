package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.osf.academyosf.entities.Products;

public interface ProductRepository extends PagingAndSortingRepository<Products, Integer> {

	public Iterable<Products> findByNameContainingIgnoreCase(String products);

	@Query("SELECT p from Products p where p.product_name like %:product_name%")
	List<Products> searchByNameLike(@Param("product_name") String partName);

}
