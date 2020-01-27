<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer confirm</title>
</head>
<body>
The Customer is confirmed 
<br><br>
	${customer.firstName} ${customer.lastName}
	
<br><br>

Allowed Free passes : ${customer.freePasses}
	
	<br><br>
	
Postal Code : ${customer.postalCode}
<br><br>
	
Phone Number : ${customer.mobileNumber}

<br><br>
	
Reference Number : ${customer.refNumber}

<br><br>	
</body>
</html>