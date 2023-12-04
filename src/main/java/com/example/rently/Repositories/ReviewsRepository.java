package com.example.rently.Repositories;

import com.example.rently.Entities.ReservationsEntity;
import com.example.rently.Entities.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Integer> {
}
