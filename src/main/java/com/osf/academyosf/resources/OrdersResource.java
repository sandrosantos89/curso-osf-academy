package com.osf.academyosf.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.Orders;
import com.osf.academyosf.repositories.OrdersRepository;

@RestController
@RequestMapping(value = "/api")
public class OrdersResource {

	@Autowired
	OrdersRepository orders_repository;

	@GetMapping("/orders")
	public List<Orders> list_orders() {
		return orders_repository.findAll();
	}

	@GetMapping("/orders/{id}")
	public Orders list_orders_one(@PathVariable(value = "id") int id) {
		return orders_repository.findById(id);
	}

	@PostMapping("/orders")
	public Orders salve_orders(@RequestBody Orders orders) {
		return orders_repository.save(orders);
	}

	@DeleteMapping("/orders")
	public void delete_orders(@RequestBody Orders orders) {
		orders_repository.delete(orders);
	}

	@DeleteMapping("/orders/{id}")
	public Orders delete_orders_one(@PathVariable(value = "id") int id) {
		return orders_repository.deleteById(id);
	}

	@PutMapping("/orders")
	public Orders update_orders(@RequestBody Orders orders) {
		return orders_repository.save(orders);
	}
}
