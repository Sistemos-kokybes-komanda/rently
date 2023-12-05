package com.example.rently.Repositories;

import com.example.rently.Entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    // You can add custom queries or methods here if needed
    UsersEntity findByEmail(String email);
}