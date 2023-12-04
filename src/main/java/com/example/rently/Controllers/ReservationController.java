package com.example.rently.Controllers;

import com.example.rently.Entities.ReservationsEntity;
import com.example.rently.Services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {
    @Autowired
    private ReservationsService reservationsService;
    @GetMapping("/reservations")
    public List<ReservationsEntity> getAllReservations() {
        return reservationsService.getAllReservations();
    }
    @GetMapping("/reservation/{id}")
    public ReservationsEntity getReservationById(@PathVariable int id) {
        return reservationsService.getReservationById(id);
    }
    @PostMapping("/reservation/save")
    public ReservationsEntity saveReservation(@RequestBody ReservationsEntity reservation) {
        return reservationsService.saveReservation(reservation);
    }
    @PutMapping("/reservation/update/{id}")
    public ReservationsEntity updateReservation(@PathVariable int id, @RequestBody ReservationsEntity updatedReservation) {
        return reservationsService.updateReservation(id, updatedReservation);
    }
    @DeleteMapping("/reservation/delete/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationsService.deleteReservation(id);
    }
}
