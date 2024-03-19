package org.jsp.dao;

import java.util.List;

import org.jsp.entity.Product;
import org.jsp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepo;
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}
	public List<Product> findProductsByMerchantId(Integer merchantId) {
		 return productRepo.findByMerchantId(merchantId);
	}
	public List<Product> findProductsByBrand(String brand) {
		return productRepo.findByBrand(brand);
	}
	public List<Product> findProductsByCategory(String category) {
		return productRepo.findByCategory(category);
	}
	public List<Product> findProductsByName(String name) {
		return productRepo.findByName(name);
	}
	
}
