package com.example.rently.Repositories;

import com.example.rently.Entities.ReservationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<ReservationsEntity, Integer> {
    // You can add custom queries or methods here if needed
}
