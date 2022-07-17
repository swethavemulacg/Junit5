package com.cg.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Demo.entity.Product;
import com.cg.Demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

//6add service autowire
//7write implmntm of get method call service method frm this
	@Autowired
	public ProductService ProductServ;
	//2just write method name request mapping get method
	
	
	@GetMapping("/Allproduct")
	public List<Product> getAllproducts()
	{
	   return  ProductServ.getAllproducts();
	
	}
	
	@GetMapping("/details")
	public List<Product> getlist(){
		return ProductServ.getlist();
		
	}
	
	@PostMapping("/Addproduct")
	public Product addProducts(@RequestBody Product product)
	{
		
		return ProductServ.addProducts(product);
		
	}

	@PutMapping("/updateproduct/{id}")
	public void UpdateProducts(@PathVariable Integer id,@RequestBody Product product)
	{
		
		ProductServ.UpdateProducts(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public void DeleteProduct(@PathVariable Integer id)

{
	ProductServ.deleteProduct(id);
}
}
