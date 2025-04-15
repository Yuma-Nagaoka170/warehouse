package com.example.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.entity.Location;
import com.example.example.service.LocationService;
import com.example.example.service.StockService;

@Controller
@RequestMapping("/locations")
public class LocationController {
	
	@Autowired
	private StockService stockService;


    @Autowired
    private LocationService locationService;

    @GetMapping
    public String listLocations(Model model) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        return "location/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("location", new Location());
        return "location/create";
    }

    @PostMapping("/create")
    public String createLocation(@ModelAttribute Location location) {
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }
    
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Location location = locationService.getLocationById(id).orElseThrow(() -> new IllegalArgumentException("Invalid location ID"));
        model.addAttribute("location", location);
        return "locations/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateLocation(@PathVariable Long id, @ModelAttribute Location updatedLocation) {
        Location existing = locationService.getLocationById(id).orElseThrow(() -> new IllegalArgumentException("Invalid location ID"));
        existing.setName(updatedLocation.getName());
        locationService.saveLocation(existing);
        return "redirect:/location-tree";
    }

    @PostMapping("/{parentId}/add-child")
    public String addChildLocation(@PathVariable Long parentId, @ModelAttribute Location newLocation) {
        Location parent = locationService.getLocationById(parentId).orElseThrow(() -> new IllegalArgumentException("Invalid parent ID"));
        newLocation.setParent(parent);
        locationService.saveLocation(newLocation);
        return "redirect:/location-tree";
    }
    
    @GetMapping("/location-tree")
    public String showLocationTree(Model model) {
        List<Location> locations = locationService.getTopLocations();
        Map<Long, Integer> stockSummary = new HashMap<>();
        for (Location location : locations) {
            stockSummary.put(location.getId(), stockService.getTotalQuantityByLocationId(location.getId()));
        }
        model.addAttribute("locations", locations);
        model.addAttribute("stockSummary", stockSummary);
        return "locations/tree";
    }
    
    @PostMapping("/add")
    public String addLocation(@ModelAttribute Location newLocation, @RequestParam(required = false) Long parentId) {
        locationService.getLocationById(parentId).ifPresent(newLocation::setParent);
        locationService.saveLocation(newLocation);
        return "redirect:/location-tree";
    }





}

