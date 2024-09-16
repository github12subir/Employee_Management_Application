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
	
	<form action="add_employee" method="post">
		<pre>
		Name<input type="text" name="name"/>
		EmailId<input type="text" name="email"/>
		PhNumber<input type="text" name="phnumber"/>
		Salary<input type="text" name="salary"/>
		<input type="submit" value="save"/>
		</pre>
	</form>
	${msg}

</body>
</html>