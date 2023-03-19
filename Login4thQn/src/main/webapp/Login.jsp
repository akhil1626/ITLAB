<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
<div align="center">
	<b><h1>WELLCOME TO LOGIN PAGE</h1></b>
	<form action=LoginServlet method =post>
	<table>
	<tr><td>Enter Name:</td><td><input type=text name=name></td></tr>
	<tr><td>Enter Password:</td><td><input type=password name=password></td></tr>
	<tr><td><input type=submit value=login></td><td><input type=reset></td></tr>
	</table>
	</form>
</div>
</body>
</html>