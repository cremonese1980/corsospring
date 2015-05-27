<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
   <h3>Añadir una nueva tarea</h3>
   <form:form method="POST" 
              action="addTarea"
              modelAttribute="tareaAttr">
       <table>
       	
       	<tr>
       		<td><form:label path="contenido">Tarea</form:label></td>
       		<td><form:input path="contenido"/></td>
       	</tr>
       </table>
   		<input type="submit" value="Añadir tarea"/>
   </form:form>
   
   <h3>Listado de tareas</h3>

<table>
	<tr>
		<th width="50">Ref.</th>
		<th width="150">Contenido</th>
		<th></th>
	</tr>
	<c:forEach items="${listado}" var="tarea">
		<c:url var="deleteURL" value="/spring/main/delete?id=${tarea.idtarea}"></c:url>
		<tr>
			<td><c:out value="${tarea.idtarea}" /></td>
			<td><c:out value="${tarea.contenido}" /></td>
			<td><a href ="${deleteURL}">Borrar</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>