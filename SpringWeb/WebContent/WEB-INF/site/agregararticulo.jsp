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
              modelAttribute="articuloAttribute">
       <table>
       	<tr>
       		<td><form:label path="idarticulo">Referencia</form:label></td>
       		<td><form:input path="idarticulo" disabled="true"/></td>
       	</tr>
       	<tr>
       		<td><form:label path="descripcion">Descripcion</form:label></td>
       		<td><form:input path="descripcion"/></td>
       	</tr>
       	<tr>
       		<td><form:label path="precio">Precio</form:label></td>
       		<td><form:input path="precio"/></td>
       	</tr>
       <tr>
       		<td><form:label path="stock">Stock</form:label></td>
       		<td><form:input path="stock"/></td>
       	</tr>
       	<tr>
       		<td><form:label path="proveedor">Proveedor</form:label></td>
       		<td><form:input path="proveedor"/></td>
       	</tr>
       </table>
   		<input type="submit" value="Añadir articulo"/>
   </form:form>
</body>
</html>