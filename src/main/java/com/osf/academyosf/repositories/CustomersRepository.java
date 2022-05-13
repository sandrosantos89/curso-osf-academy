package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

	Customers findById(int id);

	Customers deleteById(int id);
}
