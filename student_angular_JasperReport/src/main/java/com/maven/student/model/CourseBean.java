package com.maven.student.model;

import javax.validation.constraints.NotEmpty;

public class CourseBean {
	@NotEmpty
   private String courseId;
	@NotEmpty
   private String courseName;
   
   public CourseBean() {
	   
   }
public CourseBean(String courseId, String courseName) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
}
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
   
   
   
}
