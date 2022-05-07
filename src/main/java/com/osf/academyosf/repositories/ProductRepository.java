package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

	Products findById(int id);

	Products deleteById(int id);
}
