<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring rest Demo</title>
</head>
<body>
<h1>Spring rest demo</h1>

<h3>Available Api's</h3>

<a href="${pageContext.request.contextPath}/test/hello">Hello 	-> 		plain text</a>
<a href="${pageContext.request.contextPath}/api/students">StudentList 	-> 		json</a>

</body>
</html>