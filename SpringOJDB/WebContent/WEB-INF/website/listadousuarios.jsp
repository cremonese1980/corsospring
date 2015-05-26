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

<h3>Listado de usuarios</h3>

<table>
	<tr>
		<th width="50">Ref.</th>
		<th width="150">Nombre</th>
		<th width="150">Apellidos</th>
		<th width="50">Telefono</th>
		<th width="50">Ciudad</th>
		<th colspan="2"></th>
	</tr>
	<c:forEach items="${listado}" var="usuario">
		<c:url var="editURL" value="/spring/main/edit?id=${usuario.idusuario}"></c:url>
		<c:url var="deleteURL" value="/spring/main/delete?id=${usuario.idusuario}"></c:url>
		<tr>
			<td><c:out value="${usuario.idusuario}" /></td>
			<td><c:out value="${usuario.nombre}" /></td>
			<td><c:out value="${usuario.appellido}" /></td>
			<td><c:out value="${usuario.telefono}" /></td>
			<td><c:out value="${usuario.ciudad}" /></td>
			<td><a href ="${editURL}">Editar</a></td>
			<td><a href ="${deleteURL}">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>