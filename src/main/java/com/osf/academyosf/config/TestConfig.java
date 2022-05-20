package com.osf.academyosf.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.osf.academyosf.entities.Brands;
import com.osf.academyosf.entities.Categories;
import com.osf.academyosf.entities.Customers;
import com.osf.academyosf.entities.OrderItems;
import com.osf.academyosf.entities.Orders;
import com.osf.academyosf.entities.Products;
import com.osf.academyosf.entities.Staffs;
import com.osf.academyosf.entities.Stocks;
import com.osf.academyosf.entities.Stores;
import com.osf.academyosf.entities.enums.OrderStatus;
import com.osf.academyosf.repositories.BrandsRepository;
import com.osf.academyosf.repositories.CategoriesRepository;
import com.osf.academyosf.repositories.CustomersRepository;
import com.osf.academyosf.repositories.OrderItemsRepository;
import com.osf.academyosf.repositories.OrdersRepository;
import com.osf.academyosf.repositories.ProductsRepository;
import com.osf.academyosf.repositories.StaffsRepository;
import com.osf.academyosf.repositories.StocksRepository;
import com.osf.academyosf.repositories.StoresRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductsRepository product_repository;

	@Autowired
	private StocksRepository stocks_repository;

	@Autowired
	private StoresRepository stores_repository;

	@Autowired
	private StaffsRepository staffs_repository;

	@Autowired
	private OrderItemsRepository order_item_repository;

	@Autowired
	private OrdersRepository order_repository;

	@Autowired
	private CustomersRepository customer_repository;

	@Autowired
	private CategoriesRepository categories_repository;

	@Autowired
	private BrandsRepository brands_repository;

	@Override
	public void run(String... args) throws Exception {

		Categories cat1 = new Categories(null, "corrida");

		Brands bd1 = new Brands(null, "Nike");

		Products p1 = new Products(null, bd1, cat1, "tennis", 2022, 150.00);

		Stocks stk1 = new Stocks(null, 1, p1);

		Staffs stf1 = new Staffs(null, "santos", "sandro", "teste3@teste3.com", "12345-6789", true, true);

		Stores st1 = new Stores(null, "Loja1", Arrays.asList(stk1), Arrays.asList(p1), Arrays.asList(stf1));

		Customers ct1 = new Customers("Sandro", "Santos", "1234-5678", "teste@teste.com", "Rua teste", "São Paulo",
				"SP", "12345-678");

		Orders od1 = new Orders(null, ct1, OrderStatus.Awaiting_shipment, Instant.parse("2022-05-13T19:03:20Z"),
				Instant.parse("2022-05-13T19:03:20Z"), Instant.parse("2022-05-13T19:03:20Z"), stf1, st1);

		OrderItems oi1 = new OrderItems(od1, p1, 1, 100.00, 0.10);

		categories_repository.saveAll(Arrays.asList(cat1));
		brands_repository.saveAll(Arrays.asList(bd1));
		product_repository.saveAll(Arrays.asList(p1));
		stocks_repository.saveAll(Arrays.asList(stk1));
		staffs_repository.saveAll(Arrays.asList(stf1));
		stores_repository.saveAll(Arrays.asList(st1));
		customer_repository.saveAll(Arrays.asList(ct1));
		order_repository.saveAll(Arrays.asList(od1));
		order_item_repository.saveAll(Arrays.asList(oi1));
	}

}
