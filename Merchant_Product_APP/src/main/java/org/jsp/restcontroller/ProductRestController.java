package org.jsp.restcontroller;

import java.util.List;

import org.jsp.entity.Product;
import org.jsp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;

	@PostMapping("/product/{merchantId}")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product, @PathVariable Integer merchantId) {
		Product dbproduct = productService.saveProduct(product, merchantId);
		return new ResponseEntity<>(dbproduct, HttpStatus.CREATED);
	}

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping("/product/merchantid/{merchantId}")
	public List<Product> findProductsByMerchantId(@PathVariable Integer merchantId) {
		return productService.findProductsByMerchantId(merchantId);
	}

	@GetMapping("/product/brand/{brand}")
	public List<Product> findProductsByBrand(@PathVariable String brand) {
		return productService.findProductsByBrand(brand);
	}

	@GetMapping("/product/category/{category}")
	public List<Product> findProductsByCategory(@PathVariable String category) {
		return productService.findProductsByCategory(category);
	}

	@GetMapping("/product/name/{name}")
	public List<Product> findProductsByName(@PathVariable String name) {
		return productService.findProductsByName(name);
	}
}
