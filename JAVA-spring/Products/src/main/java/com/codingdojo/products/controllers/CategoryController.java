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
public class CategoryController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService=categoryService;
		this.productService=productService;
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "category.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category.jsp";
		}else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	@RequestMapping("categories/{id}")
	public String showCategory(@PathVariable("id")Long id, @ModelAttribute("category") Category category,Model model) {
		Category myCategory = categoryService.getCategory(id);
		model.addAttribute("category", myCategory);
		model.addAttribute("products", productService.getAllExceptId(id));
		return "showCategory.jsp";
	}
	@RequestMapping(value="categories/{id}", method=RequestMethod.POST)
	public String addProduct(@PathVariable ("id")Long categoryId,@RequestParam("product")Long proId ) {
		Category myCategory = categoryService.getCategory(categoryId);
		Product myProduct = productService.getProduct(proId);
		List<Product> products = myCategory.getProducts();
		products.add(myProduct);
		categoryService.createCategory(myCategory);
		return "redirect:/categories/"+categoryId;
	}
	
}
