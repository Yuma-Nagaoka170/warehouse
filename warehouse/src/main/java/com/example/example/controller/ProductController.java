package com.example.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.Product;
import com.example.example.repository.ProductRepository;
import com.example.example.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";  // list.html
    }
  
  @GetMapping("/products/new")
  public String showCreateForm(Model model) {
      model.addAttribute("product", new Product());
      return "products/form";
  }

  @GetMapping("/products/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
      Product product = productRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
      model.addAttribute("product", product);
      return "products/form";
  }

  @PostMapping("/products/save")
  public String saveProduct(@ModelAttribute Product product) {
      productRepository.save(product);
      return "redirect:/products";
  }

}