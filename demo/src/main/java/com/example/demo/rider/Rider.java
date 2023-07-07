package com.example.demo.rider;


import com.example.demo.motorcycles.Motorcycle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.Set;


@Entity
@Table
public class Rider {
    @Id
    @SequenceGenerator(
            name="rider_sequence",
            sequenceName = "rider_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rider_sequence"
    )
    private Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "riders")
    private Set<Motorcycle> motorcycles;



    private String firstName;
    private String lastName;
    private String experience;
    private Integer age;

    public Rider(){

    }

    public Rider(Long id, String firstName, String lastName, String experience, Integer age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        this.age = age;
    }

    public Rider(String firstName, String lastName, String experience, Integer age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        this.age = age;
    }



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getExperience(){
        return experience;
    }
    public void setExperience(String experience){
        this.experience = experience;
    }
    public Integer getAge(){
        return age;
    }
    public void  setAge(Integer age){
        this.age = age;
    }


//    public void Set<Motorcycle> getMotorcycles(){
//        return motorcycles;
//    }


//    public void assignRiderToMotorcycle(Motorcycle motorcycle){
//        motorcycle.add(motorcycle);
//    }

    @Override
    public String toString(){
        return "Rider{" +
                "id=" + id +
                ", first name ='" + firstName + '\'' +
                ", last name ='" + lastName + '\''+
                ", experience=" + experience +
                ", age=" + age +
                '}';
    }



}
