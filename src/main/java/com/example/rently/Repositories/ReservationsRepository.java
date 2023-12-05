package com.example.rently.Repositories;

import com.example.rently.Entities.ReservationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReservationsRepository extends JpaRepository<ReservationsEntity, Integer> {
    // You can add custom queries or methods here if needed
}
