package com.example.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Equipment;
import com.example.example.entity.Favorite;
import com.example.example.entity.User;
import com.example.example.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository repository;
	
	public void addToFavorites(User user, Equipment equipment) {
		if(!repository.existsByUserAndEquipment(user, equipment)) {
			Favorite favorite = new Favorite();
			favorite.setUser(user);
			favorite.setEquipment(equipment);
			favorite.setAddedAt(LocalDateTime.now());
			repository.save(favorite);
		}
	}
	
	public void removeFromFavorites(User user, Equipment equipment) {
		repository.deleteByUserAndEquipment(user, equipment);
	}
	
	public boolean isFavorited(User user, Equipment equipment) {
		return repository.existsByUserAndEquipment(user, equipment);
	}
	
	public List<Favorite> getFavorites(User user){
		return repository.findByUser(user);
	}

}
