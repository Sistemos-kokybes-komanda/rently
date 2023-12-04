package com.example.rently.Services;

import com.example.rently.Entities.ReservationsEntity;
import com.example.rently.Repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;

    public ReservationsEntity saveReservation(ReservationsEntity reservation){
        return reservationsRepository.save(reservation);
    }

    public List<ReservationsEntity> getAllReservations() {
        return reservationsRepository.findAll();
    }

    public ReservationsEntity getReservationById(int id) {
        Optional<ReservationsEntity> optionalReservation = reservationsRepository.findById(id);
        return optionalReservation.orElse(null);
    }

    public ReservationsEntity updateReservation(int id, ReservationsEntity updatedReservation) {
        if (reservationsRepository.existsById(id)) {
            updatedReservation.setId(id);
            return reservationsRepository.save(updatedReservation);
        } else {
            return null;
        }
    }
    public void deleteReservation(int id) {
        reservationsRepository.deleteById(id);
    }
}
