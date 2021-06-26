package com.codingdojo.products.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository=productRepository;
		this.categoryRepository=categoryRepository;
	}

	public void createProduct(Product product) {
		productRepository.save(product);
	}
	public Product getProduct(Long id) {
		Optional<Product> myProduct = productRepository.findById(id);
		
		if(myProduct.isPresent()) {
			return myProduct.get();
		}else {
			return null;
		}
	}
	
	public List<Product> getAll(){
		return (List<Product>) productRepository.findAll();
	}
	public List<Product> getAllExceptId(Long id){
		List<Product> myProducts = this.getAll();
		Optional<Category> x = categoryRepository.findById(id);
		if(x.isPresent()) {
			List<Product> myCategoryProduct = x.get().getProducts();
			myProducts.removeAll(myCategoryProduct);
			return myProducts;
		}else {
			return null;
		}
		
	}
}
