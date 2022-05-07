package com.osf.academyosf.resources;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/api")
public class ProductResource {

	@Autowired
	ProductRepository productsRepository;

	@GetMapping("/products") // Lista todos os produtos
	public List<Products> listaProducts() {
		return productsRepository.findAll();
	}

	@GetMapping("/product/{id}") // Lista somente o produto com id
	public Products listaProductsOne(@PathVariable(value = "id") int id) {
		return productsRepository.findById(id);
	}

	@PostMapping("/product")
	public Products salvaProduct(@RequestBody Products product) {
		return productsRepository.save(product);

	}

}
