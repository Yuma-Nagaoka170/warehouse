package com.example.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.entity.Location;
import com.example.example.service.LocationService;

@Controller
@RequestMapping("/location-tree")
public class LocationTreeController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String showLocationTree(Model model) {
        List<Location> rootLocations = locationService.getRootLocations();
        model.addAttribute("locations", rootLocations);
        model.addAttribute("newLocation", new Location());
        return "location-tree";
    }

    @PostMapping("/add")
    public String addLocation(@ModelAttribute Location newLocation, @RequestParam(required = false) Long parentId) {
        if (parentId != null) {
            locationService.getLocationById(parentId).ifPresent(newLocation::setParent);
        }
        locationService.saveLocation(newLocation);
        return "redirect:/location-tree";
    }

}

