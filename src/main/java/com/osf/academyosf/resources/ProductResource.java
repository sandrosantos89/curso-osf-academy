package com.osf.academyosf.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/api")
public class ProductResource {

	@Autowired
	ProductRepository productsRepository;

	@GetMapping("/produtos")
	public List<Products> listaProducts() {
		return productsRepository.findAll();
	}

}
