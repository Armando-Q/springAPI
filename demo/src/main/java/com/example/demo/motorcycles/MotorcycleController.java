package com.example.demo.motorcycles;


import com.example.demo.accessory.Accessory;
import com.example.demo.accessory.AccessoryService;
import com.example.demo.rider.Rider;
import com.example.demo.rider.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/motorcycle")
public class MotorcycleController {
    private final MotorcycleService motorcycleService;
    private final RiderService riderService;
    private final AccessoryService accessoryService;

    @Autowired
    public MotorcycleController(MotorcycleService motorcycleService, RiderService riderService, AccessoryService accessoryService) {
        this.motorcycleService = motorcycleService;
        this.riderService = riderService;
        this.accessoryService = accessoryService;
    }

    @GetMapping
    public List<Motorcycle> getMotorcycles() {
        return motorcycleService.getMotorcycles();
    }


    //##this is post
    @PostMapping
    public void registerNewMotorcycle(@RequestBody Motorcycle motorcycle) {
        motorcycleService.addNewMotorcycle(motorcycle);
    }

    //this is delete
    @DeleteMapping(path = "{motorcycleID}")
    public void deleteMotorcycle(@PathVariable("motorcycleID") Long motorcycleId) {
        motorcycleService.deleteMotorcycle(motorcycleId);
    }

    //THIS IS PUT
    @PutMapping(path = "{motorcycleID}")
    public void updateMotorcycle(
            @PathVariable("motorcycleID") Long motorcycleID,
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model) {
        motorcycleService.updateMotorcycle(motorcycleID, make, model);
    }

    @PutMapping("/{motorcycleId}/riders/{riderId}")
    public Motorcycle connectRiderToMotorcycle(
            @PathVariable Long motorcycleId,
            @PathVariable Long riderId

    ) {
        Motorcycle motorcycle = motorcycleService.getAMotorcycle(motorcycleId);
        Rider rider = riderService.getARider(riderId);
        motorcycle.addRider(rider);
        return motorcycleService.saveMyRepo(motorcycle);
    }

    @PutMapping(path = "/{motorcycleId}/accessorys/{accessoryId}")
    public Motorcycle addToMotorcycle(@PathVariable Long motorcycleId, @PathVariable Long accessoryId) {
        Motorcycle motorcycle = motorcycleService.getAMotorcycle(motorcycleId);
        Accessory accessory = accessoryService.getAccessory(accessoryId);
        motorcycle.addAccessory(accessory);
        return motorcycleService.saveMyRepo(motorcycle);
    }
}

