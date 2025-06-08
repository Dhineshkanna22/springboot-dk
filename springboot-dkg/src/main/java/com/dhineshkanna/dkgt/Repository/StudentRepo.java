package com.dhineshkanna.dkgt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhineshkanna.dkgt.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{ 
}
