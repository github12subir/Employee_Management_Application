<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Record</title>
</head>
<body>
	<h2>Update Your Record</h2>
	<form action="update_employee" method="post">
		<pre>
		<input type="hidden" name="id" value="${emp.id}"/>
		Name<input type="text" name="name" value="${emp.name}"/>
		EmailId<input type="text" name="email" value="${emp.email}"/>
		PhNumber<input type="text" name="phnumber" value="${emp.phnumber}"/>
		Salary<input type="text" name="salary" value="${emp.salary}"/>
		<input type="submit" value="Update"/>
		</pre>
	</form>
</body>
</html>