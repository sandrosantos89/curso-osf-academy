package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Staffs;

public interface StaffsRepository extends JpaRepository<Staffs, Integer> {

	Staffs findById(int id);
	Staffs deleteById(int id);
}
