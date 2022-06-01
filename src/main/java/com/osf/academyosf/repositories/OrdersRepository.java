package com.osf.academyosf.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osf.academyosf.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	Orders findById(int id);
	Orders deleteById(int id);
	Page<Orders> findAll(Pageable var1);

	@Query(value = "SELECT oc FROM Orders oc WHERE oc.customers =?1") 
				public List<Orders> findByOrderByOrdes(String customers);
	
	@Query(value = "SELECT od FROM Orders od WHERE od.order_date BETWEEN ?1 AND ?2)")
	public List<Orders> findByInstantBetween(Instant data_inicial, Instant data_final);;
}
