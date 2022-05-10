package com.osf.academyosf;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProducts {

	@Autowired
	ProductRepository product_repository;
	
	@org.junit.jupiter.api.Test
	
	public void listProducts() {
		List<Products> list_prod = product_repository.findAll();
		assertThat(list_prod).size().isGreaterThan(0);

	}


}
