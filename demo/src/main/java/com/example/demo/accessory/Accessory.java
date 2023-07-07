package com.example.demo.accessory;


import com.example.demo.motorcycles.Motorcycle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class Accessory {
    @Id
    @SequenceGenerator(
            name = "accessory_sequence",
            sequenceName = "accessory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accessory_sequence"
    )

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "motorcycleId", insertable = false, updatable = false)
    private Motorcycle motorcycle;

    private Long id;
    private String type;
    private Double price;

    public Accessory(){

    }

    public Accessory(Long id, String type, Double price){
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Accessory(String type, Double price){
        this.type = type;
        this.price = price;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getType(){return type;}
    public void setType(String type){
        this.type = type;

    }
    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}


    @Override
    public String toString(){
        return "Accessory{" +
                "id=" + id +
                "type=" + type + '\''+
                "price=" + price +
                '}';

    }

}
