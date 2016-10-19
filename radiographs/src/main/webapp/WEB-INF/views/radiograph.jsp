<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Radiograph</title>

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
            	<tr><td><a href="radiographs">Radiographs</a></td></tr>
            	<tr><td><a href="patients">Patients</a></td></tr>
            	<tr><td><a href="createPatient">Add Patient</a></td></tr>
            	<tr><td><a href="logout">Logout</a></td></tr>
                <tr>
                    <td colspan="2" align="center"><h2>Radiograph Registration Form</h2></td>
                </tr>
                <tr><td><div><strong>${message}</strong></div></td></tr>
                                
                <form:form action="saveRadiograph" method="post" commandName="radiographCommand">
                	<tr>
                		<td colspan="2" align="center"><form:errors path="*" cssClass="errorblock" element="div" /></td>
                	</tr>
	                <tr>
	                    <td>Select Patient :</td>
	                    <td>
	                    	<form:select path="ssn">
							  <form:option value="0" label="--- Select ---" />
							  <form:options items="${patients}" itemValue="ssn" itemLabel="name" />
						    </form:select>
	                    </td>
	                    <td><form:errors path="ssn" cssClass="error" /></td>
	                </tr>
	                <tr>
	                    <td>Description : </td>
	                    <td><form:input path="desc" /></td>
	                    <td><form:errors path="desc" cssClass="error" /></td>
	                </tr>
	                <tr>
	                    <td>Reason : </td>
	                    <td><form:input path="reason" /></td>
	                    <td><form:errors path="reason" cssClass="error" /></td>
	                </tr>
	                                
	                <tr>
	                	<form:hidden path="userName" value="${sessionScope.userName}"/>
	                    <td colspan="2" align="center"><input type="submit" value="Save" /></td>
	                </tr>
                </form:form>
            </table>
        
    </div>
</body>
</html>