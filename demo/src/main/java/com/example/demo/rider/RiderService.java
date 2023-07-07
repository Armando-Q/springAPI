package com.example.demo.rider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class RiderService {
    private List<Rider> riders;

    private final RiderRepository riderRepository;

    @Autowired
    public RiderService(RiderRepository riderRepository){
        this.riderRepository = riderRepository;
    }


    public List<Rider> getRiders() {
        return riderRepository.findAll();

    }

    public void addNewRider(Rider rider) {
        Optional<Rider> riderOptional = riderRepository
                .findRiderByFirstName(rider.getFirstName());
        if (riderOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        riderRepository.save(rider);

    }

    public void deleteRider(Long riderId) {
        boolean exists= riderRepository.existsById(riderId);
        if(!exists){
            throw new IllegalStateException(
                    "rider with id " + riderId + " does not exists");
        }
        riderRepository.deleteById(riderId);
    }

    public  Rider getARider(Long riderId){
        return riderRepository.findById(riderId).orElseThrow(()-> new IllegalStateException("Rider with this ID does not exist"));
    }
    @Transactional
    public void updateRider(Long riderID, String firstName, String lastName) {
        Rider rider = riderRepository.findById(riderID)
                .orElseThrow(()-> new IllegalStateException(
                        "rider with id " + riderID + " does not exist"));
        if(firstName != null && firstName.length()> 0 && !Objects.equals(rider.getFirstName(), firstName)){
            rider.setFirstName(firstName);
        }
        if(lastName != null && lastName.length()> 0 && !Objects.equals(rider.getLastName(),lastName)){
            Optional<Rider> riderOptional = riderRepository
                    .findRiderByLastName(lastName);
            if(riderOptional.isPresent()){
                throw new IllegalStateException("last name is taken");
            }
            rider.setLastName(lastName);
        }
    }


}
