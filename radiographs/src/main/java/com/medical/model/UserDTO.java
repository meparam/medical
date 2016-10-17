package com.medical.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public final class UserDTO {

	public UserDTO(){}

    private String userName;

    private String password;
    
    private String name;
    
    private String email;
    
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userName", this.userName)
                .append("name", this.name)
                .append("email", this.email)                              
                .toString();
    }
    
}