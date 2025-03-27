package com.app.service;

import java.util.List;

import com.app.pojos.Student;

public interface StudentService {
	
	public List<Student>getAllStudents();
	
	public Student saveStudents(Student student);
	
	public Student updateStudents(Integer id);

	public void deleteStudent(Integer id);
}
