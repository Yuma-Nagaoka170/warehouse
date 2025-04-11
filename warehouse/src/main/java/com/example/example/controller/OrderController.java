package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.entity.Order;
import com.example.example.service.OrderService;
import com.example.example.service.ProductService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String listOrders(Model model) {
		model.addAttribute("orders", orderService.getAllOrders());
		return "orders/list";
	}
	
	 @GetMapping("/create")
	    public String showCreateForm(Model model) {
	        model.addAttribute("order", new Order());
	        model.addAttribute("products", productService.getAllProducts());
	        return "orders/create";
	    }

	    @PostMapping("/create")
	    public String createOrder(@ModelAttribute Order order) {
	        orderService.saveOrder(order);
	        return "redirect:/orders";
	    }

	    @PostMapping("/delete/{id}")
	    public String deleteOrder(@PathVariable Long id) {
	        orderService.deleteOrder(id);
	        return "redirect:/orders";
	    }

	    @PostMapping("/updateStatus/{id}")
	    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
	        Order order = orderService.getOrderById(id);
	        order.setStatus(status);
	        orderService.saveOrder(order);
	        return "redirect:/orders";
	    }
	   

	}
    
