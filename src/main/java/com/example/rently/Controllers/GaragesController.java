package com.example.rently.Controllers;

import com.example.rently.Entities.GaragesEntity;
import com.example.rently.Services.GaragesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GaragesController {

    @Autowired
    private GaragesService garagesService;

    @GetMapping("/garages")
    public List<GaragesEntity> getAllGarages() {
        return garagesService.getAllGarages();
    }

    @GetMapping("/garage/{id}")
    public GaragesEntity getGarageById(@PathVariable int id) {
        return garagesService.getGarageById(id);
    }

    @PostMapping("/garage/save")
    public GaragesEntity saveGarage(@RequestBody GaragesEntity garage) {
        return garagesService.saveGarage(garage);
    }

    @PutMapping("/garage/update/{id}")
    public GaragesEntity updateGarage(@PathVariable int id, @RequestBody GaragesEntity updatedGarage) {
        return garagesService.updateGarage(id, updatedGarage);
    }
    @DeleteMapping("/garage/delete/{id}")
    public void deleteGarage(@PathVariable int id) {
        garagesService.deleteGarage(id);
    }
}
