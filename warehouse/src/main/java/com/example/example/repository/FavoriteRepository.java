package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.example.entity.Equipment;
import com.example.example.entity.Favorite;
import com.example.example.entity.User;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
	List<Favorite> findByUser(User user);
	boolean existsByUserAndEquipment(User user, Equipment equipment);
	void deleteByUserAndEquipment(User user, Equipment equipment);

}
