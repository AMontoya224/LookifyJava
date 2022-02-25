<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Lookify!
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<h1>
			Welcome to Lookify!
		</h1>
		<main>
			<form action="/dashboard" method="GET">
				<button type="submit" class="link">
					Start Looking!
				</button>
			</form>
		</main>
	</body>
</html>