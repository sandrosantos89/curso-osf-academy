package com.osf.academyosf.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductRepository user_repository;

	@Override
	public void run(String... args) throws Exception {

		Products p1 = new Products(null, "sapato", 2019, 100.00);
		Products p2 = new Products(null, "sapato", 2022, 200.00);

		user_repository.saveAll(Arrays.asList(p1, p2));

	}

}
