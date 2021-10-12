package com.student.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "student_table")
@ApiModel(description = "Details About the Student Registration")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The primary key Student Id Number")
	private Integer studentId;
	@Column(name = "student_name")
	@ApiModelProperty(notes = "The Student name")
	private String studentName;
	@Column(name = "student_address")
	@ApiModelProperty(notes = "Address details")
	private String address;
	@Column(name = "student_mobilenumber")
	@ApiModelProperty(notes = "Student mobile number")
	private String mobileNumber;
	@Column(name = "student_rollnumber", unique = true)
	@ApiModelProperty(notes = "The Unique student roll number")
	private String rollNumber;
	@Column(name = "student_password")
	@ApiModelProperty(notes = "The student password")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address addressEntity;

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

	public Address getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(Address addressEntity) {
		this.addressEntity = addressEntity;
	}

}
