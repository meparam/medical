CREATE TABLE user_details 
(
	user_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	name VARCHAR(200) NOT NULL,
	password VARCHAR(100) NOT NULL, 	
	PRIMARY KEY (user_name),
	CONSTRAINT unique_user_details_email UNIQUE (email)
);

CREATE TABLE patient
(
	ssn VARCHAR(25) NOT NULL,
	name VARCHAR(200) NOT NULL,
	dob DATE,
	PRIMARY KEY (ssn)
);

CREATE TABLE radiograph
(
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(100) NOT NULL,
	ssn VARCHAR(25) NOT NULL,
    reason VARCHAR(500) NOT NULL,
	description VARCHAR(500) NOT NULL,	
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	FOREIGN KEY (user_name) REFERENCES user_details(user_name),
	FOREIGN KEY (ssn) REFERENCES patient(ssn)
);