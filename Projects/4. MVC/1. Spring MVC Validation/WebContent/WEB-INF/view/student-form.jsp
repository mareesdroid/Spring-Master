<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- Taking the model attribute from before set key should match("student") -->
<form:form action = "processForm" modelAttribute="student">

	<!-- google for spring mvc tags -->
<!-- assigning up the path after user press the submit student.setFirstname student.setLastName seted --> 
	First name : <form:input path = "firstName" />
	<br><br>
	Last name : <form:input path = "lastName"/>
	<br><br>
	
	
	<form:select path = "country">
	<!-- get countries and automaticaly loo through and assign the value -->
		<form:options items = "${student.countries}"  />
		
		
	
	</form:select>
	
	<br><br>
	
Favorite Language : 

	JAVA <form:radiobutton path = "favoriteLanguage" value = "JAVA"/>
	Javascript <form:radiobutton path = "favoriteLanguage" value = "Javascript"/>
	PHP <form:radiobutton path = "favoriteLanguage" value = "PHP"/>
	C# <form:radiobutton path = "favoriteLanguage" value = "C#"/>
	C <form:radiobutton path = "favoriteLanguage" value = "C"/>
	
	<br><br>
	
	Operating Systems: 
		
		Windows <form:checkbox path = "operatingSystems" value = "Windows" />
		Linux <form:checkbox path = "operatingSystems" value = "Linux" />
		Mac <form:checkbox path = "operatingSystems" value = "Mac" />
	
	<br><br>
	<input type = "submit" value = "submit" />
	<!-- from here prcessform will launch(see action) go to studenController process form mapping -->
</form:form>

</body>
</html>