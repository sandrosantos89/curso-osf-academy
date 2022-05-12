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
public class BrandsResource {

	@Autowired
	CategoriesRepository brands_repository;

	@GetMapping("/brands")
	public List<Categories> list_brands() {
		return brands_repository.findAll();
	}

	@GetMapping("/brands/{id}")
	public Categories list_brands_one(@PathVariable(value = "id") int id) {
		return brands_repository.findById(id);
	}

	@PostMapping("/brands")
	public Categories salve_brands(@RequestBody Categories orders) {
		return brands_repository.save(orders);
	}

	@DeleteMapping("/brands")
	public void delete_brands(@RequestBody Categories orders) {
		brands_repository.delete(orders);
	}

	@DeleteMapping("/brands/{id}")
	public Categories delete_brands_one(@PathVariable(value = "id") int id) {
		return brands_repository.deleteById(id);
	}

	@PutMapping("/brands")
	public Categories update_brands(@RequestBody Categories orders) {
		return brands_repository.save(orders);
	}
}
