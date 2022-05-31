package com.osf.academyosf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Stores;

public interface StoresRepository extends JpaRepository<Stores, Integer> {

	Stores findById(int id);
	Stores deleteById(int id);
	Page<Stores> findAll(Pageable var1);
}
