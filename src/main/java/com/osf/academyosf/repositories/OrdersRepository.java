package com.osf.academyosf.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osf.academyosf.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	Orders findById(int id);
	Orders deleteById(int id);
	Page<Orders> findAll(Pageable var1);

	@Query(value = "SELECT * FROM Tb_order_customers oc WHERE oc.customers LIKE %:customers%") 
				public List<Orders> findByOrderByOrdes(@Param("oc") String customers);
	
	@Query(value = "SELECT * FROM Tb_order od WHERE od LIKE(:data_inicial) <= LIKE(:data_final)")
	public List<Orders> findByOrderByOrdesDate(@Param("od")Instant data_inicial, Instant data_final);;
}
