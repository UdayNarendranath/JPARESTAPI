package com.example.jparest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jparest.jpa.StudentEntity;
import com.example.jparest.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping(value="/getall", produces = ("application/json"))
	@ResponseStatus(HttpStatus.OK)
	public List<StudentEntity> getAllStudents() throws Exception{
		return studentService.getAllStudents();
		
	}
	@GetMapping(value="/id/{id}", produces = ("application/json"))
	@ResponseStatus(HttpStatus.OK)
	public Optional<StudentEntity> getStudentById(@PathVariable("id") Long id) throws Exception{
    	return studentService.findById(id);
 
	}
	
	@PutMapping(value="student", produces = ("application/json"))
	@ResponseStatus(HttpStatus.OK)
	public StudentEntity EditStudent(@RequestBody StudentEntity studentEntity) throws Exception {
    	return studentService.editStudent(studentEntity);
    		}
	@PostMapping(value="student",  produces = ("application/json"))
	@ResponseStatus(HttpStatus.OK)
	public StudentEntity CreateStudent(@RequestBody StudentEntity studentEntity) throws Exception {
    	 return studentService.createStudent(studentEntity);
	}
	@DeleteMapping(value="/id/{id}", produces = ("application/json"))
	@ResponseStatus(HttpStatus.OK)
	public String deleteStudent(@PathVariable("id") Long id) throws Exception {
    	String list = studentService.deleteStudent(id);
    	return list;
	}
}
