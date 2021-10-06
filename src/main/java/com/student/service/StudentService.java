package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {

	String createStudentData(Student student) throws Exception;

	Student getStudentDataById(Integer studentId) throws Exception;

	List<Student> getAllStudents() throws Exception;

	Student getStudentByRollNumAndPassword(String rollNumber, String password) throws Exception;

	Student getStudentDataByName(String studentName) throws Exception;

	Student updateStudent(Student student) throws Exception;

	void updateStudentName(Integer studentId, String studentName) throws Exception;

	String deleteStudentDataById(Integer studentId) throws Exception;

}
