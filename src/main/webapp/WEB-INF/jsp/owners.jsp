<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>OWNERS</title>
	</head>
	<body>
		<table>
			<thead>
				<tr style="font-weight: bold;" bgcolor="lightblue">
					<td>ID</td>
					<td>First Name</td>
					<td>Last Name</td>
				</tr>
			</thead>
			<c:forEach items="${owners}" var="owner" varStatus="status">
				<tr bgcolor="${status.index % 2 == 0 ? 'white' : 'lightgray'}">
					<td>${owner.id}</td>
					<td>${owner.firstName}</td>
					<td>${owner.lastName}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>