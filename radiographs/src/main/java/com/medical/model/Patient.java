package com.medical.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public final class Patient {

	// explicit constructor required for hibernate
	public Patient(){}
	
    @Id
    @Column(name = "ssn", nullable = false, length = 25)
    private String ssn;
        
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Column(name = "dob", nullable = true)
    private Date dob;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
       
}