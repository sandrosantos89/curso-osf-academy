package com.osf.academyosf.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.Products;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@GetMapping
	public ResponseEntity<Products> prodAll() {
		Products p = new Products(1, "Computador", 2022, 2000.00);
		return ResponseEntity.ok().body(p);

	}

}
