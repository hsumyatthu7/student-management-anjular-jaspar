package com.maven.student.model;

import javax.validation.constraints.NotEmpty;

public class LoginBean {
	@NotEmpty
    private String loginId;
	@NotEmpty
    private String loginPassword;
    public LoginBean() {
    	
    }
    
	public LoginBean(String loginId, String loginPassword) {
		super();
		this.loginId = loginId;
		this.loginPassword = loginPassword;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
    
    
}
