package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_address")
	private String address;
	@Column(name = "student_mobilenumber")
	private String mobileNumber;
	@Column(name = "student_rollnumber", unique = true)
	private String rollNumber;
	@Column(name = "student_password")
	private String password;

	public Student(Integer studentId, String studentName, String address, String mobileNumber, String rollNumber,
			String password) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.rollNumber = rollNumber;
		this.password = password;
	}

	public Student() {
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
