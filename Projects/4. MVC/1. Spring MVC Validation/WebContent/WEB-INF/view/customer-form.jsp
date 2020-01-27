<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>
<style>
.error{
	color:red;
}
</style>

</head>
<body>

<form:form action="processForm" modelAttribute = "customer">

First Name : <form:input path="firstName"/>
<br><br>

LastName (*): <form:input path="lastName"/>
<form:errors path = "lastName" cssClass="error" />
<br><br>


Free Passes : <form:input path="freePasses"/>
<form:errors path="freePasses" cssClass="error" />
<br> <br>

Postal code : <form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error" />
<br> <br>

Mobile Number : <form:input path="mobileNumber"/>
<form:errors path="mobileNumber" cssClass="error" />
<br> <br>

Reference Number : <form:input path="refNumber"/>
<form:errors path="refNumber" cssClass="error" />
<br> <br>


<input type="submit" value = "Submit" />

</form:form>

</body>
</html>