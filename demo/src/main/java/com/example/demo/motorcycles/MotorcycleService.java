package com.example.demo.motorcycles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class MotorcycleService {


    private final MotorcycleRepository motorcycleRepository;

    @Autowired
    public MotorcycleService(MotorcycleRepository motorcycleRepository){
        this.motorcycleRepository = motorcycleRepository;
    }

    public List<Motorcycle> getMotorcycles() {
        return motorcycleRepository.findAll();

    }


    public Motorcycle getAMotorcycle(Long motorcycleId){
        return motorcycleRepository.findById(motorcycleId).orElseThrow(()-> new IllegalStateException("This motorcycle ID is not present"));
    }
    public void addNewMotorcycle(Motorcycle motorcycle) {
        motorcycleRepository.save(motorcycle);
    }

    public void deleteMotorcycle(Long motorcycleId) {
       boolean exists= motorcycleRepository.existsById(motorcycleId);
       if(!exists){
           throw new IllegalStateException(
                   "motorcycle with id " + motorcycleId + " does not exists");
       }
       motorcycleRepository.deleteById(motorcycleId);
    }

    @Transactional
    public void updateMotorcycle(Long motorcycleID, String make, String model) {
        Motorcycle motorcycle = motorcycleRepository.findById(motorcycleID)
                .orElseThrow(()-> new IllegalStateException(
                        "motorcycle with id " + motorcycleID + " does not exist"));
        if(make != null && make.length()> 0 && !Objects.equals(motorcycle.getMake(), make)){
            motorcycle.setMake(make);
        }
        if(model != null && model.length()> 0 && !Objects.equals(motorcycle.getModel(),model)){
            Optional<Motorcycle> motorcycleOptional = motorcycleRepository
                    .findMotorcycleByModel(model);
            if(motorcycleOptional.isPresent()){
                throw new IllegalStateException("model taken");
            }
            motorcycle.setModel(model);
        }




    }
    public Motorcycle saveMyRepo(Motorcycle motorcycle) {
        return motorcycleRepository.saveAndFlush(motorcycle);
    }


}
