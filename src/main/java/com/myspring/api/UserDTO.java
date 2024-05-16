package com.myspring.api;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//DTO stand for Data Transfer Object
public class UserDTO {
	

	@NotBlank(message = "user name canot been Blank")
	@Size(min=3 ,max = 15, message ="your name should have char between 3-15")
	private String userName = "th euser NAMe default value";
	
	@NotBlank(message = "crush name canot been Blank")
	@Size(min=3 ,max = 15, message ="your crush should have char between 3-15")
	private String crushName = " default crush name";
	
//	@AssertTrue(message="afree to use our app")
//	private boolean termAndCondition;
//	
//	public boolean isTermAndCondition() {
//		return termAndCondition;
//	}
//	public void setTermAndCondition(boolean termAndCondition) {
//		this.termAndCondition = termAndCondition;
//	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", crushName=" + crushName + "]";
	}
	
	
}
