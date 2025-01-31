package com.fastfood.restaurants;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer>{
	  Product findById(int id);
	  List<Product> findByCategory(String category);
}
