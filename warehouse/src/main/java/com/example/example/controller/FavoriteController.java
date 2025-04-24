package com.example.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.entity.Equipment;
import com.example.example.entity.User;
import com.example.example.service.EquipmentService;
import com.example.example.service.FavoriteService;
import com.example.example.service.UserService;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private EquipmentService equipmentService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/add")
    public String addFavorite(@RequestParam("equipmentId") Long equipmentId, Principal principal) {
    	String username = principal.getName();
    	User user = userService.findByUsername(username);
    	
    	Equipment equipment = equipmentService.getById(equipmentId);
    	favoriteService.addToFavorites(user, equipment);
    	
    	return "redirect:/equipments";
    }
    
    @PostMapping("/remove")
    public String removeFavorite(@RequestParam("equipmentId") Long equipmentId, Principal principal) {
    	String username = principal.getName();
    	User user = userService.findByUsername(username);
    	
    	Equipment equipment = equipmentService.getById(equipmentId);
    	favoriteService.removeFromFavorites(user, equipment);
    	
    	return "redirect:/equipments";
    }
    

    


}
