<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registration</title>
	<style>
		.error {
			color: #ff0000;
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
</head>
<body>
    <div align="center">    	
        
            <table border="0">
            	<tr><td><a href="patients">Patients</a></td></tr>
            	<tr><td><a href="radiographs">Radiographs</a></td></tr>            	
            	<tr><td><a href="logout">Logout</a></td></tr>
                <tr>
                    <td colspan="3" align="center"><h2>Patient Registration Form</h2></td>
                </tr>
                <tr>
                	<td colspan="3" align="center" style="color:red"><div><strong>${message}</strong></div></td>
                </tr>
                <form:form action="savePatient" method="post" commandName="patientCommand">
                	<tr>
                		<td colspan="3" align="center"><form:errors path="*" cssClass="errorblock" element="div" /></td>
                	</tr>
	                <tr>
	                    <td>Social Security ID :</td>
	                    <td><form:input path="ssn" /></td>
	                    <td><form:errors path="ssn" cssClass="error" /></td>
	                </tr>
	                <tr>
	                    <td>Name : </td>
	                    <td><form:input path="name" /></td>
	                    <td><form:errors path="name" cssClass="error" /></td>
	                </tr>
	                                
	                <tr>
	                    <td colspan="3" align="center"><input type="submit" value="Save" /></td>
	                </tr>
                </form:form>
            </table>
        
    </div>
</body>
</html>