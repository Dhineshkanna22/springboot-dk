package com.dhineshkanna.dkgt.ServiceLayour;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhineshkanna.dkgt.Model.Address;
import com.dhineshkanna.dkgt.Model.Student;
import com.dhineshkanna.dkgt.Repository.AddressRepo;
import com.dhineshkanna.dkgt.Repository.StudentRepo;

@Service
public class AppService {
    @Autowired
    StudentRepo repoS;

    @Autowired
    AddressRepo repoA;

    public void SaveDetails() {
        // Students
        Student student1 = new Student(0, "Alice Johnson", 9876543210L);
        Student student2 = new Student(0, "Michael Smith", 9123456789L);
        // Addresses
        Address address1 = new Address(0, "21B Baker Street", "London", "England");
        Address address2 = new Address(0, "742 Evergreen Terrace", "Springfield", "Illinois");
        Address address3 = new Address(0, "1600 Pennsylvania Avenue", "Washington", "DC");
        Address address4 = new Address(0, "12 Grimmauld Place", "London", "England");
        
        student1.setAddresses(List.of(address1, address2));
        student2.setAddresses(List.of(address3, address4));

        address1.setStudent(student1);
        address2.setStudent(student1);
        address3.setStudent(student2);
        address4.setStudent(student2);

        repoS.save(student1);
        repoS.save(student2);
    }

    @Transactional
    public void getDetailsAdd() {
        System.out.println(repoS.findAll());
        System.out.println();
        System.out.println("*********");
        System.out.println(repoA.findById(3).get().getStudent()); 
    }
}
