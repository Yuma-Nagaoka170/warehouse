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

import com.example.example.entity.Location;
import com.example.example.service.LocationService;

@Controller
@RequestMapping("/locations")
public class LocationController {

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



}

