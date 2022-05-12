package com.osf.academyosf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	Orders findById(int id);

	Orders deleteById(int id);
}
