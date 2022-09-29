package com.maven.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maven.student.dto.Student;

public interface StudentRepository  extends JpaRepository<Student, String>{
	@Query(value="select * from student where student_id=:id or student_name=:name or student_course=:course",nativeQuery = true)
    List<Student> searchStudent(@Param("id") String studentid, @Param("name") String studentname, @Param("course") String studentcourse);
    
	Student findBystudentId(String studentId);
}
