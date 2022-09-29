package com.maven.student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="user_id")
	private String userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="user_password")
	private String userPassword;
//	@Transient
	@Column(name="user_confirmpassword")
	private String userConfirmpassword;
	@Column(name="user_role")
	private String userRole;
	
	public User() {
		
	}
	public User(String userId, String userName,String userEmail, String userPassword, String userConfirmpassword, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail=userEmail;
		this.userPassword = userPassword;
		this.userConfirmpassword = userConfirmpassword;
		this.userRole = userRole;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserConfirmpassword() {
		return userConfirmpassword;
	}
	public void setUserConfirmpassword(String userConfirmpassword) {
		this.userConfirmpassword = userConfirmpassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
