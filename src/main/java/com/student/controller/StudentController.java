package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/student/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student) throws Exception {
		String response = studentService.createStudentData(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/student/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer StudentId) throws Exception {
		Student response = studentService.getStudentDataById(StudentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/students")
	public ResponseEntity<List<Student>> getAllStudents() throws Exception {
		List<Student> response = studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/student")
	public ResponseEntity<Student> getStudentById(@RequestParam("rollNumber") String rollNumber,
			@RequestParam("password") String password) throws Exception {
		Student response = studentService.getStudentByRollNumAndPassword(rollNumber, password);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/student/name/{studentName}")
	public ResponseEntity<Student> getStudentByName(@PathVariable("studentName") String studentName) throws Exception {
		Student response = studentService.getStudentDataByName(studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/update/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws Exception {
		Student response = studentService.updateStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/update/student/{studentId}/{studentName}")
	public ResponseEntity<String> updateStudentName(@PathVariable("studentId") Integer studentId, @PathVariable("studentName") String studentName)
			throws Exception {
		studentService.updateStudentName(studentId, studentName);
		return ResponseEntity.status(HttpStatus.OK).body("updated student name");
	}
	
	@DeleteMapping("/delete/student/{studentId}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") Integer StudentId) throws Exception {
		String response = studentService.deleteStudentDataById(StudentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	} 
}
