package com.maven.student.model;

import javax.validation.constraints.NotEmpty;

public class StudentBean {
	@NotEmpty
    private String studentId;
	@NotEmpty
    private String studentName;
	@NotEmpty
    private String studentDob;
	@NotEmpty
    private String studentGender;
	@NotEmpty
    private String studentEducation;
	@NotEmpty
    private String studentPhone;
	@NotEmpty
    private String studentCourse;
    
    public StudentBean() {
    	
    }
	public StudentBean(String studentId, String studentName, String studentDob, String studentGender,
			String studentEducation, String studentPhone, String studentCourse) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentGender = studentGender;
		this.studentEducation = studentEducation;
		this.studentPhone = studentPhone;
		this.studentCourse = studentCourse;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentDob() {
		return studentDob;
	}
	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public String getStudentEducation() {
		return studentEducation;
	}
	public void setStudentEducation(String studentEducation) {
		this.studentEducation = studentEducation;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
    
}
