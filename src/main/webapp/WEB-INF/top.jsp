<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Search
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
	</head>
	<body>
		<header>
			<h1>
				Top Ten Songs
			</h1>
			<form action="/dashboard" method="GET">
				<button type="submit" class="link">
					Dashboard
				</button>
			</form>
		</header>
		<table>
        	<tbody>
				<c:forEach var="lookify" items="${lookifyList}">
					<tr>
						<td><c:out value="${lookify.getRating()}"/></td>
                    	<td>
                    		<form action="/songs/${lookify.getId()}" method="GET">
								<button type="submit" class="link">
									<c:out value="${lookify.getTitle()}"/>
								</button>
							</form>
						</td>
                        <td><c:out value="${lookify.getArtist()}"/></td>
					</tr>
            	</c:forEach>
			</tbody>
		</table>
	</body>
</html>