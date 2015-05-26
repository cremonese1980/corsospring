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
   <h3>Añadir un nuevo articulo</h3>
   <form:form method="POST" 
              action="add"
              modelAttribute="usuarioAttr">
       <table>
       	<tr>
       		<td><form:label path="idusuario">Referencia</form:label></td>
       		<td><form:input path="idusuario" disabled="true"/></td>
       	</tr>
       	<tr>
       		<td><form:label path="nombre">Nombre</form:label></td>
       		<td><form:input path="nombre"/></td>
       	</tr>
       	<tr>
       		<td><form:label path="appellido">Appellido</form:label></td>
       		<td><form:input path="appellido"/></td>
       	</tr>
       <tr>
       		<td><form:label path="telefono">Telefono</form:label></td>
       		<td><form:input path="telefono"/></td>
       	</tr>
       	<tr>
       		<td><form:label path="ciudad">Ciudad</form:label></td>
       		<td><form:input path="ciudad"/></td>
       	</tr>
       </table>
   		<input type="submit" value="Añadir usuario"/>
   </form:form>
</body>
</html>