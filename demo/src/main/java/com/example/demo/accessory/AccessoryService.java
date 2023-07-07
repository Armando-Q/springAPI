package com.example.demo.accessory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class AccessoryService {

    private final AccessoryRepository accessoryRepository;

    @Autowired
    public AccessoryService(AccessoryRepository accessoryRepository){
        this.accessoryRepository = accessoryRepository;
    }


    public List<Accessory> getAccessorys() {
        return accessoryRepository.findAll();

    }

    public void addNewAccessory(Accessory accessory) {
        accessoryRepository.save(accessory);
    }
    public Accessory getAccessory(Long accessoryId){
        return accessoryRepository.findById(accessoryId).orElseThrow(() -> new IllegalStateException("This accessory ID is not present"));
    }

    public void deleteAccessory(Long accessoryId) {
        boolean exists = accessoryRepository.existsById(accessoryId);
    }

    @Transactional
    public void updateAccessory(Long accessoryID, String type, Double price) {
        Accessory accessory = accessoryRepository.findById(accessoryID)
                .orElseThrow(() -> new IllegalStateException("Accessory with ID " + accessoryID + " does not exist"));

        if (price != null && !Objects.equals(accessory.getPrice(), price)) {
            accessory.setPrice(price);
        }

        if (type != null && !Objects.equals(accessory.getType(), type)) {
            Optional<Accessory> accessoryOptional = accessoryRepository.findAccessoryByType(type);
            if (accessoryOptional.isPresent()) {
                throw new IllegalStateException("Type is taken");
            }
            accessory.setType(type);
        }

    }
}
