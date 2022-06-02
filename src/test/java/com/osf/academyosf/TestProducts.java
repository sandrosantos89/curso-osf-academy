package com.osf.academyosf;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osf.academyosf.entities.Products;
import com.osf.academyosf.repositories.ProductsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProducts {

	@Autowired
	private ProductsRepository product_repository;

	@Test
	public void listProducts() {
		List<Products> list_prod = product_repository.findCountProducts_name("tennis");
		assertThat(list_prod.size()).isEqualTo(1);
	}

	
	@SuppressWarnings("unlikely-arg-type")
	@org.junit.jupiter.api.Test
	public void productContainsCategories() {
		Products pd = new Products();
		List<Products> list_prod = product_repository.findCountProducts_name("tennis");
		assertThat(list_prod.contains(pd.getCategories()));
	}
}
