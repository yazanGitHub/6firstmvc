<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1 align="center">find my crush</h1>
	<hr/>
	
	<p>user name is : ${userName}</p>
	<p>has crush on : ${crushName}</p>
	
	<hr/>using the DTO object	<hr/>
	<p>user name is : ${userInfo.userName}</p>
	<p>has crush on : ${userInfo.crushName}</p>
</body>
</html>