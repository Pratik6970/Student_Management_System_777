package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Student;
import com.app.repo.StudentRepository;

@Service
public class StduentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository stdRepo;
	
	public StduentServiceImpl() {
		System.out.println("StudentServiceImpl called here"+getClass().getName());
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = this.stdRepo.findAll();
		System.out.println("Students = "+students);
		return students;
	}

	@Override
	public Student saveStudents(Student student) {
		Student std = this.stdRepo.save(student);
		System.out.println("Post_Students = "+std);
		return  std;
	}

	@Override
	public Student updateStudents(Integer id) {
		
		System.out.println("UpdateStudent called here"+getClass().getName());
		
		Student updadateStudent = this.stdRepo.findById(id).get();
		
		System.out.println("UpdateStudents = "+updadateStudent);
		
		return updadateStudent;
	}

	@Override
	public void deleteStudent(Integer id) {
		
		System.out.println("Deleted Students Here"+getClass().getName());
		
		 this.stdRepo.deleteById(id);
		 
		 System.out.println("Deleted Student Succesfully here");
		
	}
	
	

}
