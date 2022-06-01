package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

	Categories findById(int id);
	Categories deleteById(int id);
}
