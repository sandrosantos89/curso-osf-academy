package com.osf.academyosf.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.osf.academyosf.entities.Categories;
import com.osf.academyosf.entities.OrderItems;
import com.osf.academyosf.entities.Orders;
import com.osf.academyosf.entities.Products;
import com.osf.academyosf.entities.enums.OrderStatus;
import com.osf.academyosf.repositories.CategoriesRepository;
import com.osf.academyosf.repositories.OrdersRepository;
import com.osf.academyosf.repositories.ProductsRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductsRepository product_repository;

	@Autowired
	private OrdersRepository order_repository;

//	@Autowired
//	private OrderItems order_item_repository;

	@Autowired
	private CategoriesRepository categories_repository;

	@Override
	public void run(String... args) throws Exception {

		Categories cat1 = new Categories(null, "social");
		Categories cat2 = new Categories(null, "usual");

		Products p1 = new Products(null, "sapato", 2019, 100.00);
		Products p2 = new Products(null, "camisa", 2022, 200.00);

//		OrderItems oi1 = new OrderItems(null, p1, 1, 100.00, 0.10);
//		OrderItems oi2 = new OrderItems(null, p2, 2, 200.00, 0.10);

		Orders od1 = new Orders(null, Instant.parse("2022-05-13T19:03:20Z"), Instant.parse("2022-05-13T19:03:20Z"),
				Instant.parse("2022-05-13T19:03:20Z"), OrderStatus.Awaiting_shipment, null, null, null);
		Orders od2 = new Orders(null, Instant.parse("2022-05-13T19:03:20Z"), Instant.parse("2022-05-13T19:03:20Z"),
				Instant.parse("2022-05-13T19:03:20Z"), OrderStatus.In_transit, null, null, null);

		categories_repository.saveAll(Arrays.asList(cat1, cat2));
		product_repository.saveAll(Arrays.asList(p1, p2));
//		order_item_repository.saveAll(Arrays.asList(oi1, oi2));
		order_repository.saveAll(Arrays.asList(od1, od2));
	}

}
