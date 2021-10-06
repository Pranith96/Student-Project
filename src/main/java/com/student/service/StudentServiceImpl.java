package com.student.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Exception.StudentNotFoundException;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public String createStudentData(Student student) throws Exception {
		Student studentResponse = repository.save(student);
		if (studentResponse == null) {
			throw new Exception("Student data not saved");
		}
		return "Student Data successfully saved";
	}

	@Override
	public Student getStudentDataById(Integer studentId) throws StudentNotFoundException {
		Optional<Student> studentResponse = repository.findById(studentId);
		if (!studentResponse.isPresent()) {
			throw new StudentNotFoundException("Student Data not found");
		}
		return studentResponse.get();
	}

	@Override
	public List<Student> getAllStudents() throws Exception {
		List<Student> response = repository.findAll();
		if (response.isEmpty() || response == null) {
			throw new Exception("Student Data is Empty");
		}
		return response;
	}

	@Override
	public Student getStudentByRollNumAndPassword(String rollNumber, String password) throws Exception {
		Optional<Student> studentResponse = repository.findByRollNumberAndPassword(rollNumber, password);
		if (!studentResponse.isPresent()) {
			throw new Exception("Student Data not found");
		}
		return studentResponse.get();
	}

	@Override
	public Student getStudentDataByName(String studentName) throws Exception {
		// Optional<Student> studentResponse =
		// repository.findByStudentName(studentName);
		Optional<Student> studentResponse = repository.getByStudentName(studentName);
		if (!studentResponse.isPresent()) {
			throw new Exception("Student Data not found");
		}
		return studentResponse.get();
	}

	@Override
	public Student updateStudent(Student student) throws Exception {
		Optional<Student> response = repository.findById(student.getStudentId());
		if (!response.isPresent()) {
			throw new Exception("Student Id doesnt exists");
		}

		response.get().setStudentId(student.getStudentId());
		if (student.getStudentName() != null) {
			response.get().setStudentName(student.getStudentName());
		}
		if (student.getAddress() != null) {
			response.get().setAddress(student.getAddress());
		}
		if (student.getMobileNumber() != null) {
			response.get().setMobileNumber(student.getMobileNumber());
		}
		if (student.getRollNumber() != null) {
			response.get().setRollNumber(student.getRollNumber());
		}
		if (student.getPassword() != null) {
			response.get().setPassword(student.getPassword());
		}

		Student updatedResponse = repository.save(response.get());
		return updatedResponse;
	}

	@Override
	public void updateStudentName(Integer studentId, String studentName) throws Exception {

		Optional<Student> response = repository.findById(studentId);
        if (!response.isPresent()) {
            throw new Exception("Data not found");
        }
         repository.updateStudentName(studentName,studentId);
	}

	@Override
	public String deleteStudentDataById(Integer studentId) throws Exception {
		Optional<Student> response = repository.findById(studentId);
        if (!response.isPresent()) {
            throw new Exception("Data not found");
        }		
        repository.deleteById(studentId);
        return "Deleted successfully";
	}

}
