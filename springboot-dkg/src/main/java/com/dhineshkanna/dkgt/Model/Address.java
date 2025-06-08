package com.dhineshkanna.dkgt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String houseDetails;
    private String city;
    private String state;

    public Address(int addressId, String houseDetails, String city, String state){
        this.addressId = addressId;
        this.houseDetails = houseDetails;
        this.city = city;
        this.state = state;
    }

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "student_id")
    Student student;
}