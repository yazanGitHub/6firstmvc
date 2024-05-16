<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page</title>

	<script type="text/javascript">
		function validateUserName()
		{
			var userName = document.getElementById("name").value;
			if(userName.length  < 2 )
				{
					alert("user name canot be null")
					return false;
				}
		}
	
	</script>

</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr />
	<form action="process-homepage" method="GET" onsubmit="return validateUserName()">
		<div align="center">
			<p>
				<label for="name">Your Name:</label> <input type="text" id="name"
					name="userName" />
			</p>
			<p>
				<label for="crushName">Crush Name:</label> <input type="text"
					id="crush" name="crushName">
			</p>
			<input type="submit" value="calculate">
		</div>
	</form>

	<hr />
	getting the process using the Object DTO the validation will work only in this form because we have here add the DTO object
	
	<hr />
	<!-- here we do the validation in the backend -->
	<form action="process-homepage/usingObject" method="GET" >
		<div align="center">
			<p>
				<label for="name">Your Name:</label> <input type="text" id="name"
					name="userName" />
			</p>
			<p>
				<label for="crushName">Crush Name:</label> <input type="text"
					id="crush" name="crushName">
			</p>
			<input type="submit" value="calculate">
		</div>
	</form>


	<hr />
	getting the process to get the default value
	<hr />
	<form:form action="process-homepage/usingObject" method="GET" modelAttribute="userInfo" >
		<div align="center">
			<p>
				<label for="name">Your Name:</label> 
				<form:input id="name" path="userName" />
			</p>
			<p>
				<label for="crushName">Crush Name:</label>
				 <form:input id="crush" path="crushName"/>
			</p>
			<input type="submit" value="calculate">
		</div>
	</form:form>

</body>
</html>