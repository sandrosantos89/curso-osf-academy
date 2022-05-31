package com.osf.academyosf.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.Customers;
import com.osf.academyosf.repositories.CustomersRepository;

@RestController
@RequestMapping(value = "/api")
public class CustomersResource {

	@Autowired
	private CustomersRepository customers_repository;

	@GetMapping("/customers")
	public List<Customers> list_customers() {
		return customers_repository.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customers list_customers_one(@PathVariable(value = "id") int id) {
		return customers_repository.findById(id);
	}

	@PostMapping("/customers")
	public Customers salve_customers(@RequestBody Customers orders) {
		return customers_repository.save(orders);
	}

	@DeleteMapping("/customers")
	public void delete_customers(@RequestBody Customers orders) {
		customers_repository.delete(orders);
	}

	@DeleteMapping("/customers/{id}")
	public Customers delete_customers_one(@PathVariable(value = "id") int id) {
		return customers_repository.deleteById(id);
	}

	@PutMapping("/customers")
	public Customers update_customers(@RequestBody Customers orders) {
		return customers_repository.save(orders);
	}
	
	@GetMapping("/customers/page")
	public Page<Customers> lista_products(Pageable pageable) {
		return customers_repository.findAll(pageable);
	}
}
