package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository=productRepository;
	}
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getAll(){
		return (List<Category>) categoryRepository.findAll();
	}
	public Category getCategory(Long id) {
		Optional<Category> myCategory = categoryRepository.findById(id);
		if(myCategory.isPresent()) {
			return myCategory.get();
		}else {
			return null;
		}
	}
	public List<Category> getAllExceptId(Long id){
		List<Category> myCategories = this.getAll();
		Optional<Product> x = productRepository.findById(id);
		if(x.isPresent()) {
			List<Category> myProductCategory = x.get().getCategories();
			myCategories.removeAll(myProductCategory);
			return myCategories;
		}else {
			return null;
		}
		
	}
}
