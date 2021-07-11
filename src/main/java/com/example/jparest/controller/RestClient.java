package com.example.jparest.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.jparest.jpa.StudentEntity;

public class RestClient {
	private static final String GET_ALL_STUDENTS_API= "http://localhost:8080/api/getall";
	private static final String GET_STUDENT_BY_ID_API= "http://localhost:8080/api/id/{id}";
	private static final String CREATE_STUDENT_API= "http://localhost:8080/api/student";
	private static final String EDIT_STUDENT_API= "http://localhost:8080/api/student";
	private static final String DELETE_STUDENT_API= "http://localhost:8080/api/id/{id}";

	static RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args) {
		callGetAllStudentsAPI();
		callGetStudentByIdAPI();
		callCreateStudentAPI();
		callEditStudentAPI();

	}

	private static void callGetAllStudentsAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_STUDENTS_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);

	}
	private static void callGetStudentByIdAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 1);
		StudentEntity studentEntity = restTemplate.getForObject(GET_STUDENT_BY_ID_API, StudentEntity.class, param);
		System.out.println(studentEntity.getFirstname());
		System.out.println(studentEntity.getLastname());
		System.out.println(studentEntity.getEmail());
		System.out.println(studentEntity.getPhone());
		
	}
	private static void callCreateStudentAPI() {
		StudentEntity studentEntity = new StudentEntity("Ramesh","Nani","Ramn@gmail.com", "284-946-8965");
		ResponseEntity<StudentEntity> studententity = restTemplate.postForEntity(CREATE_STUDENT_API, studentEntity ,StudentEntity.class);
		System.out.println(studententity.getBody());
	}
	private static void callEditStudentAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 35);
		StudentEntity editStudent = new StudentEntity("Ram","Krishna","Ramk@gmail.com","404-858-9847");
		restTemplate.put(EDIT_STUDENT_API, editStudent, StudentEntity.class);
	}
	

}
