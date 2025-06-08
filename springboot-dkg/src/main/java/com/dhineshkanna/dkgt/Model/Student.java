package com.dhineshkanna.dkgt.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private Long mobile;

    public Student(int studentId, String name, Long mobile){
        this.studentId = studentId;
        this.name = name;
        this.mobile = mobile;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addresses;
}