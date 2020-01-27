<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>

<!-- Reference our dtylesheet -->

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" /> 

<script type="text/javascript">
  function handleClick(clickedId)
  {
	   
	 console.log(clickedId);
	 if(!confirm("Are you sure you want to delete the customer?"))
		 return false;
	 
	 
	return window.location.href = clickedId;
	 
     
  }
</script>
</head>
<body>
<div id = "wrapper">
	<div id = "header">
	<h2>CRM - Customer Relationship Manager</h2>
	</div>
	
	<div id = "container">
	
	<div id = "content">
	<!--  put new button: Add customer -->
	<!-- here showFormForAdd is our controller see annotation in controller -->
	<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
	
	<!--  add our html table ghere -->
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		
		<!--  Loop Over and print our customers -->
		<c:forEach var = "currentCustomer" items = "${customers}">	<!-- remember as same as the model attrbute key check customer controller -->
		
		<!-- Construct an update link with customer id -->
		<!-- creating a variable named "updateLink" and it's value is /customer/showUpdateForm and we put customerid in param to know which element is clicked  -->
		<c:url var="updateLink" value="/customer/showUpdateForm">
			<c:param name="customerId" value="${currentCustomer.id}" />
		</c:url>
		<c:url var="deleteLink" value="/customer/delete">
			<c:param name="customerId" value="${currentCustomer.id}" />
		</c:url>
		<tr>
			<td>${currentCustomer.firstName}</td>
			<td>${currentCustomer.lastName}</td>
			<td>${currentCustomer.email}</td>
			<td>
			<img src="${pageContext.request.contextPath}/resources/img/pencil-edit-button.png" onclick="window.location.href='${updateLink}'; return false;" />
			|
			<img src="${pageContext.request.contextPath}/resources/img/rubbish-bin-delete-button.png" 
				onclick="handleClick('${deleteLink}')" />
			
			
			</td>
		</tr>
		
		</c:forEach>
	</table>
	
	</div>
	</div>
</div>
</body>
</html>