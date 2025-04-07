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

import com.example.example.entity.Stock;
import com.example.example.service.ProductService;
import com.example.example.service.StockService;
import com.example.example.service.WarehouseService;

@Controller
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductService productService;

    @GetMapping("/warehouse/{warehouseId}")
    public String listStocks(@PathVariable Long warehouseId, Model model) {
        model.addAttribute("stocks", stockService.getStocksByWarehouseId(warehouseId));
        model.addAttribute("warehouse", warehouseService.getWarehouseById(warehouseId));
        return "stocks/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("stock", new Stock());
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        model.addAttribute("products", productService.getAllProducts());
        return "stocks/create";
    }

    @PostMapping("/create")
    public String createStock(@ModelAttribute Stock stock) {
        stockService.createOrUpdateStock(stock);
        return "redirect:/stocks/warehouse/" + stock.getWarehouse().getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteStock(@PathVariable Long id, @RequestParam Long warehouseId) {
        stockService.deleteStock(id);
        return "redirect:/stocks/warehouse/" + warehouseId;
    }
}
