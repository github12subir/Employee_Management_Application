<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List Employee Page</h2>
	<table border=1>
		<tr>
		<th>Name</th>
		<th>Email</th>
		<th>PhNumber</th>
		<th>Salary</th>
		<th>Delete</th>
		<th>Update</th>
		</tr>

			<c:forEach items="${allEmployees}" var="emp">
	        	<tr>
		        	<td>${emp.name}</td>
					<td>${emp.email}</td>
					<td>${emp.phnumber}</td>
					<td>${emp.salary}</td>
					<td><a href=delete?id=${emp.id}>delete</a></td>
					<td><a href=update?id=${emp.id}>update</a></td>
				</tr>
          </c:forEach>
				
	</table>
	${msg}
</body>
</html>