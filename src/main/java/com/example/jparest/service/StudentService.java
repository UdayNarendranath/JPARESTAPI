package com.example.jparest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.Optional;
import com.example.jparest.jpa.StudentEntity;

@Service
public interface StudentService {
	public List<StudentEntity> getAllStudents();
	public Optional<StudentEntity> findById(Long id) throws Exception;
	public StudentEntity editStudent(StudentEntity studentEntity) throws Exception;
	public String deleteStudent(Long id) throws Exception;
	public StudentEntity createStudent(StudentEntity studentEntity) throws Exception;
}