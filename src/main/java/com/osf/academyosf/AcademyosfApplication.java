package com.osf.academyosf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductsRepository;

@SpringBootApplication
public class AcademyosfApplication implements CommandLineRunner {
	
	@Autowired
	private ProductsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AcademyosfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		String name = "tennis";
		List<Products> list_product = repository.findByOrderByProduct_name(name);
		list_product.forEach(System.out::println);
		}
}

