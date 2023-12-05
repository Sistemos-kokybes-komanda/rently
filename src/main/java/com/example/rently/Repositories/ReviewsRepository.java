package com.example.rently.Repositories;

import com.example.rently.Entities.ReservationsEntity;
import com.example.rently.Entities.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Integer> {
}
