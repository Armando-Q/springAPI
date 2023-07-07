package com.example.demo.rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long> {


    @Query("SELECT r FROM Rider r  WHERE r.firstName = ?1")
    Optional<Rider> findRiderByFirstName(String firstName);


    Optional<Rider> findRiderByLastName(String lastName);
}


