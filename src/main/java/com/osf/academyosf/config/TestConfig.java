package com.osf.academyosf.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.osf.academyosf.entities.OrderItems;
import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductsRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductsRepository product_repository;

	@Autowired
	private OrderItems order_item_repository;

	@Override
	public void run(String... args) throws Exception {

		Products p1 = new Products(null, "sapato", 2019, 100.00);
		Products p2 = new Products(null, "camisa", 2022, 200.00);

		OrderItems oi1 = new OrderItems(null, p2, 2, 200.00, 0.10);

		product_repository.saveAll(Arrays.asList(p1, p2));
		order_item_repository.saveAll(Arrays.asList(oi1));
	}

}
