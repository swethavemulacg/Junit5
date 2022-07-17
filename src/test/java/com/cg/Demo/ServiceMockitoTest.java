package com.cg.Demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.Demo.Repository.ProductRepo;
import com.cg.Demo.entity.Product;
import com.cg.Demo.service.ProductService;

@SpringBootTest
public class ServiceMockitoTest {

	@Mock
	ProductRepo repo;

	@InjectMocks
	ProductService serv;

	public List<Product> products;

	@Test
	@Order(3)
	public void test_getAllproducts() {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "ball"));
		products.add(new Product(2, "pen"));

		when(repo.findAll()).thenReturn(products);
		assertEquals(2, serv.getAllproducts().size());
	}

	@Test
	@Order(2)
	public void test_UpdateProducts() {
		Product products = new Product(1, "banana");
		when(repo.save(products)).thenReturn(products);
		assertEquals(products, serv.UpdateProducts(products));

	}

	@Test
	@Order(1)
	public void test_deleteProduct() {
		Product products = new Product(1, "banana");
		int productId = 1;

		serv.deleteProduct(productId);
		// verify(repo.times(1)).deleteProduct(1);
		//verify(serv, Mockito.times(1)).deleteProduct(1);

	}

}
