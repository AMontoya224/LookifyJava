<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Show Expense
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<main>
			<div class="row">
				 <h1>
					Song Details
				</h1> 
				<form action="/dashboard" method="GET">
					<button type="submit" class="link">
						Dashboard
					</button>
				</form>
			</div>
			<h3>
				Title: <c:out value="${lookify.getTitle()}"/>
			</h3>
			<h3>
				Artist: <c:out value="${lookify.getArtist()}"/>
			</h3>
			<h3>
				Rating (1 - 10): <c:out value="${lookify.getRating()}"/>
			</h3>
			<form action="/songs/delete/${lookify.getId()}" method="POST">
				<input type="hidden" name="_method" value="DELETE" />
				<button type="submit" class="link">
					delete
				</button>
			</form>
		</main>
	</body>
</html>