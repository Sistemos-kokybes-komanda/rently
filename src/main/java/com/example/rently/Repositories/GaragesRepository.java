package com.example.rently.Repositories;

import com.example.rently.Entities.GaragesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface GaragesRepository extends JpaRepository<GaragesEntity, Integer> {
    // You can add custom queries or methods here if needed
}
