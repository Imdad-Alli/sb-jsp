package org.jsp.repository;

import java.util.List;

import org.jsp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.merchant.id=?1")
	public List<Product> findByMerchantId(Integer id);
	
	public List<Product> findByName(String name);
	
	public List<Product> findByBrand(String brand);
	
	public List<Product> findByCategory(String category);
	
}
