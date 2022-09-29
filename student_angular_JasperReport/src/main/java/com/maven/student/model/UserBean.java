package com.maven.student.model;

import javax.validation.constraints.NotEmpty;

public class UserBean {
	@NotEmpty
	private String userId;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String userEmail;
	@NotEmpty
	private String userPassword;
	@NotEmpty
	private String userConfirmpassword;
	@NotEmpty
	private String userRole;
	
	public UserBean() {
		
	}
	public UserBean(String userId, String userName,String userEmail, String userPassword, String userConfirmpassword, String userRole) {
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
