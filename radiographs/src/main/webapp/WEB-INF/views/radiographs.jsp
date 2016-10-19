<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<div align="center">
	<table>
		<tr><td><a href="createPatient">Add Patient</a></td></tr>
		<tr><td><a href="createRadiograph">Register Radiograph</a></td></tr>
		<tr><td><a href="patients">Patients</a></td></tr>
		<tr><td><a href="logout">Logout</a></td></tr>
	</table>
	
	<h2>Radiographs</h2>
	
	<div><strong>${message}</strong></div>

	<c:if test="${empty radiographs}">
		No Record Found
	</c:if>
	<c:if test="${not empty radiographs}">

		<table>
			<tr>
				<th>Patient Name</th><th>Social Security ID</th><th>Doctor Name</th><th>Description</th><th>Reason</th>
			</tr>
			<c:forEach var="radiograph" items="${radiographs}">
				<tr>
					<td>${radiograph.patientDTO.name}</td>
					<td>${radiograph.patientDTO.ssn}</td>
					<td>${radiograph.userDTO.name}</td>
					<td>${radiograph.desc}</td>
					<td>${radiograph.reason}</td>					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
</body>
</html>