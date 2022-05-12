package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Brands;

public interface BrandsRepository extends JpaRepository<Brands, Integer> {

	Brands findById(int id);

	Brands deleteById(int id);
}
