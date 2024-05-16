<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div modelAttribute="registerDTO">
	Name: ${registerDTO.name}
	<br/>
	userName: ${registerDTO.userName} 
		<br/>
	
	pass: ${registerDTO.password} 
		<br/>
	
	country:${registerDTO.country} 
		<br/>
	
	hobbies: ${registerDTO.hobbies} 
		<br/>
	
	gender:	${registerDTO.gender} 
		<br/>
	
	age: ${registerDTO.age}
	</div>

</body>
</html>