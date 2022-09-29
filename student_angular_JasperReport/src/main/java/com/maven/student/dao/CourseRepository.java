package com.maven.student.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.maven.student.dto.Course;

public interface CourseRepository extends JpaRepository<Course,String> {
//	Course findByCourseId(String courseId);

}
