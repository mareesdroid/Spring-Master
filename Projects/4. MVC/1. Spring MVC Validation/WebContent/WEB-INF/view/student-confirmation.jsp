<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
						<!-- student.firstName      student.lastname    calls the getmethod in student Object -->
The Student is Confirmed: ${student.firstName} ${student.lastName}

<br><br>

Selected Country : ${student.country}
<br><br>

Favorite Language : ${student.favoriteLanguage} 

<br><br>

Operating Systems : 

	<ul>
	
	<c:forEach var = "current" items = "${student.operatingSystems}">
		<li> ${current}</li>
	</c:forEach>
	 
	</ul>

<br><br>
</body>
</html>