package com.codingdojo.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}

	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable ("id")Long id, @ModelAttribute("product")Product product,Model model) {
		Product myProduct = productService.getProduct(id);
		model.addAttribute("product", myProduct);
		model.addAttribute("categories",categoryService.getAllExceptId(id));
		return "showproduct.jsp";
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	public String addCategory(@PathVariable("id")Long ProId,@RequestParam("category") Long categoryId) {
		Product myProduct = productService.getProduct(ProId);
		Category myCategory = categoryService.getCategory(categoryId);
		List<Category> categories = myProduct.getCategories();
		categories.add(myCategory);
		productService.createProduct(myProduct);
		return "redirect:/products/"+ProId;
	}
	
}
