package com.example.demo.rider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "rider")
public class RiderController {
    private final RiderService riderService;

    @Autowired
    public RiderController(RiderService riderService){
        this.riderService = riderService;
    }
    @GetMapping
    public List<Rider> getRiders(){
        return riderService.getRiders();
    }

    @GetMapping(path ="{riderId}")
    public Rider getRiderById(@PathVariable("riderId") Long riderId) {
        return riderService.getARider(riderId);
    }

    //##this is post
    @PostMapping
    public void registerNewRider(@RequestBody Rider rider){
        riderService.addNewRider(rider);
    }

    //this is delete
    @DeleteMapping(path = "{id}")
    public void deleteMotorcycle(@PathVariable("id")Long riderId){
        riderService.deleteRider(riderId);
    }

    //THIS IS PUT
    @PutMapping(path = "{id}")
    public void updateRider(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String experience){
        riderService.updateRider(id, firstName, experience);
    }
}
