<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team Management</title>
</head>
<body>
<div align="center">
<h1>Team</h1>
<a href="newTeam">New team</a>
<table>


<th>Name</th>
<th>Country</th>

<c:forEach var="team" items="${listTeam}">
<tr>
<td>${team.name}</td>
<td>${team.country}</td>
<td><a href="editTeam?id=${team.id}">Edit</a></td>
<td><a href="deleteTeam?id=${team.id}">Delete</a></td>

</tr>
</c:forEach>
</table>
</div>
</body>
</html>