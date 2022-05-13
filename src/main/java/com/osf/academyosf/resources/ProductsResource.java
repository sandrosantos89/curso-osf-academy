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

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductsRepository;

@RestController
@RequestMapping(value = "/api")
public class ProductsResource {

	@Autowired
	ProductsRepository products_repository;

	@GetMapping("/products") 
	public List<Products> lista_products() {
		return products_repository.findAll();
	}

	@GetMapping("/product/{id}") 
	public Products lista_products_one(@PathVariable(value = "id") int id) {
		return products_repository.findById(id);
	}

	@PostMapping("/product")
	public Products salve_product(@RequestBody Products product) {
		return products_repository.save(product);
	}

	@DeleteMapping("/product") 
	public void delete_product(@RequestBody Products product) {
		products_repository.delete(product);
	}

	@DeleteMapping("/product/{id}")
	public Products delete_product_one(@PathVariable(value = "id") int id ){
		return products_repository.deleteById(id);
	}

	@PutMapping("/product") 
	public Products update_product(@RequestBody Products product) {
		return products_repository.save(product);
	}
}
