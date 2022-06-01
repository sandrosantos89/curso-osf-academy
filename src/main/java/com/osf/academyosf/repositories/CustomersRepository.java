package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osf.academyosf.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

	Customers findById(int id);
	Customers deleteById(int id);
	Page<Customers> findAll(Pageable var1);
	
	@Query(value = "SELECT * FROM Customers c WHERE c.first_name =?1", 
			countQuery = "SELECT count(first_name) FROM Products c WHERE c.first_name = ?1")
	public List<Customers> findByOrderByCustomers(String first_name);
}
