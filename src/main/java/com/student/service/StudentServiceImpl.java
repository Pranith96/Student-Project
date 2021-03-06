package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.student.Exception.StudentNotFoundException;
import com.student.entity.Status;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
@Transactional
@Profile(value = { "local", "dev", "prod" })
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public String createStudentData(Student student) throws Exception {
		student.getAddressEntity().setStudent(student);
		student.setStatus(Status.ACTIVE);
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
		List<Student> response = repository.findAll().stream().filter(data -> data.getStatus().equals(Status.ACTIVE))
				.collect(Collectors.toList());
		if (response.isEmpty() || response == null) {
			throw new Exception("Student Data is Empty");
		}
		return response;
	}

	@Override
	public Student getStudentByRollNumAndPassword(String rollNumber, String password) throws StudentNotFoundException {
		Optional<Student> studentResponse = repository.findByRollNumberAndPassword(rollNumber, password);
		if (!studentResponse.isPresent()) {
			throw new StudentNotFoundException("Student Data not found");
		}
		return studentResponse.get();
	}

	@Override
	public Student getStudentDataByName(String studentName) throws StudentNotFoundException {
		// Optional<Student> studentResponse =
		// repository.findByStudentName(studentName);
		Optional<Student> studentResponse = repository.getByStudentName(studentName);
		if (!studentResponse.isPresent()) {
			throw new StudentNotFoundException("Student Data not found");
		}
		return studentResponse.get();
	}

	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException {
		Optional<Student> response = repository.findById(student.getStudentId());
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student Id doesnt exists");
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
	public void updateStudentName(Integer studentId, String studentName) throws StudentNotFoundException {

		Optional<Student> response = repository.findById(studentId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Data not found");
		}
		repository.updateStudentName(studentName, studentId);
	}

	@Override
	public String deleteStudentDataById(Integer studentId) throws StudentNotFoundException {
		Optional<Student> response = repository.findById(studentId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Data not found");
		}
		repository.deleteById(studentId);
		return "Deleted successfully";
	}

}
