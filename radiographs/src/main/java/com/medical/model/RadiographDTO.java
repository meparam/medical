package com.medical.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public final class RadiographDTO {
	
	private Long id;
	
	private UserDTO userDTO;
	
	private PatientDTO patientDTO;
	
	private String userName;
	
	private String ssn;
	
	private String desc;
	
	private String reason;
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public PatientDTO getPatientDTO() {
		return patientDTO;
	}

	public void setPatientDTO(PatientDTO patientDTO) {
		this.patientDTO = patientDTO;
	}	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}	
	
	@Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userDTO", this.userDTO)
                .append("patientDTO", this.patientDTO)
                .append("userName", this.userName)                              
                .append("ssn", this.ssn)
                .append("desc", this.desc)                              
                .append("reason", this.reason)
                .toString();
    }
       
}