package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

	OrderItems findById(int id);
	OrderItems deleteById(int id);
}
