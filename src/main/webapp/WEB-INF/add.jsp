<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Add Song
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<form action="/dashboard" method="GET">
				<button type="submit" class="link">
					Dashboard
				</button>
			</form>
		<main>
			<form:form method="POST" action="/songs/new" modelAttribute="lookify">
				<div>
					<p><form:errors path="title" class="error"/></p>
					<p><form:errors path="artist" class="error"/></p>
					<p><form:errors path="rating" class="error"/></p>
				</div>
				<div class="justify">
					<form:label path="title" for="title">
						Title:
					</form:label>
					<form:input path="title" type="text" name="title" id="title"/>
				</div>
				<div class="justify">
					<form:label path="artist" for="artist">
						Artist:
					</form:label>
					<form:input path="artist" type="text" id="artist" name="artist"/>
				</div>
				<div class="justify">
					<form:label path="rating" for="rating">
						Rating (1 - 10):
					</form:label>
					<form:input path="rating" type="number" id="rating" name="rating"/>
				</div>
				<button type="submit" class="submit" >
					Submit
				</button>
			</form:form>
		</main>
	</body>
</html>