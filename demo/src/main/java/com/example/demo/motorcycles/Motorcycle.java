package com.example.demo.motorcycles;


import com.example.demo.accessory.Accessory;
import com.example.demo.rider.Rider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table
public class Motorcycle {
    @Id
    @SequenceGenerator(
            name="motorcycle_sequence",
            sequenceName = "motorcycle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "motorcycle_sequence"
    )
    private Long id;

   // @JsonIgnore
    @ManyToMany()
    @JoinTable(
            name="mutual_riders",
            joinColumns = @JoinColumn(name = "rider_id"),
            inverseJoinColumns = @JoinColumn(name = "motorcycle_id")
    )
    private Set<Rider> riders = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "motorcycle_id")
    private Set<Accessory> accessories = new HashSet<>();


    private String make;
    private String model;
    private Integer year;
    private Double mileage;

    public Motorcycle(){

    }

    public Motorcycle(Long id, String make, String model, Integer year, Double mileage){
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public Motorcycle(String make, String model, Integer year, Double mileage){
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getMake(){
        return make;
    }
    public void setMake(String make){
        this.make = make;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model=model;
    }
    public Integer getYear(){
        return year;
    }
    public void setYear(Integer year){
        this.year = year;
    }
    public Double getMileage(){
        return mileage;
    }
    public void  setMileage(Double mileage){
        this.mileage = mileage;
    }

    @Override
    public String toString(){
        return "Motorcycle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\''+
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }
    public Set<Rider> getRiders(){
        return riders;
    }

    public void addRider(Rider rider){
        this.riders.add(rider);
    }

    public void addAccessory(Accessory accessory){
        this.accessories.add(accessory);
    }


}
