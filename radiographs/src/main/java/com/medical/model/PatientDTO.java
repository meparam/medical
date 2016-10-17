package com.medical.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public final class PatientDTO {

    private String ssn;

    private String name;
    
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
       
	@Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ssn", this.ssn)
                .append("name", this.name)
                .append("dob", this.dob)                              
                .toString();
    }
}