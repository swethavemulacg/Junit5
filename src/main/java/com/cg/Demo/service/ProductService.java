package com.cg.Demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Demo.Repository.ProductRepo;
import com.cg.Demo.entity.Product;

@Service
public class ProductService {
//5 write repo import and now wrte method implmntn of get
	@Autowired
	public ProductRepo Repo;
	
	List<Product> products=new ArrayList<>();
	//3just write getmethod service antn
	
	public List<Product> getAllproducts()
	{
		
	List<Product> products=new ArrayList<>();
		Repo.findAll().forEach(products::add);
		return products;
	}
	
	/*public List<Product> getnames()
	{
		products.stream().filter(t->t.startswith("m")).forEach(t->System.out.println(t));
		return products;
		
	}*/
	
	//using stream to get ids>2
	public List<Product> getlist() {
		Repo.findAll().forEach(products::add);
		return products.stream().filter(p->p.getId()>2).collect(Collectors.toList());
		
	}
	
	public Product addProducts(Product product) {
		return Repo.save(product);
	}

	public Product UpdateProducts(Product product) {
		// TODO Auto-generated method stub
		Repo.save(product);
		return product;

		
	}

	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Repo.deleteById(id);
		
	}

//9 we need to add products 
}
