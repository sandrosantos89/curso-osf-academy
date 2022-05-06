package com.osf.academyosf;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductRepository;

@SpringBootTest
class AcademyosfApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ProductRepository repo;

	@Test
	public void testarProduto() {
		List<Products> prod = repo.searchByNameLike("nike");
		assertThat(prod.size()).isEqualTo(1);
	}

}
