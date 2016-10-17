package com.medical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public final class User {
	
	// explicit constructor required for hibernate
	public User(){}

    @Id
    @Column(name = "userName", nullable = false, length = 100)
    private String userName;
    
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Column(name = "email", nullable = false, length = 100)
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

    
}