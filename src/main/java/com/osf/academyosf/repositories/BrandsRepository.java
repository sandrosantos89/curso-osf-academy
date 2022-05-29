package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osf.academyosf.entities.Brands;

public interface BrandsRepository extends JpaRepository<Brands, Integer> {

	Brands findById(int id);

	Brands deleteById(int id);

	@Query(value = "SELECT b FROM Tb_brands b WHERE b.brand_name LIKE %:brand_name%",
			countQuery = "SELECT count(brand_name) FROM Tb_brands a WHERE b.brand_name LIKE %:brand_name%")
	List<Brands> findByOrderByBrands(@Param ("brand_name") String brand_name);

}
