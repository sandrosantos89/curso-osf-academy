package com.osf.academyosf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osf.academyosf.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

	Customers findById(int id);

	Customers deleteById(int id);
	
	@Query(value = "SELECT * FROM Tb_customers c WHERE c.first_name LIKE %:first_name%", 
			countQuery = "SELECT count(first_name) FROM Tb_products c WHERE c.first_name LIKE %:first_name%")
	public List<Customers> findByOrderByCustomers(@Param("first_name") String first_name);
}
