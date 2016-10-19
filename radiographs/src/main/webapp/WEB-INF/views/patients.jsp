<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<div align="center">
		
		<table border="0">	
			<tr><td><a href="createPatient">Add Patient</a></td></tr>
			<tr><td><a href="radiographs">Radiographs</a></td></tr>
			<tr><td><a href="createRadiograph">Register Radiograph</a></td></tr>
		</table>
		
		</br>
		
		<h2>Patients</h2>
		
		<div><strong>${message}</strong></div>
	
		<c:if test="${empty patients}">
			No Record Found
		</c:if>
		<c:if test="${not empty patients}">
	
			<table>
				<tr>
					<th>Secial Security ID</th><th>Name</th>
				</tr>
				<c:forEach var="patient" items="${patients}">
					<tr>
						<td>${patient.ssn}</td>
						<td>${patient.name}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>