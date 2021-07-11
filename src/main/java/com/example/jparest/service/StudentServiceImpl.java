package com.example.jparest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jparest.jpa.StudentEntity;
import com.example.jparest.jpa.StudentRepository;

@Service()
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public List<StudentEntity> getAllStudents() {
		// TODO Auto-generated method stub
    	return studentRepository.findAll();
    	
	}
	@Override
	public Optional<StudentEntity> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
		
		
	}
	@Override
	public StudentEntity createStudent(StudentEntity studentEntity) throws Exception {
    	return studentRepository.save(studentEntity);
    	
	}
	@Override
	public StudentEntity editStudent(StudentEntity studentEntity) throws Exception {
		return  studentRepository.save(studentEntity);
    	 
	}
	@Override
	public String deleteStudent(Long id) throws Exception {
	         studentRepository.deleteById(id);
		return "Id"  + " " +id + " is Deleted" ;
	}
	
	

}
