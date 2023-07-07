package com.example.demo.accessory;

import com.example.demo.accessory.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory,Long> {


    @Query("SELECT a FROM Accessory a  WHERE a.type = ?1")
    Optional<Accessory> findAccessoryByType(String type);

    Optional<Accessory> findAccessoryByPrice(Double price);
}
