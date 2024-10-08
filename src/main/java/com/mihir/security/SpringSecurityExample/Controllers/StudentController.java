package com.mihir.security.SpringSecurityExample.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mihir.security.SpringSecurityExample.Model.StudentModel;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	List<StudentModel> students = new ArrayList<>(List.of(
			new StudentModel(1,"mihir",60),
			new StudentModel(2,"Jain",27)
			));
	
	
	@GetMapping("/getstudents")
	public List<StudentModel> getStudents(){
		return students;
	}
	
	
	
	// for post we need CSRF token
	@PostMapping("/addstudents")
	public StudentModel addStudents(@RequestBody StudentModel student) {
		students.add(student);
		return student;
	}
	
	@GetMapping("/getcsrftoken")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
	
	
}
