package com.cg.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.Demo.entity.Product;
//4extend with crudrepositry class and mention entity and primary id
public interface ProductRepo extends JpaRepository<Product,Integer>{

	 //times(int i);Object

	
}
