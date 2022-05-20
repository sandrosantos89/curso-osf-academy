package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.enums.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

	OrderStatus updateById(int id);

	
}
