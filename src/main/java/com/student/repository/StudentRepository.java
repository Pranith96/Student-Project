package com.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.entity.Status;
import com.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Student> findByRollNumberAndPassword(String rollNumber, String password);

	// JPA query
	// Optional<Student> findByStudentName(String studentName);

	// NATIVE SQL
	// @Query(value = "select * from student_table where student_name =
	// :studentName", nativeQuery = true)
	// Optional<Student> getByStudentName(@Param("studentName") String studentName);

	// JPQL
	//@Query("select s from Student s where s.studentName = ?1 and s.password = ?2")
	//Optional<Student> getByStudentName(@Param("studentName") String studentName,@Param("password") String password);
		
	// JPQL
	@Query("select s from Student s where s.studentName = :studentName")
	Optional<Student> getByStudentName(@Param("studentName") String studentName);

	@Modifying
	@Query("update Student set studentName =:studentName where studentId = :studentId")
	void updateStudentName(@Param("studentName") String studentName, @Param("studentId") Integer studentId);
}
