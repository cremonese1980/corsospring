<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Pagina de Moderacion</title>
</head>
<body>
	<h1>Pagina de Moderacion</h1>
	<p>
		Pagina disponible para todos los moderadores<br /> <a
			href="<c:url value="/j_spring_security_logout" />">Logout</a> <br />
		<a href="${pageContext.request.contextPath}/index.html">Pagina
			inicial</a><br />
	</p>
</body>
</html>