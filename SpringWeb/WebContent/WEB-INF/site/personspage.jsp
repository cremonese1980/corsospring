<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<h3>Listado de empleados</h3>

<table>
	<tr>
		<th width="50">Ref.</th>
		<th width="150">Nombre</th>
		<th width="150">Apellidos</th>
		<th width="50">Sueldo</th>
	</tr>
	<c:forEach items="${personas}" var="person">
		<tr>
			<td><c:out value="${person.id}" /></td>
			<td><c:out value="${person.firstName}" /></td>
			<td><c:out value="${person.lastName}" /></td>
			<td><c:out value="${person.money}" /></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>