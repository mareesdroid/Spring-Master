<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>Home</h1>
<hr>
<!-- Display username and role -->
<p>
	User: <security:authentication property="principal.username" />
	<br><br>
	Role(s): <security:authentication property="principal.authorities" />
</p>
<hr>
<security:authorize access="hasRole('MANAGER')">
<!-- Add a link to point to /leaders .......managers only-->
<p>
	<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
</p>

</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<!-- Add a link to point to /system .......admin only-->
<p>
	<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
</p>
</security:authorize>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout"/>
</form:form>
</body>
</html>