package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osf.academyosf.entities.Brands;

public interface BrandsRepository extends JpaRepository<Brands, Integer> {

	Brands findById(int id);
	Brands deleteById(int id);

	@Query(value = "SELECT b FROM Brands b WHERE b.brand_name =?1",
			countQuery = "SELECT count(brand_name) FROM Brands b WHERE b.brand_name =?1")
	List<Brands> findByOrderByBrands(String brand_name);

}
