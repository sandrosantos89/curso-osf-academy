package com.osf.academyosf.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.enums.OrderStatus;
import com.osf.academyosf.repositories.OrderStatusRepository;

@RestController
@RequestMapping(value = "/api")
public class OrderStatusResource {

	@Autowired
	private OrderStatusRepository order_status_repository;

	@PutMapping("/order_status/{id}")
	public OrderStatus delete_order_status_one(@PathVariable(value = "id") int id) {
		return order_status_repository.updateById(id);
	}

	@PutMapping("/order_status")
	public OrderStatus update_order_status(@RequestBody OrderStatus orders_status) {
		return order_status_repository.save(orders_status);
	}
}
