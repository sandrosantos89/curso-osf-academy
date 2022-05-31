package com.osf.academyosf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Staffs;

public interface StaffsRepository extends JpaRepository<Staffs, Integer> {

	Staffs findById(int id);
	Staffs deleteById(int id);
	Page<Staffs> findAll(Pageable var1);
}
