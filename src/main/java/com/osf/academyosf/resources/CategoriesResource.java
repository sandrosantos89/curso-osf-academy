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

import com.osf.academyosf.entities.Categories;
import com.osf.academyosf.repositories.CategoriesRepository;

@RestController
@RequestMapping(value = "/api")
public class CategoriesResource {

	@Autowired
	private CategoriesRepository categories_repository;

	@GetMapping("/categories")
	public List<Categories> list_categories() {
		return categories_repository.findAll();
	}

	@GetMapping("/categories/{id}")
	public Categories list_categories_one(@PathVariable(value = "id") int id) {
		return categories_repository.findById(id);
	}

	@PostMapping("/categories")
	public Categories salve_categories(@RequestBody Categories orders) {
		return categories_repository.save(orders);
	}

	@DeleteMapping("/categories")
	public void delete_categories(@RequestBody Categories orders) {
		categories_repository.delete(orders);
	}

	@DeleteMapping("/categories/{id}")
	public Categories delete_categories_one(@PathVariable(value = "id") int id) {
		return categories_repository.deleteById(id);
	}

	@PutMapping("/categories")
	public Categories update_categories(@RequestBody Categories orders) {
		return categories_repository.save(orders);
	}
}
