<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px
}
</style>

</head>
<body>
	<h1 align="center">Please Register</h1>

	<form:form action="register" modelAttribute="registerDTO">

		<div align="center">
			<label>User: </label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error" />


			<br /> <br />

			<label>userName: </label>
			<form:input path="userName" />
			<br /> <br />

			<label>Password: </label>
			<form:password path="password" />
			<br /> <br />

			<label>Date: </label>
			<form:input path="date"  type="date"/>
			<br /> <br />

			<laabe>Country: </laabe>
			<form:select path="country">
				<form:option value="GER">German</form:option>
				<form:option value="ENG">England</form:option>
				<form:option value="USA">USA</form:option>
				<form:option value="EGP">Egypt</form:option>
			</form:select>

			<br /> <br /> <label>Hobbies: </label> Swiming :
			<form:checkbox path="hobbies" value="swim" />
			Football :
			<form:checkbox path="hobbies" value="football" />
			BasketBall :
			<form:checkbox path="hobbies" value="basket" />
			horse riding :
			<form:checkbox path="hobbies" value="horse" />

			<br /> <br /> <label>Gender: </label> Male:
			<form:radiobutton path="gender" value="male" />
			Female:
			<form:radiobutton path="gender" value="female" />

			<label>Age: </label>
			<form:input path="age" />
			<form:errors path="age" cssClass="error" />

			<div align="center">
				<h3>Communication</h3>
				<label>Email</label>
				<form:input path="contact.email" />
				<form:errors path="contact.email" cssClass="error"/>
				<br /> <br /> 
				<label>Phone</label>
				<form:input path="contact.phone" />
			</div>


			<input type="submit" value="register" />
		</div>
	</form:form>
</body>
</html>