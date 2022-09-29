package com.maven.student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="student_id")
    private String studentId;
	@Column(name="student_name")
    private String studentName;
	@Column(name="student_Dob")
    private String studentDob;
	@Column(name="student_Gender")
    private String studentGender;
	@Column(name="student_Education")
    private String studentEducation;
	@Column(name="student_Phone")
    private String studentPhone;
	
//	@ManyToMany
//	@JoinTable(
//			name="student_course",
//			joinColumns=@JoinColumn(name="student_id"),
//			inverseJoinColumns=@JoinColumn(name="course_id")
//			)
//	
	@Column(name="student_Course")
    private String studentCourse;
	
	
	
	public Student(String studentId, String studentName, String studentDob, String studentGender,
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
    public Student() {
    	
    }

	
}
