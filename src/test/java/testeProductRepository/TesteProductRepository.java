package testeProductRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.osf.academyosf.entities.Products;

import com.osf.academyosf.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteProductRepository {

	@Autowired
	private ProductRepository prod;

	@Test
	public void testeProductRepository() {

		List<Products> produtos = prod.findByProductsNameContaining("tennis");
		assertThat(produtos.size()).isEqualTo(1);
		assertThat(produtos.get(0).getProduct_name().equals("tennis"));
	}
}
