package com.example.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.Product;
import com.example.example.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";  // list.html
    }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
	  model.addAttribute("product", new Product());
	  return "products/create";
  }
  
  @PostMapping("/create")
  public String createProduct(@ModelAttribute Product product) {
	  productService.createProduct(product);
	  return "redirect:/products";
  }
}