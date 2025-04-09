package com.example.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.Shipment;
import com.example.example.service.OrderService;
import com.example.example.service.ShipmentService;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
	
	@Autowired
	private OrderService orderService;

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public String listShipments(Model model) {
        List<Shipment> shipments = shipmentService.getAllShipments();
        model.addAttribute("shipments", shipments);
        return "shipment/list"; // HTML: templates/shipment/list.html
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("shipment", new Shipment());
        model.addAttribute("orders", orderService.getAllOrders());
        return "shipment/create"; // HTML: templates/shipment/create.html
    }

    @PostMapping("/create")
    public String createShipment(@ModelAttribute Shipment shipment) {
        shipmentService.saveShipmennt(shipment);
        return "redirect:/shipments";
    }

    @GetMapping("/delete/{id}")
    public String deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }
}

