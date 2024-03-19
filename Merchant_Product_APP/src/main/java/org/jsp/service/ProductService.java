package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.MerchantDao;
import org.jsp.dao.ProductDao;
import org.jsp.entity.Merchant;
import org.jsp.entity.Product;
import org.jsp.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private MerchantDao merchantDao;
	
	public Product saveProduct(Product product, Integer merchantId) {
		Optional<Merchant> findById = merchantDao.findMerchantById(merchantId);
		if(findById.isPresent()) {
			Merchant merchant = findById.get();
			product.setMerchant(merchant);
		}
		return productDao.saveProduct(product);
	}
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}
	public List<Product> findProductsByMerchantId(Integer merchantId){
		List<Product> products = productDao.findProductsByMerchantId(merchantId);
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Products are not found With merchantId: "+merchantId);
		}else {
			return products;
		}
	}
	public List<Product> findProductsByBrand(String brand){
		return productDao.findProductsByBrand(brand);
	}
	public List<Product> findProductsByCategory(String category){
		return productDao.findProductsByCategory(category);
	}
	public List<Product> findProductsByName(String name){
		return productDao.findProductsByName(name);
	}
	
}
