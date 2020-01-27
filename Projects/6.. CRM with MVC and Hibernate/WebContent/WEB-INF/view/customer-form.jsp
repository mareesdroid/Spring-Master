<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" /> 
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" /> 

</head>
<body>
<div id="wrapper">
<div id = "header">
	<h2>Add New Customer</h2>
	</div>
	
	<div id = "container">
	
	<div id = "content">
	<!--  put new button: Add customer -->
	<!-- here showFormForAdd is our controller see annotation in controller -->
	<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	
	<!-- need to associate this data with customerId -->
	<!-- Without this line selected object id will be 0 and ad every time as new -->
	<form:hidden path="id"/>
	
	
	<table>
		<tbody>
			<tr>
				<td><label>First Name : </label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			
			<tr>
				<td><label>Last Name : </label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			
			<tr>
				<td><label>Email : </label></td>
				<td><form:input path="email" /></td>
			</tr>
			
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Add" class="save"/></td>
			</tr>
		</tbody>
	</table>
	</form:form>
	
	<div style="clear; both;"></div>
	
	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back</a>
	</p>
	
	</div></div></div>
</body>
</html>