package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
