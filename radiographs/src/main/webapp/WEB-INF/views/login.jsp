<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<div align="center">
			<h2>Login</h2>
			<div style="color:red">${message}</div>
			<form:form id="loginForm" method="post" action="login" commandName="loginCommand">
				<table border="0">
					<tr>
						<td><label>Please enter User Name</label>
						<td><form:input id="username" path="userName" /><br>
					</tr>
					<tr>
						<td><label>Please enter your Password</label>
						<td><form:password id="password" path="password" /><br>
					<tr>
					<tr>
						<td colspan="2"><input type="submit" value="Login" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</body>
</html>