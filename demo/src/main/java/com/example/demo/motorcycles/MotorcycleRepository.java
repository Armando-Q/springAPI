package com.example.demo.motorcycles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle,Long> {


    @Query("SELECT m FROM Motorcycle m  WHERE m.model = ?1")
    Optional<Motorcycle> findMotorcycleByModel(String model);
}


