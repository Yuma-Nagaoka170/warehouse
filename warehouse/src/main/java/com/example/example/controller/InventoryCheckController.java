package com.example.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.InventoryCheck;
import com.example.example.service.InventoryCheckService;

@Controller
@RequestMapping("/inventory-checks") // ← ★ここでパスを整理してる！
public class InventoryCheckController {

    @Autowired
    private InventoryCheckService inventoryCheckService;

    @GetMapping
    public String listInventoryChecks(Model model) {
        List<InventoryCheck> checks = inventoryCheckService.getAllInventoryChecks();
        model.addAttribute("checks", checks);
        return "inventory-check/list"; // HTMLファイルも"inventory-check"ディレクトリに置いてね！
    }
}
