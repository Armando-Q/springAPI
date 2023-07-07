package com.example.demo.accessory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accessory")
public class AccessoryController {
    private final AccessoryService accessoryService;

    @Autowired
    public AccessoryController(AccessoryService accessoryService){
        this.accessoryService=accessoryService;
    }
    @GetMapping
    public List<Accessory> getAccesorys(){
        return accessoryService.getAccessorys();
    }
    @PostMapping
    public void registerNewAccessory(@RequestBody Accessory accessory){
        accessoryService.addNewAccessory(accessory);
    }

    //this is delete
    @DeleteMapping(path = "{accessoryID}")
    public void deleteAccessory(@PathVariable("accessoryID")Long accessoryId){
        accessoryService.deleteAccessory(accessoryId);
    }

    //THIS IS PUT
    @PutMapping(path = "{accessoryID}")
    public void updateAccessory(
            @PathVariable("accessoryID") Long accessoryID,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double price){
        accessoryService.updateAccessory(accessoryID, type, price);
    }
}
