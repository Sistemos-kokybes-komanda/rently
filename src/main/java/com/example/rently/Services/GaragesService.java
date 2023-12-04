package com.example.rently.Services;

import com.example.rently.Entities.GaragesEntity;
import com.example.rently.Repositories.GaragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GaragesService {
    @Autowired
    private GaragesRepository garagesRepository;

    public GaragesEntity saveGarage(GaragesEntity garage){
        return garagesRepository.save(garage);
    }

    public List<GaragesEntity> getAllGarages() {
        return garagesRepository.findAll();
    }

    public GaragesEntity getGarageById(int id) {
        Optional<GaragesEntity> optionalGarage = garagesRepository.findById(id);
        return optionalGarage.orElse(null);
    }

    public GaragesEntity updateGarage(int id, GaragesEntity updatedGarage) {
        if (garagesRepository.existsById(id)) {
            updatedGarage.setId(id);
            return garagesRepository.save(updatedGarage);
        } else {
            return null;
        }
    }
    public void deleteGarage(int id) {
        garagesRepository.deleteById(id);
    }
}
