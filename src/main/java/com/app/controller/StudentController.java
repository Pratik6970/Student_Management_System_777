package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.app.pojos.Student;
import com.app.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	public StudentController() {
		System.out.println("StudentController called here"+getClass().getName());
	}
	
	@GetMapping("/homePage")
	public String HomePage()
	{
	    System.out.println("Home Page called here"+getClass().getName());
	    
	    return "home";
	}
	
	@GetMapping("/getStudent")
	public String getAllStudents(Model map)
	{
		map.addAttribute("student", service.getAllStudents());
		
		return "studentPage";
	}
	
	@GetMapping("/students/new")
	public String create_Students(Model map)
	{
		Student student = new Student();
		
		map.addAttribute("AddStudent", student);
		return "create-student";
	}
	
	@PostMapping("/postStudent")
	public String saveStudent(@ModelAttribute("AddStudent") Student student)
	{
		Student std2 =service.saveStudents(student);
		System.out.println(std2);
		
		return "redirect:/getStudent";
	}
	
	@GetMapping("/students/update/{id}")
	public String getupdate_Students(@PathVariable Integer id,Model map)
	{
		
		map.addAttribute("updateStudent", service.updateStudents(id));
		return "update_Student";
	}
	
	@PostMapping("/students/update/{id}")
	public String update_Student_form(@PathVariable Integer id, @ModelAttribute("updateStudent") Student student)
	{
		Student existingStudent = service.updateStudents(id);
		System.out.println("ExistingStudents = "+existingStudent);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		 Student saved=this.service.saveStudents(existingStudent);
		System.out.println("UpdateStudent = "+saved);
		return "redirect:/getStudent";
	}
	
	@GetMapping("/students/delete/{id}")
	public String delete_Students(@PathVariable Integer id)
	{
	   service.deleteStudent(id);
		
		System.out.println("Deleted Students here"+getClass().getName());
		
		return "redirect:/getStudent";
		
	
	}
	
	@GetMapping("/logout")
	public String logout() {
		// Optional: Clear session or authentication logic if necessary
		return "logout";  // Return to the logout.html page
	}
	
	

}
