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
		<header>
			<h1>
				Songs by artist: <c:out value="${lookifyList.get(0).getArtist()}"/>
			</h1>
			<form:form method="GET" action="/search" modelAttribute="lookify">
				<form:input path="artist" type="text" id="artist" name="artist"/>
				<button type="submit" class="link">
					Search Artists
				</button>
			</form:form>
			<form action="/dashboard" method="GET">
				<button type="submit" class="link">
					Dashboard
				</button>
			</form>
		</header>
		<table>
        	<thead>
		        <tr>
		            <th>Title</th>
		            <th>Rating</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
        	<tbody>
				<c:forEach var="lookify" items="${lookifyList}">
					<tr>
                    	<td>
                    		<form action="/songs/${lookify.getId()}" method="GET">
								<button type="submit" class="link">
									<c:out value="${lookify.getTitle()}"/>
								</button>
							</form>
						</td>
                        <td><c:out value="${lookify.getRating()}"/></td>
                        <td>
							<form action="/songs/delete/${lookify.getId()}" method="POST">
								<input type="hidden" name="_method" value="DELETE" />
								<button type="submit" class="delete">
									delete
								</button>
							</form>
						</td>
					</tr>
            	</c:forEach>
			</tbody>
		</table>
	</body>
</html>