package com.student.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Student Data doesnot exists in System")
public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public StudentNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
